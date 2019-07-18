package osm.util;

import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.Config;

import java.io.IOException;

public class OpenSenseMapHandlerTest {

    @Test
    public void testHandleConfigWithSenseBox() throws ParseException, IOException {
        String[] args = new String[]{
                "-osm", "5cc58071facf70001a872bef",
        };

        Assertions.assertDoesNotThrow(() -> new OpenSenseMapHandler().handleConfig(new Config().parseArgs(args)));
    }

    @Test
    public void testHandleConfigWithMeasurements() throws ParseException, IOException {
        String[] args = new String[]{
                "-osm", "5cc58071facf70001a872bef",
                "-measurements",
                "-timerange", "2019-05-01T00:00:00.000Z", "2019-05-15T00:00:00.000Z"
        };

        Assertions.assertDoesNotThrow(() -> new OpenSenseMapHandler().handleConfig(new Config().parseArgs(args)));
    }

    @Test
    public void testHandleConfigWithLocations() throws ParseException, IOException {
        String[] args = new String[]{
                "-osm", "5cc58071facf70001a872bef",
                "-locations",
                "-timerange", "2019-05-01T00:00:00.000Z", "2019-05-15T00:00:00.000Z"
        };

        Assertions.assertDoesNotThrow(() -> new OpenSenseMapHandler().handleConfig(new Config().parseArgs(args)));
    }
}
