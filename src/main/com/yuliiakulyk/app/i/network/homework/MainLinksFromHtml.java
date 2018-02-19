package main.com.yuliiakulyk.app.i.network.homework;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yuliia Kulyk on 19.02.2018.
 */
public class MainLinksFromHtml {
    public static void main(String[] args) {
        try {
            File file = new File("src\\main\\com\\yuliiakulyk\\app\\i\\network\\homework\\linksFromHtml.txt");
            LinksFromHtml.linksFromHtmlToFile("https://www.google.com.ua", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
