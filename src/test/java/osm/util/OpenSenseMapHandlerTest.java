package osm.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.Config;


public class OpenSenseMapHandlerTest {

    @Test
    public void testHandleConfigWithSenseBox() {
        String[] args = new String[]{
                "-osm", "5cc58071facf70001a872bef",
                "-path", "file.out"
        };

        Assertions.assertDoesNotThrow(() -> new OpenSenseMapHandler().handleConfig(new Config().parseArgs(args)));
    }

    @Test
    public void testHandleConfigWithMeasurements() {
        String[] args = new String[]{
                "-osm", "5cc58071facf70001a872bef",
                "-measurements",
                "-timerange", "2019-05-01T00:00:00.000Z", "2019-05-15T00:00:00.000Z",
                "-path", "file.out"
        };

        Assertions.assertDoesNotThrow(() -> new OpenSenseMapHandler().handleConfig(new Config().parseArgs(args)));
    }

    @Test
    public void testHandleConfigWithLocations() {
        String[] args = new String[]{
                "-osm", "5cc58071facf70001a872bef",
                "-locations",
                "-timerange", "2019-05-01T00:00:00.000Z", "2019-05-15T00:00:00.000Z",
                "-path", "file.out"
        };

        Assertions.assertDoesNotThrow(() -> new OpenSenseMapHandler().handleConfig(new Config().parseArgs(args)));
    }
}
