package main.com.yuliiakulyk.app.i.network;

import java.io.File;

/**
 * Created by Yuliia Kulyk on 15.02.2018.
 */
public class Main {
    public static void main(String[] args) {
//        String urlAddress = "https://prog.kiev.ua/forum/index.php/topic,3373.75.html";
//        String result = InetWork.getStringFromURL(urlAddress);
//        System.out.println(result);

        String url = "https://i1.rozetka.ua/big_promo/547/547903.jpg";
        File file = new File("photo.jpg");
        InetWork.saveToFileURLresources(url, file);
        System.out.println("Done");
    }
}
