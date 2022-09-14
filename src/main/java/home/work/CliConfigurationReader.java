package home.work;

import org.apache.commons.cli.*;

public class CliConfigurationReader {
    public static Configuration readFrom(CommandLine cli){
        Configuration configuration = new Configuration(cli.getOptionValue("l"),cli.getOptionValue("v"));
        return configuration;
    }
}
