package repositories;

import models.QuestionAnswer;

import java.util.List;

/**
 * Created by yws894 on 3/10/17.
 */
public interface QARepository {
    List<QuestionAnswer> loadQuestionAnswers(String userId);

    QuestionAnswer insertQuestionAnswer(String userId, QuestionAnswer questionAnswer);
}
