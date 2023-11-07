package edu.hillel.homework.lesson25.client.services.impl;

import edu.hillel.homework.lesson25.client.services.FileService;
import org.jetbrains.annotations.NotNull;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class FileSender implements FileService {

    @Override
    public void send(@NotNull File file, Socket socket) {
        if (file.exists() && file.isFile()) {
            try (OutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                 FileInputStream fileInputStream = new FileInputStream(file)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                throw new RuntimeException("Error creating output stream.", e);
            }
        } else {
            System.out.println("File not found.");
        }
    }
}
