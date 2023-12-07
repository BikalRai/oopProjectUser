import model.*;
import query.*;
import utility.DispatchUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NavServlet", value = "/nav")
public class NavServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String page = request.getParameter("page");

        HttpSession session = request.getSession();
        Integer userID = (Integer) session.getAttribute("userID");

        List<TimingModel> availabletimings = new ArrayList<>();
        TimingQuery timingQuery = new TimingQuery();
        List<Sports> allSports = new ArrayList<>();
        SportsQuery sportsQuery = new SportsQuery();

        try {
            availabletimings = timingQuery.getAvailableTimings();
            allSports = sportsQuery.getAllSports();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (page.equalsIgnoreCase("home")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./index.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("about")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/about.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("book")) {
            request.setAttribute("allTimings", availabletimings);
            request.setAttribute("allSports", allSports);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/book.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("bookings")) {
            if (userID != null) {

                int userBookingCount = UpdateBookingCountQuery.getUserBookingCount(userID);
                request.setAttribute("userTotalBookings", userBookingCount);

                List<UserBookingsModel> allUserBookings = new ArrayList<>();
                UserBookingsQuery userBookings = new UserBookingsQuery();


                allUserBookings = userBookings.getUserBookings(userID);


                session.setAttribute("allUserBookings", allUserBookings);
                request.setAttribute("userBookings", allUserBookings);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/bookings.jsp");
                requestDispatcher.forward(request, response);
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/bookings.jsp");
                requestDispatcher.forward(request, response);
            }
        }

        if (page.equalsIgnoreCase("settings")) {
            if (userID != null) {
                User user = new User();
                GetUserQuery getUserQuery = new GetUserQuery();

                user = getUserQuery.getUser(userID);

                request.setAttribute("loggedInUser", user);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/settings.jsp");
                requestDispatcher.forward(request, response);
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/settings.jsp");
                requestDispatcher.forward(request, response);
            }
        }


        if (page.equalsIgnoreCase("training")) {
            request.setAttribute("allTiming", availabletimings);
            request.setAttribute("allSports", allSports);
            new DispatchUtil().dispatch(request, response, "./pages/training.jsp");
        }

    }
}
