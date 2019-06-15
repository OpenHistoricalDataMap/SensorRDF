package apis.osm;

import models.osm.Location;
import models.osm.Measurement;
import models.osm.SenseBox;
import util.JsonInputHandler;
import util.osm.JsonConverter;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class OpenSenseMapApi {

    /***
     * @see "https://docs.opensensemap.org/#api-Measurements-getLatestMeasurements"
     */
    public static SenseBox getSenseBox(String senseBoxId) throws IOException {
        URL url = new URL("https://api.opensensemap.org/boxes/" + senseBoxId);

        return JsonConverter.convertToSenseBox(JsonInputHandler.getJsonFromUrl(url));
    }

    /***
     * @see "https://docs.opensensemap.org/#api-Measurements-getData"
     */
    public static List<Measurement> getMeasurements(String senseBoxId, String sensorId) throws IOException {
        URL url = new URL("https://api.opensensemap.org/boxes/" + senseBoxId + "/data");

        return JsonConverter.convertToMeasurements(JsonInputHandler.getJsonFromUrl(url));
    }

    /***
     * @see "https://docs.opensensemap.org/#api-Measurements-getData"
     */
    public static List<Measurement> getMeasurements(String senseBoxId, String sensorId, String fromDate, String toDate) throws IOException {
        URL url = new URL("https://api.opensensemap.org/boxes/" + senseBoxId + "/data/" + sensorId + "?from-date=" + fromDate + "&to-date=" + toDate);

        return JsonConverter.convertToMeasurements(JsonInputHandler.getJsonFromUrl(url));
    }

    /***
     * @see "https://docs.opensensemap.org/#api-Boxes-getBoxLocations"
     */
    public static List<Location> getLocations(String senseBoxId) throws IOException {
        URL url = new URL("https://api.opensensemap.org/boxes/" + senseBoxId + "/locations");

        return JsonConverter.convertToLocations(JsonInputHandler.getJsonFromUrl(url));
    }

    /***
     * @see "https://docs.opensensemap.org/#api-Boxes-getBoxLocations"
     */
    public static List<Location> getLocations(String senseBoxId, String fromDate, String toDate) throws IOException {
        URL url = new URL("https://api.opensensemap.org/boxes/" + senseBoxId + "/locations?from-date=" + fromDate + "&to-date=" + toDate);

        return JsonConverter.convertToLocations(JsonInputHandler.getJsonFromUrl(url));
    }
}
