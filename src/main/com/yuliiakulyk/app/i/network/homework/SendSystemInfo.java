package main.com.yuliiakulyk.app.i.network.homework;

import java.io.*;
import java.net.Socket;

/**
 * Created by Yuliia Kulyk on 03.03.2018.
 */
public class SendSystemInfo implements Runnable {
    private Socket socket;
    private int requestNumber;

    public SendSystemInfo(Socket socket, int requestNumber) {
        this.socket = socket;
        this.requestNumber = requestNumber;
    }

    public void sendSystemInfo() throws IOException {
        try (InputStream inputStream = this.socket.getInputStream();
             PrintWriter writer = new PrintWriter(this.socket.getOutputStream(), true)) {
            byte[] rec1 = new byte[inputStream.available()];
            inputStream.read(rec1);
            String request = new String(rec1);
            System.out.println("--------------------------------------------------");
            System.out.println("Accepted socket: " + this.socket.getInetAddress());
            System.out.println("request: " + request);
            String response = "HTTP/1.1 200 OK\r\n" + "Server: My_Server\r\n" + "Content-Type: text/html\r\n" + "Content-Length: " + "\r\n" + "Connection: close\r\n\r\n";
            writer.print(response);
            writer.print(this.getSystemInfo());
            writer.flush();
            this.socket.close();
            System.out.println("Closed socket");
            System.out.println("--------------------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public String getSystemInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<p>Request number: " + this.requestNumber + "</p>");
        stringBuilder.append("<p>OS name: " + System.getProperty("os.name") + "</p>");
        stringBuilder.append("<p>OS version: " + System.getProperty("os.version") + "</p>");
        stringBuilder.append("<p>Architecture of the OS: " + System.getProperty("os.arch") + "</p>");
        stringBuilder.append("<p>Maximum memory (bytes): " + Runtime.getRuntime().maxMemory() + "</p>");
        stringBuilder.append("<p>Total memory available to JVM (bytes): " + Runtime.getRuntime().totalMemory() + "</p>");
        stringBuilder.append("<p>Available processors (cores): " + Runtime.getRuntime().availableProcessors() + "</p>");
        return stringBuilder.toString();
    }

    @Override
    public void run() {
        try {
            sendSystemInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}