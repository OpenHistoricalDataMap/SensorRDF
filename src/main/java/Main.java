import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.MissingOptionException;
import org.apache.commons.cli.ParseException;

import osm.util.OpenSenseMapHandler;
import util.Config;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {

        Config c = new Config();
        try {
            CommandLine config = c.parseArgs(args);

            if (config.hasOption("osm")) {
                new OpenSenseMapHandler().handleConfig(config);
            } else {
                System.out.println("No data source specified.");
                System.out.println("Please refer to the README.");
            }
        } catch (MissingOptionException e) {
            c.printHelp();
        } catch (NullPointerException npe){
            c.printHelp();
        }
    }
}
