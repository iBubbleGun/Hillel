package homework.lesson24.processor;

import edu.hillel.homework.lesson24.processor.DataProcessor;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestDataProcessor {

    @Test
    public void testProcessData() {
        DataProcessor mock = mock(DataProcessor.class);
        Map<Integer, String> testData = new LinkedHashMap<>(3);
        mock.processData(testData);
        verify(mock).processData(testData);
    }
}
