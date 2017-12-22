/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Duoc UC
 */
public class RegistroVideo extends Conexion {
    
    //Método para agregar la pelicula
    public boolean agregarComedia(){
            //Se arma la consulta
            String q=" INSERT INTO videobuster.pelicula(precio,idcategoria,formato4K,nombre) "
                    + "VALUES (12345,1,'S','Pelicula Comedia') ";
            //se ejecuta la consulta
            try {
                PreparedStatement pstm = this.getconexion().prepareStatement(q);
                pstm.execute();
                pstm.close();
                return true;
            }catch(SQLException e){
                System.err.println( e.getMessage() );
            }
            return false;
    }
    
        public boolean agregarDrama(){
            //Se arma la consulta
            String q=" INSERT INTO videobuster.pelicula(precio,idcategoria,formato4K,nombre) "
                    + "VALUES (12345,2,'S','Pelicula Drama') ";
            //se ejecuta la consulta
            try {
                PreparedStatement pstm = this.getconexion().prepareStatement(q);
                pstm.execute();
                pstm.close();
                return true;
            }catch(SQLException e){
                System.err.println( e.getMessage() );
            }
            return false;
    }

                public boolean ModificaPeli(){
            //Se arma la consulta
            String q="UPDATE videobuster.pelicula SET nombre= 'P_Nuevodrama' WHERE codigo=2";
            //se ejecuta la consulta
            try {
                PreparedStatement pstm = this.getconexion().prepareStatement(q);
                pstm.execute();
                pstm.close();
                return true;
            }catch(SQLException e){
                System.err.println( e.getMessage() );
            }
            return false;
    }
}
