package edu.hillel.homework.lesson25.client.services;

import java.io.File;
import java.net.Socket;

public interface FileService {

    void send(File file, Socket socket);
}
