import model.BookingModel;
import model.UserBookingsModel;
import query.*;
import utility.UserBookingsUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookingActionsServlet", value = "/booking-actions")
public class BookingActionsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String paymentMethod = request.getParameter("payment-method");
        String[] paymentValues = paymentMethod.split(",");
        String paymentMethodValue = paymentValues[0];

        int paymentID = Integer.parseInt(paymentValues[1].trim());
        int bookedById = Integer.parseInt(paymentValues[2].trim());

        PaymentQuery paymentQuery = new PaymentQuery();

        ParticularBookingQuery particularBookingQuery = new ParticularBookingQuery();
        BookingModel booking = particularBookingQuery.getParticularBooking(paymentID);

        HttpSession session = request.getSession();
        Integer userID = (Integer) session.getAttribute("userID");




        List<UserBookingsModel> allUserBookings = new ArrayList<>();
        allUserBookings = UserBookingsUtil.getAllUserBookings(userID);


        String message = "";


        if (paymentMethodValue.equalsIgnoreCase("esewa")) {

            request.setAttribute("bookingDetails", booking);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/payment.jsp");
            requestDispatcher.forward(request, response);
//            response.sendRedirect("./pages/bookings.jsp");
        }

        if (paymentMethodValue.equalsIgnoreCase("cash")) {
            paymentQuery.cashPayment(paymentID);
            UpdateBookingCountQuery.updateBookingCount(bookedById);

            int userBookingCount = UpdateBookingCountQuery.getUserBookingCount(userID);

            message = "You have chosen cash as payment";
            request.setAttribute("paymentMsg", message);
            request.setAttribute("userBookings", allUserBookings);
            request.setAttribute("userTotalBookings", userBookingCount);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/bookings.jsp");
            requestDispatcher.forward(request,response);
//            response.sendRedirect("./pages/bookings.jsp");
        }

        if (paymentMethodValue.equalsIgnoreCase("delete")) {
            DeleteQuery deleteQuery = new DeleteQuery();
            deleteQuery.deleteBooking(paymentID);

            List<UserBookingsModel> updatedUserBookings = UserBookingsUtil.getAllUserBookings(userID);

//            List<UserBookingsModel> allUserBookings = new ArrayList<>();
//            UserBookingsQuery userBookings = new UserBookingsQuery();
//
//            if (userID != null) {
//                allUserBookings = userBookings.getUserBookings(userID);
//
//            }

            message = "Successfully deleted";
            request.setAttribute("paymentMsg", message);
            request.setAttribute("userBookings", updatedUserBookings);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/bookings.jsp");
            requestDispatcher.forward(request,response);
        }



    }
}
