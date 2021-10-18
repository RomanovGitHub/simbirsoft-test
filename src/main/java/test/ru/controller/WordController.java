package test.ru.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.ru.service.WordService;

import java.io.IOException;

@RestController
@RequestMapping
public class WordController {

    private final WordService service;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public WordController(WordService service) {
        this.service = service;
    }

    @GetMapping(value = "/wordStatisticByUrl")
    public ResponseEntity<String> wordStatisticByUrl(String url) throws IOException {
        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus;
        String body;
        try {
            body = objectMapper.writeValueAsString(service.calculateWordStatisticByUrl(url));
            httpStatus = HttpStatus.OK;
        } catch (Exception e) {
            httpStatus = HttpStatus.BAD_REQUEST;
            body = e.getMessage();
        }
        return new ResponseEntity<>(body, responseHeaders, httpStatus);
    }

}
