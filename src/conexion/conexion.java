package conexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class conexion {
      public static Connection getconexion() {
        Connection connection = null;
        try {
           String driverClassName = "com.mysql.jdbc.Driver";
           String driverUrl="jdbc:mysql://localhost/VClubVBuster";
           Class.forName(driverClassName);
           connection = DriverManager.getConnection(driverUrl, "root","");
           System.out.println("Conexion exitosa!");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
        
        
    }
}

