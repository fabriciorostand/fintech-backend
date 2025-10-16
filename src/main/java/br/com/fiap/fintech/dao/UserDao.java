package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.EntityNotFoundException;
import br.com.fiap.fintech.factory.ConnectionFactory;
import br.com.fiap.fintech.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    // Attributes
    private Connection connection;

    // Constructors
    public UserDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    // Methods
    public void register(User user) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO T_FIN_USUARIO (ID_USUARIO, NM_USUARIO, EM_USUARIO, SH_USUARIO) VALUES (T_FIN_USUARIO_ID_USUARIO_SEQ.NEXTVAL, ?, ?, ?)");
        stm.setString(1, user.getName());
        stm.setString(2, user.getEmail());
        stm.setString(3, user.getPassword());
        stm.executeUpdate();
    }

    public User read(int code) throws SQLException, EntityNotFoundException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM T_FIN_USUARIO WHERE ID_USUARIO = ?");
        stm.setInt(1, code);
        ResultSet result = stm.executeQuery();
        if (!result.next()) {
            throw new EntityNotFoundException("Usuário não encontrado");
        }
        int id = result.getInt("ID_USUARIO");
        String name = result.getString("NM_USUARIO");
        String email = result.getString("EM_USUARIO");
        String password = result.getString("SH_USUARIO");
        return new User(id, name, email, password);
    }

    public List<User> list() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM T_FIN_USUARIO");
        ResultSet result = stm.executeQuery();
        List<User> list = new ArrayList<>();
        while (result.next()) {
            int id = result.getInt("ID_USUARIO");
            String name = result.getString("NM_USUARIO");
            String email = result.getString("EM_USUARIO");
            String password = result.getString("SH_USUARIO");
            list.add(new User(id, name, email, password));
        }
        return  list;
    }

    public void update(User user) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("UPDATE T_FIN_USUARIO SET NM_USUARIO = ?, EM_USUARIO = ?, SH_USUARIO = ? WHERE ID_USUARIO = ?");
        stm.setString(1, user.getName());
        stm.setString(2, user.getEmail());
        stm.setString(3, user.getPassword());
        stm.executeUpdate();
    }

    public void delete(User user) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("DELETE FROM T_FIN_USUARIO WHERE ID_USUARIO = ?");
        stm.setInt(1, user.getId());
        stm.executeUpdate();
    }

    public User findByEmailAndPassword(String email, String password) throws SQLException, EntityNotFoundException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM T_FIN_USUARIO WHERE EM_USUARIO = ? AND SH_USUARIO = ?");
        stm.setString(1, email);
        stm.setString(2, password);
        ResultSet result = stm.executeQuery();
        if (!result.next()) {
            throw new EntityNotFoundException("Credenciais inválidas");
        }
        User user = new User();
        user.setEmail(result.getString("EM_USUARIO"));
        user.setPassword(result.getString("SH_USUARIO"));
        return user;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}