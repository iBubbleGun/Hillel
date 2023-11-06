package edu.hillel.homework.lesson25.server.managers;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class ServerSocketManager implements AutoCloseable {

    private ServerSocket serverSocket;
    private final InetSocketAddress inetSocketAddress;

    public ServerSocketManager(String address, int port) {
        this.inetSocketAddress = new InetSocketAddress(address, port);
    }

    public ServerSocket getSocket() throws IOException {
        this.serverSocket = new ServerSocket();
        serverSocket.bind(inetSocketAddress);
        return serverSocket;
    }

    @Override
    public void close() throws Exception {
        if (serverSocket != null) {
            serverSocket.close();
        }
    }
}
