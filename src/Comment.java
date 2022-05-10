import java.time.Instant;

public class Comment {
    String contents;
    Instant lastEdited;

    public Comment(String contents) {
        this.contents = contents;
        this.lastEdited = Instant.now();
    }

    public String getContents() {
        return contents;
    }

    public Instant getLastEdited() {
        return lastEdited;
    }

    public void setContents(String contents) {
        this.contents = contents;
        updateLastEdited();
    }

    private void updateLastEdited() {
        this.lastEdited = Instant.now();
    }

    @Override
    public String toString() {
        return "Comment: " + this.getContents();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Comment)) {
            return false;
        }

        Comment comment = (Comment) obj;

        return this.getContents().equals(comment.getContents());
    }
}
