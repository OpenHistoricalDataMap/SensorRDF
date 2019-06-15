package api.osm;

import apis.osm.OpenSenseMapApi;
import models.osm.Location;
import models.osm.Measurement;
import models.osm.SenseBox;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class OpenSenseMapApiTest {

    @Test
    public void getSenseBoxTest() throws IOException {
        SenseBox box = OpenSenseMapApi.getSenseBox("5cc58071facf70001a872bef");

        System.out.println(box.toString());
    }

    @Test
    public void getLatestMeasurementsTest() throws IOException {
        List<Measurement> measurements = OpenSenseMapApi.getMeasurements("5cc58071facf70001a872bef", "5cc58071facf70001a872bf1");

        for (Measurement measurement : measurements) {
            measurement.toString();
        }
    }

    @Test
    public void getMeasurementsTest() throws IOException {
        String fromDate = "2019-05-01T00:00:00.000Z";
        String toDate = "2019-06-01T00:00:00.000Z";

        List<Measurement> measurements = OpenSenseMapApi.getMeasurements("5cc58071facf70001a872bef", "5cc58071facf70001a872bf1", fromDate, toDate);

        for (Measurement measurement : measurements) {
            measurement.toString();
        }
    }

    @Test
    public void getLatestLocationsTest() throws IOException {
        List<Location> locations = OpenSenseMapApi.getLocations("5cc58071facf70001a872bef");

        for (Location location : locations) {
            System.out.println(location.toString());
        }
    }

    @Test
    public void getLocationsTest() throws IOException {
        String fromDate = "2019-06-01T00:00:00.000Z";
        String toDate = "2019-06-15T00:00:00.000Z";

        List<Location> locations = OpenSenseMapApi.getLocations("5cc58071facf70001a872bef", fromDate, toDate);

        for (Location location : locations) {
            System.out.println(location.toString());
        }
    }
}
