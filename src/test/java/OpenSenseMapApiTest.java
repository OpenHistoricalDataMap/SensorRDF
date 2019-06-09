import apis.OpenSenseMapApi;
import models.SenseBox;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class OpenSenseMapApiTest {

    @Test
    public void getLatestMeasurementsTest() throws IOException {
        SenseBox box = OpenSenseMapApi.getLatestMeasurements("5cc58071facf70001a872bef");

        System.out.println(box.toString());
    }
}
