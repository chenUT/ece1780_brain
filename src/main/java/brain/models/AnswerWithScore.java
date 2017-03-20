package brain.models;

/**
 * Created by chen on 3/16/17.
 */
public class AnswerWithScore {

    private String knownQuestion;
    private String answer;
    private double score;

    public AnswerWithScore(String answer) {
        this.answer = answer;
        this.score = 0;
    }

    public void addScore(double addScore){
       this.score = this.score + addScore;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public double getScore() {
        return score;
    }

    public String getKnownQuestion() {
        return knownQuestion;
    }

    public void setKnownQuestion(String knownQuestion) {
        this.knownQuestion = knownQuestion;
    }

    @Override
    public String toString() {
        return "Score: "+this.getScore()+"; Answer: "+this.getAnswer()+"\n; Question: "+this.getKnownQuestion();
    }
}
