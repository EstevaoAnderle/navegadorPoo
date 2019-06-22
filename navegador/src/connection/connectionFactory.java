/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Estêvão Anderle, Lenon de Paula Classe contém configurações da
 * conexão
 */
public class connectionFactory {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/navegador?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=America/Sao_Paulo";
    //private static final String URL = "jdbc:mysql://localhost:3306/navegador";
    private static final String USER = "root";
    private static final String PASS = "root";

    /**
     * Inicia a conexão
     */
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Falha na conexão, verifique.", ex);
        }
    }

    /**
     * Fecha a conexão
     */
    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro close" + ex);
            }
        }
    }

    /**
     * Fecha a conexão
     */
    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro close" + ex);
            }
        }
    }

    /**
     * Fecha a conexão
     */
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro close" + ex);
            }
        }
    }

    //https://www.youtube.com/watch?v=i5INLVcrMAg
    //https://dev.mysql.com/downloads/file/?id=485766
    //https://stackoverflow.com/questions/50387952/how-to-resolve-unable-to-load-authentication-plugin-caching-sha2-password-issu/50433762#50433762
    //https://stackoverflow.com/questions/46131295/classcastexception-java-math-biginteger-cannot-be-cast-to-java-lang-long-on-con
    //https://www.youtube.com/watch?v=IWcV-9Lcu64
    //https://www.devmedia.com.br/forum/salvar-data-e-hora-no-bd/569558
    //https://blog.alura.com.br/pegando-a-data-atual-em-java/
}
