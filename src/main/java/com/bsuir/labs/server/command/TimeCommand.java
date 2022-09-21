package com.bsuir.labs.server.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeCommand implements Command{
    private Socket clientSocket;

    public TimeCommand(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void runCommand() throws IOException {
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        writer.println(formatter.format(date));
        writer.flush();
    }
}
