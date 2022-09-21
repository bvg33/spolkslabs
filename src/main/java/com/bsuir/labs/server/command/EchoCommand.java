package com.bsuir.labs.server.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoCommand implements Command{

    private Socket clientSocket;

    private String message;

    public EchoCommand(Socket clientSocket, String message) {
        this.clientSocket = clientSocket;
        this.message = message;
    }

    @Override
    public void runCommand() throws IOException {
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
        writer.println(message);
        writer.flush();
    }
}
