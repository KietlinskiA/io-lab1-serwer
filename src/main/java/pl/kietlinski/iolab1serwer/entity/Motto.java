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
public class Motto {

    @Id
    private String id;
    private String content;
    private String author;

    public Motto(String content, String author) {
        this.content = content;
        this.author = author;
    }

}
