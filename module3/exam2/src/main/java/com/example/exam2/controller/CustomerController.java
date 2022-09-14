package com.example.exam2.controller;

import com.example.exam2.model.Customer;
import com.example.exam2.service.CustomerService;
import com.example.exam2.service.impl.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerController", value = "/customers")
public class CustomerController extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();

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
            case "edit":
                //showFormEdit(request, response);
                //break;
            default:
                showListCustomer(request, response);
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.readAllCustomers();
        request.setAttribute("customerList", customerList);

        try {
            request.getRequestDispatcher("customer/create_customer.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.readAllCustomers();
        request.setAttribute("customerList", customerList);

        try {
            request.getRequestDispatcher("customer/list_customer.jsp").forward(request, response);
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
                addCustomer(request, response);
                break;
            case "edit":
                //editCustomer(request, response);
                break;
            case "search":
                //searchCustomer(request, response);
                break;
            case "delete":
                //deleteCustomer(request, response);
                break;
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(name, phone, email, address);
        Map<String, String> map = customerService.addCustomer(customer);

        String mess = "add failed";
        if (map.isEmpty()) {
            mess = "new add was successful";
        } else {
            request.setAttribute("error", map);
        }
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("customer/create_customer.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
