package homework.lesson24.data;

import edu.hillel.homework.lesson24.data.Data;
import edu.hillel.homework.lesson24.data.DataManager;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestDataManager {

    private DataManager dataManager;

    @Before
    public void setUp() {
        this.dataManager = new DataManager();
    }

    @Test
    public void testAddData() {
        dataManager.addData(new Data(1, "Test 1"));
        dataManager.addData(new Data(2, "Test 2"));
        dataManager.addData(new Data(3, "Test 3"));

        Map<Integer, String> dataMap = dataManager.getDataMap();
        assertNotNull(dataMap);
        assertEquals(3, dataMap.size());
        assertTrue(dataMap.containsKey(1));
        assertTrue(dataMap.containsKey(2));
        assertTrue(dataMap.containsKey(3));
        assertEquals("Test 1", dataMap.get(1));
        assertEquals("Test 2", dataMap.get(2));
        assertEquals("Test 3", dataMap.get(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDataWithNullData() {
        dataManager.addData(null);
    }

    @Test
    public void testGetDataMap() {
        this.dataManager = new DataManager();
        dataManager.addData(new Data(1, "Test"));
        dataManager.addData(new Data(2, "Another"));

        Map<Integer, String> dataMap = dataManager.getDataMap();
        assertNotNull(dataMap);
        assertEquals(2, dataMap.size());
        assertTrue(dataMap.containsKey(1));
        assertTrue(dataMap.containsKey(2));
        assertEquals("Test", dataMap.get(1));
        assertEquals("Another", dataMap.get(2));
    }
}
