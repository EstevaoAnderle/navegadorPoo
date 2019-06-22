/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Calendar;

/**
 * Classe Historico contendo os atributos da mesma
 *
 * @author Estêvão Anderle, Lenon de Paula
 */
public class Historico {

    protected int id;
    protected String pagina;
    protected String url;
    protected Timestamp data_acesso;
    protected int id_usuario;

    /**
     * construtor do historico
     */
    public Historico() {
    }

    /**
     * construtor do historico
     */
    public Historico(String pagina, String url, Timestamp data_acesso, int id_usuario) {
        this.pagina = pagina;
        this.url = url;
        this.data_acesso = data_acesso;
        this.id_usuario = id_usuario;
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

    public Timestamp getData_acesso() {
        return data_acesso;
    }

    public void setData_acesso(Timestamp data_acesso) {
        this.data_acesso = data_acesso;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int getIDUsuario) {
        this.id_usuario = getIDUsuario;
    }
}
