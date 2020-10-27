package pl.kietlinski.iolab1serwer.service;

import pl.kietlinski.iolab1serwer.entity.Question;

import java.util.List;

public interface QuizService {

    List<Question> getQuiz();

    void getNewQuestions();

    int getQuizResult(String question1, String question2, String question3, String question4, String question5);
}
