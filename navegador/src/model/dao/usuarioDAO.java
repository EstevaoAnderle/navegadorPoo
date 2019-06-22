package model.dao;

import connection.connectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Usuario;

/**
 *
 *
 * @author Lenon
 */
public class usuarioDAO {

    Connection con = connectionFactory.getConnection();
    private String nomeUsuario;
    Usuario usuario = new Usuario();

    //Esse cara seria utilizado se caso a gente criasse um usuário
//    public boolean save(Usuario usuario) {
//        String sql = "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, ?)";
//        PreparedStatement stmt = null;
//        try {
//            stmt = con.prepareStatement(sql);
//            stmt.setString(1, usuario.getNome());
//            stmt.setString(2, usuario.getLogin());
//            stmt.setString(3, usuario.getSenha());
//            stmt.executeUpdate();
//            return true;
//        } catch (SQLException ex) {
//            System.err.println("Erro " + ex);
//            return false;
//        }
//    }
    public boolean checkLogin(String login, String senha) {
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {
            stmt = con.prepareStatement(sql);

            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

//            while (rs.next()) {
//                Usuario usuario = new Usuario();
//                usuario.setId(rs.getInt("id"));
//                usuario.setNome(rs.getString("nome"));
//                usuario.setLogin(rs.getString("login"));
//                usuario.setSenha(rs.getString("senha"));
//            }
            if (rs.next()) {
                check = true;
                nomeUsuario = rs.getString("nome");
                usuario.setId(rs.getInt("id"));
            }
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
        return check;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }
}
