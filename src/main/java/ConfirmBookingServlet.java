import model.BookingModel;
import model.UserBookingsModel;
import query.BookingQuery;
import query.ConfirmBookingQuery;
import query.UpdateBookingCountQuery;
import utility.UserBookingsUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ConfirmBookingServlet", value = "/confirm-booking")
public class ConfirmBookingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        Integer userID = (Integer) session.getAttribute("userID");

        int userBookingCount = UpdateBookingCountQuery.getUserBookingCount(userID);


//        int id = Integer.parseInt(request.getParameter("timingId"));
        BookingModel booking = (BookingModel) session.getAttribute("bookingConfirm");

//        ConfirmBookingQuery confirmBookingQuery = new ConfirmBookingQuery();
//        confirmBookingQuery.confirmBooking(id);

        BookingQuery bookingQuery = new BookingQuery();
        bookingQuery.createBooking(booking);


        List<UserBookingsModel> updatedUserBookings = UserBookingsUtil.getAllUserBookings(userID);

        request.setAttribute("userBookings", updatedUserBookings);
        request.setAttribute("userTotalBookings", userBookingCount);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/bookings.jsp");
        requestDispatcher.forward(request, response);

    }
}
