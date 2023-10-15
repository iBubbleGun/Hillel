package edu.hillel.homework.logger.log4hillel.misc;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.IntStream;

public class DefaultConfigFile {

    public static void create(String @NotNull [] configFiles) {
        IntStream.range(0, configFiles.length).forEach(i -> {
            if (i == 0) {
                fileLoggerConfigFileCreate(configFiles[i]);
            } else if (i == 1) {
                consoleLoggerConfigFileCreate(configFiles[i]);
            } else if (i == 2) {
                databaseLoggerConfigFileCreate(configFiles[i]);
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

    private static void fileLoggerConfigFileCreate(String configFilePath) {
        createParentDirectories(configFilePath);
        final File defaultConfigFile = new File(configFilePath);
        if (!defaultConfigFile.exists()) {
            try {
                if (defaultConfigFile.createNewFile()) {
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(defaultConfigFile, true))) {
                        bw.write("## Enable logging in to external log file (true/false)");
                        bw.newLine();
                        bw.write("File-Logging-Enabled=true");
                        bw.newLine();
                        bw.write("## External log file full path with [DATA], [TIME] format. For example: D:\\Log\\Log_[DATE]_[TIME].log");
                        bw.newLine();
                        bw.write("File=Log\\Log_[DATE]_[TIME].log"); // your log file path
                        bw.newLine();
                        bw.write("## Max-File-Size in bytes. If Max-File-Size=0 - rotate log file will be disabled.");
                        bw.newLine();
                        bw.write("Max-File-Size=4096");
                        bw.newLine();
                        bw.write("## Logging level (INFO, WARN, ERROR, DEBUG)");
                        bw.newLine();
                        bw.write("Log-Level=DEBUG");
                        bw.newLine();
                        bw.write("## Logging string format");
                        bw.newLine();
                        bw.write("Format=[TIMESTAMP] [LEVEL] Message: [MESSAGE]");
                        bw.newLine();
                    } catch (IOException err) {
                        throw new RuntimeException(err);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void consoleLoggerConfigFileCreate(String configFilePath) {
        createParentDirectories(configFilePath);
        final File defaultConfigFile = new File(configFilePath);
        if (!defaultConfigFile.exists()) {
            try {
                if (defaultConfigFile.createNewFile()) {
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(defaultConfigFile, true))) {
                        bw.write("## Enable logging in to console (true/false)");
                        bw.newLine();
                        bw.write("Console-Logging-Enabled=true");
                        bw.newLine();
                        bw.write("## Logging level (INFO, WARN, ERROR, DEBUG)");
                        bw.newLine();
                        bw.write("Log-Level=WARN");
                        bw.newLine();
                        bw.write("## Logging string format");
                        bw.newLine();
                        bw.write("Format=[TIMESTAMP] [LEVEL] Message: [MESSAGE]");
                        bw.newLine();
                    } catch (IOException err) {
                        throw new RuntimeException(err);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void databaseLoggerConfigFileCreate(String configFilePath) {
        createParentDirectories(configFilePath);
        final File defaultConfigFile = new File(configFilePath);
        if (!defaultConfigFile.exists()) {
            try {
                if (defaultConfigFile.createNewFile()) {
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(defaultConfigFile, true))) {
                        bw.write("## Enable logging in to external database (true/false)");
                        bw.newLine();
                        bw.write("Database-Logging-Enabled=false");
                        bw.newLine();
                        bw.write("## Logging level (INFO, WARN, ERROR, DEBUG)");
                        bw.newLine();
                        bw.write("Log-Level=DEBUG");
                        bw.newLine();
                        bw.write("## Logging string format");
                        bw.newLine();
                        bw.write("Format=[TIMESTAMP] [LEVEL] Message: [MESSAGE]");
                        bw.newLine();
                    } catch (IOException err) {
                        throw new RuntimeException(err);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
