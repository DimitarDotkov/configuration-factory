package home.work;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class IniConfigurationReaderTest {

    @Test
    void readFromFileThrowsExceptionForFileNotFound() {
        assertThrows(IOException.class,()->new IniConfigurationReader().readFromFile("not-exist.ini"));
    }

    @Test
    void readFromFileReturnsCorrectConfiguration() throws IOException, ConfigurationException {
        String fileName = ".\\resources\\ini-test.ini";

        Configuration expected = new Configuration("D:\\INI\\TESTS\\1","WARN");
        Configuration actual = new IniConfigurationReader().readFromFile(fileName);

        assertEquals(expected.getLogLevel(),actual.getLogLevel());
        assertEquals(expected.getLogFilePath(),actual.getLogFilePath());
    }

}