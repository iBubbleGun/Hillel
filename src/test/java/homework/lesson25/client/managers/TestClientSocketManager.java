package homework.lesson25.client.managers;

import edu.hillel.homework.lesson25.client.managers.ClientSocketManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.Socket;

import static org.junit.Assert.assertNotNull;

public class TestClientSocketManager {

    private ClientSocketManager clientSocketManagerMock;
    private Socket clientSocketMock;

    @Before
    public void setUp() {
        this.clientSocketManagerMock = Mockito.mock(ClientSocketManager.class);
        this.clientSocketMock = Mockito.mock(Socket.class);
    }

    @After
    public void tearDown() throws Exception {
        clientSocketManagerMock.close();
    }

    @Test
    public void testGetSocket() throws Exception {
        Mockito.when(clientSocketManagerMock.getSocket()).thenReturn(clientSocketMock);
        clientSocketManagerMock.getSocket();
        assertNotNull(clientSocketManagerMock.getSocket());
    }

    @Test
    public void testClose() {
        try {
            Mockito.when(clientSocketManagerMock.getSocket()).thenReturn(clientSocketMock);
            clientSocketManagerMock.getSocket().close();
            Mockito.verify(clientSocketManagerMock.getSocket(), Mockito.times(1)).close();
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while trying to get client socket.", e);
        }
    }

    @Test
    public void testCloseWithoutGetSocket() throws Exception {
        clientSocketManagerMock.close(); // It should not throw an exception.
    }

    @Test(expected = IOException.class)
    public void testGetSocketWithIOException() throws IOException {
        Mockito.doThrow(new IOException()).when(clientSocketManagerMock).getSocket();
        clientSocketManagerMock.getSocket();
        Mockito.verify(clientSocketManagerMock).getSocket();
    }

    @Test(expected = RuntimeException.class)
    public void testCreateClientSocketManagerWithNullAddress() {
        try (ClientSocketManager clientSocketManager = new ClientSocketManager(null, 0);
             Socket clientSocket = clientSocketManager.getSocket()) {
            //
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
