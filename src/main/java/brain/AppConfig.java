package brain;

import brain.filters.AuthFilter;
import brain.models.QAText;
import brain.models.Question;
import brain.models.QuestionAnswer;
import brain.service.QATextService;
import org.apache.commons.io.Charsets;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.text.sentenceiterator.BasicLineIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.eclipse.jetty.util.IO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import brain.repositories.QARepository;
import brain.repositories.impl.QARepositoryMapImpl;
import brain.service.SentenceService;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ResourceLoader;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;


/**
 * Created by chen on 3/17/17.
 */
@Configuration
public class AppConfig {

    @Autowired
    SentenceService sentenceService;

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    QATextService qaTextService;

    @Bean
    public FilterRegistrationBean authFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setName("auth");
        filterRegistrationBean.setFilter(new AuthFilter());
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    @Bean
    @Scope(SCOPE_SINGLETON)
    public QARepository qaRepository() {
        List<QAText> qaTexts = qaTextService.getQaTexts();

        QARepository qaRepository = new QARepositoryMapImpl();

        qaTexts.forEach(qaText -> {
            QuestionAnswer qa = new QuestionAnswer();
            Question q = sentenceService.processQuestion(qaText.getQuestion());
            qa.setQuestion(q);
            qa.setAnswerText(qaText.getAnswer());
            qaRepository.insertQuestionAnswer("UoT Grad School", qa);
        });
        return qaRepository;
    }
}