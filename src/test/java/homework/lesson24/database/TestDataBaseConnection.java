package homework.lesson24.database;

import edu.hillel.homework.lesson24.database.DataBaseConnection;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

public class TestDataBaseConnection {

    private DataBaseConnection dataBaseConnectionMock;

    @Before
    public void setUp() {
        this.dataBaseConnectionMock = Mockito.mock(DataBaseConnection.class);
    }

//    @Test // test real connection to real database
//    public void testGetConnection() {
//        try (DataBaseConnection dataBaseConnection = new DataBaseConnection()) {
//            Connection connection = dataBaseConnection.getConnection();
//            assertNotNull(connection);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Test
    public void testGetConnectionMock() {
        Connection connectionMock = Mockito.mock(Connection.class);
        Mockito.when(dataBaseConnectionMock.getConnection()).thenReturn(connectionMock);
        assertNotNull(dataBaseConnectionMock.getConnection());
    }

    @Test(expected = MockitoException.class)
    public void testGetConnectionWithException() {
        Mockito.doThrow(new MockitoException("Simulated SQLException", new SQLException()))
                .when(dataBaseConnectionMock).getConnection();
        dataBaseConnectionMock.getConnection();
        Mockito.verify(dataBaseConnectionMock).getConnection();
    }

    @Test
    public void testClose() throws SQLException {
        dataBaseConnectionMock.close();
        Mockito.verify(dataBaseConnectionMock, Mockito.times(1)).close();
    }
}
