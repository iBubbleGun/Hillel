package edu.hillel.homework.lesson19.logger;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoggerConfigurationLoader {

    @Contract("_ -> new")
    public static @NotNull FileLoggerConfiguration load(String configFilePath) throws IOException {
        try (BufferedReader r = new BufferedReader(new FileReader(configFilePath))) {
            String filePath = null;
            LoggingLevel loggingLevel = null;
            long maxSize = 0L;
            String format = null;

            String line;
            while ((line = r.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length != 2) {
                    continue;
                }

                String key = parts[0].trim().toUpperCase();
                String value = parts[1].trim();

                switch (key) {
                    case "FILE" -> filePath = value;
                    case "LEVEL" -> loggingLevel = LoggingLevel.valueOf(value);
                    case "MAX-SIZE" -> maxSize = Long.parseLong(value);
                    case "FORMAT" -> format = value;
                    default -> throw new RuntimeException("Invalid configuration file format.");
                }
            }

            if (filePath != null && loggingLevel != null && format != null) {
                return new FileLoggerConfiguration(filePath, loggingLevel, maxSize, format);
            } else {
                throw new IllegalArgumentException("Invalid configuration file format.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
