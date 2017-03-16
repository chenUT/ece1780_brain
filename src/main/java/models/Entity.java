package models;

/**
 * Created by yws894 on 3/10/17.
 */
public class Entity {
    private String value;
    private String type;

    public Entity(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
