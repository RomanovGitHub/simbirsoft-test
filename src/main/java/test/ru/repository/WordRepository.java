package test.ru.repository;

import org.springframework.data.repository.CrudRepository;
import test.ru.entity.WordQuery;

public interface WordRepository extends CrudRepository<WordQuery, Long> {
}
