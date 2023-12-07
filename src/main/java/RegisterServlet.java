import model.User;
import passwordHash.HashingPassword;
import query.LoginQuery;
import query.RegisterUserQuery;
import query.UserRegisterQuery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String page = request.getParameter("page");


        if (page.equalsIgnoreCase("reg")) {

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/register.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("login")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/login.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("in")) {
            User user = new User();
            User checkUser = new User();
            LoginQuery loginQuery = new LoginQuery();

            String fullname = request.getParameter("fullname");
            String mobile = request.getParameter("mobile");
            String password = request.getParameter("password");
            String hashedPassword = HashingPassword.hashPassword(password);

            String error = "";
            boolean regIsValid = false;


            user.setFullName(fullname);
            user.setMobile(mobile);
            user.setPassword(hashedPassword);

//            checkUser.setMobile(loginQuery.getMobile(mobile));

//            checkUser = loginQuery.getUser(mobile, hashedPassword);
//            System.out.println(checkUser.getMobile());

            boolean check = UserRegisterQuery.userCheck(mobile);



            if (check) {
                regIsValid = false;
                error = "Moblie number already registered";

                request.setAttribute("registerErrorMobile", error);
                request.setAttribute("regValid", regIsValid);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/register.jsp");
                requestDispatcher.forward(request, response);

            } else {
                error = "";
                regIsValid = true;
                request.setAttribute("regValid", regIsValid);

                UserRegisterQuery userRegisterQuery = new UserRegisterQuery();
                userRegisterQuery.registerUser(user);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/login.jsp");
                requestDispatcher.forward(request, response);
            }





//            RegisterUserQuery registerUserQuery = new RegisterUserQuery();
//            registerUserQuery.registerUser(user);



        }
    }
}
