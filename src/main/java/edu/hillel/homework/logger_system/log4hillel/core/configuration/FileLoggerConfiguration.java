package edu.hillel.homework.logger_system.log4hillel.core.configuration;

import edu.hillel.homework.logger_system.log4hillel.LogLevel;

public class FileLoggerConfiguration implements LoggerConfigurationInterface {

    private final boolean enabled;
    private final String logFilePath;
    private final long maxLogFileSize;
    private final LogLevel logLevel;
    private final String loggingFormat;

    public FileLoggerConfiguration(boolean enabled, String logFilePath, long maxLogFileSize, LogLevel logLevel, String loggingFormat) {
        this.enabled = enabled;
        this.logFilePath = logFilePath;
        this.maxLogFileSize = maxLogFileSize;
        this.logLevel = logLevel;
        this.loggingFormat = loggingFormat;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public String getLogFilePath() {
        return logFilePath;
    }

    public long getMaxLogFileSize() {
        return maxLogFileSize;
    }

    @Override
    public LogLevel getLogLevel() {
        return logLevel;
    }

    @Override
    public String getLoggingFormat() {
        return loggingFormat;
    }
}
