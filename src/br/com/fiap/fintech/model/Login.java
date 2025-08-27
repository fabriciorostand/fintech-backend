package br.com.fiap.fintech.model;

public class Login {
    private User user;

    public Login() {

    }

    public Login(User user) {
        this.user = user;
    }

    public void doLogin(String email, String password) {
        if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
            user.setLogged(true);
            System.out.println("\nLogin feito com sucesso!\n");
        } else {
            System.out.println("\nCredenciais inválidas\n");
        }
    }
}