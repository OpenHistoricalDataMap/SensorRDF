package osm.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SenseBox {

    @JsonProperty("_id")
    private String id;

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("updatedAt")
    private String updatedAt;

    @JsonProperty("sensors")
    private List<Sensor> builtInSensors;

    @JsonProperty("name")
    private String name;

    @JsonProperty("exposure")
    private String exposure;

    @JsonProperty("currentLocation")
    private Location currentLocation;

    @JsonProperty("model")
    private String model;

    @JsonProperty("lastMeasurementAt")
    private String lastMeasurementAt;

    // Ignoring this one, since it is nested further and only contains redundant data
    @JsonProperty("loc")
    @JsonIgnore
    private Object loc;

    public SenseBox() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Sensor> getBuiltInSensors() {
        return builtInSensors;
    }

    public void setBuiltInSensors(List<Sensor> builtInSensors) {
        this.builtInSensors = builtInSensors;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getExposure() {
        return exposure;
    }

    public void setExposure(String exposure) {
        this.exposure = exposure;
    }

    public String getModel() {
        return model;
    }

    public String getLastMeasurementAt() {
        return lastMeasurementAt;
    }

    public void setLastMeasurementAt(String lastMeasurementAt) {
        this.lastMeasurementAt = lastMeasurementAt;
    }

    public Object getLoc() {
        return loc;
    }

    public void setLoc(Object loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "SenseBox{" +
                "id='" + id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", builtInSensors=" + builtInSensors +
                ", name='" + name + '\'' +
                ", exposure='" + exposure + '\'' +
                ", currentLocation=" + currentLocation +
                ", model='" + model + '\'' +
                ", lastMeasurementAt='" + lastMeasurementAt + '\'' +
                ", loc=" + loc +
                '}';
    }
}
