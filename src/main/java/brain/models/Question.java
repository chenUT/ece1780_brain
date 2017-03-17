package brain.models;

import brain.common.SentenceType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 3/16/17.
 */
public class Question {
    private SentenceType type;
    private List<String> nouns;
    private List<String> verbs;
    private List<String> words;
    private List<String> phrases;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;

    public Question(){
        this.nouns = new ArrayList<>();
        this.verbs = new ArrayList<>();
        this.words = new ArrayList<>();
        this.phrases = new ArrayList<>();
    }

    public SentenceType getType() {
        return type;
    }

    public void setType(SentenceType type) {
        this.type = type;
    }

    public List<String> getNouns() {
        return nouns;
    }

    public void addNouns(String noun) {
        if(!this.nouns.contains(noun)){
            this.nouns.add(noun);
        }
    }

    public List<String> getVerbs() {
        return verbs;
    }

    public void addVerb(String verb) {
        if(!this.verbs.contains(verb)){
            this.verbs.add(verb);
        }
    }

    public void addWord(String word) {
        if(!this.words.contains(word)){
            this.words.add(word);
        }
    }

    public List<String> getWords() {
        return words;
    }
}
