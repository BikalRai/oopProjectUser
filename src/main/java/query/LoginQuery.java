package query;

import dbconnection.DBConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginQuery {

    public User getUser (String mobile, String password) {
        User user = new User();
        String query = "SELECT * FROM users WHERE mobile = ? and password = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setString(1, mobile);
            preparedStatement.setString(2, password);

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

    public User getCompanyUser (String mobile, String password) {
        User user = new User();
        String query = "SELECT * FROM organisation where mobile = ? AND password = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setString(1, mobile);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user.setFullName(resultSet.getString("fullname"));
                user.setAccType(resultSet.getString("accType"));
                user.setMobile(resultSet.getString("mobile"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public String getMobile (String mobile) {
        String mob = null;
        String query = "SELECT mobile FROM users WHERE mobile = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setString(1, mobile);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                mob = resultSet.getString("mobile");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mob;
    }

}
