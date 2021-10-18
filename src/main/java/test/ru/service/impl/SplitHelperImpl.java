package test.ru.service.impl;

import org.springframework.stereotype.Service;
import test.ru.service.SplitHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Service
public class SplitHelperImpl implements SplitHelper {
    private static final String SPACE = " ";
    private static final String EMPTY_SYMBOL = " ";
    private final String[] separators = {
            ",", ".", "!", "?", ";", ":", "(", ")",
            "[", "]", "\n", "\r", "\t", "\"", "‑",
            "-", "—", "'", "/", "%", "1", "2", "3",
            "4", "5", "6", "7", "8", "9"
    };

    @Override
    public List<String> getWords(List<String> uniqStringList) {
        List<String> resultWords = new ArrayList<>();
        for (String stringValue : uniqStringList) {
            for (String separator : separators) {
                if (stringValue.contains(separator)) {
                    stringValue = stringValue.replace(separator, SPACE);
                }
            }
            String [] words = (stringValue.split(SPACE));
            for (String word : words) {
                if (!word.isEmpty()) {
                    resultWords.add(word);
                }
            }
        }
        return resultWords;
    }

}