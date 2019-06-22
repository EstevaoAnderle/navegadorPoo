/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author estev
 */
public class favoritoDAO {

    Usuario usuario = new Usuario();

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
