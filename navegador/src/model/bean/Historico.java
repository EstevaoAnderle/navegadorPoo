/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;

/**
 * Classe Historico contendo os atributos da mesma
 *
 * @author Estêvão Anderle, Lenon de Paula
 */
public class Historico {

    protected int id;
    protected String pagina;
    protected String url;
    protected Date data_acesso;
    protected Usuario id_usuario;
    protected boolean favorito;

    /**
     * construtor do historico
     */
    public Historico() {
    }

    /**
     * construtor do historico
     */
    public Historico(String pagina, String url, Date data_acesso, Usuario id_usuario, boolean favorito) {
        this.pagina = pagina;
        this.url = url;
        this.data_acesso = data_acesso;
        this.id_usuario = id_usuario;
        this.favorito = favorito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getData_acesso() {
        return data_acesso;
    }

    public void setData_acesso(Date data_acesso) {
        this.data_acesso = data_acesso;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

}
