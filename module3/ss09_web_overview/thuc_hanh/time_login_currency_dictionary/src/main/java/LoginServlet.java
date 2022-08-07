import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("converter.jsp");
            requestDispatcher.forward(request, response);
        } else if ("guest".equals(username) && "guest".equals(password)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("dictionary.jsp");
            requestDispatcher.forward(request, response);
        } else {
            writer.println("<h1>Login Error</h1>");
        }
    }
}
