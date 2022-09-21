package com.bsuir.labs.server.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class CloseCommand implements Command{

    private final Socket clientSocket;

    public CloseCommand(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    @Override
    public void runCommand(){
        try (clientSocket) {
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
            writer.println("Connection was successfully closed\n");
            writer.flush();
        } catch (IOException ignored){

        }
    }
}
