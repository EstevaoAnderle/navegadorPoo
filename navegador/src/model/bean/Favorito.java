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

    /**
     * Construtor vazio de Favorito.
     */
    public Favorito() {

    }

    /**
     * Construtor de Favorito, porém com parâmetros.
     *
     * @param nome, nome do Favorito.
     * @param url, URL do Favorito.
     * @param data_armazenamento, Data de armazenamento do mesmo.
     * @param id_usuario, usuário proprietário do Favorito.
     */
    public Favorito(String nome, String url, Timestamp data_armazenamento, int id_usuario) {
        this.nome = nome;
        this.url = url;
        this.data_armazenamento = data_armazenamento;
        this.id_usuario = id_usuario;
    }

    /**
     * Busca o ID.
     *
     * @return id do favorito
     */
    public int getId() {
        return id;
    }

    /**
     * Define um ID.
     *
     * @param id do Favorito
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Busca o nome.
     *
     * @return nome do favorito
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define um nome.
     *
     * @param nome do Favorito
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Busca a URL.
     *
     * @return url do Favorito
     */
    public String getUrl() {
        return url;
    }

    /**
     * Define a URL.
     *
     * @param url do Favorito
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Busca a data de criação do favorito
     *
     * @return data_armazenamento do Favorito
     */
    public Timestamp getData_armazenamento() {
        return data_armazenamento;
    }

    /**
     * Define data de armazenamento do Favorito
     *
     * @param data_armazenamento
     */
    public void setData_armazenamento(Timestamp data_armazenamento) {
        this.data_armazenamento = data_armazenamento;
    }

    /**
     * Retorna o usuário daquele Favorito
     *
     * @return id do usuário
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * Define a id do usuário.
     *
     * @param id_usuario
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

}
