package com.example.time_login_currency_dictionary;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        if ("admin".equals(username) && "admin".equals(password)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("hello.jsp");
            request.setAttribute("name", username);
            requestDispatcher.forward(request, response);
        } else {
            writer.println("Not found");
        }
    }
}
