package home.work;

import org.apache.commons.cli.*;

public class ConfigurationReaderFactory {
    public static Configuration create(CommandLine cmd) throws Exception {
        if(cmd.hasOption('c')) {

            String fileName = cmd.getOptionValue('c');
            ConfigurationReader reader = ConfigurationReaderFactory.createFromFilename(fileName);
            return reader.readFromFile(fileName);
        } else {
            return CliConfigurationReader.readFrom(cmd);
        }
    }

    public static String fileExtension(String fileName) {
        int lastIndex=fileName.lastIndexOf(".");
        String extension = fileName.substring(lastIndex+1);
        return extension;
    }

    public static ConfigurationReader createFromFilename(String filename) throws Exception {
        switch(fileExtension(filename)) {
            case "ini":
                return new IniConfigurationReader();
            case "xml":
                return new XmlConfigurationReader();
            case "":
                throw new Exception("File name is missing!");
            default:
            throw new Exception("File type is not supported!");
        }
    }
}
