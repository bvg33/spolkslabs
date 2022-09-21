package com.bsuir.labs.server.command;

import java.net.Socket;

public class CommandFactory {
    public static Command getCommand(String userLine, Socket clientSocket) {
        String stringCommand = userLine.split(" ")[0];
        String message = userLine.replaceFirst("^\\w+ ", "");
        switch (stringCommand) {
            case "echo":
                return new EchoCommand(clientSocket, message);
            case "time":
                return new TimeCommand(clientSocket);
            case "close":
                return new CloseCommand(clientSocket);
            case "upload":
                return new UploadCommand(clientSocket);
            default:
                return null;
        }
    }
}
