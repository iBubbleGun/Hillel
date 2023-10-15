package edu.hillel.homework.logger.log4hillel.config_loader;

import edu.hillel.homework.logger.log4hillel.LogLevel;
import edu.hillel.homework.logger.log4hillel.core.configuration.DatabaseLoggerConfiguration;
import edu.hillel.homework.logger.log4hillel.core.configuration.LoggerConfigurationInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DatabaseLoggerConfigLoader implements LoggerConfigLoaderInterface {

    private final String configFilePath;

    public DatabaseLoggerConfigLoader(String configFilePath) {
        this.configFilePath = configFilePath;
    }

    @Override
    public LoggerConfigurationInterface load() {
        try (BufferedReader r = new BufferedReader(new FileReader(configFilePath))) {
            boolean databaseLoggingEnable = false;
            LogLevel logLevel = null;
            String format = null;

            String line;
            while ((line = r.readLine()) != null) {
                if (line.contains("##")) {
                    continue;
                }
                String[] parts = line.split("=");
                if (parts.length != 2) {
                    continue;
                }

                String key = parts[0].trim().toUpperCase();
                String value = parts[1].trim();

                switch (key) {
                    case "DATABASE-LOGGING-ENABLED" -> {
                        try {
                            databaseLoggingEnable = Boolean.parseBoolean(value);
                        } catch (Exception e) {
                            throw new RuntimeException("Invalid configuration file format.", e);
                        }
                    }
                    case "LOG-LEVEL" -> logLevel = LogLevel.valueOf(value);
                    case "FORMAT" -> format = value;
                    default -> throw new RuntimeException("Invalid configuration file format.");
                }
            }

            if (logLevel != null && format != null) {
                return new DatabaseLoggerConfiguration(databaseLoggingEnable, logLevel, format);
            } else {
                throw new IllegalArgumentException("Invalid configuration file format.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
