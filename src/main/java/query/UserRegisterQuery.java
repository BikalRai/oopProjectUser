package query;

import dbconnection.DBConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRegisterQuery {

    public void registerUser (User user) {
        String query = "INSERT INTO users (fullname, mobile, password) VALUES(?, ?, ?)";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getMobile());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean userCheck (String mobile) {
        boolean check = false;
        String query = "select mobile from users where mobile = ?";

        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setString(1, mobile);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                check = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return check;
    }
}
