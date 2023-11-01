package homework.lesson24.data;

import edu.hillel.homework.lesson24.data.Data;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestData {

    @Test
    public void testGetId() {
        final int expected_id = 10;
        Data data = new Data(expected_id, "Test info.");
        assertEquals("Test data id: ", expected_id, data.getId());
    }

    @Test
    public void testGetInfo() {
        final String expected_info = "Test info.";
        Data data = new Data(1, expected_info);
        assertEquals("Test data info: ", expected_info, data.getInfo());
    }

    @Test
    public void testToString() {
        Data data = new Data(1, "Test");
        String expectedString = "Data{id=1, info='Test'}";
        assertEquals(expectedString, data.toString());
    }

    @Test
    public void testEquals() {
        Data data1 = new Data(1, "Test");
        Data data2 = new Data(1, "Test");
        Data data3 = new Data(2, "Another");

        assertEquals(data1, data2);
        assertNotEquals(data1, data3);
    }

    @Test
    public void testHashCode() {
        Data data1 = new Data(1, "Test");
        Data data2 = new Data(1, "Test");
        Data data3 = new Data(2, "Another");

        int hashCode1 = data1.hashCode();
        int hashCode2 = data2.hashCode();
        int hashCode3 = data3.hashCode();

        assertEquals(hashCode1, hashCode2);
        assertNotEquals(hashCode1, hashCode3);
    }
}
