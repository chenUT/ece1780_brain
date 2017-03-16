package repositories.impl;

import models.QuestionAnswer;
import org.apache.commons.lang3.StringUtils;
import repositories.QARepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yws894 on 3/10/17.
 */
public class QARepositoryMapImpl implements QARepository{

    private final static Map<String, List<QuestionAnswer>> qaMap = new ConcurrentHashMap();

    @Override
    public List<QuestionAnswer> loadQuestionAnswers(String userId) {
        if(StringUtils.isBlank(userId)) {
            return null;
        }

        return qaMap.getOrDefault(userId, new ArrayList<>());
    }

    @Override
    public QuestionAnswer insertQuestionAnswer(String userId, QuestionAnswer questionAnswer) {
        if(StringUtils.isBlank(userId)) {
            return null;
        }
        String newId =  qaMap.getOrDefault(userId, new ArrayList<>()).size() + "";
        questionAnswer.setId(newId);

        if (qaMap.containsKey(userId)) {
            qaMap.get(userId).add(questionAnswer);
        } else {
           List<QuestionAnswer> qaList = new ArrayList<>();
           qaList.add(questionAnswer);
           qaMap.put(userId, qaList);
        }
        return questionAnswer;
    }
}
