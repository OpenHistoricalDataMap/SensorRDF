import org.apache.commons.cli.*;

import osm.util.OpenSenseMapHandler;
import util.Config;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Config c = new Config();

        try {
            CommandLine config = c.parseArgs(args);

            if (config.hasOption("osm")) {
                new OpenSenseMapHandler().handleConfig(config);
            } else {
                System.out.println("No data source specified.\nPlease refer to the README.");
            }
        } catch (ParseException e) {
            c.printHelp();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
