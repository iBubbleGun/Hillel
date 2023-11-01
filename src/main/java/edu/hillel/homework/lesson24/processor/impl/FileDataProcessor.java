package edu.hillel.homework.lesson24.processor.impl;

import edu.hillel.homework.lesson24.processor.DataProcessor;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileDataProcessor implements DataProcessor {

    private final String file_path;

    public FileDataProcessor(String file_path) {
        this.file_path = file_path;
    }

    @Override
    public void processData(@NotNull Map<Integer, String> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : data.entrySet()) {
            dataList.add(entry.getKey() + "=" + entry.getValue());
        }
        final Path file = Paths.get(file_path);
        final Path parentDirectory = file.getParent();

        if (!Files.exists(parentDirectory)) {
            try {
                Files.createDirectories(parentDirectory);
                //System.out.println("Created parent directories: " + parentDirectory); // debug
            } catch (IOException err) {
                throw new RuntimeException(
                        "An error occurred while creating parent directories: "
                                .concat(parentDirectory.toString()), err);
            }
        }
        try {
            Files.write(file, dataList, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            //System.out.println("Write in to file: " + dataList); // debug
            System.out.println("Writing data to file (" + file_path + ") completed successfully.");
        } catch (IOException err) {
            throw new RuntimeException(
                    "An error occurred while writing data in to the file: "
                            .concat(file.toString()), err);
        }
    }
}
