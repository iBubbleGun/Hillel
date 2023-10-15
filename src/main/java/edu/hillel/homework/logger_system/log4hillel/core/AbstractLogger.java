package edu.hillel.homework.logger_system.log4hillel.core;

import edu.hillel.homework.logger_system.log4hillel.LogLevel;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractLogger {

    protected abstract void writeLog(LogLevel level, String message);

    protected @NotNull String generateLogMessage(@NotNull String inputString, @NotNull LogLevel level, String message) {
        return inputString
                .replace("TIMESTAMP", new SimpleDateFormat("dd.MM.yyyy-HH:mm:ss").format(new Date()))
                .replace("LEVEL", level.name())
                .replace("[MESSAGE]", message) + System.lineSeparator();
    }
}
