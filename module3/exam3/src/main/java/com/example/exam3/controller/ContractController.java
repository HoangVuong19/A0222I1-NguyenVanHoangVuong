package com.example.exam3.controller;

import com.example.exam3.model.Contract;
import com.example.exam3.service.ContractService;
import com.example.exam3.service.impl.ContractServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ContractController", value = "/contracts")
public class ContractController extends HttpServlet {
    ContractService contractService = new ContractServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList = contractService.readAllContracts();
        request.setAttribute("contractList", contractList);
        try {
            request.getRequestDispatcher("contract/create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList = contractService.readAllContracts();
        request.setAttribute("contractList", contractList);
        try {
            request.getRequestDispatcher("contract/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addContract(request, response);
                break;
            case "search":
                searchContract(request, response);
                break;
            case "delete":
                deleteContract(request, response);
                break;
        }
    }

    private void searchContract(HttpServletRequest request, HttpServletResponse response) {

    }

    private void addContract(HttpServletRequest request, HttpServletResponse response) {
        String plantId = request.getParameter("plantId");
        String area = request.getParameter("area");
        String status = request.getParameter("status");
        String floor = request.getParameter("floor");
        String plantType = request.getParameter("plantType");
        String price = request.getParameter("price");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        if (area.equals("")) {
            area = "-1";
        }
        if (price.equals("")) {
            price = "-1.0";
        }
        if (startDate.equals("")) {
            startDate = "2000-12-22";
        }
        if (endDate.equals("")) {
            endDate = "2000-12-22";
        }
        Contract contract = new Contract(plantId, Integer.parseInt(area), status, Integer.parseInt(floor), plantType, Double.parseDouble(price), Date.valueOf(startDate), Date.valueOf(endDate));
        Map<String, String> map = contractService.addContract(contract);

        String mess = "add failed";
        if (map.isEmpty()) {
            mess = "new add was successful";
        } else {
            request.setAttribute("error", map);
        }
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("contract/create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check = contractService.deleteContractById(id);
        if (check){
            showList(request, response);
        }
    }
}
