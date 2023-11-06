package homework.lesson25.client.services;

import edu.hillel.homework.lesson25.client.services.FileService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.net.Socket;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestFileService {

    private Socket socketMock;

    @Before
    public void setup() {
        this.socketMock = Mockito.mock(Socket.class);
    }

    @Test
    public void testProcessData() {
        FileService mock = mock(FileService.class);
        File file = new File("test\\file\\path\\testFile.name");
        mock.send(file, socketMock);
        verify(mock).send(file, socketMock);
    }
}
