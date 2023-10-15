package edu.hillel.homework.lesson19.logger;

import edu.hillel.homework.lesson19.logger.exceptions.FileMaxSizeReachedException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger {

    private final FileLoggerConfiguration configuration;
    private File logFile;

    public FileLogger(@NotNull FileLoggerConfiguration configuration) throws IOException {
        this.configuration = configuration;
        this.logFile = generateLogFileName(new File(configuration.getFilePath()));
        createNewLogFile();
    }

    private boolean shouldLog(@NotNull LoggingLevel level) {
        return level.ordinal() <= configuration.getLoggingLevel().ordinal();
    }

    private void checkFileSize() throws FileMaxSizeReachedException {
        if (logFile.length() >= configuration.getMaxSize()) {
            //throw new FileMaxSizeReachedException(logFile.length(), configuration.getMaxSize(), logFile.getAbsolutePath()); // if you don't need to rotate log files uncomment this line
            rotateLogFile(); // if you don't need to rotate log files comment this line
        }
    }

    private void rotateLogFile() {
        this.logFile = generateLogFileName(new File(configuration.getFilePath()));
        createNewLogFile();
    }

    private void createNewLogFile() {
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

    @Contract("_ -> new")
    private @NotNull File generateLogFileName(@NotNull File file) {
        String currentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        String currentTime = new SimpleDateFormat("HH-mm-ss").format(new Date());
        String newLogFileName = file.getName()
                .replace("[DATE]", currentDate)
                .replace("[TIME]", currentTime);
        return new File(file.getParent(), newLogFileName);
    }

    private @NotNull String generateLogMessage(@NotNull LoggingLevel level, String msg) {
        return configuration.getFormat()
                .replace("TIMESTAMP", new SimpleDateFormat("dd.MM.yyyy-HH:mm:ss").format(new Date()))
                .replace("LEVEL", level.name())
                .replace("[MESSAGE]", msg) + System.lineSeparator();
    }

    public void debug(String message) throws FileMaxSizeReachedException {
        if (shouldLog(LoggingLevel.DEBUG)) {
            checkFileSize();
            try (FileWriter debug = new FileWriter(logFile, true)) {
                debug.write(generateLogMessage(LoggingLevel.DEBUG, message));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void info(String message) throws FileMaxSizeReachedException {
        if (shouldLog(LoggingLevel.INFO)) {
            checkFileSize();
            try (FileWriter info = new FileWriter(logFile, true)) {
                info.write(generateLogMessage(LoggingLevel.INFO, message));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
