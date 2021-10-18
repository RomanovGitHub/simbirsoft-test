package test.ru.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import test.ru.service.SplitHelper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SplitHelperTest {

    @Autowired
    SplitHelper splitHelper = new SplitHelperImpl();

    @DisplayName("Test SplitHelperTest simple")
    @Test
    void testGet() {

        List<String> preparedStringList = List.of(" ", "122Мама. ", "Папа1", "Привет! !", "!,мир!", ",421");

        List<String> expectedList = List.of("Мама", "Папа", "Привет", "мир");
        List<String> result = splitHelper.getWords(preparedStringList);
        assertEquals(4, result.size());
        for (int  i = 0; i < result.size(); i ++) {
            assertEquals(expectedList.get(i), (result.get(i)));
        }
    }

}