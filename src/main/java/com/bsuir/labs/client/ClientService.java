package com.bsuir.labs.client;

import static org.apache.commons.lang3.ArrayUtils.toPrimitive;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientService {
    private Client client;

    private Socket clientSocket;

    private String lastCommand;

    public ClientService(Client client, Socket clientSocket) {
        this.client = client;
        this.clientSocket = clientSocket;
    }

    public String getConsoleCommand(){
        Scanner consoleScanner = new Scanner(System.in);
        String commandWithArgs = consoleScanner.nextLine();
        setLastCommand(commandWithArgs);
        return commandWithArgs;
    }

    private void setLastCommand(String commandWithArgs){
        lastCommand = commandWithArgs.split(" ")[0];
    }

    public void sendRequestToServer(String command) throws IOException {
        PrintWriter outputWriter = new PrintWriter(clientSocket.getOutputStream());
        outputWriter.println(command);
        outputWriter.flush();
    }

    public void getServerResponse() throws IOException {
        Scanner inputScanner = new Scanner(clientSocket.getInputStream());
        if(lastCommand.equals("upload")){
            uploadFile(inputScanner);
        }
        else if(inputScanner.hasNext()){
            System.out.println(inputScanner.nextLine());
        }
    }

    private void uploadFile(Scanner inputScanner) throws IOException {
        if(inputScanner.hasNext()){
            String byteString = inputScanner.nextLine();
            byte[] uploadFileBytes = byteString.getBytes(StandardCharsets.UTF_8);
            FileWriter fileWriter = new FileWriter("downloaded_file.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(byteString);
            fileWriter.flush();
            fileWriter.close();
            printWriter.flush();
            printWriter.close();
        }
    }
}
