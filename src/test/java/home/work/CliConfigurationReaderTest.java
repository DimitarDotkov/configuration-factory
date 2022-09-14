package home.work;

import org.apache.commons.cli.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CliConfigurationReaderTest {
    CommandLine testParser(String[] testArgs) throws ParseException {
        Options options = new Options();
        options.addOption("c", "configuration", true, "Configuration file path");
        options.addOption("l", "log-path", true, "Log file path");
        options.addOption("v", "log-level", true, "Log level");

        CommandLineParser parser = new DefaultParser();
        return parser.parse(options, testArgs);
    }

    @Test
    void readFromReturnsCorrectConfiguration() throws ParseException {
        String[] testLine = new String[2];
        testLine[0]="--log-path=D:\\Cli\\Test";
        testLine[1]="--log-level=FINE";
        CommandLine cli = testParser(testLine);

        Configuration actual = CliConfigurationReader.readFrom(cli);
        Configuration expected = new Configuration("D:\\Cli\\Test","FINE");

        assertEquals(expected.getLogLevel(),actual.getLogLevel());
        assertEquals(expected.getLogFilePath(),actual.getLogFilePath());
    }
}