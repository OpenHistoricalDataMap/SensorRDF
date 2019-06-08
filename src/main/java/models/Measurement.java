package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;

public class Measurement {


    @JsonProperty("value")
    private double value;

    @JsonProperty("createdAt")
    private String createdAt;

    private final String DATE_FORMAT = "yyyy-MM-dd'T'h:m:ssZZZZZ";

    public Measurement() {
    }
/**
    public Measurement(double value, SimpleDateFormat createdAt) {

        this.value = value;
        this.createdAt = createdAt;
    }**/

    public Measurement(double value, String createdAt) {

        this.value = value;
        this.createdAt = createdAt;
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

    /**
    public SimpleDateFormat getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(SimpleDateFormat createdAt) {
        this.createdAt = createdAt;
    }
**/



    @Override
    public String toString() {
        return "{" +
                "value=" + value +
                ", createdAt=" + createdAt +
                '}';
    }
}
