package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    public static Connection conexion() {
        // Apuntamos a 'probas' que é onde está a táboa en DBeaver
        String url = "jdbc:postgresql://10.0.9.226:5432/probas";
        String usuario = "postgres";
        String contrasena = "admin";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, usuario, contrasena);
            if (conn != null) {
                System.out.println("Conexión establecida con éxito a PostgreSQL.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a PostgreSQL: " + e.getMessage());
        }
        return conn;
    }
}