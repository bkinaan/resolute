import java.io.Serializable;

public class User implements Serializable {
    private final String username;
    private String password;
    private final Status status;

    public User(String username, String password, Status status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Status getStatus() {
        return status;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof User)) {
            return false;
        }

        User user = (User) obj;

        return user.getUsername().equals(username) && user.getPassword().equals(password) && user.getStatus() == status;   
    }
}
