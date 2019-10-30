package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    /*public static void main(String[] args) throws IOException {
    }*/

    public MyServer(InetAddress inetAddress, int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port, 256, inetAddress);
        while (true) {
            Socket socket = serverSocket.accept();
            Thread thread = new Thread(new ServerThread(socket));
            thread.start();
        }
    }
}

class ServerThread implements Runnable {
    private Socket serverSocket;

    public ServerThread(Socket socket) {
        this.serverSocket = socket;
    }

    @Override
    public void run() {
        System.out.println("server is bound" + this.serverSocket.isBound());
        System.out.println("server" + this.serverSocket.toString());
        try {
            write("Hello World!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String text) throws IOException {
        PrintWriter writer =  new PrintWriter(this.serverSocket.getOutputStream(), true);
        writer.println(text);
        writer.close();
    }

    public void read() throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(this.serverSocket.getInputStream()));
        String line;
        while ((line = inputReader.readLine()) != null) {
            System.out.println(line);
        }

        this.serverSocket.close();
    }
}
