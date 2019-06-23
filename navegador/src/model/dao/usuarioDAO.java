package model.dao;

import connection.connectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.bean.Usuario;

/**
 * Classe que realiza o login dos usuários.
 *
 * @author Estêvão Anderle, Lenon de Paula
 */
public class usuarioDAO {

    Connection con = connectionFactory.getConnection();
    private String nomeUsuario;
    Usuario usuario = new Usuario();

    /**
     * Verifica se o login e senha informado estão de acordo e se será possível
     * realizar o login
     *
     * @param login do usuário
     * @param senha do usuário
     * @return se foi possível conectar com o usuário informado ou não
     */
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

            if (rs.next()) {
                check = true;
                nomeUsuario = rs.getString("nome");
                usuario.setId(rs.getInt("id"));
            }
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }
}
