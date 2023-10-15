package edu.hillel.homework.lesson19.logger;

public class FileLoggerConfiguration {

    private final String filePath;
    private final LoggingLevel loggingLevel;
    private final long maxSize;
    private final String format;

    public FileLoggerConfiguration(String filePath, LoggingLevel loggingLevel, long maxSize, String format) {
        this.filePath = filePath;
        this.loggingLevel = loggingLevel;
        this.maxSize = maxSize;
        this.format = format;
    }

    public String getFilePath() {
        return filePath;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public String getFormat() {
        return format;
    }
}
