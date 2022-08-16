package com.example.time_login_currency_dictionary;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "TimeServlet", value = "/time")
public class TimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date today = new Date();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("time.jsp");
        request.setAttribute("date", today);
        requestDispatcher.forward(request, response);
    }

}
