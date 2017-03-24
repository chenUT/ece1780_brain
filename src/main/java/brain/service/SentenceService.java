package brain.service;

import brain.common.WordUtils;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.PropertiesUtils;
import brain.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by yws894 on 3/11/17.
 */
@Service
public class SentenceService {
   StanfordCoreNLP pipeline;

   @Autowired
    ResourceLoader resourceLoader;

   // singleton initializer
   public SentenceService(){
       Properties props = PropertiesUtils.asProperties(
               "annotators", "tokenize,ssplit,pos,lemma,ner,parse,natlog",
               "ssplit.isOneSentence", "false",
        "ner.model", "edu/stanford/nlp/models/ner/english.all.3class.distsim.crf.ser.gz", // simplest ner model
//        "ner.model", "edu/stanford/nlp/brain.models/ner/english.conll.4class.distsim.crf.ser.gz",
//               "ner.model", "edu/stanford/nlp/brain.models/ner/english.muc.7class.distsim.crf.ser.gz",
               "tokenize.language", "en");

       pipeline = new StanfordCoreNLP(props);

   }

   public Question processQuestion(String text){
//        create an empty Annotation just with the given text
       Annotation document = new Annotation(text);
       WordUtils wordUtils = WordUtils.getInstance(resourceLoader);

       // run all Annotators on this text
       pipeline.annotate(document);

       List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);

       Question resultQuestion = new Question();
       resultQuestion.setText(text);

       for(CoreMap sentence: sentences) {
           // traversing the words in the current sentence
           // a CoreLabel is a CoreMap with additional token-specific methods
           for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
               // this is the text of the token
               String word = token.get(CoreAnnotations.TextAnnotation.class);
               // this is the POS tag of the token
               String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);

               String lemma = token.get(CoreAnnotations.LemmaAnnotation.class);
               // this is the NER label of the token
               String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);

               // noun and the lemma is not a stop word
               if (!wordUtils.isStopword(lemma)){
                   if (wordUtils.isNoun(pos)){
                       resultQuestion.addNouns(lemma.toLowerCase());
                   } else if (wordUtils.isVerb(pos)){
                       resultQuestion.addVerb(lemma.toLowerCase());
                   }
                   //add this word to the words list
                   resultQuestion.addWord(word);
               }
//               System.out.printf("Token: %s,lemma: %s ,pos: %s, ne: %s\n", word, lemma, pos, ne);
           }

           // TODO parse tree to get sentence type
//           Tree tree = sentence.get(TreeCoreAnnotations.TreeAnnotation.class);
       }

       return resultQuestion;
   }


}
