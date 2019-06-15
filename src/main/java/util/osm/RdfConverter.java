package util.osm;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.vocabulary.GEO;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.RDFS;

import java.util.*;

import models.osm.Location;
import models.osm.Measurement;
import models.osm.Sensor;
import models.osm.SenseBox;
import vocabularys.SOSA;

public class RdfConverter {

    public static List<Statement> convertSenseBoxToStatements(SenseBox senseBox) {
        List<Statement> statements = new LinkedList<Statement>();

        ValueFactory factory = SimpleValueFactory.getInstance();

        IRI senseBoxIri = factory.createIRI("SenseBox:" + senseBox.getId());
        statements.add(factory.createStatement(senseBoxIri, RDF.TYPE, SOSA.Platform));

        for (Sensor sensor : senseBox.getBuiltInSensors()) {
            IRI sensorIri = factory.createIRI("Sensor:" + sensor.getSensorID());
            statements.add(factory.createStatement(senseBoxIri, SOSA.hosts, sensorIri));
            statements.add(factory.createStatement(sensorIri, RDF.TYPE, SOSA.Sensor));

            Literal sensorTitle = factory.createLiteral(sensor.getTitle());
            statements.add(factory.createStatement(sensorIri, RDFS.LABEL, sensorTitle));

            IRI sensorResultIri = factory.createIRI("Result:" + sensor.getSensorID() + "_" + sensor.getLastMeasurement().getCreatedAt());
            statements.add(factory.createStatement(sensorResultIri, RDF.TYPE, SOSA.Observation));
            statements.add(factory.createStatement(sensorResultIri, SOSA.madeBySensor, sensorIri));

            IRI sensorResultUnit = factory.createIRI("Unit:" + sensor.getUnit());
            Literal sensorResult = factory.createLiteral(String.valueOf(sensor.getLastMeasurement().getValue()), sensorResultUnit);
            statements.add(factory.createStatement(sensorResultIri, SOSA.hasSimpleResult, sensorResult));
        }

        Literal senseBoxLocation = convertDoubleCoordinatesToLiteral(senseBox.getCurrentLocation().getCoordinates());
        statements.add(factory.createStatement(senseBoxIri, GEO.WKT_LITERAL, senseBoxLocation));

        Literal senseBoxTime = factory.createLiteral(senseBox.getLastMeasurementAt());
        statements.add(factory.createStatement(senseBoxIri, SOSA.resultTime, senseBoxTime));

        return statements;
    }

    public static List<Statement> convertMeasurementsToStatements(List<Measurement> locations) {
        List<Statement> statements = new LinkedList<Statement>();

        return statements;
    }

    public static List<Statement> convertLocationsToStatements(List<Location> locations) {
        List<Statement> statements = new LinkedList<Statement>();

        return statements;
    }

    private static Literal convertDoubleCoordinatesToLiteral(double[] coordinates) {
        return SimpleValueFactory.getInstance().createLiteral("POINT(" + coordinates[0] + ", " + coordinates[1] + ")");
    }
}
