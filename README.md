# SensorRDF

The SensorRDF parser allows you to convert unstructured sensor data to the standardized RDF format. At the moment, only the openSenseMap API is implemented as a data source. However, this project is meant to be a template for accessing different APIs and collect their data.

## Getting Started

The following instructions will help you compile and run this project.

### Prequisites

Make sure you match the following Requirements before starting:

* have Java setup on your machine (implemented with Java SE 11)
* have Maven setup on your machine (implemented with Maven 3.6.1)

### Compiling and Using the Code

Clone this repository or download the archive and unzip it. In the main folder (the one containing the pom.xml) run `mvn clean package`. This will start the build and test process. If everything went well, you will find a executable `.jar` in the `target` folder. You can run it with `java -jar XXX.jar`.

You may use the following parameters when calling the program:

|Parameter|Explanation|Example|
|---|---|---|
|osm|Set the ID of the senseBox you want to collect data from.|-osm 5cc58071facf70001a872bef|
|measurements|A flag indicating measurements should get collected.|-measurements|
|locations|A flag indicating only locations should get collected.|-locations|
|timerange|Set the range in which data should get collected. If not set, the last ~30 days will be used.|-timerange 2019-05-01T00:00:00.000Z 2019-05-15T00:00:00.000Z|
|path|Full path of your output file.|-path /folder/file.out|

Example call:
```
java -jar XXX.jar -osm 5cc58071facf70001a872bef -measurements
                  -timerange 2019-05-01T00:00:00.000Z 2019-05-15T00:00:00.000Z -path /rdf.out
```

### Tests

Some basic tests are implemented under the `test` folder. They may be useful to you when experimenting with this project.

## Used Frameworks and Ontologies

TBF

## What is RDF and why do I need it?

TBF
