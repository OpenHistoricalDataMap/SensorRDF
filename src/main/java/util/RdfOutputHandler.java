package util;

import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFWriter;
import org.eclipse.rdf4j.rio.Rio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class RdfOutputHandler {
    public static void OutputRdfToFile(List<Statement> statements, String filePath) throws IOException {
        FileOutputStream stream = new FileOutputStream(filePath);

        RDFWriter writer = Rio.createWriter(RDFFormat.TURTLE, stream);

        writer.startRDF();

        for (Statement statement : statements) {
            writer.handleStatement(statement);
        }

        writer.endRDF();
        stream.close();
    }
}
