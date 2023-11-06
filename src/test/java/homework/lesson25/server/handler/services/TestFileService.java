package homework.lesson25.server.handler.services;

import edu.hillel.homework.lesson25.server.handler.services.FileService;
import org.junit.Test;

import java.io.File;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestFileService {

    @Test
    public void testProcessData() {
        FileService mock = mock(FileService.class);
        File file = new File("test\\file\\path\\testFile.name");
        mock.save(file);
        verify(mock).save(file);
    }
}
