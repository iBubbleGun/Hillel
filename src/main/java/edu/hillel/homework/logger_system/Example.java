package edu.hillel.homework.logger_system;

import edu.hillel.homework.logger_system.log4hillel.LogLevel;
import edu.hillel.homework.logger_system.log4hillel.Logger;
import edu.hillel.homework.logger_system.log4hillel.config_loader.DatabaseLoggerConfigLoader;
import edu.hillel.homework.logger_system.log4hillel.config_loader.LoggerConfigLoaderInterface;
import edu.hillel.homework.logger_system.log4hillel.config_loader.ConsoleLoggerConfigLoader;
import edu.hillel.homework.logger_system.log4hillel.config_loader.FileLoggerConfigLoader;
import edu.hillel.homework.logger_system.log4hillel.managers.LoggerManager;
import edu.hillel.homework.logger_system.log4hillel.misc.DefaultConfigFiles;

import java.util.ArrayList;
import java.util.List;

public class Example {

    // Logger system public static main instance.
    // Initialized once in the main class of the project.
    public static final Logger LOGGER;

    // initial logger system setup in static area main app class
    static {
        // logger system configuration file names
        final String FILE_LOGGER_CONFIG_FILE_NAME = "file_logger.properties"; // do not change
        final String CONSOLE_LOGGER_CONFIG_FILE_NAME = "console_logger.properties"; // do not change
        final String DATABASE_LOGGER_CONFIG_FILE_NAME = "database_logger.properties"; // do not change

        // file paths can be independently different
        final String[] CONFIG_FILES = {
                "config\\".concat(FILE_LOGGER_CONFIG_FILE_NAME),  // main "file logger" config file path
                "config\\".concat(CONSOLE_LOGGER_CONFIG_FILE_NAME), // main "console logger" config file path
                "config\\".concat(DATABASE_LOGGER_CONFIG_FILE_NAME) // main "database logger" config file path
        };

        DefaultConfigFiles.generate(CONFIG_FILES); // automatic generation of default logger configuration files

        final List<LoggerConfigLoaderInterface> config = new ArrayList<>();
        config.add(new FileLoggerConfigLoader(CONFIG_FILES[0])); // main "file logger" config file
        config.add(new ConsoleLoggerConfigLoader(CONFIG_FILES[1])); // main "console logger" config file
        config.add(new DatabaseLoggerConfigLoader(CONFIG_FILES[2])); // main "database logger" config file

        LOGGER = new LoggerManager(config).getLogger(); // logger system main instance
    }

    public static void main(String[] args) {

        // logger system example usage
        for (int i = 0; i < 100; i++) {

            LOGGER.log(LogLevel.INFO, "This is an info message #" + i);
            LOGGER.log(LogLevel.WARN, "This is a warning message #" + i);
            LOGGER.log(LogLevel.ERROR, "This is an error message #" + i);
            LOGGER.log(LogLevel.DEBUG, "This is a debug message #" + i);

            try {
                Thread.sleep(300); // delay simulation for clearer time logging
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
