
package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Registro_manantial extends Conexion {
    
    //Metodo para acceder a clientes
        //Verificar usuario
    public static boolean accedercli(Integer rut, String nombre) {
        try {
            Connection cnx = Conexion.getconexion();
            String query = "SELECT * FROM manantial.usuario WHERE rut = ? and nombre=? ";
            PreparedStatement select = cnx.prepareStatement(query);
            select.setInt(1, rut);
            select.setString(2, nombre);
            select.execute();
            ResultSet rs = select.getResultSet();
            
            if (rs.next()) {
                cnx.close();
                return true;
            } else {
                System.err.println( "USUARIO NO EXISTE, CLIENTE NO REGISTRADO");
                cnx.close();
                return false;
            }

        } catch (SQLException s) {
            System.err.println("Error SQL  " + s.getMessage());
            return true;
        } catch (Exception e) {
            System.err.println("Error SQL" + e.getMessage());
            return true;
        }
    }
    
    
    
}
