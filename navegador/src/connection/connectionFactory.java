package connection;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe contém configurações da conexão
 *
 * @author Estêvão Anderle, Lenon de Paula
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
}
