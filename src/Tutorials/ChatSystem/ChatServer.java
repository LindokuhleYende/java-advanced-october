package Tutorials.ChatSystem;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 5555;
    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args){
        System.out.println("Starting server...");

        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Server started on port " + PORT);

            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected : " + clientSocket.getInetAddress());

                ClientHandler clientHandler = new ClientHandler(clientSocket, clients);
                clients.add(clientHandler);

                Thread thread = new Thread(clientHandler);
                thread.start();
            }


        } catch(IOException e){
            e.printStackTrace();


        }
    }

}
