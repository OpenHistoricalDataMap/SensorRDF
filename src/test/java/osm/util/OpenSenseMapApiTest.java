package osm.util;

import osm.models.Location;
import osm.models.Measurement;
import osm.models.SenseBox;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class OpenSenseMapApiTest {

    private static String mobileStationId = "5cc58071facf70001a872bef";
    private static String mobileStationSensorID = "5cc58071facf70001a872bf1";

    private static String fromDate = "2019-05-01T00:00:00.000Z";
    private static String toDate = "2019-06-01T00:00:00.000Z";

    @Test
    public void getSenseBoxTest() throws IOException {
        SenseBox box = OpenSenseMapApi.getSenseBox(mobileStationId);

        System.out.println(box.toString());
    }

    @Test
    public void testGetLatestMeasurements() throws IOException {
        List<Measurement> measurements = OpenSenseMapApi.getMeasurements(mobileStationId, mobileStationSensorID);

        for (Measurement measurement : measurements) {
            measurement.toString();
        }
    }

    @Test
    public void testGetMeasurements() throws IOException {
        List<Measurement> measurements = OpenSenseMapApi.getMeasurements(mobileStationId, mobileStationSensorID, fromDate, toDate);

        for (Measurement measurement : measurements) {
            measurement.toString();
        }
    }

    @Test
    public void testGetLatestLocations() throws IOException {
        List<Location> locations = OpenSenseMapApi.getLocations(mobileStationId);

        for (Location location : locations) {
            System.out.println(location.toString());
        }
    }

    @Test
    public void testGetLocations() throws IOException {
        List<Location> locations = OpenSenseMapApi.getLocations(mobileStationId, fromDate, toDate);

        for (Location location : locations) {
            System.out.println(location.toString());
        }
    }
}
