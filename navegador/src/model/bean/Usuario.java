package model.bean;

/**
 * Classe Usuario contendo os atributos da mesma
 *
 * @author Estêvão Anderle, Lenon de Paula
 */
public class Usuario {

    protected static int id;
    protected String nome;
    protected String login;
    protected String senha;

    /**
     * Construtor do histórico.
     */
    public Usuario() {

    }

    /**
     * Construtor de usuário com seus devidos atributos.
     *
     * @param id
     * @param nome
     * @param login
     * @param senha
     */
    public Usuario(int id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    /**
     * Busca a ID.
     *
     * @return id do usuário
     */
    public int getId() {
        return id;
    }

    /**
     * Define a ID do usuário.
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Busca o nome do usuário em questão.
     *
     * @return nome do usuário
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define um nome para o usuário.
     *
     * @param nome do usuário
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Busca o login do usuário.
     *
     * @return login do usuário
     */
    public String getLogin() {
        return login;
    }

    /**
     * Define um login para o usuário.
     *
     * @param login do usuário
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Busca a senha do usuário.
     *
     * @return senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do mesmo.
     *
     * @param senha do usuário
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

}
