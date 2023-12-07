import model.User;
import passwordHash.HashingPassword;
import query.GetPasswordQuery;
import query.LoginQuery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String page = request.getParameter("page");
        String error;

        if (page.equalsIgnoreCase("login")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/login.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("register")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/register.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("index")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./index.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("logout")) {

            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate(); // Invalidate the session
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("home")) {
            User user = new User();
            User compUser = new User();
            GetPasswordQuery getPasswordQuery = new GetPasswordQuery();

            String mobile = request.getParameter("mobile");
            String storedHashedPassword = getPasswordQuery.getUserPassword(mobile);

            String password = request.getParameter("password");

            LoginQuery loginQuery = new LoginQuery();
//            compUser = loginQuery.getCompanyUser(mobile, password);



            if (HashingPassword.verifyPassword(password, storedHashedPassword)) {
                // Password verification successful, proceed with login

                user = loginQuery.getUser(mobile, storedHashedPassword);

                if (user.getFullName() != null) {
                    // User exists, set session attributes and forward to the index page
                    HttpSession session = request.getSession();
                    session.setAttribute("username", user.getFullName());
                    session.setAttribute("userID", user.getId());
                    session.setAttribute("accType", user.getAccType());
                    request.setAttribute("userTotalBookings", user.getBookings());


                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("./index.jsp");
                    requestDispatcher.forward(request, response);


                } else {
                    // User does not exist or other issue
                    error = "User does not exist";
                    request.setAttribute("userError", error);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/login.jsp");
                    requestDispatcher.forward(request, response);
                }
            } else {
                // Password verification failed, handle invalid login attempt
                error = "Invalid credentials"; // Or more specific error message
                request.setAttribute("userError", error);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/login.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    }
}
