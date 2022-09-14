package home.work;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class XmlConfigurationReaderTest {

    @Test
    void readFromFileThrowsExceptionForFileNotFound() {
        assertThrows(IOException.class,()->new XmlConfigurationReader().readFromFile("wrong-file.xml"));
    }

    @Test
    void readFromFileReturnsCorrectConfiguration() throws IOException, ConfigurationException {
        String fileName = ".\\resources\\xml-test.xml";

        Configuration expected = new Configuration("C:\\XML\\TESTS\\1","FINE");
        Configuration actual = new XmlConfigurationReader().readFromFile(fileName);

        assertEquals(expected.getLogLevel(),actual.getLogLevel());
        assertEquals(expected.getLogFilePath(),actual.getLogFilePath());
    }

    //REVIEW NOTES
    @Test
    void readFromFileReturnsCorrectConfiguration2() throws IOException, ConfigurationException {
        ConfigSample.assertEquals(
            new XmlConfigurationReader().readFromFile(fileName);
        );
    }
}

//REVIEW NOTES
class ConfigSample {
    static String expectedLevel = "WARN";
    static String expectedPath = "C:/some/path/filename.log";

    public static void assertEquals(Configuration cfg) {
        assertEquals(expectedLevel, cfg.getLogLevel());
        assertEquals(expectedPath, cfg.getLogFilePath());
    }
}