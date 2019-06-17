package osm.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class Measurement {

    @JsonProperty("value")
    private double value;

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("location")
    private double[] location;

    public Measurement() {
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public double[] getLocation() {
        return location;
    }

    public void setLocation(double[] location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "value=" + value +
                ", createdAt='" + createdAt + '\'' +
                ", location=" + Arrays.toString(location) +
                '}';
    }
}
