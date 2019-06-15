package util.osm;

import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.junit.jupiter.api.Test;

import apis.osm.OpenSenseMapApi;
import util.RdfOutputHandler;
import util.osm.RdfConverter;

import java.io.IOException;
import java.util.List;

public class OsmRdfConverterTest {

    @Test
    public void testStatementsCreation() throws IOException {
        List<Statement> statements = RdfConverter.convertSenseBoxToStatements(OpenSenseMapApi.getSenseBox("5cc58071facf70001a872bef"));

        RdfOutputHandler.OutputRdfToFile(statements, System.getProperty("user.home") + "/output.rdf", RDFFormat.TURTLE);
    }
}
