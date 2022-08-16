package com.example.time_login_currency_dictionary;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslateServlet", value = "/translate")
public class TranslateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");

        String search = request.getParameter("txtSearch");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String result = dictionary.get(search);
        if (result != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("translate.jsp");
            request.setAttribute("word", search);
            request.setAttribute("result", result);
            requestDispatcher.forward(request, response);
        } else {
            writer.println("Not found");
        }
    }
}
