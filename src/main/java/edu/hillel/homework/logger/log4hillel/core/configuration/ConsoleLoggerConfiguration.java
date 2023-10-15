package edu.hillel.homework.logger.log4hillel.core.configuration;

import edu.hillel.homework.logger.log4hillel.LogLevel;

public class ConsoleLoggerConfiguration implements LoggerConfigurationInterface {

    private final boolean enabled;
    private final LogLevel logLevel;
    private final String loggingFormat;

    public ConsoleLoggerConfiguration(boolean enabled, LogLevel logLevel, String loggingFormat) {
        this.enabled = enabled;
        this.logLevel = logLevel;
        this.loggingFormat = loggingFormat;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
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
