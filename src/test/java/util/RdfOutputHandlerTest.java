package util;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.vocabulary.GEO;
import org.eclipse.rdf4j.rio.RDFFormat;

import org.junit.jupiter.api.Test;

import util.RdfOutputHandler;
import vocabularys.SOSA;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class RdfOutputHandlerTest {

    @Test
    public void testOutput() throws IOException {

        ValueFactory factory = SimpleValueFactory.getInstance();

        IRI subject = factory.createIRI("station:4711");
        IRI predicate1 = GEO.WKT_LITERAL;
        Literal object1 = factory.createLiteral("POINT(13.524448, 52.455685)");
        Statement s1 = factory.createStatement(subject, predicate1, object1);

        IRI predicate2 = SOSA.hasSimpleResult;
        Literal object2 = factory.createLiteral(20.5);
        Statement s2 = factory.createStatement(subject, predicate2, object2);

        IRI predicate3 = SOSA.resultTime;
        Literal object3 = factory.createLiteral(new GregorianCalendar(2019, Calendar.MAY, 31).getTime());
        Statement s3 = factory.createStatement(subject, predicate3, object3);

        RdfOutputHandler.OutputRdfToFile(Arrays.asList(s1, s2, s3), System.getProperty("user.home") + "/output.rdf", RDFFormat.TURTLE);
    }
}
