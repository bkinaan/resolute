import java.time.Instant;

public class Note extends Comment {
    String contents;
    Instant lastEdited;

    public Note(String contents) {
        super(contents);
    }
}
