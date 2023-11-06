package homework.lesson25.client;

import edu.hillel.homework.lesson25.client.Client;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class TestClient {

    private Client clientMock;

    @Before
    public void setup() {
        this.clientMock = Mockito.mock(Client.class);
    }

    @Test
    public void testCreateNewClient() {
        Client client = new Client("localhost", Mockito.anyInt());
        Assert.assertNotNull(client);
    }

    @Test
    public void testStart() {
        clientMock.start();
        verify(clientMock).start();
    }
}
