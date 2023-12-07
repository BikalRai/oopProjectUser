package query;

import dbconnection.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteQuery {
    public void deleteBooking (int id) {
        String query = "DELETE FROM newbookings where bookingID = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
