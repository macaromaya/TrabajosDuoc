/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Registro_manantial;
import vista.Login;
import vista.Usuarios;
import vista.Productos;
import vista.Carro_compra;
/**
 *
 * @author Duoc UC
 */
public class CoordinaEscucha  implements ActionListener{
    //Declaramos las vistas
    Login vistainicial = new Login();
    Usuarios vistadato = new Usuarios ();
    Productos vistaprod = new Productos ();
    Carro_compra vistacarro = new Carro_compra ();
    
    //Declarar clase modelo
    Registro_manantial comunicaBD = new Registro_manantial();
    
    //Enumera todos los botones
    public enum Accion {
        Btn_login,
        Btn_clientesig,
        jButton1,
        jButton2,
        jButton3,
        Finaliza   
    }
    
    //Contructor

    public CoordinaEscucha(Login vistainicial) {
        this.vistainicial=vistainicial;
    }
    
    public void iniciar(){
        //con esto dejamos la pantalla de la vista quede en el centro
        this.vistainicial.setLocationRelativeTo(null);
        this.vistadato.setLocationRelativeTo(null);
        this.vistaprod.setLocationRelativeTo(null);
        this.vistacarro.setLocationRelativeTo(null);
        //con esto dejamos la vista principal visible 
        this.vistainicial.setVisible(true);
        //vamos a escuchar todos los botones, se da actionCommand y actionlistener para cada boton
        this.vistainicial.Btn_login.setActionCommand( "Btn_login" );
        this.vistainicial.Btn_login.addActionListener(this);
        this.vistadato.Btn_clientesig.setActionCommand( "Btn_clientesig" );
        this.vistadato.Btn_clientesig.addActionListener(this);
        this.vistaprod.jButton1.setActionCommand( "jButton1" );
        this.vistaprod.jButton1.addActionListener(this);
        this.vistaprod.jButton2.setActionCommand( "jButton2" );
        this.vistaprod.jButton2.addActionListener(this);
        this.vistaprod.jButton3.setActionCommand( "jButton3" );
        this.vistaprod.jButton3.addActionListener(this);
        this.vistacarro.Finaliza.setActionCommand( "Finaliza" );
        this.vistacarro.Finaliza.addActionListener(this);
    }
    
        // metodo abstracto para escuchar formulario
        @Override
        public void actionPerformed (ActionEvent e) {
        switch (Accion.valueOf(e.getActionCommand())) {
                case Btn_login:
                    if (this.comunicaBD.accedercli(Integer.parseInt(this.vistainicial.tf_rut.getText()),this.vistainicial.tf_usuario.getText())) {
                        JOptionPane.showMessageDialog(null, "Se accedió ");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo acceder");
                    }
                    break;

            

        }
        }
}