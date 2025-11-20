package com.example.bank;

import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XmlParser {

    public static List<RateRow> parse(String xml) throws Exception {
        List<RateRow> list = new ArrayList<>();

        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(new java.io.ByteArrayInputStream(xml.getBytes("UTF-8")));

        NodeList nodes = doc.getElementsByTagName("Rate");

        for (int i = 0; i < nodes.getLength(); i++) {
            Element el = (Element) nodes.item(i);

            String date = el.getAttribute("date");
            String rate = el.getTextContent();

            list.add(new RateRow(date, rate));
        }

        return list;
    }
}
