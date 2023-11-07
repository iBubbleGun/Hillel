package homework.lesson25.server.managers;

import edu.hillel.homework.lesson25.server.managers.ServerSocketManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.ServerSocket;

import static org.junit.Assert.assertNotNull;

public class TestServerSocketManager {

    private ServerSocketManager serverSocketManagerMock;
    private ServerSocket serverSocketMock;

    @Before
    public void setUp() {
        this.serverSocketManagerMock = Mockito.mock(ServerSocketManager.class);
        this.serverSocketMock = Mockito.mock(ServerSocket.class);
    }

    @After
    public void tearDown() throws Exception {
        serverSocketManagerMock.close();
    }

    @Test
    public void testGetSocket() throws Exception {
        Mockito.when(serverSocketManagerMock.getSocket()).thenReturn(serverSocketMock);
        serverSocketManagerMock.getSocket();
        assertNotNull(serverSocketManagerMock.getSocket());
    }

    @Test
    public void testClose() {
        try {
            Mockito.when(serverSocketManagerMock.getSocket()).thenReturn(serverSocketMock);
            serverSocketManagerMock.getSocket().close();
            Mockito.verify(serverSocketManagerMock.getSocket(), Mockito.times(1)).close();
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while trying to get server socket.", e);
        }
    }

    @Test
    public void testCloseWithoutGetSocket() throws Exception {
        serverSocketManagerMock.close(); // It should not throw an exception.
    }

    @Test(expected = IOException.class)
    public void testGetSocketWithIOException() throws IOException {
        Mockito.doThrow(new IOException()).when(serverSocketManagerMock).getSocket();
        serverSocketManagerMock.getSocket();
        Mockito.verify(serverSocketManagerMock).getSocket();
    }

    @Test(expected = RuntimeException.class)
    public void testCreateServerSocketManagerWithNullAddress() {
        try (ServerSocketManager serverSocketManager = new ServerSocketManager(null, 0);
             ServerSocket serverSocket = serverSocketManager.getSocket()) {
            //
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
