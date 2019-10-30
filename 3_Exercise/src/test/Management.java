package test;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Management {
    ArrayList<MyClient> outgoingSockets = new ArrayList<MyClient>();
    ArrayList<MyServer> incomingSockets = new ArrayList<MyServer>();

    Queue<String> incomeQueue = new ArrayDeque<String>();
    Queue<String> outgoingQueue = new ArrayDeque<String>();

    public Management() throws IOException {
        // InetAddress.getByName("127.0.0.1")

        MyServer server = new MyServer(InetAddress.getByName("127.0.0.1"),1500);
        MyClient client = new MyClient();

        incomingSockets.add(server);
        outgoingSockets.add(client);
    }

    public  insertSocketIfNotExistent(Message message){
        // check server if exists



    }
}
