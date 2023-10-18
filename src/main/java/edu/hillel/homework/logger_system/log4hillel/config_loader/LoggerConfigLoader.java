package edu.hillel.homework.logger_system.log4hillel.config_loader;

import edu.hillel.homework.logger_system.log4hillel.LogLevel;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public abstract class LoggerConfigLoader {

    private static final String COMMENT_SYMBOLS = "##";

    protected boolean isComment(@NotNull String inputLine) {
        return inputLine.contains(COMMENT_SYMBOLS);
    }

    protected boolean parseBooleanValue(String value) {
        try {
            return Boolean.parseBoolean(value);
        } catch (Exception e) {
            throw new RuntimeException(errMessage(), e);
        }
    }

    protected long parseLongValue(String value) {
        try {
            return Long.parseLong(value);
        } catch (Exception e) {
            throw new RuntimeException(errMessage(), e);
        }
    }

    protected LogLevel parseLogLevelValue(String value) {
        try {
            return LogLevel.valueOf(value);
        } catch (Exception e) {
            throw new RuntimeException(errMessage(), e);
        }
    }

    protected String parseStringValue(String value) {
        return String.valueOf(value);
    }

    @Contract(pure = true)
    private @NotNull String errMessage() {
        return "Invalid configuration file format.";
    }
}
