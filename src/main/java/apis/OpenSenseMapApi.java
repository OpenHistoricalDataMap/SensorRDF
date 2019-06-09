package apis;

import models.SenseBox;
import util.Helpers;

import java.io.IOException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class OpenSenseMapApi {

    public static SenseBox getLatestMeasurements(String senseBoxId) throws IOException {

        URL url = new URL("https://api.opensensemap.org/boxes/" + senseBoxId + "/sensors");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String inputLine;

        StringBuffer response = new StringBuffer();

        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }

        reader.close();

        return Helpers.readJSONResponseToPOJO(response.toString());
    }
}
