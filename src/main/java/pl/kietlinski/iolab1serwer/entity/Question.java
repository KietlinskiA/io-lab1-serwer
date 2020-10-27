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
public class Question {

    @Id
    private String id;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String correctAnswer;

    public Question(String question, String answer1, String answer2, String answer3, String correctAnswer) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.correctAnswer = correctAnswer;
    }
}
