package main.com.yuliiakulyk.app.i.network;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Yuliia Kulyk on 15.02.2018.
 */
public class InetWork {

    public static String getStringFromURL(String urlAddress) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(urlAddress);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream is = con.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String temp = "";
            for (; (temp = reader.readLine()) != null;) {
                sb.append(temp).append(System.lineSeparator());
            }
            reader.close();
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void saveToFileURLresources(String urlAddress, File file) {
        try {
            URL url = new URL(urlAddress);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream is = con.getInputStream();
            try (OutputStream os = new FileOutputStream(file)) {
                byte[] byteArray = new byte[1024];
                int byteRead = 0;
                for(;(byteRead = is.read(byteArray)) > 0;) {
                    os.write(byteArray, 0, byteRead);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
