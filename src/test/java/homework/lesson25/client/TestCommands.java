package homework.lesson25.client;

import edu.hillel.homework.lesson25.client.Commands;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCommands {

    @Test
    public void testExitType() {
        assertEquals("EXIT", Commands.EXIT.name());
    }

    @Test
    public void testFileType() {
        assertEquals("FILE", Commands.FILE.name());
    }

    @Test
    public void testDateType() {
        assertEquals("DATE", Commands.DATE.name());
    }

    @Test
    public void testTimeType() {
        assertEquals("TIME", Commands.TIME.name());
    }

    @Test
    public void testValuesSize() {
        assertEquals(4, Commands.values().length);
    }

    @Test
    public void testExitOrdinal() {
        assertEquals(0, Commands.EXIT.ordinal());
    }

    @Test
    public void testFileOrdinal() {
        assertEquals(1, Commands.FILE.ordinal());
    }

    @Test
    public void testDateOrdinal() {
        assertEquals(2, Commands.DATE.ordinal());
    }

    @Test
    public void testTimeOrdinal() {
        assertEquals(3, Commands.TIME.ordinal());
    }
}
