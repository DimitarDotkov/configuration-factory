package home.work;

public class Configuration {
    String logFilePath;
    String logLevel;

    public Configuration(String logFilePath,String logLevel){
        this.logFilePath=logFilePath;
        this.logLevel=logLevel;
    }

    public String getLogLevel(){
        return this.logLevel;
    }

    public String getLogFilePath(){
        return this.logFilePath;
    }
}
