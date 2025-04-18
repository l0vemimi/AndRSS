package com.andrss;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;

public class RSSParser {
    public static String[] parseRSS(String feedUrl) {
        try {
            URL url = new URL(feedUrl);
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(url.openStream());

            NodeList items = doc.getElementsByTagName("item");
            Element item = (Element) items.item(0);

            String title = item.getElementsByTagName("title").item(0).getTextContent();
            String description = item.getElementsByTagName("description").item(0).getTextContent();

            return new String[]{title, description};
        } catch (Exception e) {
            e.printStackTrace();
            return new String[]{"Error", "Could not fetch RSS feed"};
        }
    }
}