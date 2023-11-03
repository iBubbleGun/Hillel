package edu.hillel.homework.lesson24.data;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;

public class DataManager {

    private final Map<Integer, String> dataMap;

    public Map<Integer, String> getDataMap() {
        return dataMap;
    }

    public DataManager() {
        this.dataMap = new LinkedHashMap<>();
    }

    public void addData(@NotNull Data data) {
        dataMap.put(data.getId(), data.getInfo());
    }
}
