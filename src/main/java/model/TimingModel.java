package model;

public class TimingModel {
    private int timingID;
    private String startTime;
    private String endTime;
    private int isBooked;

    public TimingModel(int timingID, String startTime, String endTime, int isBooked) {
        this.timingID = timingID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isBooked = isBooked;
    }

    public int getTimingID() {
        return timingID;
    }

    public void setTimingID(int timingID) {
        this.timingID = timingID;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(int isBooked) {
        this.isBooked = isBooked;
    }
}
