package edu.hillel.homework.logger_system.log4hillel.loggers;

import edu.hillel.homework.logger_system.log4hillel.LogLevel;
import edu.hillel.homework.logger_system.log4hillel.Logger;
import edu.hillel.homework.logger_system.log4hillel.core.AbstractLogger;
import edu.hillel.homework.logger_system.log4hillel.core.configuration.FileLoggerConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger extends AbstractLogger implements Logger {

    private final FileLoggerConfiguration config;
    private File logFile;

    public FileLogger(@NotNull FileLoggerConfiguration config) {
        this.config = config;
        createNewLogFile();
    }

    private void checkFileSize() {
        if (config.getMaxLogFileSize() > 0 && logFile.length() >= config.getMaxLogFileSize()) {
            createNewLogFile();
        }
    }

    private void createNewLogFile() {
        this.logFile = generateLogFileName(new File(config.getLogFilePath()));

        final File parentDirectory = logFile.getParentFile();
        if (!parentDirectory.exists()) {
            if (parentDirectory.mkdirs()) {
                //System.out.println("Created parent directories: " + parentDirectory); // debug
            } else {
                throw new RuntimeException();
            }
        }

        if (!logFile.exists()) {
            try {
                if (logFile.createNewFile()) {
                    System.out.println("Created new log file: " + logFile.getName()); // debug info
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private @NotNull File generateLogFileName(@NotNull File currentLogFile) {
        String currentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        String currentTime = new SimpleDateFormat("HH-mm-ss").format(new Date());
        String newLogFileName = currentLogFile.getName()
                .replace("[DATE]", currentDate)
                .replace("[TIME]", currentTime);
        return new File(currentLogFile.getParent(), newLogFileName);
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
            checkFileSize();
            try (BufferedWriter w = new BufferedWriter(new FileWriter(logFile, true))) {
                w.write(super.generateLogMessage(config.getLoggingFormat(), level, message));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
