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
 * Classe Historico contendo os atributos da mesma.
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
     * Construtor do Histórico com seus parâmetros.
     *
     * @param pagina
     * @param url
     * @param data_acesso
     * @param id_usuario
     */
    public Historico(String pagina, String url, Timestamp data_acesso, int id_usuario) {
        this.pagina = pagina;
        this.url = url;
        this.data_acesso = data_acesso;
        this.id_usuario = id_usuario;
    }

    /**
     * Busca a ID.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Define a ID
     *
     * @param id do histórico
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Busca o título da página.
     *
     * @return nome da página
     */
    public String getPagina() {
        return pagina;
    }

    /**
     * Define o nome da página que será salva.
     *
     * @param pagina
     */
    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    /**
     * Busca a URL.
     *
     * @return url da página
     */
    public String getUrl() {
        return url;
    }

    /**
     * Define a URL que será salva.
     *
     * @param url da página acessada
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Busca a data de acesso daquele registro do histórico.
     *
     * @return data do acesso
     */
    public Timestamp getData_acesso() {
        return data_acesso;
    }

    /**
     * Define a data que o registro foi acessado.
     *
     * @param data_acesso da página
     */
    public void setData_acesso(Timestamp data_acesso) {
        this.data_acesso = data_acesso;
    }

    /**
     * Busca a ID do usuário que acessou aquele registro.
     *
     * @return id do usuário
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * Define a Id do usuário que acessou.
     *
     * @param getIDUsuario
     */
    public void setId_usuario(int getIDUsuario) {
        this.id_usuario = getIDUsuario;
    }
}
