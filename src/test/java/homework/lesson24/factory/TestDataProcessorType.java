package homework.lesson24.factory;

import edu.hillel.homework.lesson24.factory.DataProcessorType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDataProcessorType {

    @Test
    public void testMapType() {
        assertEquals("MAP", DataProcessorType.MAP.name());
    }

    @Test
    public void testFileType() {
        assertEquals("FILE", DataProcessorType.FILE.name());
    }

    @Test
    public void testDatabaseType() {
        assertEquals("DATABASE", DataProcessorType.DATABASE.name());
    }

    @Test
    public void testValuesSize() {
        assertEquals(3, DataProcessorType.values().length);
    }

    @Test
    public void testMapOrdinal() {
        assertEquals(0, DataProcessorType.MAP.ordinal());
    }

    @Test
    public void testFileOrdinal() {
        assertEquals(1, DataProcessorType.FILE.ordinal());
    }

    @Test
    public void testDatabaseOrdinal() {
        assertEquals(2, DataProcessorType.DATABASE.ordinal());
    }
}
