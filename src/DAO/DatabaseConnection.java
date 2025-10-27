
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    
    private static final String SERVER = "LAPTOP-I37PQEHO\\SQLEXPRESS"; 
    private static final String DATABASE = "Gestor_Hospital";
    private static final String PORT = "1433";
    
   /* private static final String URL = "jdbc:sqlserver://" + SERVER + 
                                     ";databaseName=" + DATABASE + 
                                     ";integratedSecurity=true;" +
                                     "encrypt=true;trustServerCertificate=true";*/
    
    
    
     private static final String URL = "jdbc:sqlserver://" + SERVER + ":" + PORT + 
                                     ";databaseName=" + DATABASE + 
                                     ";integratedSecurity=true;" +
                                     "encrypt=true;trustServerCertificate=true";
    // Driver de SQL Server
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    static {
        try {
            Class.forName(DRIVER);
            System.out.println("Driver de SQL Server cargado correctamente");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error al cargar el driver de SQL Server: " + e.getMessage(), e);
        }
    }
    
   
    public static Connection getConnection() throws SQLException {
        try {
            // Con Windows Authentication no se necesita usuario ni contraseña
            Connection conn = DriverManager.getConnection(URL);
            System.out.println("Conexión establecida exitosamente con Windows Authentication");
            return conn;
        } catch (SQLException e) {
            System.err.println("Error al conectar con SQL Server: " + e.getMessage());
            throw e;
        }
    }
    
   
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada correctamente");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
    
     /**
     * Método para probar la conexión
     */
   /* public static void testConnection() {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("✓ Prueba de conexión exitosa");
                System.out.println("Base de datos: " + conn.getCatalog());
            }
        } catch (SQLException e) {
            System.err.println("✗ Error en la prueba de conexión: " + e.getMessage());
        }
    }
    
    // Método main para probar (opcional, puedes eliminarlo)
    public static void main(String[] args) {
        testConnection();
    }*/

}