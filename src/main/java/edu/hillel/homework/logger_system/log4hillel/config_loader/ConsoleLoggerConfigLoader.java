package edu.hillel.homework.logger_system.log4hillel.config_loader;

import edu.hillel.homework.logger_system.log4hillel.LogLevel;
import edu.hillel.homework.logger_system.log4hillel.core.configuration.ConsoleLoggerConfiguration;
import edu.hillel.homework.logger_system.log4hillel.core.configuration.LoggerConfigurationInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConsoleLoggerConfigLoader extends LoggerConfigLoader implements LoggerConfigLoaderInterface {

    private final String configFilePath;

    public ConsoleLoggerConfigLoader(String configFilePath) {
        this.configFilePath = configFilePath;
    }

    @Override
    public LoggerConfigurationInterface load() {
        try (BufferedReader r = new BufferedReader(new FileReader(configFilePath))) {
            boolean consoleLoggingEnable = false;
            LogLevel logLevel = null;
            String format = null;

            String line;
            while ((line = r.readLine()) != null) {
                if (super.isComment(line)) {
                    continue;
                }
                String[] parts = line.split("=");
                if (parts.length != 2) {
                    continue;
                }

                String key = parts[0].trim().toUpperCase();
                String value = parts[1].trim();

                switch (key) {
                    case "CONSOLE-LOGGING-ENABLED" -> consoleLoggingEnable = super.parseBooleanValue(value);
                    case "LOG-LEVEL" -> logLevel = super.parseLogLevelValue(value);
                    case "FORMAT" -> format = super.parseStringValue(value);
                    default -> throw new RuntimeException("Invalid configuration file format.");
                }
            }

            if (logLevel != null && format != null) {
                return new ConsoleLoggerConfiguration(consoleLoggingEnable, logLevel, format);
            } else {
                throw new IllegalArgumentException("Invalid configuration file format.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
