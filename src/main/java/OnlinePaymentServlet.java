import model.BookingModel;
import query.ConfirmBookingQuery;
import query.PaymentQuery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OnlinePaymentServlet", value = "/online-payment")
public class OnlinePaymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        BookingModel bookingModel = (BookingModel) request.getAttribute("bookingDetails");

        PaymentQuery paymentQuery = new PaymentQuery();
        paymentQuery.onlinePayment(bookingModel.getBookingID());
    }
}
