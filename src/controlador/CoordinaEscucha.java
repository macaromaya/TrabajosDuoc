/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.RegistroVideo;
import vista.Vista_Taller;

/**
 *
 * @author Duoc UC
 */
public class CoordinaEscucha implements ActionListener {
    //Declara la vista en caso de tener solo una, si tengo mas de una se declaran todas las vistas
    Vista_Taller vistaPrincipal = new Vista_Taller();
    //Declarar la clase modelo que en este caso es RegistroVideo.java
    RegistroVideo comunicaBD = new RegistroVideo();
    //Enumerar todos los botones de la vista (nombre boton), si tengo mas vistas las enumeras todas
    public enum Accion{
        btn_drama,
        btn_comedia,
        btn_limpiar,
        btn_romance,
        btn_elim_por_precio,
        btn_nuevoregistrosP
    }

    //Constructor
    public CoordinaEscucha(Vista_Taller vistaPrincipal) {
        this.vistaPrincipal= vistaPrincipal;
    }
    
    public void iniciar(){
        //con esto dejamos la pantalla de la vista quede en el centro
        this.vistaPrincipal.setLocationRelativeTo(null);
        //con esto dejamos la vista principal visible 
        this.vistaPrincipal.setVisible(true);
        //vamos a escuchar todos los botones, se da actionCommand y actionlistener para cada boton
        this.vistaPrincipal.btn_comedia.setActionCommand( "btn_comedia" );
        this.vistaPrincipal.btn_comedia.addActionListener(this);
        this.vistaPrincipal.btn_drama.setActionCommand( "btn_drama" );
        this.vistaPrincipal.btn_drama.addActionListener(this);
        this.vistaPrincipal.btn_limpiar.setActionCommand( "btn_limpiar" );
        this.vistaPrincipal.btn_limpiar.addActionListener(this);
        
    }
    //esto es un metodo abstracto que nos sirve para escuchar el formulario
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Accion.valueOf(e.getActionCommand())){  
            case btn_comedia:
                if(this.comunicaBD.agregarComedia()){
                    JOptionPane.showMessageDialog(null, "Se agrego la pelicula en comedia");                    
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo agregar nadita de nada");
                }
            break;
            case btn_drama:  
                if(this.comunicaBD.agregarDrama()){
                    JOptionPane.showMessageDialog(null, "Se agrego la pelicula en drama");                    
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo agregar nadita de nada");
                }
            break;
            case btn_limpiar:  
               this.vistaPrincipal.txtf_nompeli.setText(" ");
            break;
           
        }
    }
      
}
