package query;

import dbconnection.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUserQuery {
    public void updateUser (int id, String name, String mobile) {
        String query = "UPDATE user SET fullname = ?, mobile = ? WHERE userID = ?";

        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, mobile);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
