package edu.hillel.homework.logger_system;

import edu.hillel.homework.logger_system.log4hillel.LogLevel;
import edu.hillel.homework.logger_system.log4hillel.Logger;
import edu.hillel.homework.logger_system.log4hillel.config_loader.DatabaseLoggerConfigLoader;
import edu.hillel.homework.logger_system.log4hillel.config_loader.LoggerConfigLoaderInterface;
import edu.hillel.homework.logger_system.log4hillel.config_loader.ConsoleLoggerConfigLoader;
import edu.hillel.homework.logger_system.log4hillel.config_loader.FileLoggerConfigLoader;
import edu.hillel.homework.logger_system.log4hillel.managers.LoggerManager;
import edu.hillel.homework.logger_system.log4hillel.misc.DefaultConfigFile;

import java.util.ArrayList;
import java.util.List;

public class Example {

    public static final Logger LOGGER;

    // initial logger setup in static area main app class
    static {
        // file paths can be independently different
        final String[] CONFIG_FILES = {
                "config\\file_logger.properties",  // main "file logger" config file path
                "config\\console_logger.properties", // main "console logger" config file path
                "config\\database_logger.properties" // main "database logger" config file path
        };

        DefaultConfigFile.create(CONFIG_FILES);

        final List<LoggerConfigLoaderInterface> config = new ArrayList<>();
        config.add(new FileLoggerConfigLoader(CONFIG_FILES[0])); // main "file logger" config file
        config.add(new ConsoleLoggerConfigLoader(CONFIG_FILES[1])); // main "console logger" config file
        config.add(new DatabaseLoggerConfigLoader(CONFIG_FILES[2])); // main "database logger" config file

        LOGGER = new LoggerManager(config).getLogger();
    }

    public static void main(String[] args) {

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
