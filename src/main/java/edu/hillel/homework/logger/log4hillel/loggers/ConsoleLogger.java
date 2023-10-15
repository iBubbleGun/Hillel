package edu.hillel.homework.logger.log4hillel.loggers;

import edu.hillel.homework.logger.log4hillel.LogLevel;
import edu.hillel.homework.logger.log4hillel.Logger;
import edu.hillel.homework.logger.log4hillel.core.AbstractLogger;
import edu.hillel.homework.logger.log4hillel.core.configuration.ConsoleLoggerConfiguration;
import org.jetbrains.annotations.NotNull;

public class ConsoleLogger extends AbstractLogger implements Logger {

    private final ConsoleLoggerConfiguration config;

    public ConsoleLogger(ConsoleLoggerConfiguration config) {
        this.config = config;
    }

    @Override
    public void log(@NotNull LogLevel level, String message) {
        if (level.ordinal() <= config.getLogLevel().ordinal()) {
            writeLog(level, message);
        }
    }

    @Override
    protected void writeLog(LogLevel level, String message) {
        if (config.isEnabled()) {
            System.out.print(super.generateLogMessage(config.getLoggingFormat(), level, message));
        }
    }
}
