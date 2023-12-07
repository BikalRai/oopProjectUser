package query;

import dbconnection.DBConnection;
import model.BookingModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParticularBookingQuery {
    public BookingModel getParticularBooking (int id) {


        String query = "SELECT * FROM newbookings where bookingID = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        BookingModel bookingModel = new BookingModel();

        try {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                bookingModel.setBookingID(resultSet.getInt("bookingID"));
                bookingModel.setBookingDate(resultSet.getString("bookedDate"));
                bookingModel.setBookedBy(resultSet.getString("bookedBy"));
                bookingModel.setBookedFor(resultSet.getString("bookedFor"));
                bookingModel.setBookingStart(resultSet.getString("bookStartTime"));
                bookingModel.setBookingEnd(resultSet.getString("bookEndTime"));
                bookingModel.setBookedById(resultSet.getInt("bookedById"));
                bookingModel.setPrice(resultSet.getString("price"));
                bookingModel.setPayment(resultSet.getString("payment"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookingModel;
    }
}
