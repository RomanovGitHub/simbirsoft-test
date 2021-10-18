package test.ru.service;

import test.ru.entity.WordQuery;

import java.io.IOException;

public interface WordService {
    WordQuery calculateWordStatisticByUrl(String url) throws IOException;
}
