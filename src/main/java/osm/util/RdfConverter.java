package osm.util;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.vocabulary.GEO;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.RDFS;

import java.util.*;

import osm.models.Location;
import osm.models.Measurement;
import osm.models.Sensor;
import osm.models.SenseBox;
import vocabularys.SOSA;

public class RdfConverter {

    public static List<Statement> convertSenseBoxToStatements(SenseBox senseBox) {
        List<Statement> statements = new LinkedList<Statement>();

        ValueFactory factory = SimpleValueFactory.getInstance();

        IRI senseBoxIri = getId(senseBox);
        statements.add(factory.createStatement(senseBoxIri, RDF.TYPE, SOSA.Platform));

        for (Sensor sensor : senseBox.getBuiltInSensors()) {
            // Adding Sensor to SenseBox
            IRI sensorIri = getId(sensor);
            statements.add(factory.createStatement(senseBoxIri, SOSA.hosts, sensorIri));
            statements.add(factory.createStatement(sensorIri, RDF.TYPE, SOSA.Sensor));

            // Adding Title to Sensor
            Literal sensorTitle = factory.createLiteral(sensor.getTitle());
            statements.add(factory.createStatement(sensorIri, RDFS.LABEL, sensorTitle));
        }

        return statements;
    }

    public static List<Statement> convertMeasurementsToStatements(Sensor sensor, List<Measurement> measurements) {
        List<Statement> statements = new LinkedList<Statement>();

        ValueFactory factory = SimpleValueFactory.getInstance();

        IRI sensorIri = getId(sensor);

        for (Measurement measurement : measurements) {
            // Adding Result as Observation of Sensor
            IRI sensorResultIri = factory.createIRI("Result:" + sensor.getSensorID() + "_" + measurement.getCreatedAt());
            statements.add(factory.createStatement(sensorResultIri, RDF.TYPE, SOSA.Observation));
            statements.add(factory.createStatement(sensorResultIri, SOSA.madeBySensor, sensorIri));

            // Adding Result Value
            IRI sensorResultUnit = factory.createIRI("Unit:" + sensor.getUnit());
            Literal sensorResult = factory.createLiteral(String.valueOf(measurement.getValue()), sensorResultUnit);
            statements.add(factory.createStatement(sensorResultIri, SOSA.hasSimpleResult, sensorResult));

            // Adding Location
            Literal measurementLocation = convertDoubleCoordinatesToLiteral(measurement.getLocation());
            statements.add(factory.createStatement(sensorResultIri, GEO.WKT_LITERAL, measurementLocation));

            // Adding Time
            Literal measurementTime = factory.createLiteral(measurement.getCreatedAt());
            statements.add(factory.createStatement(sensorResultIri, SOSA.resultTime, measurementTime));
        }

        return removeDuplicates(statements);
    }

    public static List<Statement> convertLocationsToStatements(SenseBox senseBox, List<Location> locations) {
        List<Statement> statements = new LinkedList<Statement>();

        ValueFactory factory = SimpleValueFactory.getInstance();

        IRI senseBoxIri = getId(senseBox);

        for (Location location : locations) {
            // Adding Location
            Literal senseBoxLocation = convertDoubleCoordinatesToLiteral(location.getCoordinates());
            statements.add(factory.createStatement(senseBoxIri, GEO.WKT_LITERAL, senseBoxLocation));

            // Adding Time
            Literal senseBoxTime = factory.createLiteral(location.getTimestamp());
            statements.add(factory.createStatement(senseBoxIri, SOSA.resultTime, senseBoxTime));
        }

        return removeDuplicates(statements);
    }

    private static IRI getId(SenseBox senseBox) {
        return SimpleValueFactory.getInstance().createIRI("SenseBox:" + senseBox.getId());
    }

    private static IRI getId(Sensor sensor) {
        return SimpleValueFactory.getInstance().createIRI("Sensor:" + sensor.getSensorID());
    }

    private static Literal convertDoubleCoordinatesToLiteral(double[] coordinates) {
        return SimpleValueFactory.getInstance().createLiteral("POINT(" + coordinates[0] + ", " + coordinates[1] + ")");
    }

    /***
     * Duplicate "subject, predicate, object" combinations will lead to an AssertionError when writing to file.
     * Therefore, they will get filtered out with this method.
     * @// TODO: Since this process is time consuming, try to find another way of dealing with duplicates.
     */
    private static List<Statement> removeDuplicates(List<Statement> statements) {
        List<Statement> uniqueStatements = new LinkedList<Statement>();

        for (Statement statement : statements) {
            if (!uniqueStatements.contains(statement))
                uniqueStatements.add(statement);
        }

        return uniqueStatements;
    }
}
