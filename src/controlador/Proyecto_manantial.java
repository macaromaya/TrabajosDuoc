/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import vista.Login;
import vista.Usuarios;
import vista.Productos;
import vista.Carro_compra;

public class Proyecto_manantial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new CoordinaEscucha (new Login()).iniciar();
    }
    
}
