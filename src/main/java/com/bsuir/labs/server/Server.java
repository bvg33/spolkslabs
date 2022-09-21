package com.bsuir.labs.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ClientHandler handler;

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(7777);
        System.out.println("Сервер запущен!");
        Socket client = server.accept();
        System.out.println("Клиент подключен " + client);
        new ClientHandler(client).processInputData();
    }
}
