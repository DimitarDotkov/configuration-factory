package home.work;

import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.IOException;

public interface ConfigurationReader {
    public Configuration readFromFile(String fileName) throws  IOException, ConfigurationException;
}
