import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.junit.jupiter.api.Test;

import apis.osm.OpenSenseMapApi;
import util.osm.RdfOutput;
import util.osm.rdf.RdfParser;

import java.io.IOException;
import java.util.List;

public class OsmRdfParserTest {

    @Test
    public void testStatementsCreation() throws IOException {
        List<Statement> statements = RdfParser.SenseBoxToStatements(OpenSenseMapApi.getLatestMeasurement("5cc58071facf70001a872bef"));

        RdfOutput.OutputRdfToFile(statements, System.getProperty("user.home") + "/output.rdf", RDFFormat.TURTLE);
    }
}
