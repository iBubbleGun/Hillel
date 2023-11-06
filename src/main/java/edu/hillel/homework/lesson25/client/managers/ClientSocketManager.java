package edu.hillel.homework.lesson25.client.managers;

import java.io.IOException;
import java.net.Socket;

public class ClientSocketManager implements AutoCloseable {

    private final String address;
    private final int port;
    private Socket socket;

    public ClientSocketManager(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public Socket getSocket() throws IOException {
        this.socket = new Socket(address, port);
        return socket;
    }

    @Override
    public void close() throws Exception {
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
    }
}
