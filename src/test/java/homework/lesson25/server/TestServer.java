package homework.lesson25.server;

import edu.hillel.homework.lesson25.server.Server;
import edu.hillel.homework.lesson25.server.handler.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class TestServer {

    private User userMock;
    private Server serverMock;

    @Before
    public void setup() {
        this.userMock = Mockito.mock(User.class);
        this.serverMock = Mockito.mock(Server.class);
    }

    @Test
    public void testCreateNewServer() {
        Server server = new Server("localhost", Mockito.anyInt());
        Assert.assertNotNull(server);
    }

    @Test
    public void testStart() {
        serverMock.start();
        verify(serverMock).start();
    }

    @Test
    public void testBroadcastMessage() {
        serverMock.broadcastMessage("test", userMock);
        verify(serverMock).broadcastMessage("test", userMock);
    }

    @Test
    public void testRemoveClient() {
        serverMock.removeClient(userMock);
        verify(serverMock).removeClient(userMock);
    }
}
