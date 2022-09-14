package com.example.exam2.controller;

import com.example.exam2.model.Book;
import com.example.exam2.model.Contract;
import com.example.exam2.model.Customer;
import com.example.exam2.service.BookService;
import com.example.exam2.service.ContractService;
import com.example.exam2.service.CustomerService;
import com.example.exam2.service.impl.BookServiceImpl;
import com.example.exam2.service.impl.ContractServiceImpl;
import com.example.exam2.service.impl.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ContractController", value = "/contracts")
public class ContractController extends HttpServlet {
    ContractService contractService = new ContractServiceImpl();
    BookService bookService = new BookServiceImpl();
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
                showFormEdit(request, response);
                break;
            default:
                showListContract(request, response);
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contract contract = contractService.findContractById(id);
        List<Book> bookList = bookService.readAllBooks();
        List<Customer> customerList = customerService.readAllCustomers();
        request.setAttribute("contract", contract);
        request.setAttribute("bookList", bookList);
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("contract/edit_contract.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Book> bookList = bookService.readAllBooks();
        List<Customer> customerList = customerService.readAllCustomers();

        request.setAttribute("bookList", bookList);
        request.setAttribute("customerList", customerList);

        try {
            request.getRequestDispatcher("contract/create_contract.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showListContract(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList = contractService.readAllContracts();
        List<Book> bookList = bookService.readAllBooks();
        List<Customer> customerList = customerService.readAllCustomers();

        request.setAttribute("contractList", contractList);
        request.setAttribute("bookList", bookList);
        request.setAttribute("customerList", customerList);

        try {
            request.getRequestDispatcher("contract/list_contract.jsp").forward(request, response);
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
            case "edit":
                editContract(request, response);
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
        String character = request.getParameter("search");
        List<Contract> contractList = contractService.searchByBookName(character);
        List<Book> bookList = bookService.readAllBooks();
        List<Customer> customerList = customerService.readAllCustomers();
        request.setAttribute("contractList", contractList);
        request.setAttribute("bookList", bookList);
        request.setAttribute("customerList", customerList);
        request.setAttribute("character", character);
        try {
            request.getRequestDispatcher("contract/list_contract.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check = contractService.deleteContractById(id);
        if (check){
            showListContract(request, response);
        }
    }

    private void editContract(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String date = request.getParameter("date");
        String status = request.getParameter("status");
        String rentAmount = request.getParameter("rentAmount");
        String bookId = request.getParameter("bookId");
        String customerId = request.getParameter("customerId");

        Contract contract = new Contract(Integer.parseInt(id), date, status, Integer.parseInt(rentAmount), Integer.parseInt(bookId), Integer.parseInt(customerId));
        boolean check = contractService.updateContract(contract);
        if (check) {
            showListContract(request, response);
        }
    }

    private void addContract(HttpServletRequest request, HttpServletResponse response) {
        String date = request.getParameter("date");
        String status = request.getParameter("status");
        String rentAmount = request.getParameter("rentAmount");
        String bookId = request.getParameter("bookId");
        String customerId = request.getParameter("customerId");

        List<Book> bookList = bookService.readAllBooks();
        request.setAttribute("bookList", bookList);
        List<Customer> customerList = customerService.readAllCustomers();
        request.setAttribute("customerList", customerList);

        if (rentAmount.equals("")) {
            rentAmount = "-1";
        }
        Contract contract = new Contract(date, status, Integer.parseInt(rentAmount), Integer.parseInt(bookId), Integer.parseInt(customerId));
        Map<String, String> map = contractService.addContract(contract);

        String mess = "add failed";
        if (map.isEmpty()) {
            mess = "new add was successful";
        } else {
            request.setAttribute("error", map);
        }
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("contract/create_contract.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
