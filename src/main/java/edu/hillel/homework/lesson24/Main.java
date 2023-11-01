package edu.hillel.homework.lesson24;

import edu.hillel.homework.lesson24.data.Data;
import edu.hillel.homework.lesson24.data.DataManager;
import edu.hillel.homework.lesson24.factory.DataProcessorFactory;
import edu.hillel.homework.lesson24.factory.DataProcessorType;
import edu.hillel.homework.lesson24.processor.DataProcessor;

import java.util.Map;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        // generate test data collection
        final DataManager dataManager = new DataManager();
        IntStream.rangeClosed(1, 10).mapToObj(i -> new Data(i, "Test string #" + i)).forEach(dataManager::addData);

        // our test data collection
        final Map<Integer, String> inputData = dataManager.getDataMap();

        // processor factory
        final DataProcessorFactory factory = new DataProcessorFactory();

        // memory data storage
        DataProcessor mapDataProcessor = factory.createDataProcessor(DataProcessorType.MAP);
        mapDataProcessor.processData(inputData);

        // file data storage
        DataProcessor fileDataProcessor = factory.createDataProcessor(DataProcessorType.FILE);
        fileDataProcessor.processData(inputData);

        // mysql data storage
        DataProcessor databaseDataProcessor = factory.createDataProcessor(DataProcessorType.DATABASE);
        databaseDataProcessor.processData(inputData);
    }
}
