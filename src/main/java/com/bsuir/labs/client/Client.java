package com.bsuir.labs.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public void start() throws IOException {
        Socket clientSocket = new Socket(InetAddress.getLocalHost(), 7777);
        ClientService service = new ClientService(this, clientSocket);
        System.out.println("Клиент запущен!");
        while (true) {
            String command = service.getConsoleCommand();
            service.sendRequestToServer(command);
            service.getServerResponse();
        }
    }
}
