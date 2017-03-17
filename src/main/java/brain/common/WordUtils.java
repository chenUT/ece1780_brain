package brain.common;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by yws894 on 3/10/17.
 */
public class WordUtils {

    private final static List<String> CLAUSE_LEVEL = new ArrayList<>();
    private final static List<String> NOUN_PHRASE = new ArrayList<>();
    private final static List<String> NOUN = new ArrayList<>();
    private final static List<String> STOP_WORDS = new ArrayList<>();
    private final static List<String> VERB = new ArrayList<>();

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

        // we consider number as noun
        NOUN.add("CD");

        VERB.add("VB");
        VERB.add("VBD");
        VERB.add("VBG");
        VERB.add("VBN");
        VERB.add("VBP");
        VERB.add("VBZ");
    }

    // add a list of stop words in constructor
    private WordUtils(ResourceLoader resourceLoader){
//        ClassLoader classLoader = getClass().getR();
//        File file = new File(getClass().getResource("/stopwords.txt").getFile());
        File file = null;
        InputStream inputStream ;
        try {
//            file = ResourceUtils.getFile("/stopwords.txt");
//            file = new ClassPathResource("/stopwords.txt").getFile();
            inputStream = resourceLoader.getResource("classpath:stopwords.txt").getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String word;
            while ((word = reader.readLine()) != null ){
                STOP_WORDS.add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try (Stream<String> stream = Files.) {
//            stream.forEach(l -> STOP_WORDS.add(l));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

//    private static class InstanceHolder {
//        private static final WordUtils INSTANCE = new WordUtils();
//    }

    private static WordUtils _instance;

    public static WordUtils getInstance(ResourceLoader resourceLoader) {
        if (_instance == null) {
            _instance = new WordUtils(resourceLoader);
        }
        return _instance;
    }

    public boolean isClause(String label){
       return CLAUSE_LEVEL.contains(label);
    }

    public boolean isNounPhrase(String label){
        return NOUN_PHRASE.contains(label);
    }

    public boolean isNoun(String token){
        return NOUN.contains(token);
    }

    public boolean isVerb(String token) {
        return VERB.contains(token);
    }

    public boolean isStopword(String token){
        return STOP_WORDS.contains(token);
    }
}
