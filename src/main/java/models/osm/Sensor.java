package models.osm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sensor {

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("title")
    private String title;

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("sensorType")
    private String sensorType;

    @JsonProperty("_id")
    private String sensorID;

    @JsonProperty("lastMeasurement")
    private Measurement lastMeasurement;

    public Sensor() {
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public Measurement getLastMeasurement() {
        return lastMeasurement;
    }

    public void setLastMeasurement(Measurement lastMeasurement) {
        this.lastMeasurement = lastMeasurement;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "icon='" + icon + '\'' +
                ", title='" + title + '\'' +
                ", unit='" + unit + '\'' +
                ", sensorType='" + sensorType + '\'' +
                ", sensorID='" + sensorID + '\'' +
                ", lastMeasurement=" + lastMeasurement +
                '}';
    }
}
