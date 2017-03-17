package brain.common;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by yws894 on 3/10/17.
 */
public enum SentenceType {

    DIRECT_QUESTION("Direct question introduced by a wh-word or a wh-phrase. Indirect questions and relative clauses should be bracketed as SBAR, not SBARQ.", "SBARQ");

    private String description = "";
    private String value = "";
    SentenceType(String description, String value){
       this.description = description;
       this.value = value;
    }

    public String getDescription(){
        return this.description;
    }

    public boolean isEqual(SentenceType type){
        return !StringUtils.isBlank(type.getValue()) && this.value.equals(type.getValue());
    }

    public boolean isEqual(String type){
        return !StringUtils.isBlank(type) && this.value.equals(type);
    }

    public String getValue(){
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static boolean isQuestion(String type){
        return "SBARQ".equals(type);
    }

    public static boolean isRoot(String type){
        return "ROOT".equals(type);
    }

    public static SentenceType getType(String type){
        switch (type){
            case "SBARQ":
                return SentenceType.DIRECT_QUESTION;
            default:
                return null;
        }
    }
}
