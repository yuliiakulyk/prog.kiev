package main.com.yuliiakulyk.app.i.network.task;

import java.io.File;
import java.util.Map;
import java.util.Set;

/**
 * Created by Yuliia Kulyk on 15.02.2018.
 */
public class Main {
    public static void main(String[] args) {
//        Set<String> set = UrlWork.readURLFromFile(new File("url.txt"));
//        for (String url: set) {
//            //System.out.println(url);
//            System.out.println("url " + url + " is available: " + UrlWork.urlExists(url));
//        }
        UrlWork work = new UrlWork();
        work.loadLinksFromFile(new File("url.txt"));
        work.checkAllLinks();

        Map<String, Link> result = work.getLinks();
        Set<String> resultLinks = result.keySet();
        for (String link:resultLinks
             ) {
            System.out.println(result.get(link));
        }
    }

}
