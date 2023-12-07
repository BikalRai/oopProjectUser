package query;

import dbconnection.DBConnection;
import model.BookingModel;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConfirmBookingQuery {
    public void confirmBooking(int id) {
        String query = "UPDATE booking_timings SET is_booked = 1 where timingID = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);
        try {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
