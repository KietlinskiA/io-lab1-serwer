package pl.kietlinski.iolab1serwer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kietlinski.iolab1serwer.entity.Question;
import pl.kietlinski.iolab1serwer.repository.QuizRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;
    private List<Question> questionList;
    private List<Question> chosenQuestionList;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
        initQuizRepository();
        this.questionList = new ArrayList<>();
        initQuestionList();
        this.chosenQuestionList = new ArrayList<>();
    }
    
    private void initQuizRepository() {
        quizRepository.deleteAll();
        quizRepository.save(new Question(
                "Jakiego koloru jest trawa?",
                "Czerwony",
                "Zielony",
                "Szary",
                "B"));
        quizRepository.save(new Question(
                "Jak się nazywają budowle w stożka w Egipcie?",
                "Kostki Rubika",
                "Trójkąty",
                "Piramidy",
                "C"));
        quizRepository.save(new Question(
                "Kiedy jest dzień dziecka?",
                "11 Czerwca",
                "1 Czerwca",
                "1 Lipca",
                "B"));
        quizRepository.save(new Question(
                "Co pada z nieba zimą?",
                "Śnieg",
                "Kamienie",
                "Podkowy",
                "A"));
        quizRepository.save(new Question(
                "Małe, żółte i kopie?",
                "Średnia niebieska ciężarówka",
                "Duża czerwona taczka",
                "Mała żółta koparka",
                "C"));
        quizRepository.save(new Question(
                "Jaki jest wynik działania 2+2*2?",
                "6",
                "8",
                "10",
                "A"));
        quizRepository.save(new Question(
                "Jakiego koloru jest słońce?",
                "Żółte",
                "Niebieskie",
                "Purpurowe",
                "A"));
        quizRepository.save(new Question(
                "System operacyjny firmy Apple to...?",
                "Linux",
                "MacOS",
                "Windows",
                "B"));
        quizRepository.save(new Question(
                "W jakim wieku możemy otrzymać prawo jazdy kat. B?",
                "17",
                "21",
                "18",
                "C"));
        quizRepository.save(new Question(
                "Które z wymienionych czynności ma najbardziej szkodliwe działanie dla człowieka? ",
                "Palenie tytoniu",
                "Zdrowa dieta",
                "Uprawianie sportu",
                "A"));
        quizRepository.save(new Question(
                "Która marka samochodowa jest najbardziej prestiżowa?",
                "Rolls-Royce",
                "Smart",
                "Polonez",
                "A"));
        quizRepository.save(new Question(
                "Jak nazywa się najpopularniejszy portal społecznościowy?",
                "Facepaper",
                "Footbook",
                "Facebook",
                "C"));
        quizRepository.save(new Question(
                "Jak nazywa się najpopularniejszy sklep internetowy?",
                "Alledrogo",
                "Allegro",
                "Alletanio",
                "B"));
        quizRepository.save(new Question(
                "Jak nazywa się najpopularniejszy serwis ogłoszeń lokalnych?",
                "OLX",
                "XDD",
                "LOL",
                "A"));
        quizRepository.save(new Question(
                "Jak nazywa się najpopularniejszy serwis ogłoszeń samochodowych?",
                "Ototo",
                "Ototamto",
                "Otomoto",
                "C"));
        quizRepository.save(new Question(
                "Jak nazywa się popularny aktor, ulubieniec reżysera Tarantino?",
                "Leonardo DiCaprio",
                "Leonardo DiHortex",
                "Leonardo DiTymbark",
                "A"));
        quizRepository.save(new Question(
                "Jak nazywa się maszyna wirnikowa sprężająca powietrze za pomocą turbiny?",
                "Turbosprężarka",
                "Sprężarka",
                "Turbina",
                "A"));
        quizRepository.save(new Question(
                "Dlaczego Święty Mikołaj jest taki uśmiechnięty?",
                "Bo zna wszystkie niegrzeczne dziewczynki",
                "Bo dostał wylewu",
                "Bo zgubił portfel",
                "A"));
        quizRepository.save(new Question(
                "Jak nazywa się popularny framework Java?",
                "Winter",
                "Spring",
                "Summer",
                "B"));
        quizRepository.save(new Question(
                "Jaki napój ma największą ilość procentową alkoholu?",
                "Wódka",
                "Piwo",
                "Spirytus",
                "C"));
    }

    private void initQuestionList() {
        questionList = quizRepository.findAll();
    }

    @Override
    public List<Question> getQuiz() {
        getNewQuestions();
        return chosenQuestionList;
    }

    @Override
    public void getNewQuestions() {
        if (chosenQuestionList.size() != 0) {
            chosenQuestionList.clear();
        }
        Random random = new Random();
        // Losuj 5 pytań
        do {
            // Wylosuj pytanie z puli pytań
            Question question = questionList.get(random.nextInt(questionList.size()));
            // Sprawdź czy jest już takie pytanie w puli wylosowanych pytań
            boolean anyMatch = chosenQuestionList.stream()
                    .noneMatch(chosenQuestion -> chosenQuestion.getId().equals(question.getId()));
            // Jeśli nie ma - dodaj do puli wylosowanych pytań
            if (anyMatch) {
                chosenQuestionList.add(question);
            }
        } while (chosenQuestionList.size() != 5); // while
    }

    @Override
    public int getQuizResult(String question1, String question2, String question3, String question4, String question5) {
        int points = 0;
        String[] answerList = new String[]{question1, question2, question3, question4, question5};
        for (int i = 0; i < 5; i++) {
            if (answerList[i].equals(chosenQuestionList.get(i).getCorrectAnswer())) {
                points++;
            }
        }
        return points;
    }
}
