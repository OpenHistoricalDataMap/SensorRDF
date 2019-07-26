import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.MissingOptionException;
import org.apache.commons.cli.ParseException;

import osm.util.OpenSenseMapHandler;
import util.Config;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {

        try {
            CommandLine config = new Config().parseArgs(args);

            if (config.hasOption("osm")) {
                new OpenSenseMapHandler().handleConfig(config);
            } else {
                System.out.println("No data source specified.");
                System.out.println("Please refer to the README.");
            }
        } catch (MissingOptionException e) {
            System.out.println("You are missing the following options: " + e.getMissingOptions());
            System.out.println("Please refer to the README.");
        }
    }
}
