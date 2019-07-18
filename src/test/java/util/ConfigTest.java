package util;

import org.apache.commons.cli.UnrecognizedOptionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConfigTest {

    @Test
    public void testParseArgs() {
        String[] args = new String[]{
                "-osm", "senseBoxId",
                "-measurements",
                "-locations",
                "-timerange", "2000-01-01T00:00:00.000Z", "2000-01-02T00:00:00.000Z",
                "-path", "/test/path/out.rdf"
        };

        Assertions.assertDoesNotThrow(() -> new Config().parseArgs(args));
    }

    @Test
    public void testParseArgsWithUnknownParameter() {
        String[] args = new String[]{
                "-osm", "senseBoxId",
                "-unknown", "valueOfUnknown"
        };

        Assertions.assertThrows(UnrecognizedOptionException.class, () -> new Config().parseArgs(args));
    }
}
