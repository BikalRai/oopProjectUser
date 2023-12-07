package query;

import dbconnection.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentQuery {

    public void cashPayment (int id) {
        String query = "UPDATE newbookings SET payment = 'cash' WHERE bookingID = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void onlinePayment (int id) {
        String query = "UPDATE newbookings SET payment = 'online' WHERE bookingID = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getPaymentStatus(int id) {
        String status = null;

        String query = "SELECT payment FROM newbookings where bookingID = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                status = resultSet.getString("payment");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;

    }

}
