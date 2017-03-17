package brain.models;

/**
 * Created by chen on 3/16/17.
 */
public class QAText {
    private String question;
    private String answer;

    public QAText(String question, String answer) {
//        String utf8 = ("UTF-8");
//        this.question = HtmlUtils.htmlEscape(question, utf8);
//        this.answer = HtmlUtils.htmlEscape(answer, utf8);
       this.question = question;
       this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
