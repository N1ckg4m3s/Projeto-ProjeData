package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

    private Connection conection;
    private final String URL = "jdbc:mysql://localhost:3306/testepraticoprojedata?serverTimezone=UTC";
    private final String user = "root";
    private final String password = "admin123";

    public MySqlConnection() {
        // Cria conexão
        try {
            conection = DriverManager.getConnection(URL, user, password);
            System.out.println("Conexão criada com sucesso");

        } catch (SQLException e) {
            System.out.println("[ERROR] Controller.MySqlConnection.<init>(): " + e);
        }
    }

    public Connection getConection() {
        return conection;
    }
}
