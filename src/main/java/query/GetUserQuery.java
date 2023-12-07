package query;

import dbconnection.DBConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetUserQuery {
    public User getUser(int id) {
        User user = new User();
        String query = "SELECT * FROM users where userID = ?";

        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user.setId(resultSet.getInt("userID"));
                user.setFullName(resultSet.getString("fullname"));
                user.setMobile(resultSet.getString("mobile"));
                user.setPassword(resultSet.getString("password"));
                user.setBookings(resultSet.getInt("bookings"));
                user.setAccType(resultSet.getString("acc_type"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
