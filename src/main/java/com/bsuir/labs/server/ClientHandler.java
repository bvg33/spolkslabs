package com.bsuir.labs.server;

import com.bsuir.labs.server.command.Command;
import com.bsuir.labs.server.command.CommandFactory;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler {
    private Socket clientSocket;

    private Scanner scanner;

    public ClientHandler(Socket socket) throws IOException {
        this.clientSocket = socket;
        this.scanner = new Scanner(socket.getInputStream());
    }

    public void processInputData() throws IOException {
        while (true) {
            if (scanner.hasNext()) {
                String clientMessage = scanner.nextLine();
                System.out.println(clientMessage);
                Command command = CommandFactory.getCommand(clientMessage, clientSocket);
                if (command != null) {
                    command.runCommand();
                }
            }
        }
    }
}
