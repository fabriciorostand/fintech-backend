package br.com.fiap.fintech.model;

public class Login {
    String email;
    String password;
    User user;

    public Login() {

    }

    public Login(User user) {
        this.user = user;
    }


    public Login(String email, String password, User user) {
        this.email = email;
        this.password = password;
        this.user = user;
    }

    public void doLogin(String email, String password) {
        if (email.equals(user.email) && password.equals(user.password)) {
            user.logged = true;
            System.out.println("\nbr.com.fiap.fintech.model.Login feito com sucesso!");
        } else {
            System.out.println("\nCredencias inválidas");
        }
    }
}