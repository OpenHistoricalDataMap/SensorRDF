package vocabularys;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;

public class SOSA {
    private static ValueFactory factory = SimpleValueFactory.getInstance();

    // Namespace and Prefix
    public static final String NAMESPACE = "http://www.w3.org/ns/sosa/";
    public static final String PREFIX = "sosa";

    // Classes
    public static final IRI Platform = factory.createIRI(NAMESPACE + "Platform");
    public static final IRI Sensor = factory.createIRI(NAMESPACE + "Sensor");
    public static final IRI Result = factory.createIRI(NAMESPACE + "Result");
    public static final IRI Observation = factory.createIRI(NAMESPACE + "Observation");

    // Properties
    public static final IRI hosts = factory.createIRI(NAMESPACE + "hosts");
    public static final IRI hasSimpleResult = factory.createIRI(NAMESPACE + "hasSimpleResult");
    public static final IRI resultTime = factory.createIRI(NAMESPACE + "resultTime");
    public static final IRI madeBySensor = factory.createIRI(NAMESPACE + "madeBySensor");
}
