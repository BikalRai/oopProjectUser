package model;

public class Sports {
    private int sportId;
    private String sportName;
    private String price;
    private String desc;

    public Sports () {

    }

    public Sports(int sportId, String sportName, String price, String desc) {
        this.sportId = sportId;
        this.sportName = sportName;
        this.price = price;
        this.desc = desc;
    }

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
