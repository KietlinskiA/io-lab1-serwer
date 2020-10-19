package pl.kietlinski.iolab1serwer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.kietlinski.iolab1serwer.entity.Question;

@Repository
public interface QuizRepository extends MongoRepository<Question, String> {
}
