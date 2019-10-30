package test;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.UUID;

public class MyClient {
    private Socket socket;
    private String uuid;

  /*  public static void main(String[] args) throws IOException {
        MyClient client = new MyClient();
    }*/

    public MyClient( InetAddress inetAddress, int port) throws IOException {
        this.uuid = UUID.randomUUID().toString().replace("-", "");
        this.socket = new Socket(inetAddress, port);
        this.socket.setKeepAlive(true);

        System.out.println("is connected: " + this.socket.isConnected());
        System.out.println("client (" + this.uuid + ") " + this.socket.toString());
        read();
    }

    public void read() throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        String line;
        while ((line = inputReader.readLine()) != null) {
            System.out.println(line);
        }

        this.socket.close();
    }

    public void write(String text) throws IOException {
        PrintWriter writer = new PrintWriter(this.socket.getOutputStream(), true);
        writer.println(text);
        writer.close();
    }

    public boolean close() throws IOException {
        this.socket.close();
        return this.socket.isClosed();
    }
}

