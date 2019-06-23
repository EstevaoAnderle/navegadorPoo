package model.dao;

import connection.connectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Favorito;
import model.bean.Usuario;

/**
 * Classe de acesso dos favoritos ao banco de dados, com todos SQL necessários
 * para uso.
 *
 * @author Estêvão Anderle, Lenon de Paula
 */
public class favoritoDAO {

    Usuario usuario = new Usuario();

    /**
     * Adiciona novos favoritos no banco.
     *
     * @param fav que será adicionado
     * @return se foi criado o favorito ou não
     */
    public boolean create(Favorito fav) {

        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO favorito (nome, url, data_armazenamento, id_usuario) VALUES (?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, fav.getNome());
            stmt.setString(2, fav.getUrl());
            stmt.setObject(3, fav.getData_armazenamento());
            stmt.setInt(4, fav.getId_usuario());

            stmt.executeUpdate();
            return true;
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Essa página já está salva como favorito.");
            return false;
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            return false;
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }

    /**
     * Busca todos os favoritos do usuário logado.
     *
     * @return os favoritos do usuário logado
     */
    public List<Favorito> getAll() {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Favorito> fav = new ArrayList<>();

        try {
            String sql = "SELECT f.data_armazenamento, f.nome, F.url FROM favorito AS f "
                    + "WHERE f.id_usuario = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, usuario.getId());
            rs = stmt.executeQuery();

            while (rs.next()) {
                Favorito favi = new Favorito();
                favi.setData_armazenamento(rs.getTimestamp("data_armazenamento"));
                favi.setNome(rs.getString("nome"));
                favi.setUrl(rs.getString("url"));
                fav.add(favi);
            }
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }
        return fav;
    }

    /**
     * Busca os favoritos por nome.
     *
     * @param nome do favorito procurado
     * @return lista dos favoritos
     */
    public List<Favorito> getForNome(String nome) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Favorito> his = new ArrayList<>();

        try {
            String sql = "SELECT f.data_armazenamento, f.nome, f.url FROM favorito AS f "
                    + "WHERE f.id_usuario = ? AND f.nome LIKE ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, usuario.getId());
            stmt.setString(2, "%" + nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Favorito favi = new Favorito();
                favi.setData_armazenamento(rs.getTimestamp("data_armazenamento"));
                favi.setNome(rs.getString("nome"));
                favi.setUrl(rs.getString("url"));
                his.add(favi);
            }
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }
        return his;
    }

    /**
     * Busca os favoritos por data.
     *
     * @param data do favorito procurado
     * @return lista dos favoritos
     */
    public List<Favorito> getForDate(String data) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Favorito> fav = new ArrayList<>();

        try {
            String sql = "SELECT f.data_armazenamento, f.nome, f.url FROM favorito AS f "
                    + "WHERE f.id_usuario = ? AND f.data_armazenamento LIKE ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, usuario.getId());
            stmt.setString(2, "%" + data + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Favorito favi = new Favorito();
                favi.setData_armazenamento(rs.getTimestamp("data_armazenamento"));
                favi.setNome(rs.getString("nome"));
                favi.setUrl(rs.getString("url"));
                fav.add(favi);
            }
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }
        return fav;
    }

}
