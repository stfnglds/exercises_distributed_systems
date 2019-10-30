package test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        int port = 1500;

        MyServer server = new MyServer();
        MyClient client = new MyClient(inetAddress, port);

    }
}
