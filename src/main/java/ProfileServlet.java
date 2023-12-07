import model.User;
import query.GetUserQuery;
import query.UpdateUserQuery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProfileServlet", value = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userID");

        String name = request.getParameter("fullname");
        String mobile = request.getParameter("mobile");

        UpdateUserQuery updateUserQuery = new UpdateUserQuery();
        updateUserQuery.updateUser(userId, name, mobile);

        User user = new User();
        GetUserQuery getUserQuery = new GetUserQuery();

        user = getUserQuery.getUser(userId);

        request.setAttribute("loggedInUser", user);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/settings.jsp");
        requestDispatcher.forward(request, response);
    }
}
