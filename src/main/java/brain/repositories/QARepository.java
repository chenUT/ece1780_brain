package brain.repositories;

import brain.models.QuestionAnswer;

import java.util.List;

/**
 * Created by yws894 on 3/10/17.
 */
public interface QARepository {
    List<QuestionAnswer> loadQuestionAnswers(String category);

    List<String> getCategoryList();

    QuestionAnswer insertQuestionAnswer(String category, QuestionAnswer questionAnswer);
}
