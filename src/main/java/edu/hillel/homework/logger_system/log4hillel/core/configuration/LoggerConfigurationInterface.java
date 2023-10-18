package edu.hillel.homework.logger_system.log4hillel.core.configuration;

import edu.hillel.homework.logger_system.log4hillel.LogLevel;

public interface LoggerConfigurationInterface {

    boolean isEnabled();

    LogLevel getLogLevel();

    String getLoggingFormat();
}
