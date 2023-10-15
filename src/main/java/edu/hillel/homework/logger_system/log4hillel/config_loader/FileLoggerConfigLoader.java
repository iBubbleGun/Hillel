package edu.hillel.homework.logger_system.log4hillel.config_loader;

import edu.hillel.homework.logger_system.log4hillel.LogLevel;
import edu.hillel.homework.logger_system.log4hillel.core.configuration.FileLoggerConfiguration;
import edu.hillel.homework.logger_system.log4hillel.core.configuration.LoggerConfigurationInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoggerConfigLoader implements LoggerConfigLoaderInterface {

    private final String configFilePath;

    public FileLoggerConfigLoader(String configFilePath) {
        this.configFilePath = configFilePath;
    }

    @Override
    public LoggerConfigurationInterface load() {
        try (BufferedReader r = new BufferedReader(new FileReader(configFilePath))) {
            boolean fileLoggingEnable = false;
            String filePath = null;
            long maxFileSize = 0L;
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
                    case "FILE-LOGGING-ENABLED" -> {
                        try {
                            fileLoggingEnable = Boolean.parseBoolean(value);
                        } catch (Exception e) {
                            throw new RuntimeException("Invalid configuration file format.", e);
                        }
                    }
                    case "FILE" -> filePath = value;
                    case "MAX-FILE-SIZE" -> maxFileSize = Long.parseLong(value);
                    case "LOG-LEVEL" -> logLevel = LogLevel.valueOf(value);
                    case "FORMAT" -> format = value;
                    default -> throw new RuntimeException("Invalid configuration file format.");
                }
            }

            if (filePath != null && logLevel != null && format != null) {
                return new FileLoggerConfiguration(fileLoggingEnable, filePath, maxFileSize, logLevel, format);
            } else {
                throw new IllegalArgumentException("Invalid configuration file format.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
