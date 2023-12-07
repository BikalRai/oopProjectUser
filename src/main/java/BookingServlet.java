import model.BookingModel;
import model.Sports;
import model.TimingModel;
import query.*;
import utility.UserBookingsUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookingServlet", value = "/booking")
public class BookingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String page = request.getParameter("page");
        String message = "";

        HttpSession session = request.getSession();
        Integer userID = (Integer) session.getAttribute("userID");

        int userBookingCount = UpdateBookingCountQuery.getUserBookingCount(userID);
        request.setAttribute("userTotalBookings", userBookingCount);

        if (page.equalsIgnoreCase("createBooking")){
            String times = request.getParameter("timings");
            String sport = request.getParameter("sport");

            String[] timevalues = times.split(",");
            String startTime = timevalues[0];
            String endTime = timevalues[1].trim();
            int timeId = Integer.parseInt(timevalues[2].trim());

            String[] sportValue = sport.split(",");
            String sportName = sportValue[0];
            int sportId = Integer.parseInt(sportValue[1].trim());

            BookingQuery bookingQuery = new BookingQuery();
            boolean bookValid = false;

            BookingModel bookingModel = new BookingModel();
            List<Sports> allSports = new ArrayList<>();
            SportsQuery sportsQuery = new SportsQuery();
            Sports sportDetails = new Sports();
            List<TimingModel> availabletimings = new ArrayList<>();
            TimingQuery timingQuery = new TimingQuery();
            try {
                allSports = sportsQuery.getAllSports();
                sportDetails = sportsQuery.getSport(sportId);
                availabletimings = timingQuery.getAvailableTimings();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }



            bookingModel.setBookedBy((String) session.getAttribute("username"));
            bookingModel.setBookingDate(request.getParameter("date"));
            bookingModel.setBookingStart(startTime);
            bookingModel.setBookingEnd(endTime);
            bookingModel.setBookedFor(sportName);
            bookingModel.setBookedById((Integer) session.getAttribute("userID"));
            bookingModel.setPrice(sportDetails.getPrice());

            if (bookingQuery.checkEntry(bookingModel) == 0) {

                request.setAttribute("confirmBooking", bookingModel);
                request.setAttribute("timingId", timeId);
                session.setAttribute("bookingConfirm", bookingModel);
                bookValid = true;

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/confirm-booking.jsp");
                requestDispatcher.forward(request, response);

            } else {



                request.setAttribute("allTimings", availabletimings);
                request.setAttribute("allSports", allSports);



                message = "The date and time has already been booked, try again";
                bookValid = false;
                request.setAttribute("alreadyBooked", message);
                request.setAttribute("bookValid", bookValid);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/book.jsp");
                requestDispatcher.forward(request, response);
            }

//            BookingQuery bookingQuery = new BookingQuery();
//            bookingQuery.createBooking(bookingModel);



        }
    }
}
