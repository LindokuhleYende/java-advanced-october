package ch17;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.*;
import java.util.concurrent.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SimpleChatServer {
  private final List<PrintWriter> clientWriters = new ArrayList<>();

  public static void main(String[] args) {
    new SimpleChatServer().go();
  }

  public void go() {
    ExecutorService threadPool = Executors.newCachedThreadPool(); //Creates a thread pool that can dynamically create new threads.
    try {
      ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
      serverSocketChannel.bind(new InetSocketAddress(5000));  //Opens a server socket channel to listen for connections on port 5000.

      while (serverSocketChannel.isOpen()) {
        SocketChannel clientSocket = serverSocketChannel.accept();
        PrintWriter writer = new PrintWriter(Channels.newWriter(clientSocket, UTF_8)); //It creates a PrintWriter to send data to that client.
        clientWriters.add(writer); //Adds the writer to a list clientWriters (so it can broadcast messages later).
        threadPool.submit(new ClientHandler(clientSocket)); //Creates a new ClientHandler and submits it to the thread pool.
          //Each new client gets its own thread via the thread pool, and that thread runs ClientHandler.run()
        System.out.println("got a connection");
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  private void tellEveryone(String message) {
    for (PrintWriter writer : clientWriters) {
      writer.println(message);
      writer.flush();
    }
  }

  public class ClientHandler implements Runnable {
    BufferedReader reader;
    SocketChannel socket;

    public ClientHandler(SocketChannel clientSocket) {
      socket = clientSocket;
      reader = new BufferedReader(Channels.newReader(socket, UTF_8));
    }

    public void run() {
      String message;
      try {
        while ((message = reader.readLine()) != null) {
          System.out.println("read " + message);
          tellEveryone(message);
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }
}