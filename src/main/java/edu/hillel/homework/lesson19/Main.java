package edu.hillel.homework.lesson19;

import edu.hillel.homework.lesson19.logger.FileLogger;
import edu.hillel.homework.lesson19.logger.FileLoggerConfigurationLoader;
import edu.hillel.homework.lesson19.logger.default_config.DefaultConfigFile;
import edu.hillel.homework.lesson19.logger.exceptions.FileMaxSizeReachedException;

import java.io.IOException;

public class Main {

    private static final String LOGGER_CONFIG_FILE_NAME = "lesson19.properties"; // main logger config file name
    public static FileLogger LOGGER; // public static method for unambiguity and visibility throughout the project

    static {
        DefaultConfigFile.generate(LOGGER_CONFIG_FILE_NAME);
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
}
