package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;


import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

// DateFormat String timestamp = new SimpleDateFormat("yyyy-MM-dd'T'h:m:ssZZZZZ").format(new Date());


public class Sensor {

    @JsonProperty("title")
    private String title;
    @JsonProperty("sensorType")
    private String sensorType;
    @JsonProperty("_id")
    private String sensorID;
    private String unit;
    @JsonProperty("lastMeasurement")
    private Measurement lastMeasurement;


    public Sensor() {
    }

    public Sensor(String title, String sensorType, String sensorID, Measurement measurement, String unit) {
        this.title = title;
        this.sensorType = sensorType;
        this.sensorID = sensorID;
        this.lastMeasurement = measurement;
        this.unit = unit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public String getSensorID() {
        return sensorID;
    }

    public void setSensorID(String sensorID) {
        this.sensorID = sensorID;
    }

    public void setLastMeasurement(Measurement lastMeasurement) {
        this.lastMeasurement = lastMeasurement;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "title='" + title + '\'' +
                ", sensorType='" + sensorType + '\'' +
                ", sensorID='" + sensorID + '\'' +
                ", lastMeasurement=" + lastMeasurement.toString() +
                '}';
    }
}
