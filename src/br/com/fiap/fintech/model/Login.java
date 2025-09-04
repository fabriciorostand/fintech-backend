package br.com.fiap.fintech.model;

public class Login {
    // Attributes
    private User user;

    // Constructors
    public Login() {

    }

    public Login(User user) {
        this.user = user;
    }

    // Methods
    public void doLogin(String email, String password) {
        if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
            user.setLogged(true);
            System.out.println("\nLogin feito com sucesso!");
        } else {
            System.out.println("\nCredenciais inválidas");
        }
    }
}