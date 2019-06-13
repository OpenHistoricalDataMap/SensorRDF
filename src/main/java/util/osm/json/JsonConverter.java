package util.osm.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.osm.Location;
import models.osm.Measurement;
import models.osm.SenseBox;

import java.io.IOException;
import java.util.List;

public class JsonConverter {

    public static SenseBox convertJsonToSenseBox(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(json, SenseBox.class);
    }

    public static List<Measurement> convertJsonToMeasurements(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(json, new TypeReference<List<Measurement>>(){});
    }

    public static List<Location> convertJsonToLocations(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(json, new TypeReference<List<Location>>(){});
    }
}
