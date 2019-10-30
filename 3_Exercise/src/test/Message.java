package test;

public class Message {
    private String body;
    private String address;
    private int port;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Message(String body, String address, int port) {
        this.body = body;
        this.address = address;
        this.port = port;
    }

}
