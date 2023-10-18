package edu.hillel.homework.logger_system.log4hillel.misc;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultConfigFiles {

    public static void generate(String @NotNull [] configFilePath) {
        Arrays.stream(configFilePath).forEach(filePath -> {
            createParentDirectories(filePath);
            final File defaultConfigFile = new File(filePath);
            if (!defaultConfigFile.exists()) {
                try {
                    if (defaultConfigFile.createNewFile()) {
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(defaultConfigFile, true))) {
                            final List<String> configFile = getConfigFileLinesList(filePath);
                            for (String line : configFile) {
                                bw.write(line);
                                bw.newLine();
                            }
                        } catch (IOException err) {
                            throw new RuntimeException(err);
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private static void createParentDirectories(String filePath) {
        final File parentDirectory = new File(filePath).getParentFile();
        if (!parentDirectory.exists()) {
            if (parentDirectory.mkdirs()) {
                //System.out.println("Created parent directories: " + parentDirectory); // debug
            } else {
                throw new RuntimeException();
            }
        }
    }

    private static List<String> getConfigFileLinesList(@NotNull String filePath) {
        if (filePath.contains("file_logger.properties")) {
            return getFileLoggerConfigFile();
        } else if (filePath.contains("console_logger.properties")) {
            return getConsoleLoggerConfigFile();
        } else if (filePath.contains("database_logger.properties")) {
            return getDatabaseLoggerConfigFile();
        } else {
            throw new RuntimeException("The configuration file was not found. " +
                    "There may be an error in the configuration file name.");
        }
    }

    private static @NotNull List<String> getFileLoggerConfigFile() {
        final int totalConfigLines = 10;
        final List<String> configuration = new ArrayList<>(totalConfigLines);
        configuration.add("## Enable logging in to external log file (true/false)");
        configuration.add("File-Logging-Enabled=true");
        configuration.add("## External log file full path with [DATA], [TIME] format. For example: D:\\Log\\Log_[DATE]_[TIME].log");
        configuration.add("File=Log\\Log_[DATE]_[TIME].log"); // your log file path
        configuration.add("## Max-File-Size in bytes. If Max-File-Size=0 - rotate log file will be disabled.");
        configuration.add("Max-File-Size=4096");
        configuration.add("## Logging level (INFO, WARN, ERROR, DEBUG)");
        configuration.add("Log-Level=DEBUG");
        configuration.add("## Logging string format");
        configuration.add("Format=[TIMESTAMP] [LEVEL] Message: [MESSAGE]");
        return configuration;
    }

    private static @NotNull List<String> getConsoleLoggerConfigFile() {
        final int totalConfigLines = 6;
        final List<String> configuration = new ArrayList<>(totalConfigLines);
        configuration.add("## Enable logging in to console (true/false)");
        configuration.add("Console-Logging-Enabled=true");
        configuration.add("## Logging level (INFO, WARN, ERROR, DEBUG)");
        configuration.add("Log-Level=WARN");
        configuration.add("## Logging string format");
        configuration.add("Format=[TIMESTAMP] [LEVEL] Message: [MESSAGE]");
        return configuration;
    }

    private static @NotNull List<String> getDatabaseLoggerConfigFile() {
        final int totalConfigLines = 6;
        final List<String> configuration = new ArrayList<>(totalConfigLines);
        configuration.add("## Enable logging in to external database (true/false)");
        configuration.add("Database-Logging-Enabled=false");
        configuration.add("## Logging level (INFO, WARN, ERROR, DEBUG)");
        configuration.add("Log-Level=DEBUG");
        configuration.add("## Logging string format");
        configuration.add("Format=[TIMESTAMP] [LEVEL] Message: [MESSAGE]");
        return configuration;
    }
}
