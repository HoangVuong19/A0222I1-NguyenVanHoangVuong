package com.calculate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculateServlet", value = "/calculate")
public class CalculateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num1 = Integer.parseInt(request.getParameter("first"));
        int num2 = Integer.parseInt(request.getParameter("second"));
        String operator = request.getParameter("operator");

        try {
            String result = calculate(num1, operator, num2);
            request.setAttribute("result", result);
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private String calculate(int num1, String operator, int num2) throws Exception {
        String result = "";
        switch (operator) {
            case "addition":
                result = num1 + " + " + num2 + " = " + (num1 + num2);
                break;
            case "subtraction":
                result = num1 + " - " + num2 + " = " + (num1 - num2);
                break;
            case "multiplication":
                result = num1 + " * " + num2 + " = " + (num1 * num2);
                break;
            case "division":
                if (num2 == 0) {
                    result = "Cannot division to zero";
                    break;
                }
                result = num1 + " / " + num2 + " = " + (num1 / num2);
                break;
        }
        return result;
    }
}
