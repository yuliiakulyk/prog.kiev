package main.com.yuliiakulyk.app.i.network.homework;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yuliia Kulyk on 19.02.2018.
 */
public class LinksFromHtml {

    public static void linksFromHtmlToFile(String url, File file) throws IOException {
        listStringToFile(linksFromString(getHtml(url)), file);
    }

    public static String getHtml(String url) throws IOException {
        URL urlObject = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
        StringBuilder builder = new StringBuilder();
        String temp;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            while ((temp = reader.readLine()) != null) {
                builder.append(temp).append(System.lineSeparator());
            }
        }
        return builder.toString();
    }

    public static List<String> linksFromString(String string) {
        List<String> links = new ArrayList<>();
        String regex = "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            links.add(matcher.group());
        }
        return links;
    }

    public static void listStringToFile(List<String> list, File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line: list) {
                writer.write(line);
                writer.write(System.lineSeparator());
            }
        }
    }
}
