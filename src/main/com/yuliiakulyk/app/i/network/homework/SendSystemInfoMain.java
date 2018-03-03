package main.com.yuliiakulyk.app.i.network.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Yuliia Kulyk on 20.02.2018.
 */
public class SendSystemInfoMain {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(20000)) {
            int i = 0;
            while(true) {
                System.out.println("Waiting for incoming socket");
                Socket incomingSocket = serverSocket.accept();
                Thread t = new Thread(new SendSystemInfo(incomingSocket, ++i));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
