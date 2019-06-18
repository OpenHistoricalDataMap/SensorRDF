package osm.util;

import org.apache.commons.cli.CommandLine;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.rio.RDFFormat;

import osm.models.Location;
import osm.models.Measurement;
import osm.models.SenseBox;
import osm.models.Sensor;
import util.RdfOutputHandler;

import java.io.IOException;
import java.util.List;

public class OpenSenseMapHandler {

    public void handleUserAction(CommandLine config) throws IOException {
        SenseBox senseBox = OpenSenseMapApi.getSenseBox(config.getOptionValue("osm"));

        List<Statement> statements = RdfConverter.convertSenseBoxToStatements(senseBox);

        if (config.hasOption("measurements")) {
            for (Sensor sensor : senseBox.getBuiltInSensors()) {

                List<Measurement> measurements = null;

                if (config.hasOption("timerange")) {
                    String[] timeRange = config.getOptionValues("timerange");

                    measurements = OpenSenseMapApi.getMeasurements(senseBox.getId(), sensor.getSensorID(), timeRange[0], timeRange[1]);
                } else {
                    measurements = OpenSenseMapApi.getMeasurements(senseBox.getId(), sensor.getSensorID());
                }

                statements.addAll(RdfConverter.convertMeasurementsToStatements(sensor, measurements));
            }


        } else if (config.hasOption("locations")) {
            List<Location> locations = null;

            if (config.hasOption("timerange")) {
                String[] timeRange = config.getOptionValues("timerange");

                locations = OpenSenseMapApi.getLocations(senseBox.getId(), timeRange[0], timeRange[1]);
            } else {
                locations = OpenSenseMapApi.getLocations(senseBox.getId());
            }

            statements.addAll(RdfConverter.convertLocationsToStatements(senseBox, locations));
        }

        String filePath = config.getOptionValue("path", System.getProperty("user.home") + "/OsmOutput.rdf");

        RdfOutputHandler.OutputRdfToFile(statements, filePath, RDFFormat.TURTLE);
    }
}
