package home.work;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationTest {

    @Test
    void getterForLogLevelReturnsLogLevel() {
        String logLevel = "WARN";

        Configuration configuration = new Configuration("D:\\Test","WARN");

        assertEquals(logLevel,configuration.getLogLevel());
    }

    @Test
    void getterForLogFilePathReturnsLogFilePath() {
        String logFilePath = "D:\\Test\\FurtherTestFolder";

        Configuration configuration = new Configuration("D:\\Test\\FurtherTestFolder","WARN");

        assertEquals(logFilePath,configuration.getLogFilePath());
    }
}