package pl.kietlinski.iolab1serwer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Quiz {

    @Id
    private String id;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String correctAnswer;

}
