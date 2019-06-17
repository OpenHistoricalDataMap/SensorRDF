package osm.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import osm.models.Location;
import osm.models.Measurement;
import osm.models.SenseBox;

import java.io.IOException;
import java.util.List;

public class JsonConverter {

    public static SenseBox convertToSenseBox(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(json, SenseBox.class);
    }

    public static List<Measurement> convertToMeasurements(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(json, new TypeReference<List<Measurement>>(){});
    }

    public static List<Location> convertToLocations(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(json, new TypeReference<List<Location>>(){});
    }
}
