import model.BookingModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CancelBookingServlet", value = "/cancel-booking")
public class CancelBookingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String message = "You have cancelled your booking";

        session.removeAttribute("bookingConfirm");
        request.setAttribute("cancel", message);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/confirm-booking.jsp");
        requestDispatcher.forward(request, response);

    }
}
