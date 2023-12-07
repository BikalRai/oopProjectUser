package query;

import dbconnection.DBConnection;
import model.BookingModel;

import javax.servlet.http.HttpSession;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingQuery {
    public void createBooking (BookingModel bookingModel) {

            String query = "INSERT INTO newbookings (bookedDate, bookedBy, bookedFor, bookStartTime, bookEndTime, bookedById, price, type, trainer) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setString(1, bookingModel.getBookingDate());
            preparedStatement.setString(2, bookingModel.getBookedBy());
            preparedStatement.setString(3, bookingModel.getBookedFor());
            preparedStatement.setString(4, bookingModel.getBookingStart());
            preparedStatement.setString(5, bookingModel.getBookingEnd());
            preparedStatement.setInt(6, bookingModel.getBookedById());
            preparedStatement.setString(7, bookingModel.getPrice());
            preparedStatement.setString(8,  bookingModel.getType());
            preparedStatement.setString(9, bookingModel.getTrainer());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int checkEntry (BookingModel bookingModel) {
        int count = 0;
        String query = "SELECT COUNT(*) as count FROM newbookings WHERE bookedDate = ? AND bookStartTime = ? AND bookEndTime = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setString(1, bookingModel.getBookingDate());
            preparedStatement.setString(2, bookingModel.getBookingStart());
            preparedStatement.setString(3, bookingModel.getBookingEnd());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }
}
