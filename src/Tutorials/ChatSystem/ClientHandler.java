package Tutorials.ChatSystem;

import java.io.*;
import java.net.*;
import java.util.*;



public class ClientHandler implements Runnable{
    private Socket socket;
    private BufferedReader reader ;
    private PrintWriter writer;
    private String nickname;
    private List<ClientHandler> clients;

    public ClientHandler(Socket socket, List<ClientHandler> clients) {
        this.socket = socket;
        this.clients = clients;
    }

    public void run(){
        try{
            // Set up input/output streams
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            //Ask for Nickname
            writer.println("Enter your nickname");
            nickname = reader.readLine();

            System.out.println(nickname + " has joined the chat");
            broadcast(nickname + "joined the chat", this) ;

        } catch(IOException e){
           System.out.println("Error: " + e.getMessage());
        } finally{
            disconnect();
        }
    }

    public void broadcast(String message, ClientHandler sender){
        for (ClientHandler client : clients) {
            if(client != sender){
                client.writer.println(message);
            }
        }
    }
    public void disconnect(){
        try{
            clients.remove(this);
            if (nickname != null) {
                System.out.println(nickname + " has left the chat");
                broadcast(nickname + "left the chat", this);
            }
            socket.close();
        } catch(IOException e) {
            e.printStackTrace();

        }
    }



}
