package query;

import dbconnection.DBConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterUserQuery {
    public void registerUser (User user) {
        String query = "insert into users (fullname, mobile, password, bookings, acc_type) values(?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getMobile());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getBookings());
            preparedStatement.setString(5, user.getAccType());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
