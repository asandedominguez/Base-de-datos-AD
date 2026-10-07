package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class ConexionBD {

    public static Connection conexion() {
        String url = "jdbc:postgresql://10.0.9.226:5432/postgres";
        String usuario = "postgres";
        String contrasena = "admin";

        try {
            Connection conn = DriverManager.getConnection(url, usuario, contrasena);
            if (conn != null) {
                System.out.println(" Conexión establecida con éxito a PostgreSQL.");
                return conn;
            }
        }
        catch (SQLException e) {
            System.out.println("Error al conectar a PostgreSQL: " + e.getMessage());
        }
        return null;
    }
}

