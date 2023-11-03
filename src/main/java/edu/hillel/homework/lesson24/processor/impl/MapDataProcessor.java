package edu.hillel.homework.lesson24.processor.impl;

import edu.hillel.homework.lesson24.processor.DataProcessor;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapDataProcessor implements DataProcessor {

    private final Map<Integer, String> dataMap = new LinkedHashMap<>();

    @Override
    public void processData(@NotNull Map<Integer, String> data) {
        dataMap.putAll(data);
        System.out.println("Writing data to memory completed successfully.");
    }

    public Map<Integer, String> getDataMap() {
        return dataMap;
    }

    @Override
    public String toString() {
        return "MapDataProcessor{" +
                "dataMap=" + dataMap +
                '}';
    }
}
