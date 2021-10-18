package test.ru.service.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import test.ru.service.HtmlParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HtmlParserImpl implements HtmlParser {
    @Override
    public List<String> getUniqStringList(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        String s = "";
        List<String> uniqStringList = new ArrayList<>();
        for (Element element : doc.getAllElements()) {
            if (element.tagName().equals("div")) {
                String elementText = element.text();
                if (!elementText.isEmpty()) {
                    if (!s.contains(elementText)) {
                        s = elementText;
                        uniqStringList.add(elementText);
                    }
                }
            }
        }
        return uniqStringList;
    }
}
