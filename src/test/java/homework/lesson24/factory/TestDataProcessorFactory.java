package homework.lesson24.factory;

import edu.hillel.homework.lesson24.factory.DataProcessorFactory;
import edu.hillel.homework.lesson24.factory.DataProcessorType;
import edu.hillel.homework.lesson24.processor.impl.DatabaseDataProcessor;
import edu.hillel.homework.lesson24.processor.impl.FileDataProcessor;
import edu.hillel.homework.lesson24.processor.impl.MapDataProcessor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestDataProcessorFactory {

    private DataProcessorFactory factory;

    @Before
    public void setUp() {
        this.factory = new DataProcessorFactory();
    }

    @Test
    public void testCreateMapDataProcessor() {
        assertTrue(factory.createDataProcessor(DataProcessorType.MAP) instanceof MapDataProcessor);
    }

    @Test
    public void testCreateFileDataProcessor() {
        assertTrue(factory.createDataProcessor(DataProcessorType.FILE) instanceof FileDataProcessor);
    }

    @Test
    public void testCreateDatabaseDataProcessor() {
        assertTrue(factory.createDataProcessor(DataProcessorType.DATABASE) instanceof DatabaseDataProcessor);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateDataProcessorWithIllegalArgumentException() {
        factory.createDataProcessor(DataProcessorType.valueOf("NOT_EXIST_TYPE_NAME"));
    }
}
