public class User {
    private int id;
    String name;
    String email;
    String password;
    boolean logged = false;

    public User() {

    }

    public User(int id, String name, String email, String password, boolean logged) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.logged = logged;
    }
}