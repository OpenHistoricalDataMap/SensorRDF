package apis;

import models.Location;
import models.Measurement;
import models.SenseBox;
import util.JsonConverter;

import java.io.IOException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.List;

public class OpenSenseMapApi {

    // https://docs.opensensemap.org/#api-Measurements-getLatestMeasurements
    public static SenseBox getSenseBoxLatestMeasurement(String senseBoxId) throws IOException {
        URL url = new URL("https://api.opensensemap.org/boxes/" + senseBoxId);

        return JsonConverter.convertJsonToSenseBox(getJsonFromUrl(url));
    }

    // https://docs.opensensemap.org/#api-Measurements-getData
    public static List<Measurement> getSenseBoxLatestMeasurements(String senseBoxId, String sensorId) throws IOException {
        URL url = new URL("https://api.opensensemap.org/boxes/" + senseBoxId + "/data/" + sensorId);

        return JsonConverter.convertJsonToMeasurements(getJsonFromUrl(url));
    }

    // https://docs.opensensemap.org/#api-Boxes-getBoxLocations
    public static List<Location> getSenseBoxLocations(String senseBoxId) throws IOException {
        URL url = new URL("https://api.opensensemap.org/boxes/" + senseBoxId + "/locations");

        return JsonConverter.convertJsonToLocations(getJsonFromUrl(url));
    }

    private static String getJsonFromUrl(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuffer response = new StringBuffer();

        String inputLine;

        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }

        reader.close();

        return response.toString();
    }
}
