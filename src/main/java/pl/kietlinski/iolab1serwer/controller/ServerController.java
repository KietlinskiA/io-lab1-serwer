package pl.kietlinski.iolab1serwer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kietlinski.iolab1serwer.entity.Motto;
import pl.kietlinski.iolab1serwer.entity.Question;
import pl.kietlinski.iolab1serwer.service.MottoService;
import pl.kietlinski.iolab1serwer.service.QuizService;

import java.util.List;

@RestController
public class ServerController {

    private MottoService mottoService;
    private QuizService quizService;

    @Autowired
    public ServerController(MottoService mottoService, QuizService quizService) {
        this.mottoService = mottoService;
        this.quizService = quizService;
    }

    @GetMapping("/motto")
    public ResponseEntity<Motto> getMotto() {
        return ResponseEntity.ok(mottoService.getMotto());
    }

    @GetMapping("/quiz")
    public ResponseEntity<List<Question>> getQuiz() {
        return ResponseEntity.ok(quizService.getQuiz());
    }

    @GetMapping("/checkAnswers")
    public ResponseEntity<Integer> getQuizResult(@RequestParam String question1,
                                                @RequestParam String question2,
                                                @RequestParam String question3,
                                                @RequestParam String question4,
                                                @RequestParam String question5
    ) {
        return ResponseEntity.ok(quizService.getQuizResult(question1, question2, question3, question4, question5));
    }


}
