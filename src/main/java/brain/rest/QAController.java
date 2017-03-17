package brain.rest;

import brain.models.AnswerWithScore;
import brain.models.Question;
import brain.models.QuestionAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import brain.repositories.QARepository;
import brain.service.ScoreService;
import brain.service.SentenceService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yws894 on 3/10/17.
 */
@RestController
public class QAController {

    @Autowired
    ScoreService scoreService;

    @Autowired
    SentenceService sentenceService;

    @Autowired
    QARepository qaRepository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/qa")
    public AnswerWithScore getAnswer(@RequestParam(name = "question")String question){
        Question askQuestion = sentenceService.processQuestion(question);
        List<QuestionAnswer> tempQAs = qaRepository.loadQuestionAnswers("UoT");
        List<AnswerWithScore> scoredList = tempQAs.stream().map(tempQA -> scoreService.getAnswerWithScore(tempQA, askQuestion)).collect(Collectors.toList());

        scoredList.sort((o1, o2) -> o2.getScore() - o1.getScore());

        if(scoredList.size() == 0){
            return new AnswerWithScore("No Answer Available");
        }

        return scoredList.get(0);
    }
}
