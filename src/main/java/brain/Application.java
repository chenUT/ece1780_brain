package brain;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.util.Triple;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

/**
 * Created by chen on 3/8/17.
 */

@SpringBootApplication
public class Application {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

      SpringApplication.run(Application.class, args);

//      and coreference resolution
//      Properties props = new Properties();
//      props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");

//      String text = "This is an awesome library by Stanford folks";
//      String text = "On Sunday, 2015 the fate of Lehman Brothers which is in New York and has 3% of 234 billion dollars in assets, the beleaguered investment bank, hung in the balance on Sunday as Federal Reserve officials and the leaders of major financial institutions continued to gather in emergency meetings trying to complete a plan to rescue the stricken bank.  Several possible plans emerged from the talks, held at the Federal Reserve Bank of New York and led by Timothy R. Geithner, the president with two friends of the New York Fed, and Treasury Secretary Henry M. Paulson Jr.";
//      String text = "There are many apples.";
//      String text ="Barack Obama was born on August 4, 1961 in Honolulu, Hawaii which was 4 days\n" + "ago.";
//      String text ="How much did you pay";
//      String text = "What country borders the most others? How many apple do you have?";
//      String text = "What to do when in diet";
//        String text = "What is line 245 and how to pay for it";
//        String text = "What should I do if I can't find what I want to sell in the Amazon catalog?";
////        sentenceWorks(text);
//        SentenceService sentenceService = new SentenceService();
//        ScoreService scoreService = new ScoreService();
////        Question question = sentenceService.processQuestion(text);
//
////        List<QAText> qaTexts = initQAList();
//
//        QARepository qaRepository = new QARepositoryMapImpl();
//
//        List<QuestionAnswer> tempQAs = qaRepository.loadQuestionAnswers("UoT");
//
//        String questionText = "What is the application fee?";
//        Question askQuestion = sentenceService.processQuestion(questionText);
//
//        System.out.println("----");
//
//        askQuestion.getNouns().forEach(System.out::println);
//
//        System.out.println("----");
//
//        List<AnswerWithScore> scoredList = tempQAs.stream().map(tempQA -> scoreService.getAnswerWithScore(tempQA, askQuestion)).collect(Collectors.toList());
//
//        scoredList.sort((o1, o2) -> o2.getScore() - o1.getScore());
//
//        scoredList.forEach(System.out::println);

//        nouns.stream().forEach(System.out::println);

//      nERWorks(text);
    }


    public static void sentenceWorks(String text){
//        Properties props = PropertiesUtils.asProperties(
//        "annotators", "tokenize,ssplit,pos,lemma,ner,parse,natlog",
//        "ssplit.isOneSentence", "false",
////        "ner.model", "edu/stanford/nlp/brain.models/ner/english.all.3class.distsim.crf.ser.gz",
////        "ner.model", "edu/stanford/nlp/brain.models/ner/english.conll.4class.distsim.crf.ser.gz",
//        "ner.model", "edu/stanford/nlp/brain.models/ner/english.muc.7class.distsim.crf.ser.gz",
//        "tokenize.language", "en");
//
//        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
//
//        // create an empty Annotation just with the given text
//        Annotation document = new Annotation(text);
//
//        // run all Annotators on this text
//        pipeline.annotate(document);
//
//        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
//
//        for(CoreMap sentence: sentences) {
//            // traversing the words in the current sentence
//            // a CoreLabel is a CoreMap with additional token-specific methods
//            for (CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)) {
//                // this is the text of the token
//                String word = token.get(CoreAnnotations.TextAnnotation.class);
//                // this is the POS tag of the token
//                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
//
//                String lemma = token.get(CoreAnnotations.LemmaAnnotation.class);
//                // this is the NER label of the token
//                String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
//
//                System.out.printf("Token: %s,lemma: %s ,pos: %s, ne: %s\n", word, lemma, pos, ne);
//            }
//
//            // this is the parse tree of the current sentence
//            Tree tree = sentence.get(TreeCoreAnnotations.TreeAnnotation.class);
//
//            System.out.println("Parse tree: "+tree.toString());
////            System.out.println("Parse tree root: "+tree.isPhrasal());
//            System.out.println("Parse tree root: "+tree.isPreTerminal());
////            System.out.println("Parse tree root: "+tree.nodeString());
////            System.out.println("Parse tree root: "+tree.pennString());
////            System.out.println("Parse tree root: "+tree.pennString());
//
//            // this is the Stanford dependency graph of the current sentence
//            SemanticGraph dependencies = sentence.get(SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation.class);

//            System.out.println("dependency graph: "+dependencies.toString());
        }

// This is the coreference link graph
// Each chain stores a set of mentions that link to each other,
// along with a method for getting the most representative mention
// Both sentence and token offsets start at 1!
//        Map<Integer, CorefChain> graph = document.get(CorefCoreAnnotations.CorefChainAnnotation.class);

//        System.out.println("dependency graph: "+graph.toString());
//    }

    public static void nERWorks(String text) throws IOException, ClassNotFoundException {

        String classifierPath ="edu/stanford/nlp/models/ner/english.muc.7class.distsim.crf.ser.gz";
        AbstractSequenceClassifier<CoreLabel> classifier = CRFClassifier.getClassifier(classifierPath);
        List<List<CoreLabel>> out = classifier.classify(text);

        for (List<CoreLabel> sentence : out) {
            for (CoreLabel word : sentence) {
                System.out.print(word.word() + '/' + word.get(CoreAnnotations.AnswerAnnotation.class) + ' ');
            }
            System.out.println();
        }
        System.out.println("---");
        List<Triple<String, Integer, Integer>> list = classifier.classifyToCharacterOffsets(text);
        for (Triple<String, Integer, Integer> item : list) {
            System.out.println(item.first() + ": " + text.substring(item.second(), item.third()));
        }
        System.out.println("---");
        System.out.println("Ten best entity labelings");
//        DocumentReaderAndWriter<CoreLabel> readerAndWriter = classifier.makePlainTextReaderAndWriter();
//        classifier.classifyAndWriteAnswersKBest(args[1], 10, readerAndWriter);

        System.out.println("---");
    }
}
