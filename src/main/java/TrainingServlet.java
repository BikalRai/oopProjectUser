import model.BookingModel;
import model.Sports;
import model.TimingModel;
import query.BookingQuery;
import query.SportsQuery;
import query.TimingQuery;
import utility.DispatchUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TrainingServlet", value = "/training")
public class TrainingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();
        String loggedInUser = (String) session.getAttribute("username");
        int loggedInUserId = (Integer) session.getAttribute("userID");
        String defaultType = "training";
        String sportValues = request.getParameter("training-type");
        String[] sportValuesList = sportValues.split(",");
        int sportId = Integer.parseInt(sportValuesList[1].trim());
        String message = null;

        List<Sports> allSports = new ArrayList<>();
        SportsQuery sportsQuery = new SportsQuery();
        Sports sportDetails = new Sports();
        sportDetails = sportsQuery.getSport(sportId);
        List<TimingModel> availabletimings = new ArrayList<>();
        TimingQuery timingQuery = new TimingQuery();

        try {
            allSports = sportsQuery.getAllSports();
            availabletimings = timingQuery.getAvailableTimings();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        BookingModel booking = new BookingModel();
        BookingQuery query = new BookingQuery();

        String multiValues = request.getParameter("time");
        String[] valueList = multiValues.split(",");
        String startTime = valueList[0];
        String endTime = valueList[1].trim();
        String date = request.getParameter("date");
        String trainer = request.getParameter("trainer");

        if (query.checkEntry(booking) == 0) {
            booking.setBookingDate(date);
            booking.setBookedBy(loggedInUser);
            booking.setBookedFor(sportDetails.getSportName());
            booking.setBookingStart(startTime);
            booking.setBookingEnd(endTime);
            booking.setBookedById(loggedInUserId);
            booking.setPrice(sportDetails.getPrice());
            booking.setType(defaultType);
            booking.setTrainer(trainer);

            request.setAttribute("confirmBooking", booking);
            session.setAttribute("bookingConfirm", booking);

            new DispatchUtil().dispatch(request, response, "./pages/confirm-booking.jsp");
        } else {
            request.setAttribute("allTimings", availabletimings);
            request.setAttribute("allSports", allSports);

            message = "The date and time has already is not available, try again";
            request.setAttribute("alreadyBooked", message);
        }





    }
}
