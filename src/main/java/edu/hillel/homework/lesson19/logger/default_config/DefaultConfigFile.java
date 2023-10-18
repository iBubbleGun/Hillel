package edu.hillel.homework.lesson19.logger.default_config;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DefaultConfigFile {

    public static void generate(String filePath) {
        final File defaultConfigFile = new File(filePath);
        if (!defaultConfigFile.exists()) {
            try {
                if (defaultConfigFile.createNewFile()) {
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(defaultConfigFile, true))) {
                        for (String line : getConfig()) {
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
    }

    private static @NotNull List<String> getConfig() {
        List<String> defaultConfig = new ArrayList<>(4);
        defaultConfig.add("File=D:\\Log_[DATE]_[TIME].log");
        defaultConfig.add("Level=DEBUG");
        defaultConfig.add("Max-size=2048");
        defaultConfig.add("Format=[TIMESTAMP] [LEVEL] Message: [MESSAGE]");
        return defaultConfig;
    }
}
