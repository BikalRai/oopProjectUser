package utility;

import model.UserBookingsModel;
import query.UserBookingsQuery;

import java.util.ArrayList;
import java.util.List;

public class UserBookingsUtil {
    public static List<UserBookingsModel> getAllUserBookings (int id ) {
        List<UserBookingsModel> allUserBookings = new ArrayList<>();
        UserBookingsQuery userBookingsQuery = new UserBookingsQuery();

        allUserBookings = userBookingsQuery.getUserBookings(id);
        return  allUserBookings;
    }
}
