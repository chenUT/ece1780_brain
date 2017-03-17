package brain.service;

import brain.models.AnswerWithScore;
import brain.models.Question;
import brain.models.QuestionAnswer;
import org.springframework.stereotype.Service;

/**
 * Created by chen on 3/16/17.
 */
@Service
public class ScoreService {
    private static final int NOUN_SCORE = 10;
    private static final int VERB_SCORE = 5;

    private static final Object LOCK = new Object();

    public AnswerWithScore getAnswerWithScore(QuestionAnswer knownQA, Question query) {
        AnswerWithScore totalScore = new AnswerWithScore(knownQA.getAnswerText());
        totalScore.setKnownQuestion(knownQA.getQuestion().getText());

        // check noun
        query.getNouns().forEach(n -> {
            if (knownQA.getQuestion().getNouns().contains(n)){
                synchronized (LOCK) {
                    totalScore.addScore(NOUN_SCORE);
                }
            }
        });

        // check verb
        query.getVerbs().forEach(v -> {
            if (knownQA.getQuestion().getVerbs().contains(v)){
                synchronized (LOCK) {
                    totalScore.addScore(VERB_SCORE);
                }
            }
        });

        return totalScore;
    }
}
