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
import java.util.ArrayList;
import java.util.List;
import model.bean.Usuario;
import model.bean.Historico;

/**
 *
 * @author Lenon
 */
public class historicoDAO {

    public boolean create(Historico his) {

        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO historico (pagina, url, data_acesso, id_usuario, favorito) VALUES (?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, his.getPagina());
            stmt.setString(2, his.getUrl());
            stmt.setDate(3, his.getData_acesso());
            stmt.setInt(4, his.getId_usuario().getId());
            stmt.setBoolean(5, his.isFavorito());

            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            return false;
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Historico> getAll() {
        Connection con = connectionFactory.getConnection();
        String sql = "SELECT h.id, h.pagina, h.url, h.data_acesso, h.id_usuario, h.favorito FROM historico as h"
                + " INNER JOIN usuario AS u ON h.id_usuario = u.id";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Historico> his = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Historico hist = new Historico();
                hist.setId(rs.getInt("id"));
                hist.setPagina(rs.getString("pagina"));
                hist.setUrl(rs.getString("url"));
                hist.setData_acesso(rs.getDate("data_acesso"));

                Usuario user = new Usuario();
                user.setId(rs.getInt("id_usuario"));
                hist.setId_usuario(user);
                hist.setFavorito(rs.getBoolean("favorito"));
                his.add(hist);
            }
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
        return his;
    }

}
