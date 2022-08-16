package com.example.product_discount_calculator;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DiscountServlet", value = "/display-discount")
public class DiscountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        float discount = Float.parseFloat(request.getParameter("discount"));
        int result = (int) (price * discount * 0.01);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("discount.jsp");
        request.setAttribute("description", description);
        request.setAttribute("price", price);
        request.setAttribute("discount", discount);
        request.setAttribute("result", result);
        requestDispatcher.forward(request, response);
    }
}
