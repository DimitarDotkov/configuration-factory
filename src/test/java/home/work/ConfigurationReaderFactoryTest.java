package home.work;

import org.apache.commons.cli.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationReaderFactoryTest {

    CommandLine testParser(String[] testArgs) throws ParseException {
        Options options = new Options();
        options.addOption("c", "configuration", true, "Configuration file path");
        options.addOption("l", "log-path", true, "Log file path");
        options.addOption("v", "log-level", true, "Log level");

        CommandLineParser parser = new DefaultParser();
        return parser.parse(options, testArgs);
    }

    @Test
    void createReturnsNewConfigurationFromValidCommandLineArguments() throws Exception {
        String[] args=new String[1];
        args[0]="--configuration=.\\resources\\valid-test.ini";

        Configuration expectedConfig = ConfigurationReaderFactory.create(testParser(args));
        Configuration actualConfig = new Configuration("D:\\sample","FINE");

        assertEquals(expectedConfig.getLogLevel(),actualConfig.getLogLevel());
        assertEquals(expectedConfig.getLogFilePath(),actualConfig.getLogFilePath());

    }

    @Test
    void createThrowsExceptionFromErrorInFileName(){
        String[] args = new String[1];
        args[0]="--configuration=tes.ini";
        assertThrows(IOException.class,()->ConfigurationReaderFactory.create(testParser(args)));
    }

    @Test
    void createThrowsExceptionFromErrorInCommandLineArguments(){
        String[] args = new String[1];
        args[0]="--confa=test.ini";
        assertThrows(ParseException.class,()->ConfigurationReaderFactory.create(testParser(args)));
    }

    @Test
    void fileExtensionReturnsXmlExtensionFromFileName() {
        String fileName="sample.name.xml";

        assertEquals("xml",ConfigurationReaderFactory.fileExtension(fileName));
    }

    @Test
    void fileExtensionReturnsIniExtensionFromFileName() {
        String fileName="test-file.name.ini";

        assertEquals("ini",ConfigurationReaderFactory.fileExtension(fileName));
    }

    @Test
    void createFromFilenameThrowsExceptionForEmptyFileName(){
        String emptyFileName = "";
        Exception exception =assertThrows(Exception.class,()->ConfigurationReaderFactory.createFromFilename(emptyFileName));

        String expectedMessage = "File name is missing!";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    void createFromFilenameThrowsExceptionForUnsupportedFileFormat(){
        String fileName = "samples.txt";
        Exception exception = assertThrows(Exception.class,()->ConfigurationReaderFactory.createFromFilename(fileName));

        String expectedMessage = "File type is not supported!";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage,actualMessage);
    }
}