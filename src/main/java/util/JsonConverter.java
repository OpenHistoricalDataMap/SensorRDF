package util;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.SenseBox;

import java.io.IOException;

public class JsonConverter {

    public static SenseBox convertJsonToSenseBox(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(json, SenseBox.class);
    }
}
