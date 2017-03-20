package brain.rest;

import brain.models.*;
import brain.service.QATextService;
import brain.service.Word2VecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import brain.repositories.QARepository;
import brain.service.ScoreService;
import brain.service.SentenceService;

import java.io.IOException;
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
    QATextService qaTextService;

    @Autowired
    Word2VecService word2VecService;

    @Autowired
    QARepository qaRepository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(name = "/qa", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void loadQA(@RequestBody QAList qaList, @RequestParam(name = "category", defaultValue = "UoT") String category){
        if (qaList == null || qaList.getQaList() == null || qaList.getQaList().size() == 0) {
            throw new IllegalArgumentException("qas can not be empty");
        }

        qaList.getQaList().forEach(qaText -> {
            qaTextService.addQAText(qaText);
        });

        qaList.getQaList().forEach(qaText -> {
            QuestionAnswer qa = new QuestionAnswer();
            Question q = sentenceService.processQuestion(qaText.getQuestion());
            qa.setQuestion(q);
            qa.setAnswerText(qaText.getAnswer());
            qaRepository.insertQuestionAnswer(category, qa);
        });

        try {
            word2VecService.train();
        } catch (IOException e) {
            e.printStackTrace();
            throw  new RuntimeException("fail to train");
        }
        // retrain the word2vec
        System.out.println("done");
    }

    @RequestMapping(name = "/qa", method = RequestMethod.GET)
    public AnswerWithScore getAnswer(@RequestParam(name = "question")String question){
        Question askQuestion = sentenceService.processQuestion(question);
        List<QuestionAnswer> tempQAs = qaRepository.loadQuestionAnswers("UoT");
        List<AnswerWithScore> scoredList = tempQAs.stream().map(tempQA -> scoreService.getAnswerWithScore(tempQA, askQuestion)).collect(Collectors.toList());

        scoredList.sort((o1, o2) -> {
            if (o1.getScore() < o2.getScore()) return 1;
            else if (o1.getScore() > o2.getScore()) return -1;
            else return 0;
        });

        if(scoredList.size() == 0){
            return new AnswerWithScore("No Answer Available");
        }

        return scoredList.get(0);
    }
}
