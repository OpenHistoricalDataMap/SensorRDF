package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Measurement {

    @JsonProperty("value")
    private double value;

    @JsonProperty("createdAt")
    private String createdAt;

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

    @Override
    public String toString() {
        return "{" +
                "value=" + value +
                ", createdAt=" + createdAt +
                '}';
    }
}
