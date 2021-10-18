package test.ru.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class WordCount {
    @Column
    private String word;

    @Column
    private Integer count;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setWord(String word) {
        this.word = word;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
