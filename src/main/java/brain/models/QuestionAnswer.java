package brain.models;

/**
 * Created by yws894 on 3/10/17.
 */
public class QuestionAnswer {
   private String id;

   private String userId;

   private Question question;

   private String answerText;

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public Question getQuestion() {
      return question;
   }

   public void setQuestion(Question question) {
      this.question = question;
   }

   public String getAnswerText() {
      return answerText;
   }

   public void setAnswerText(String answerText) {
      this.answerText = answerText;
   }
}
