package pl.kietlinski.iolab1serwer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kietlinski.iolab1serwer.entity.Motto;
import pl.kietlinski.iolab1serwer.entity.Question;
import pl.kietlinski.iolab1serwer.service.MottoServiceImpl;
import pl.kietlinski.iolab1serwer.service.QuizServiceImpl;

import java.util.List;

@RestController
public class ServerController {

    private MottoServiceImpl mottoServiceImpl;
    private QuizServiceImpl quizServiceImpl;

    @Autowired
    public ServerController(MottoServiceImpl mottoServiceImpl, QuizServiceImpl quizServiceImpl) {
        this.mottoServiceImpl = mottoServiceImpl;
        this.quizServiceImpl = quizServiceImpl;
    }

    @GetMapping("/motto")
    public ResponseEntity<Motto> getMotto() {
        return ResponseEntity.ok(mottoServiceImpl.getMotto());
    }

    @GetMapping("/quiz")
    public ResponseEntity<List<Question>> getQuiz() {
        return ResponseEntity.ok(quizServiceImpl.getQuiz());
    }

    @GetMapping("/checkAnswers")
    public ResponseEntity<Integer> getQuizResult(@RequestParam String question1,
                                                 @RequestParam String question2,
                                                 @RequestParam String question3,
                                                 @RequestParam String question4,
                                                 @RequestParam String question5
    ) {
        return ResponseEntity.ok(quizServiceImpl.getQuizResult(question1, question2, question3, question4, question5));
    }


}
