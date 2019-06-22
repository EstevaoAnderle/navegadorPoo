/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Timestamp;

/**
 * Classe onde estão criados os campos da tabela de Favoritos do Banco de Dados.
 *
 * @author Estêvão Anderle, Lenon de Paula
 */
public class Favorito {

    protected int id;
    protected String nome;
    protected String url;
    protected Timestamp data_armazenamento;
    protected int id_usuario;

    public Favorito() {

    }

    public Favorito(String nome, String url, Timestamp data_armazenamento, int id_usuario) {
        this.nome = nome;
        this.url = url;
        this.data_armazenamento = data_armazenamento;
        this.id_usuario = id_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Timestamp getData_armazenamento() {
        return data_armazenamento;
    }

    public void setData_armazenamento(Timestamp data_armazenamento) {
        this.data_armazenamento = data_armazenamento;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

}
