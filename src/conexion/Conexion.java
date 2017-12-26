package conexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
      public static Connection getconexion() {
        Connection connection = null;
        try {
           String driverClassName = "com.mysql.jdbc.Driver";
           String driverUrl="jdbc:mysql://localhost/videobuster";
           Class.forName(driverClassName);
           connection = DriverManager.getConnection(driverUrl, "root","");
           //System.out.println("Nos conectamos a la BD wiiiiiiiiiiiiii!!!");
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return connection;
        
        
    }
}