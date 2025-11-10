
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    
    private static final String SERVER = ""; 
    private static final String DATABASE = "Gestor_Hospital";
    private static final String PORT = "1433";
    
  
    
    
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
    
    
   

}
