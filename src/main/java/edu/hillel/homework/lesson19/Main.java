package edu.hillel.homework.lesson19;

import edu.hillel.homework.lesson19.logger.FileLogger;
import edu.hillel.homework.lesson19.logger.FileLoggerConfigurationLoader;
import edu.hillel.homework.lesson19.logger.exceptions.FileMaxSizeReachedException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static final String LOGGER_CONFIG_FILE_NAME = "lesson19.properties"; // main logger config file name
    public static FileLogger LOGGER; // public static method for unambiguity and visibility throughout the project

    static {
        createDefaultConfigFile();
        try {
            LOGGER = new FileLogger(FileLoggerConfigurationLoader.load(LOGGER_CONFIG_FILE_NAME));
        } catch (IOException e) {
            System.err.println("Failed to load logger configuration file : " + e.getMessage());
        }
    }

    public static void main(String[] args) throws FileMaxSizeReachedException, IOException {

        for (int i = 0; i < 100; i++) {
            LOGGER.debug("This is some debug message #" + i);
            LOGGER.info("This is some information message #" + i);

            System.out.println(i); // control iterator in to console
            try {
                Thread.sleep(200); // delay simulation for clearer time logging
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void createDefaultConfigFile() {
        File defaultConfigFile = new File(LOGGER_CONFIG_FILE_NAME);
        if (!defaultConfigFile.exists()) {
            try {
                if (defaultConfigFile.createNewFile()) {
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(defaultConfigFile, true))) {
                        bw.write("File=D:\\Log_[DATE]_[TIME].log"); // your log file path
                        bw.newLine();
                        bw.write("Level=DEBUG");
                        bw.newLine();
                        bw.write("Max-size=2048");
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
