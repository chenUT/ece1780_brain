package brain.service;

import brain.models.AnswerWithScore;
import brain.models.QAText;
import brain.models.Question;
import brain.models.QuestionAnswer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 3/16/17.
 */
@Service
public class ScoreService {
    private static final double NOUN_MATCH_SCORE = 1;

    private static final Object LOCK = new Object();

    @Autowired
    Word2VecService word2VecService;

    // TODO improve this algo
    public AnswerWithScore getAnswerWithScore(QuestionAnswer knownQA, Question query) {
        AnswerWithScore totalScore = new AnswerWithScore(knownQA.getAnswerText());
        totalScore.setKnownQuestion(knownQA.getQuestion().getText());

        final List<String> knownNouns = new ArrayList<>(knownQA.getQuestion().getNouns());
        final List<String> queryNouns = new ArrayList<>(query.getNouns());
        List<String> matchNouns = new ArrayList<>();
        // check noun

        queryNouns.forEach(n -> {
            if (knownNouns.contains(n)){
                synchronized (LOCK) {
                    totalScore.addScore(NOUN_MATCH_SCORE);
                    knownNouns.remove(n);
                    matchNouns.add(n);
                }
            }
        });

        // remove matched nouns
        matchNouns.forEach( n -> {
            queryNouns.remove(n);
        });

        //go through unmatched nouns
        queryNouns.forEach(qn -> {
           DoubleWrapper maxSim = new DoubleWrapper(-1);
           knownNouns.forEach(kn -> {
              double tmpSim = word2VecService.getWord2Vec().similarity(qn, kn);
              if (tmpSim > maxSim.value) {
                  maxSim.setValue(tmpSim);
              }
           });
           totalScore.addScore(maxSim.value);
        });

        // if we only have one noun in query, we bump up the weight for this noun
        if (knownNouns.size() == 0 && queryNouns.size() == 0) {
            totalScore.addScore(5.0);
        } else if (queryNouns.size() == 0) {
            totalScore.addScore(2.5);
        } else {
            if (knownNouns.size() == 0) {
                totalScore.addScore(1.0);
            }
        }

        return totalScore;
    }

    public void reTrain (List<QAText> qas) {
    }

    private static class DoubleWrapper {
        double value;
        public DoubleWrapper(double init){
            this.value = init;
        }

        public void setValue(double value){
            this.value = value;
        }
    }
}
