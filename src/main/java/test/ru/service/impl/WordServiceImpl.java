package test.ru.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import test.ru.entity.WordCount;
import test.ru.entity.WordQuery;
import test.ru.service.HistoryService;
import test.ru.service.HtmlParser;
import test.ru.service.SplitHelper;
import test.ru.service.WordService;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class WordServiceImpl implements WordService {
    private final SplitHelper splitHelper;
    private final HtmlParser htmlParser;
    private final HistoryService historyService;
    private final static int ONE = 1;

    @Override
    public WordQuery calculateWordStatisticByUrl(String url) throws IOException {
        List<String> uniqStringList = htmlParser.getUniqStringList(url);
        List<String> words = splitHelper.getWords(uniqStringList);
        WordQuery result = getWordsResult(words, url);
        historyService.save(result);
        return result;
    }

    private WordQuery getWordsResult(List<String> words, String url) {
        Map<String, Integer> result = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                word = word.toLowerCase();
                if (result.containsKey(word)) {
                    result.put(word, result.get(word) + ONE);
                } else
                    result.put(word, ONE);
            }
        }
        WordQuery wordQuery = new WordQuery();
        wordQuery.setUrl(url);
        wordQuery.setCreated(ZonedDateTime.now().toString());
        wordQuery.setWordsCount(getWordsCount(result));
        return wordQuery;
    }

    private List<WordCount> getWordsCount(Map<String, Integer> result) {
        List<WordCount> wordsCount = new ArrayList<>();
        for (Map.Entry<String, Integer> value : result.entrySet()) {
            WordCount wordCount = new WordCount();
            wordCount.setWord(value.getKey());
            wordCount.setCount(value.getValue());
            wordsCount.add(wordCount);
        }
        return wordsCount;
    }
}
