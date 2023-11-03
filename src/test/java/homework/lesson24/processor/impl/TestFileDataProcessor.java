package homework.lesson24.processor.impl;

import edu.hillel.homework.lesson24.processor.impl.FileDataProcessor;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class TestFileDataProcessor {

    private static final String FILE_PATH =
            System.getProperty("user.dir")
                    .concat("\\")
                    .concat("test_out.txt");
    private FileDataProcessor fileDataProcessor;

    @Before
    public void setUp() {
        this.fileDataProcessor = new FileDataProcessor(FILE_PATH);
    }

    @Test
    public void testProcessData() throws IOException {
        Map<Integer, String> testData = new LinkedHashMap<>(3);
        testData.put(1, "One");
        testData.put(2, "Two");
        testData.put(3, "Three");

        fileDataProcessor.processData(testData);

        Path file = Paths.get(FILE_PATH);
        assertTrue(Files.exists(file));

        List<String> lines = Files.readAllLines(file);
        assertTrue(lines.contains("1=One"));
        assertTrue(lines.contains("2=Two"));
        assertTrue(lines.contains("3=Three"));

        Files.delete(file);
    }
}
