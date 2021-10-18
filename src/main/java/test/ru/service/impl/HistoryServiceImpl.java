package test.ru.service.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import test.ru.entity.WordQuery;
import test.ru.repository.WordRepository;
import test.ru.service.HistoryService;

@AllArgsConstructor
@Service
@Getter
@Setter
public class HistoryServiceImpl implements HistoryService {
    private final WordRepository wordRepository;

    @Override
    public void save(WordQuery wordQuery) {
        wordRepository.save(wordQuery);
    }

}
