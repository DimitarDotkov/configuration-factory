package home.work;

import org.apache.commons.configuration2.INIConfiguration;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.*;

public class IniConfigurationReader implements ConfigurationReader {
    @Override
    public Configuration readFromFile(String fileName) throws IOException, ConfigurationException {
        INIConfiguration iniConfiguration = new INIConfiguration();
        Reader reader = new BufferedReader(new FileReader(fileName));
        iniConfiguration.read(reader);

        return new Configuration(iniConfiguration.getSection("log").getProperty("LogPath").toString(),iniConfiguration.getSection("log").getProperty("LogLevel").toString());
    }
}



