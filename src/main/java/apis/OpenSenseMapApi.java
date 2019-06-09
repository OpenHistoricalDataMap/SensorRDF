package apis;

import models.Location;
import models.SenseBox;
import util.JsonConverter;

import java.io.IOException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.List;

public class OpenSenseMapApi {

    public static SenseBox getSenseBoxLatestMeasurement(String senseBoxId) throws IOException {
        URL url = new URL("https://api.opensensemap.org/boxes/" + senseBoxId + "/sensors");

        return JsonConverter.convertJsonToSenseBox(getJson(url));
    }

    public static List<Location> getSenseBoxLocations(String senseBoxId) throws IOException {
        URL url = new URL("https://api.opensensemap.org/boxes/" + senseBoxId + "/locations");

        return JsonConverter.convertJsonToLocations(getJson(url));
    }

    private static String getJson(URL url) throws IOException {
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

        System.out.println(response.toString());

        return response.toString();
    }
}
