package edu.hillel.homework.logger.log4hillel.core;

import edu.hillel.homework.logger.log4hillel.LogLevel;
import edu.hillel.homework.logger.log4hillel.Logger;

import java.util.Arrays;
import java.util.Objects;

public class MultiLogger implements Logger {

    private final Logger[] loggers;

    public MultiLogger(Logger... loggers) {
        this.loggers = loggers;
    }

    @Override
    public void log(LogLevel level, String message) {
        Arrays.stream(loggers)
                .filter(Objects::nonNull)
                .forEach(logger -> logger.log(level, message));
    }
}
