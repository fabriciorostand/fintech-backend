package br.com.fiap.fintech.model;

import br.com.fiap.fintech.dao.UserDao;
import br.com.fiap.fintech.exception.EntityNotFoundException;

import java.sql.SQLException;

public class Login {
    // Attributes
    private User user;
    private UserDao dao;

    // Constructors
    public Login() {

    }

    public Login(UserDao dao) {
        this.dao = dao;
    }

    // Methods
    public void doLogin(String email, String password) {
        try {
            user = dao.findByEmailAndPassword(email, password);
            user.setLogged(true);
            System.out.println("\nLogin feito com sucesso!");
            dao.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntityNotFoundException e) {
            System.err.println("\nCredenciais inválidas");
        }
    }
}