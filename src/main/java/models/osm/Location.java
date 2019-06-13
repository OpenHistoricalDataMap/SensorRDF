package models.osm;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class Location {

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("coordinates")
    private double[] coordinates;

    @JsonProperty("type")
    private String type;

    public Location() {
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
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
