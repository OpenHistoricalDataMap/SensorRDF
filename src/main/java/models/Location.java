package models;

import java.util.Arrays;

public class Location {

    private String timestamp;
    private Double[] coordinates;
    private String type;


    public Location(){

    }

    public Location(String timestamp, Double[] coordinates, String type) {
        this.timestamp = timestamp;
        this.coordinates = coordinates;
        this.type = type;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Double[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "timestamp='" + timestamp + '\'' +
                ", coordinates=" + Arrays.toString(coordinates) +
                ", type='" + type + '\'' +
                '}';
    }
}
