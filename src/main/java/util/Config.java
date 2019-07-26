package util;

import org.apache.commons.cli.*;

public class Config {

    private Options options;

    public Config() {
        options = new Options();

        options.addOption(Option.builder("osm")
                .required(false)
                .hasArg(true)
                .numberOfArgs(1)
                .optionalArg(false)
                .argName("SenseBoxId")
                .desc("Id of the SenseBox.")
                .build());

        options.addOption(Option.builder("measurements")
                .required(false)
                .hasArg(false)
                .desc("Set if measurements and locations should get collected.")
                .build());

        options.addOption(Option.builder("locations")
                .required(false)
                .hasArg(false)
                .desc("Set if only locations should get collected.")
                .build());

        options.addOption(Option.builder("timerange")
                .required(false)
                .hasArg(true)
                .numberOfArgs(2)
                .optionalArg(false)
                .argName("fromDate toDate")
                .desc("Time range in witch data gets collected. (Example: 2019-05-01T00:00:00.000Z 2019-05-15T00:00:00.000Z)")
                .build());

        options.addOption(Option.builder("path")
                .required(true)
                .hasArg(true)
                .numberOfArgs(1)
                .optionalArg(false)
                .argName("/path/to/file.rdf")
                .desc("Path to output file.")
                .build());
    }

    public CommandLine parseArgs(String[] args) throws ParseException {
        return new DefaultParser().parse(options, args);
    }
}
