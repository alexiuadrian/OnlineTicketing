import java.io.Serializable;
import java.util.UUID;

public class Player implements Serializable {
    private String id;
    private String name;
    private String score;

    public Player(){
        this.id = UUID.randomUUID().toString();
    }

    public Player id(String id) {
        this.id = id;
        return this;
    }

    public Player name(String name) {
        this.name = name;
        return this;
    }

    public Player score(String score) {
        this.score = score;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.format("%s|%s|%s", id, name, score);
    }
}
