package homework.lesson24.processor.impl;

import edu.hillel.homework.lesson24.processor.impl.DatabaseDataProcessor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestDatabaseDataProcessor {

    private DatabaseDataProcessor databaseMock;

    @Before
    public void setUp() {
        this.databaseMock = Mockito.mock(DatabaseDataProcessor.class);
    }

    @Test
    public void testProcessData() {
        Map<Integer, String> testData = new LinkedHashMap<>(1);
        testData.put(1, "One");

        databaseMock.processData(testData);
        Mockito.verify(databaseMock).processData(testData);
    }

    @Test(expected = RuntimeException.class)
    public void testProcessDataWithRuntimeException() {
        Map<Integer, String> testData = new LinkedHashMap<>(1);
        testData.put(1, "One");

        Mockito.doThrow(new RuntimeException()).when(databaseMock).processData(testData);
        databaseMock.processData(testData);
        Mockito.verify(databaseMock).processData(testData);
    }
}
