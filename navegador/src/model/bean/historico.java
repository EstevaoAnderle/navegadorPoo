/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Lenon
 */
public class historico {
    
    private int id;
    private String pagina;
    private String url;
    private String data_acesso;
    private int id_usuario;
    private boolean favorito;

    public historico() {
    }

    public historico(String pagina, String url, String data_acesso, int id_usuario, boolean favorito) {
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

    public String getData_acesso() {
        return data_acesso;
    }

    public void setData_acesso(String data_acesso) {
        this.data_acesso = data_acesso;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
    
}
