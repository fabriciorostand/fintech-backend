public class User {
    private int id;
    String name;
    String email;
    String password;

    public User() {

    }

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}