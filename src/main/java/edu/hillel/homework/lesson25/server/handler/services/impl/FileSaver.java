package edu.hillel.homework.lesson25.server.handler.services.impl;

import edu.hillel.homework.lesson25.server.handler.User;
import edu.hillel.homework.lesson25.server.handler.services.FileService;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileSaver implements FileService {

    private static final String SAVED_FILES_DIR = "D:\\test";
    private final User user;

    public FileSaver(User user) {
        this.user = user;
    }

    @Override
    public void save(@NotNull File file) {
        String fileName = file.getName();
        final File outputFile = new File(SAVED_FILES_DIR + "\\" + fileName);
        final File parentDirectory = outputFile.getParentFile();

        if (!parentDirectory.exists()) {
            if (parentDirectory.mkdirs()) {
                //System.out.println("[DEBUG] Created parent directories: " + parentDirectory); // debug
            } else {
                throw new RuntimeException("Error creating parent directories: " + parentDirectory);
            }
        }

        if (!outputFile.exists()) {
            try {
                if (outputFile.createNewFile()) {
                    //System.out.println("[DEBUG] Created new file: " + outputFile.getName()); // debug info
                }
            } catch (IOException e) {
                throw new RuntimeException("Error creating file: " + outputFile.getName(), e);
            }
        } else {
            user.getClientWriter().println("File \"" + file.getName() + "\" already exist.");
            return;
        }

        try (OutputStream outputStream = new FileOutputStream(outputFile);
             InputStream inputStream = user.getClientSocket().getInputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("[INFO] Client \"" + user.getName() +
                    "\" uploaded file: " + file.getName() +
                    "\n[INFO] The file was successfully saved to the following path: " +
                    SAVED_FILES_DIR + "\\" + outputFile.getName());
        } catch (IOException e) {
            throw new RuntimeException("Error creating file output stream.", e);
        }
    }
}
