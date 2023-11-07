package homework.lesson25.server.handler;

import edu.hillel.homework.lesson25.server.handler.User;
import edu.hillel.homework.lesson25.server.handler.util.UserNameGenerator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class TestUser {

    private Socket clientSocketMock;
    private PrintWriter clientWriterMock;
    private Timestamp timestampMock;
    private User user;

    @Before
    public void setUp() {
        this.clientSocketMock = Mockito.mock(Socket.class);
        this.clientWriterMock = Mockito.mock(PrintWriter.class);
        this.timestampMock = Mockito.mock(Timestamp.class);
        this.user = Mockito.mock(User.class);
    }

    @Test
    public void testGetName() {
        Mockito.when(user.getName()).thenReturn("Test");
        assertEquals("Test", user.getName());
    }

    @Test
    public void testGetClientSocket() {
        Mockito.when(user.getClientSocket()).thenReturn(clientSocketMock);
        assertNotNull(user.getClientSocket());
    }

    @Test
    public void testGetClientWriter() {
        Mockito.when(user.getClientWriter()).thenReturn(clientWriterMock);
        assertNotNull(user.getClientWriter());
    }

    @Test
    public void testGetConnectedTime() {
        Mockito.when(user.getConnectedTime()).thenReturn(timestampMock);
        assertNotNull(user.getConnectedTime());
        assertEquals(timestampMock, user.getConnectedTime());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateUserWithNullPointerException() throws IOException {
        new User(new UserNameGenerator(10), clientSocketMock);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateUserWithNullData() throws IOException {
        new User(null, null);
    }

    @Test
    public void testEquals() {
        User user1 = user;
        User user2 = user;
        User user3 = Mockito.mock(User.class);

        assertEquals(user1, user2);
        assertNotEquals(user1, user3);
    }

    @Test
    public void testHashCode() {
        User user1 = user;
        User user2 = user;
        User user3 = Mockito.mock(User.class);

        int hashCode1 = user1.hashCode();
        int hashCode2 = user2.hashCode();
        int hashCode3 = user3.hashCode();

        assertEquals(hashCode1, hashCode2);
        assertNotEquals(hashCode1, hashCode3);
    }

    @Test
    public void testToString() {
        Mockito.when(user.toString()).thenReturn("User{" +
                "name=testName" +
                ", connectedTime=testTime" +
                ", clientSocket=testSocket" +
                ", clientWriter=testWriter}");
        String expectedString = "User{" +
                "name=testName" +
                ", connectedTime=testTime" +
                ", clientSocket=testSocket" +
                ", clientWriter=testWriter}";
        assertEquals(expectedString, user.toString());
    }
}
