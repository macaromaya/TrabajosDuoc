/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Registro_manantial;
import vista.Login;
import vista.Productos;

/**
 *
 * @author Duoc UC
 */
public class CoordinaEscucha  implements ActionListener{
    //Declaramos las vistas
    Login vistainicial;
    Productos vistaprod = new Productos();
  
    //Declarar clase modelo
    Registro_manantial comunicaBD = new Registro_manantial();
    private String totalnew;
    
    //Enumera todos los botones
    public enum Accion {
        Btn_login,
        Btn_carrocompra
    }
    
    //Contructor

    public CoordinaEscucha(Login vistainicial) {
        this.vistainicial=vistainicial;
    }
    
    public void iniciar(){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vistainicial);
            SwingUtilities.updateComponentTreeUI( this.vistaprod );
            //SwingUtilities.updateComponentTreeUI( this.modProd );
            this.vistainicial.setLocationRelativeTo(null);
            this.vistainicial.setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {}
          catch (ClassNotFoundException ex) {}
          catch (InstantiationException ex) {}
          catch (IllegalAccessException ex) {}
        
        //vamos a escuchar todos los botones, se da actionCommand y actionlistener para cada boton
        this.vistainicial.Btn_login.setActionCommand( "Btn_login" );
        this.vistainicial.Btn_login.addActionListener(this);
        this.vistaprod.Btn_carrocompra.setActionCommand("Btn_carrocompra");
        this.vistaprod.Btn_carrocompra.addActionListener(this);
        validaNumero(this.vistaprod.prod1_cant);
        validaNumero(this.vistaprod.prod2_cant);
        validaNumero(this.vistaprod.prod3_cant);
    }
    
        // metodo abstracto para escuchar formulario
        @Override
        public void actionPerformed (ActionEvent e) {
        switch (Accion.valueOf(e.getActionCommand())) {
                case Btn_login:
                    if (this.comunicaBD.accedercli(Integer.parseInt(this.vistainicial.tf_rut.getText()),this.vistainicial.tf_usuario.getText())) {
                        JOptionPane.showMessageDialog(null, "Se accedió wiiii!!!");
                        this.vistaprod.setVisible(true);                        
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo acceder");
                    }                    
                    break;
                case Btn_carrocompra:
                    int precio1=7000;
                    int cant1=Integer.parseInt(this.vistaprod.prod1_cant.getText());
                    System.out.println("el valor de la caja de texto es: " + cant1);
                    int total1= precio1*cant1;
                    
                    int precio2=19000;
                    int cant2=Integer.parseInt(this.vistaprod.prod2_cant.getText());
                    System.out.println("el valor de la caja de texto es: " + cant2);
                    int total2= precio2*cant2;
                    
                    int precio3=19000;
                    int cant3=Integer.parseInt(this.vistaprod.prod2_cant.getText());
                    System.out.println("el valor de la caja de texto es: " + cant3);
                    int total3= precio3*cant3;
                    
                    int total= total1+total2+total3;
                    //int totalnuevo= Integer.parseInt(this.vistaprod.total.getText());
                   // this.vistaprod.jButton1.setText(totalnuevo);
                    

                    break;
                  
        }
        
        }
        
        //con este metodo valido el campo que solo acepte numeros
        public void validaNumero(JTextField campo){
            campo.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e){
                    char c = e.getKeyChar();
                    if(!Character.isDigit(c)){
                        e.consume();
                    }
                }
            });
        }
      
}