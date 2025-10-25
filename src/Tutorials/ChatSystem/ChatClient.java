package Tutorials.ChatSystem;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 5555;

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;
    private String nickname;

    public static void main(String[] args) {
        ChatClient client = new ChatClient();
        client.start();
    }

    public void start() {
        try{
            //Get nickname from user
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your nickname: ");
            nickname = scanner.nextLine();

            //Connect to server
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Connected to server");

            //Start receiving thread
            Thread receiveThread = new Thread(new ReceiveMessages());
            receiveThread.start();

            //Send messages from main thread
            sendMessage(scanner);


        } catch(IOException e){
          System.out.println("Could not connect to the server" + e.getMessage());
        }
    }

    public void sendMessage(Scanner scanner){
        try{
            while(true){
                String message = scanner.nextLine();
                writer.println(nickname + ": " +message);
            }

        } catch (Exception e){
            System.out.println(e.getMessage());

        } finally{
            try{
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ReceiveMessages implements Runnable{

        @Override
        public void run() {
            try{
                String message;

                while((message = reader.readLine()) != null){
                    if(message.equals("Nick")){
                        writer.println(nickname);
                    } else {
                        System.out.println(message);
                    }
                }
            } catch(IOException e){
                System.out.println("Could not read from the server" + e.getMessage());
            }

        }
    }

}
