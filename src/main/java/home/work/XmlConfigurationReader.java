package home.work;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.BasicConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.io.FileHandler;

import java.io.*;

public class XmlConfigurationReader implements ConfigurationReader {

    @Override
    public Configuration readFromFile(String fileName) throws IOException, ConfigurationException {
        Reader reader = new BufferedReader(new FileReader(fileName));
        XMLConfiguration cfg = new BasicConfigurationBuilder<>(XMLConfiguration.class).configure(new Parameters().xml()).getConfiguration();
        FileHandler fh = new FileHandler(cfg);
        fh.load(reader);
        return new Configuration(cfg.getString("log.path"),cfg.getString("log.level"));
    }
}
