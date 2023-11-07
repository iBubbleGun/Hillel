package homework.lesson25.server.handler.services.impl;

import edu.hillel.homework.lesson25.server.handler.services.impl.FileSaver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;

import static org.mockito.Mockito.verify;

public class TestFileSaver {

    private FileSaver fileSaverMock;

    @Before
    public void setup() {
        this.fileSaverMock = Mockito.mock(FileSaver.class);
    }

    @Test
    public void testSave() {
        File file = new File("test.txt");
        fileSaverMock.save(file);
        verify(fileSaverMock).save(file);
    }
}
