package com.example.user_callable;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Servlet", urlPatterns = "/test")
public class Servlet extends HttpServlet {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Vananh0208";
    private Connection connection;

    private final String CREATE_SP= "delimiter $$\n" +
            "create procedure vuong_procedure(a varchar(20),b varchar(20),c varchar(20))\n" +
            "begin\n" +
            "insert into users (name, email, country) values(a,b,c);\n" +
            "end;\n" +
            "$$ delimiter ;";

    String createSP = "create procedure vuong_procedure(a varchar(20),b varchar(20),c varchar(20))\n" +
            "begin\n" +
            "insert into users (name, email, country) values(a,b,c);\n" +
            "end;";



    private final String QTEST= "delimiter $$" + System.lineSeparator()+
            "create procedure test_sp() begin end; $$ delimiter ; {escape '\\b'};";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            Statement statement = connection.createStatement();
            statement.execute(createSP);

            String call_sp = "{ call vuong_procedure(?,?,?) }";
            CallableStatement callableStatement= connection.prepareCall(call_sp);
            callableStatement.setString(1, "myName");
            callableStatement.setString(2, "myEmail");
            callableStatement.setString(3, "myCountry");
            callableStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        PrintWriter printWriter= response.getWriter();
        printWriter.print("Success");
    }
}