package homework.lesson25.client.services.impl;

import edu.hillel.homework.lesson25.client.services.impl.FileSender;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.net.Socket;

import static org.mockito.Mockito.verify;

public class TestFileSender {

    private FileSender fileSenderMock;
    private Socket socketMock;

    @Before
    public void setup() {
        this.fileSenderMock = Mockito.mock(FileSender.class);
        this.socketMock = Mockito.mock(Socket.class);
    }

    @Test
    public void testSend() {
        File file = new File("test.txt");
        fileSenderMock.send(file, socketMock);
        verify(fileSenderMock).send(file, socketMock);
    }
}
