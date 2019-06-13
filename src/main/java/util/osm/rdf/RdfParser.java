package util.osm.rdf;

import models.osm.Location;
import models.osm.Measurement;
import models.osm.Sensor;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.vocabulary.GEO;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.RDFS;

import java.util.*;

import models.osm.SenseBox;
import vocabularys.SOSA;

public class RdfParser {

    public static List<Statement> SenseBoxToStatements(SenseBox senseBox) {
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

        Literal senseBoxLocation = DoubleCoordinatesToLiteral(senseBox.getCurrentLocation().getCoordinates());
        statements.add(factory.createStatement(senseBoxIri, GEO.WKT_LITERAL, senseBoxLocation));

        Literal senseBoxTime = factory.createLiteral(senseBox.getLastMeasurementAt());
        statements.add(factory.createStatement(senseBoxIri, SOSA.resultTime, senseBoxTime));

        return statements;
    }

    public static List<Statement> MeasurementsToStatements(List<Measurement> locations) {
        List<Statement> statements = new LinkedList<Statement>();

        ValueFactory factory = SimpleValueFactory.getInstance();

        return statements;
    }

    public static List<Statement> LocationsToStatements(List<Location> locations) {
        List<Statement> statements = new LinkedList<Statement>();

        return statements;
    }

    private static Literal DoubleCoordinatesToLiteral(double[] coordinates) {
        return SimpleValueFactory.getInstance().createLiteral("POINT(" + coordinates[0] + ", " + coordinates[1] + ")");
    }
}