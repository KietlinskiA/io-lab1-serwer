package pl.kietlinski.iolab1serwer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kietlinski.iolab1serwer.entity.Motto;
import pl.kietlinski.iolab1serwer.service.MottoService;
import pl.kietlinski.iolab1serwer.service.QuizService;

@RestController
@RequestMapping("/api")
public class MainController {

    private MottoService mottoService;
    private QuizService quizService;

    @Autowired
    public MainController(MottoService mottoService, QuizService quizService) {
        this.mottoService = mottoService;
        this.quizService = quizService;
    }

    @GetMapping
    public ResponseEntity<Motto> getMotto() {
        return ResponseEntity.ok(mottoService.getMotto());
    }

    @GetMapping("/{points}")
    public ResponseEntity<String> getQuizResult(@PathVariable String points) {
        return ResponseEntity.ok(quizService.getQuizResult(points));
    }


}
