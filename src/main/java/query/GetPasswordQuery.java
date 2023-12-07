package query;

import dbconnection.DBConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetPasswordQuery {
    public String getUserPassword (String mobile) {
        String storedPassword = null;
        String query = "SELECT password FROM users where mobile = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setString(1, mobile);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {;
                storedPassword = resultSet.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  storedPassword;
    }
}
