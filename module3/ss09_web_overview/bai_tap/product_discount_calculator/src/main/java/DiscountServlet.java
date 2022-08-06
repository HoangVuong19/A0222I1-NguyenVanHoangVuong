import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/display-discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        float discount = Float.parseFloat(request.getParameter("discount"));
        int result = (int) (price * discount * 0.01);

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Description: " + description + "</h1>");
        writer.println("<h1>Price: " + price + " $</h1>");
        writer.println("<h1>Discount: " + discount + " %</h1>");
        writer.println("<h1>Discount Amount: " + result + " $</h1>");
        writer.println("</html>");
    }
}
