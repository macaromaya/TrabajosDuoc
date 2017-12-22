/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import vista.Vista_Taller;

/**
 *
 * @author Duoc UC
 */
public class Proyecto_video {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Llamo a la clase Conexion y a su metodo getConexion, esto es para probar la conexion con la BD
        //Conexion.getconexion();
        //con esto inicio el programa
         new CoordinaEscucha(new Vista_Taller()).iniciar();
    }
    
}
