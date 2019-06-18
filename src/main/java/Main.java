import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;

import osm.util.OpenSenseMapHandler;
import util.Config;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {

        CommandLine config = new Config().parseArgs(args);

        if (config.hasOption("osm")) {
            new OpenSenseMapHandler().handleUserAction(config);
        }
    }
}
