package br.com.fiap.fintech;

import br.com.fiap.fintech.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main( String[] args ) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            System.out.println("DB conectado com sucesso!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
