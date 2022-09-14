package home.work;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class App 
{
    public static void main( String[] args ) throws Exception {
        CommandLine cmd = parse(args);
        Configuration config = ConfigurationReaderFactory.create(cmd);
        System.out.println(config.getLogFilePath() + " " + config.getLogLevel());
    }

    static public CommandLine parse(String[] args) throws ParseException {

        Options options = new Options();
        options.addOption("c", "configuration", true, "Configuration file path");
        options.addOption("l", "log-path", true, "Log file path");
        options.addOption("v", "log-level", true, "Log level");

        CommandLineParser parser = new DefaultParser();
        return parser.parse(options, args);
    }
}
