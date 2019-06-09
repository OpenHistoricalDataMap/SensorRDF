import apis.OpenSenseMapApi;
import models.Location;
import models.SenseBox;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class OpenSenseMapApiTest {

    @Test
    public void getLatestMeasurementsTest() throws IOException {
        SenseBox box = OpenSenseMapApi.getSenseBoxLatestMeasurement("5cc58071facf70001a872bef");

        System.out.println(box.toString());
    }

    @Test
    public void getSenseBoxLocationTest() throws IOException {
        List<Location> locations = OpenSenseMapApi.getSenseBoxLocations("5cc58071facf70001a872bef");

        for (Location location : locations) {
            System.out.println(location.toString());
        }
    }
}
