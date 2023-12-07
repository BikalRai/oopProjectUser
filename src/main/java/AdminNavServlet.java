import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminNavServlet", value = "/adminNav")
public class AdminNavServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String page = request.getParameter("page");

        if (page.equalsIgnoreCase("home")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./index.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("emp")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/admin/admin-org.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
