package models;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;


public class SenseBox {

    @JsonProperty("_id")
    private String id;

    @JsonProperty("sensors")
    private List<Sensor> builtInSensors;

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("updatedAt")
    private String updatedAt;

    @JsonProperty("name")
    private String name;

    @JsonProperty("currentLocation")
    private Location currentLocation;

    @JsonProperty("exposure")
    private String exposure;

    public SenseBox(){

    }

    public SenseBox(String id, List<Sensor> builtInSensors, String createdAt, String updatedAt, String name, Location currentLocation, String exposure) {
        this.id = id;
        this.builtInSensors = builtInSensors;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.name = name;
        this.currentLocation = currentLocation;
        this.exposure = exposure;
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

    @JsonProperty("sensors")
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

    @Override
    public String toString() {
        return "SenseBox "+id+ "{" +
                ", sensors=" + builtInSensors +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", name='" + name + '\'' +
                ", currentLocation='" + currentLocation + '\'' +
                ", exposure='" + exposure + '\'' +
                '}';
    }

/**
    @SuppressWarnings("unchecked")
    @JsonProperty("sensors")
    private void unpackSensors(Map<String,Object> brand) {
        this.builtInSensors = (String)builtInSensors.get("lastMeasurement");
        Map<String,String> owner = (Map<String,String>)builtInSensors.get("owner");
        this.ownerName = owner.get("name");
    }**/
}
