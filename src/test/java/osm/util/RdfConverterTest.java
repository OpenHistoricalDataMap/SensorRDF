package osm.util;

import org.eclipse.rdf4j.model.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import osm.models.Location;
import osm.models.Measurement;
import osm.models.SenseBox;
import osm.models.Sensor;
import util.RdfOutputHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class RdfConverterTest {

    private static String testFile = System.getProperty("user.home") + "/output.rdf";

    private static String mobileStationId = "5cc58071facf70001a872bef";
    private static String mobileStationSensorID = "5cc58071facf70001a872bf1";

    private static String fromDate = "2019-05-01T00:00:00.000Z";
    private static String toDate = "2019-06-01T00:00:00.000Z";

    private static SenseBox senseBox;

    @BeforeAll
    public static void setUp() throws IOException {
        senseBox = OpenSenseMapApi.getSenseBox(mobileStationId);
    }

    @AfterAll
    public static void tearDown() throws IOException {
        Files.delete(new File(testFile).toPath());
    }

    @Test
    public void testConvertSenseBoxToStatements() {
        List<Statement> statements = RdfConverter.convertSenseBoxToStatements(senseBox);

        Assertions.assertDoesNotThrow(() -> RdfOutputHandler.OutputRdfToFile(statements, testFile));
    }

    @Test
    public void testConvertMeasurementsToStatements() throws IOException {
        List<Measurement> measurements = OpenSenseMapApi.getMeasurements(mobileStationId, mobileStationSensorID, fromDate, toDate);

        Sensor sensor = OpenSenseMapApi.getSenseBox(mobileStationId).getBuiltInSensors().get(0);

        List<Statement> statements = RdfConverter.convertMeasurementsToStatements(sensor, measurements);

        Assertions.assertDoesNotThrow(() -> RdfOutputHandler.OutputRdfToFile(statements, testFile));
    }

    @Test
    public void testConvertLocationsToStatements() throws IOException {
        List<Location> locations = OpenSenseMapApi.getLocations(mobileStationId, fromDate, toDate);

        List<Statement> statements = RdfConverter.convertLocationsToStatements(senseBox, locations);

        Assertions.assertDoesNotThrow(() -> RdfOutputHandler.OutputRdfToFile(statements, testFile));
    }
}
