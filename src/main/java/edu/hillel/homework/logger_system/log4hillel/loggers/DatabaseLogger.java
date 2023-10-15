package edu.hillel.homework.logger_system.log4hillel.loggers;

import edu.hillel.homework.logger_system.log4hillel.LogLevel;
import edu.hillel.homework.logger_system.log4hillel.Logger;
import edu.hillel.homework.logger_system.log4hillel.core.AbstractLogger;
import edu.hillel.homework.logger_system.log4hillel.core.configuration.DatabaseLoggerConfiguration;
import org.jetbrains.annotations.NotNull;

public class DatabaseLogger extends AbstractLogger implements Logger {

    private final DatabaseLoggerConfiguration config;

    public DatabaseLogger(@NotNull DatabaseLoggerConfiguration config) {
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
            // logic write to database here
        }
    }
}
