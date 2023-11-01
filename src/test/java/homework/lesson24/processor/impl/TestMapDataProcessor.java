package homework.lesson24.processor.impl;

import edu.hillel.homework.lesson24.processor.impl.MapDataProcessor;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestMapDataProcessor {

    private MapDataProcessor mapDataProcessor;

    @Before
    public void setUp() {
        this.mapDataProcessor = new MapDataProcessor();
    }

    @Test
    public void testProcessData() {
        Map<Integer, String> testData = new LinkedHashMap<>(2);
        testData.put(1, "One");
        testData.put(2, "Two");
        mapDataProcessor.processData(testData);

        Map<Integer, String> dataMap = mapDataProcessor.getDataMap();
        assertNotNull(dataMap);
        assertEquals(2, dataMap.size());
        assertTrue(dataMap.containsKey(1));
        assertTrue(dataMap.containsKey(2));
        assertEquals("One", dataMap.get(1));
        assertEquals("Two", dataMap.get(2));
    }

    @Test
    public void testProcessDataWithEmptyData() {
        Map<Integer, String> emptyData = new LinkedHashMap<>(1);
        mapDataProcessor.processData(emptyData);
        Map<Integer, String> dataMap = mapDataProcessor.getDataMap();
        assertTrue(dataMap.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProcessDataWithNullData() {
        mapDataProcessor.processData(null);
    }

    @Test
    public void testGetDataMap() {
        this.mapDataProcessor = new MapDataProcessor();
        Map<Integer, String> testData = new LinkedHashMap<>(2);
        testData.put(1, "Test");
        testData.put(2, "Another");
        mapDataProcessor.processData(testData);

        Map<Integer, String> dataMap = mapDataProcessor.getDataMap();
        assertNotNull(dataMap);
        assertEquals(2, dataMap.size());
        assertTrue(dataMap.containsKey(1));
        assertTrue(dataMap.containsKey(2));
        assertEquals("Test", dataMap.get(1));
        assertEquals("Another", dataMap.get(2));
    }

    @Test
    public void testToString() {
        String expectedString = "MapDataProcessor{dataMap={}}";
        assertEquals(expectedString, mapDataProcessor.toString());
    }
}
