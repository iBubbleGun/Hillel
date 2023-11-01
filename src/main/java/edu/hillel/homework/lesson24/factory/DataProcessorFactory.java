package edu.hillel.homework.lesson24.factory;

import edu.hillel.homework.lesson24.processor.DataProcessor;
import edu.hillel.homework.lesson24.processor.impl.DatabaseDataProcessor;
import edu.hillel.homework.lesson24.processor.impl.FileDataProcessor;
import edu.hillel.homework.lesson24.processor.impl.MapDataProcessor;
import org.jetbrains.annotations.NotNull;

public class DataProcessorFactory {

    public DataProcessor createDataProcessor(@NotNull DataProcessorType type) {
        switch (type) {
            case MAP:
                return new MapDataProcessor();
            case FILE:
                final String OUT_FILE_NAME = "out.txt";

                return new FileDataProcessor(
                        System.getProperty("user.dir")
                                .concat("\\")
                                .concat(OUT_FILE_NAME)
                );
            case DATABASE:
                return new DatabaseDataProcessor();
            default:
                throw new IllegalArgumentException("Unsupported data processor type: " + type);
        }
    }
}
