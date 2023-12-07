package query;

import dbconnection.DBConnection;
import model.Sports;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SportsQuery {
    public List<Sports> getAllSports () throws SQLException {
        List <Sports> allSports = new ArrayList<>();

        String query = "SELECT * FROM sports";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int sportId = resultSet.getInt("sportId");
            String sportName = resultSet.getString("sportName");
            String price = resultSet.getString("price");
            String desc = resultSet.getString("description");

            allSports.add(new Sports(sportId, sportName, price, desc));
        }



        return allSports;
    }

    public Sports getSport (int id) {
        String query = "SELECT * FROM sports where sportId = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        Sports sport = new Sports();

        try {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                sport.setSportId(resultSet.getInt("sportID"));
                sport.setSportName(resultSet.getString("sportName"));
                sport.setPrice(resultSet.getString("price"));
                sport.setDesc(resultSet.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sport;

    }
}
