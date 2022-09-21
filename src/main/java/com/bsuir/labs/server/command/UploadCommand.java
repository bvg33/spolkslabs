package com.bsuir.labs.server.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class UploadCommand implements Command{

    private final Socket clientSocket;

    public UploadCommand (Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void runCommand() throws IOException {
        Path filePath = Paths.get("file.txt");
       // byte [] fileBytes = Files.readAllBytes(filePath);
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
        writer.println(Files.readAllLines(filePath));
        writer.flush();
    }
}
