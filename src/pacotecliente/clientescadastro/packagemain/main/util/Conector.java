package pacotecliente.clientescadastro.packagemain.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector{
    static String URL = "jdbc:mysql://localhost/cadastrocliente";
    static String USUARIO = "root";
    static String SENHA = "";
    static Connection CON;

    public static Connection getConexao() throws SQLException {
        try {
            if (CON == null) {
                CON = (Connection) DriverManager.getConnection(URL, USUARIO, SENHA);
            }
            return CON;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
