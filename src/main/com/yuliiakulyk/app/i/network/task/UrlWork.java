package main.com.yuliiakulyk.app.i.network.task;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Yuliia Kulyk on 15.02.2018.
 */
public class UrlWork {
    Map<String, Link> links;

    public UrlWork() {
        this.links = new HashMap<>();
    }

    public Map<String, Link> getLinks() {
        return links;
    }

    private Link checkOneLink(String urlAddress) {
        Link link = new Link(urlAddress, 0, "");
        try {
            URL url = new URL(urlAddress);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            link.setResponseCode(con.getResponseCode());
            link.setResponseMessage(con.getResponseMessage());
        } catch (IOException e) {
            link.setResponseCode(404);
            link.setResponseMessage("Not registered domain name");
        }
        return link;
    }

    public void loadLinksFromFile(File file) {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String temp;
            for (; ((temp = br.readLine()) != null);) {
                links.put(temp, new Link(temp, -1, "Not checked"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkAllLinks() {
        Set<String> linkAddress = links.keySet();
        for (String urlAddress: linkAddress) {
            links.put(urlAddress, checkOneLink(urlAddress));
        }
    }

    public static Set<String> readURLFromFile(File file) {
        Set<String> urls = new LinkedHashSet<>();
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String temp;
                for(; (temp = reader.readLine()) != null ;) {
                    urls.add(temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urls;
    }

    public static boolean urlExists(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            if (connection.getContentLengthLong() == -1.0) {
//                return false;
//            } else return true;
            int code = connection.getResponseCode();
            if (code == 200) {
                System.out.println("response code: " + code);
                return true;
            } else
                return false;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
