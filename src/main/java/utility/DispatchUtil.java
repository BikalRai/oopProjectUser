package utility;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatchUtil {
    public void dispatch(HttpServletRequest request, HttpServletResponse response, String route) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(route);
        requestDispatcher.forward(request, response);
    }
}
