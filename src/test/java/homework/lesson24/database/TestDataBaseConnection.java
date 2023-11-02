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
    private Connection connectionMock;

    @Before
    public void setUp() {
        this.dataBaseConnectionMock = Mockito.mock(DataBaseConnection.class);
        this.connectionMock = Mockito.mock(Connection.class);
    }

//    @Test // test real connection to real database
//    public void testGetConnection() {
//        try (DataBaseConnection dataBaseConnection = new DataBaseConnection();
//             Connection connection = dataBaseConnection.getConnection()) {
//            assertNotNull(connection);
//        } catch (SQLException e) {
//            throw new RuntimeException("An error occurred while trying to connect to the database", e);
//        }
//    }

    @Test
    public void testGetConnectionMock() {
        try {
            Mockito.when(dataBaseConnectionMock.getConnection()).thenReturn(connectionMock);
            assertNotNull(dataBaseConnectionMock.getConnection());
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred while trying to connect to the database", e);
        }

    }

    @Test(expected = Exception.class)
    public void testGetConnectionWithException() {
        try {
            Mockito.doThrow(new MockitoException("Simulated SQLException", new SQLException()))
                    .when(dataBaseConnectionMock).getConnection();
            dataBaseConnectionMock.getConnection();
            Mockito.verify(dataBaseConnectionMock).getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred while trying to connect to the database", e);
        }
    }

    @Test
    public void testClose() {
        try {
            Mockito.when(dataBaseConnectionMock.getConnection()).thenReturn(connectionMock);
            dataBaseConnectionMock.getConnection().close();
            Mockito.verify(dataBaseConnectionMock.getConnection(), Mockito.times(1)).close();
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred while trying to connect to the database", e);
        }
    }
}
