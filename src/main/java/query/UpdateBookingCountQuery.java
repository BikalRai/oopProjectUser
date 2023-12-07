package query;

import dbconnection.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateBookingCountQuery {

    public static void updateBookingCount (int id) {
        String query = "UPDATE users SET bookings = bookings + 1 WHERE userID IN (SELECT bookedById FROM newbookings WHERE payment IS NOT NULL AND bookedById = ?)";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getUserBookingCount (int id) {
        int bookingCount = 0;
        String query = "SELECT bookings FROM users where userID = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                bookingCount = resultSet.getInt("bookings");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookingCount;
    }
}
