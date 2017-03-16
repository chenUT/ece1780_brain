package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yws894 on 3/10/17.
 */
public class QuestionAnswer {
   private String id;

   private String userId;

   private String question;

   private List<Entity> entityList = new ArrayList<>();

   private String questionType;

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

   public String getQuestion() {
      return question;
   }

   public void setQuestion(String question) {
      this.question = question;
   }

   public List<Entity> getEntityList() {
      return entityList;
   }

   public void setEntityList(List<Entity> entityList) {
      this.entityList = entityList;
   }

   public String getQuestionType() {
      return questionType;
   }

   public void setQuestionType(String questionType) {
      this.questionType = questionType;
   }
}
