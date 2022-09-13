package com.example.ss14_examination.controller;

import com.example.ss14_examination.modal.Category;
import com.example.ss14_examination.modal.Product;
import com.example.ss14_examination.service.CategoryService;
import com.example.ss14_examination.service.impl.CategoryServiceImpl;
import com.example.ss14_examination.service.impl.ProductServiceImpl;
import com.example.ss14_examination.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProductController", value = "/products")
public class ProductController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();

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
                showList(request, response);
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findProductById(id);
        List<Category> categoryList = categoryService.readAllCategories();
        request.setAttribute("product", product);
        request.setAttribute("categoryList", categoryList);
        try {
            request.getRequestDispatcher("view/edit.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = categoryService.readAllCategories();
        request.setAttribute("categoryList", categoryList);
        try {
            request.getRequestDispatcher("view/create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.readAllProducts();
        List<Category> categoryList = categoryService.readAllCategories();
        request.setAttribute("productList", productList);
        request.setAttribute("categoryList", categoryList);
        try {
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
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
                addProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "search":
                searchProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String character = request.getParameter("search");
        List<Product> productList = productService.searchByCategoryName(character);
        List<Category> categoryList = categoryService.readAllCategories();
        request.setAttribute("productList", productList);
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("character", character);
        try {
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check = productService.deleteProductById(id);
        if (check){
            showList(request, response);
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String category = request.getParameter("category");

        Product product = new Product(Integer.parseInt(id), name, Double.parseDouble(price), Integer.parseInt(quantity), color, description, Integer.parseInt(category));
        boolean check = productService.updateProduct(product);
        if (check) {
            showList(request, response);
        }
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String category = request.getParameter("category");

        List<Category> categoryList = categoryService.readAllCategories();
        request.setAttribute("categoryList", categoryList);

        if (price.equals("")) {
            price = "-1";
        }
        if (quantity.equals("")) {
            quantity = "-1";
        }
        Product product = new Product(name, Double.parseDouble(price), Integer.parseInt(quantity), color, description, Integer.parseInt(category));
        Map<String, String> map = productService.addProduct(product);

        String mess = "add failed";
        if (map.isEmpty()) {
            mess = "new add was successful";
        } else {
            request.setAttribute("error", map);
        }
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("view/create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
