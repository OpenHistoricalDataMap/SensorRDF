package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Location;
import models.Measurement;
import models.SenseBox;

import java.io.IOException;
import java.util.List;

public class JsonConverter {

    public static SenseBox convertJsonToSenseBox(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(json, SenseBox.class);
    }

    public static List<Measurement> convertJsonToMeasurements(String json) throws IOException {
        System.out.println(json);

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(json, new TypeReference<List<Measurement>>(){});
    }

    public static List<Location> convertJsonToLocations(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(json, new TypeReference<List<Location>>(){});
    }
}
