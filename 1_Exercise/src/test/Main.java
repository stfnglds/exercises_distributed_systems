package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new WriteHelloWorld());
        thread1.start();

        Thread thread2 = new Thread(new WriteRandomToFile());
        thread2.start();
    }
}


class WriteHelloWorld implements Runnable {
    public void run() {

        // write to file
        try (PrintWriter out = new PrintWriter(new FileOutputStream(
                new File("text.txt"),
                true /* append = true */))) {
            String text = "hello world " + new java.util.Date();
            out.append(text + "\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


class WriteRandomToFile implements Runnable {
    public void run() {
        while (true) {
            // sleep 5 Seconds
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // write to file
            try (PrintWriter out = new PrintWriter(new FileOutputStream(
                    new File("text.txt"),
                    true /* append = true */))) {

                String randomString = UUID.randomUUID().toString();

                String text = randomString + " " + new java.util.Date();
                out.append(text + "\n");
                System.out.println("wrote " + text + " to file");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

