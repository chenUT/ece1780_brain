package brain.repositories.impl;

import brain.models.QuestionAnswer;
import org.apache.commons.lang3.StringUtils;
import brain.repositories.QARepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yws894 on 3/10/17.
 */
public class QARepositoryMapImpl implements QARepository{

    private final static Map<String, List<QuestionAnswer>> qaMap = new ConcurrentHashMap();

    @Override
    public List<QuestionAnswer> loadQuestionAnswers(String category) {
        if(StringUtils.isBlank(category)) {
            return null;
        }

        return qaMap.getOrDefault(category, new ArrayList<>());
    }

    @Override
    public QuestionAnswer insertQuestionAnswer(String category, QuestionAnswer questionAnswer) {
        String tempUser = category;
        if(StringUtils.isBlank(tempUser)) {
            tempUser = "_ANONYMOUS_";
        }
        String newId =  qaMap.getOrDefault(tempUser, new ArrayList<>()).size() + "";
        questionAnswer.setId(newId);

        if (qaMap.containsKey(tempUser)) {
            qaMap.get(tempUser).add(questionAnswer);
        } else {
           List<QuestionAnswer> qaList = new ArrayList<>();
           qaList.add(questionAnswer);
           qaMap.put(tempUser, qaList);
        }
        return questionAnswer;
    }

    @Override
    public List<String> getCategoryList(){
        return new ArrayList(qaMap.keySet());
    }
}
