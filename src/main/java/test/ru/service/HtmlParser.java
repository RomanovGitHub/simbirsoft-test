package test.ru.service;

import java.io.IOException;
import java.util.List;

public interface HtmlParser {
    List<String> getUniqStringList(String url) throws IOException;
}
