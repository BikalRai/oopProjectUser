import query.DeleteQuery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("bookID"));

        DeleteQuery deleteQuery = new DeleteQuery();
        deleteQuery.deleteBooking(id);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/bookings.jsp");
        requestDispatcher.forward(request, response);
    }
}
