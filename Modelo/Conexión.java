
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;


public class Conexión {
   Connection connection;
   String driver = "com.mysql.cj.jdbc.Driver";
   String cadenaConexion = "jdbc:mysql://localhost:3306/reto1_g55_db";
   String usuario ="root";
   String password = "";

   
    public Conexión() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(cadenaConexion, usuario, password);
            if(connection != null){
                System.out.println("Conexión exitosa con la BD");
            
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se pudo establecer conexión con la BD");
        
        }
        
    }
   
public Connection getConnection() {
    return connection;
}
   
}
