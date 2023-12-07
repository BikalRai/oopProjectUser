import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Retrieve the session, don't create a new one if it doesn't exist
        if (session != null) {
            session.invalidate(); // Invalidate the session
        }

//        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
//        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
//        response.setDateHeader("Expires", 0); // Proxies.
//
//        // Disable browser back button using JavaScript
//        response.getWriter().write("<script>window.history.forward(1);</script>");

        // Redirect to a login page or any other destination
        response.sendRedirect("./index.jsp"); // Change this URL as needed

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
