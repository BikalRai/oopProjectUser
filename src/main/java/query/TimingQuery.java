package query;

import dbconnection.DBConnection;
import model.TimingModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimingQuery {
    public List<TimingModel> getAvailableTimings() throws SQLException {
        List <TimingModel> availableTimings = new ArrayList<>();
        String query = "select * from booking_timings";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int timingID = resultSet.getInt("timingID");
            String startTime = resultSet.getString("startTime");
            String endTime = resultSet.getString("endTime");
            int isBooked = resultSet.getInt("is_booked");
            availableTimings.add(new TimingModel(timingID, startTime, endTime, isBooked));
        }

        return availableTimings;
    }
}
