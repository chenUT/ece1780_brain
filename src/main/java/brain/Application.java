package brain;

import brain.models.QAText;
import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.util.Triple;
import org.apache.commons.io.Charsets;
import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.text.sentenceiterator.BasicLineIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.deeplearning4j.util.ModelSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 3/8/17.
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        String filePath = new ClassPathResource("raw_sentences.txt").getFile().getAbsolutePath();
//
//        List<QAText> qaTexts = initQAList();
//
//        StringBuilder fullTextBuilder = new StringBuilder();
//        qaTexts.forEach( qaText -> {
//            fullTextBuilder.append(qaText.getQuestion().toLowerCase()+ "\n" + qaText.getAnswer().toLowerCase()+ "\n");
//        });
//        String fullText = fullTextBuilder.toString();
//
//        System.out.println(fullText);
//
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(fullText.getBytes(Charsets.UTF_8)));
//        bufferedInputStream.mark(bufferedInputStream.available()+1);
//        SentenceIterator iter = new BasicLineIterator(bufferedInputStream);
//        TokenizerFactory t = new DefaultTokenizerFactory();
//        t.setTokenPreProcessor(new CommonPreprocessor());
//
////        SentenceIterator iter = new BasicLineIterator(filePath);
////        TokenizerFactory t = new DefaultTokenizerFactory();
////        t.setTokenPreProcessor(new CommonPreprocessor());
//        Word2Vec vec = new Word2Vec.Builder()
//            .minWordFrequency(1)
//            .iterations(2)
//            .layerSize(100)
//            .seed(42)
//            .windowSize(5)
//            .iterate(iter)
//            .tokenizerFactory(t)
//            .build();
//
//        vec.fit();
//        long now = System.currentTimeMillis();
//        double cosSim = vec.similarity("phd", "degree");
//        long result = System.currentTimeMillis() - now;
//        System.out.println(cosSim);
//        System.out.println("time: "+result);

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

    public static List<QAText> initQAList() {
        List<QAText> qaTexts = new ArrayList<>();

        qaTexts.add(new QAText("What are the admission requirements?", "Master's Programs and Full-Time Special Students\n" +
        "\n" +
        "\u200Ban appropriate bachelor's degree, or its equivalent, with a final year average of at least mid-B from a recognized university\n" +
        "\n" +
        "Doctoral Programs\n" +
        "\n" +
        "\u200Ban appropriate master's degree, or its equivalent, with an average of at least B+ or demonstrated comparable research competence\n" +
        "\n" +
        "Many graduate units have higher minimum requirements than the minimum SGS requirements. As we receive many more applications each year from excellent candidates than we have placements available, meeting the minimum admissions requirement does not necessarily guarantee admission.\n" +
        "\n" +
        "The minimum admissions requirements set by SGS can also be found on the Admissions page."));

        qaTexts.add(new QAText("What is an appropriate bachelor's degree?", "An appropriate admitting degree is one that satisfies the following criteria:\n" +
        "\n" +
        "a) the issuing institution must be recognized as having degree granting authority by the appropriate jurisdictional authorities (e.g. Provincial / Territorial government or regional quality assurance body);\n" +
        "\n" +
        "b) the degree must be the standard first entry degree which gives access to advanced research-based graduate programs in the country of origin (e.g. This is typically four years in North America or a three-year Bologna compliant degrees. Please consult the SGS International Equivalencies Database for more information.); and\n" +
        "\n" +
        "c) where appropriate, have the required affinity or programmatic fit to the graduate program to which you are seeking admission.\n" +
        "\n" +
        "All admission decisions are made on a case-by-case basis and are based on a composite of information which may include previous academic performance, comments from referees, relevant professional activities, proposed research statements, correspondence between research interests and available faculty expertise and in some programs, standardized test scores. Eligibility cannot be determined until a complete application is submitted."));

        qaTexts.add(new QAText("Are three-year Bologna compliant degrees acceptable?", "Qualified applicants with three-year Bologna-compliant bachelor's degrees (except three-year UK degrees preceded by the GCE A-levels which are considered equivalent) are considered admissible and are encouraged to apply. In addition to the SGS minimum admission requirements, there are several factors that will be taken into consideration while assessing these degrees: requirements for gaining admission to the degree; content of the degree and duration of the degree, among others. Eligibility cannot be determined until a complete application is submitted."));

        qaTexts.add(new QAText("I have a four-year Bachelor's degree from a community college. Will it be acceptable?", "Applications to graduate studies at U of T from graduates of four-year community college bachelor's programs are considered admissible and are encouraged to apply. In addition to the SGS minimum admission requirements, there are several factors that will be taken into consideration while assessing these degrees: the degree of affinity between the applied degree and the program to which the applicant is seeking admission; the academic content of the third and fourth year courses; and other indicators that the applicant is adequately prepared for independent research which is a distinctive characteristic of every graduate degree. The degree program should be normally comprised of at least 75% liberal arts and science content. Eligibility cannot be determined until a complete application is submitted."));

        qaTexts.add(new QAText("Can I apply to a PhD program directly from a bachelor's degree?", "Some graduate \u200Bunits will allow direct entry to a PhD program from a bachelor's degree for exceptional applicants. Such applicants require an appropriate Bachelor's degree, or equivalent, with an average of at least A-.\n" +
        "\n" +
        "For more information, contact the department to which you are applying."));

        qaTexts.add(new QAText("I am an international applicant. How do I know if you recognize my degree?", "Please consult our International Degree Equivalencies directory. If your degree is not listed there, you may wish to contact us for confirmation.\n" +
        "\n" +
        "Note that we will not review or assess your academic record without an official application to a graduate degree program at the University of Toronto, including payment of the appropriate application fee. Prior to application, we are able to confirm if the degree you have received is considered equivalent to our minimum admission requirements. If you do need to email us to inquire about your specific degree, please be sure to include the country and university in which it was earned, and the full official name of the credential awarded, with date of award and length of study period."));

        qaTexts.add(new QAText("Do I need to take the GRE exam?", "Although most of our graduate units do not require a GRE exam, there are some that do. Other departments encourage international applicants, in particular, to consider taking the GRE as this assists them in making a fair assessment of your preparation for graduate study. Please check the graduate unit’s instructions to see if the GRE is required in your case."));

        qaTexts.add(new QAText("How much is the application fee?", "A $120 CDN application fee is required. This fee is non-refundable and non-transferable. A supplementary application fee may be assessed depending upon the program to which you are applying. The supplementary application fee can be found at the program's website or at the payment step of the online application."));

        return qaTexts;

    }
}
