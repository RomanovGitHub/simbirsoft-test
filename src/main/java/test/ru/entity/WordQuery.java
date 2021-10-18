package test.ru.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "word")
public class WordQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @Column
    private String url;

    @Column(name = "created_date")
    private String created;

    @Column
    @JoinColumn(name = "word_id")
    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<WordCount> wordsCount;
}
