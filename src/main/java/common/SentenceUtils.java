package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by yws894 on 3/10/17.
 */
public class SentenceUtils {

    private final static List<String> CLAUSE_LEVEL = new ArrayList<>();
    private final static List<String> NOUN_PHRASE = new ArrayList<>();
    private final static List<String> NOUN = new ArrayList<>();
    private final static List<String> STOP_WORDS = new ArrayList<>();

    static {
        CLAUSE_LEVEL.add("S");
        CLAUSE_LEVEL.add("SBAR");
        CLAUSE_LEVEL.add("SBARQ");
        CLAUSE_LEVEL.add("SINV");
        CLAUSE_LEVEL.add("SQ");

        NOUN_PHRASE.add("NP");

        // nouns
        NOUN.add("NN");
        NOUN.add("NNS");
        NOUN.add("NNP");
        NOUN.add("NNPS");

    }

    private SentenceUtils(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("stopwords.txt").getFile());

        try (Stream<String> stream = Files.lines(file.toPath())) {
            stream.forEach(l -> STOP_WORDS.add(l));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class InstanceHolder {
        private static final SentenceUtils INSTANCE = new SentenceUtils();
    }

    public static SentenceUtils getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public boolean isClause(String label){
       return CLAUSE_LEVEL.contains(label);
    }

    public boolean isNounPhrase(String label){
        return NOUN_PHRASE.contains(label);
    }

    public boolean isNoun(String label){
        return NOUN.contains(label);
    }

    public void printStopwords(){
        STOP_WORDS.forEach(System.out::println);
    }
}
