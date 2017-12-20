/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vbuster.categoria;
import vbuster.pelicula;
import vbuster.peliculaaux;
import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Duoc UC
 */
public class registro {
    
    
    //Verificar Pelicula
    public static boolean existePeli(Integer codigo) {
        try {
            Connection con = conexion.getconexion();
            String query = "SELECT * FROM pelicula WHERE codigo = ? ";
            PreparedStatement select = con.prepareStatement(query);
            select.setInt(1, codigo);
            select.execute();
            ResultSet rs = select.getResultSet();
            
            if (rs.next()) {
                con.close();
                 System.out.println("entre");
                return true;
            } else {
                System.out.println("no entre");
                con.close();
                return false;
            }

        } catch (SQLException s) {
            System.out.println("Error SQL  " + s.getMessage());
            return true;
        } catch (Exception e) {
            System.out.println("Error SQL" + e.getMessage());
            return true;
        }
    }
    
    //Agregar PELICULA
    public static boolean grabarPeli(pelicula p) {

        try {
            Connection conexion1 = conexion.getconexion();
            String query = "INSERT INTO pelicula (codigo,precio,id_categoria,formato4k,nombre) VALUES (?,?,?,?,?)";
            PreparedStatement insertar = conexion1.prepareStatement(query);
            insertar.setInt(1, p.getCodigo());
            insertar.setInt(2, p.getPrecio());
            insertar.setInt(3, p.getId_categoria());
            insertar.setString(4, p.getFormato4k());
            insertar.setString(5, p.getNombre());
            insertar.execute();
            insertar.close();
            conexion1.close();
            return true;
        } catch (SQLException s) {
            System.out.println("Error SQL al agregar" + s.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar" + e.getMessage());
            return false;
        }
    }
    
    //Verificar Pelicula
    public static boolean existeCat(Integer codigo) {
        try {
            Connection conexion2 = conexion.getconexion();
            String query = "SELECT * FROM categoria WHERE id = ? ";
            PreparedStatement select = conexion2.prepareStatement(query);
            select.setInt(1, codigo);
            select.execute();
            ResultSet rs = select.getResultSet();
            
            if (rs.next()) {
                conexion2.close();
                 System.out.println("entre");
                return true;
            } else {
                System.out.println("no entre");
                conexion2.close();
                return false;
            }

        } catch (SQLException s) {
            System.out.println("Error SQL  " + s.getMessage());
            return true;
        } catch (Exception e) {
            System.out.println("Error SQL" + e.getMessage());
            return true;
        }
    }
    
    //Agregar CATEGORIA
    public static boolean grabarCat(categoria c) {

        try {
            Connection conexion3 = conexion.getconexion();
            String query = "INSERT INTO categoria (id,descripcion) VALUES (?,?)";
            PreparedStatement insertar = conexion3.prepareStatement(query);
            insertar.setInt(1, c.getId());
            insertar.setString(2, c.getDescripcion());
            insertar.execute();
            insertar.close();
            conexion3.close();
            return true;
        } catch (SQLException s) {
            System.out.println("Error SQL al agregar" + s.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar" + e.getMessage());
            return false;
        }
    }
    
    //listar Peliculas
    public static ArrayList<peliculaaux> listarPeli() {
        ArrayList<peliculaaux> listaPeli = new ArrayList<>();
        try {
            Connection conexion13 = conexion.getconexion();
            String query = "SELECT p.codigo, p.precio, categoria.descripcion as categoria, p.formato4k, p.nombre FROM pelicula p JOIN categoria ON (p.id_categoria = categoria.id)";
            PreparedStatement listPeli  = conexion13.prepareStatement(query);
            ResultSet rs = listPeli.executeQuery();
            while (rs.next()) {
                peliculaaux dto = new peliculaaux();
                dto.setCodigo(rs.getInt("codigo"));
                dto.setPrecio(rs.getInt("precio"));
                dto.setId_categoria(rs.getString("categoria"));
                dto.setFormato4k(rs.getString("formato4k"));
                dto.setNombre(rs.getString("nombre"));
                listaPeli.add(dto);
            }
        } catch (SQLException s) {
            System.out.println("Error SQL" + s.getMessage());
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        } return listaPeli;
    }
    
    //listar Categorias
    public static ArrayList<categoria> listarCat() {
        ArrayList<categoria> listaCat = new ArrayList<>();
        try {
            Connection conexion4 = conexion.getconexion();
            String query = "SELECT * FROM categoria";
            PreparedStatement listarcat = conexion4.prepareStatement(query);
            ResultSet rs = listarcat.executeQuery();
            while (rs.next()) {
                categoria dto = new categoria();
                dto.setId(rs.getInt("id"));
                dto.setDescripcion(rs.getString("descripcion"));
                listaCat.add(dto);
            }
        } catch (SQLException s) {
            System.out.println("Error SQL" + s.getMessage());
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        } return listaCat;
    }
    
    //Buscar pelicula
    public static pelicula buscarPeli(int codigo) {
        //ArrayList<Chocolate> listaChoc = new ArrayList<>();
        pelicula p = new pelicula();
        try {
            Connection conexion5 = conexion.getconexion();
            String query = "SELECT * FROM pelicula WHERE codigo=?";
            PreparedStatement buscarPorCodigo = conexion5.prepareStatement(query);
            buscarPorCodigo.setInt(1, codigo);
            ResultSet rs = buscarPorCodigo.executeQuery();
            while (rs.next()) {
               
                p.setCodigo(rs.getInt("codigo"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getInt("precio"));
                p.setId_categoria(rs.getInt("id_categoria"));
                p.setFormato4k(rs.getString("formato4k"));
                return p;
            }
        } catch (SQLException s) {
            System.out.println("Error SQL" + s.getMessage());
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return p;
    }
    
    //Buscar por descripcion
    public static String buscarxDesc(String desc){
         categoria c = new categoria();
         String soo="";
        try {
            Connection conexion6 = conexion.getconexion();
            String query = "SELECT * FROM categoria WHERE descripcion=?";
            PreparedStatement buscarPorDesc = conexion6.prepareStatement(query);
            buscarPorDesc.setString(1, desc);
            ResultSet rs = buscarPorDesc.executeQuery();
            
            while (rs.next()) {
               
                c.setId(rs.getInt("id"));
                c.setDescripcion(rs.getString("descripcion"));
                soo = (String.valueOf(rs.getInt("id")))+".- "+ rs.getString("descripcion");
                System.out.println(soo);
                return soo;
            }
        } catch (SQLException s) {
            System.out.println("Error SQL" + s.getMessage());
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        } return soo.toLowerCase();
    }
    
    //Buscar id cat desc
     public static int buscarIdcatxDesc(String desc){
         categoria c = new categoria();
         int soo=0;
        try {
            Connection conexion7 = conexion.getconexion();
            String query = "SELECT * FROM categoria WHERE descripcion='"+"?"+"'";
            PreparedStatement buscat = conexion7.prepareStatement(query);
            buscat.setString(1, desc);
            ResultSet rs = buscat.executeQuery();
            
            while (rs.next()) {
               
                c.setId(rs.getInt("codigo"));
                c.setDescripcion(rs.getString("descripcion"));
                soo = c.getId();
                System.out.println(soo);
                return soo;
            }
        } catch (SQLException s) {
            System.out.println("Error SQL" + s.getMessage());
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        } return soo;
    }
    
     //buscar por categoria
    public static categoria buscarCat(int id) {
        categoria c = new categoria();
        try {
            Connection conexion8 = conexion.getconexion();
            String query = "SELECT * FROM categoria WHERE id=?";
            PreparedStatement buscat = conexion8.prepareStatement(query);
            buscat.setInt(1, id);
            ResultSet rs = buscat.executeQuery();
            while (rs.next()) {
               
                c.setId(rs.getInt("codigo"));
                c.setDescripcion(rs.getString("descripcion"));
                return c;
            }
        } catch (SQLException s) {
            System.out.println("Error SQL" + s.getMessage());
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return c;
    }
    
    
    // Editar pelicula
     public static boolean editarPeli(pelicula p) {

        try {
            Connection conexion9 = conexion.getconexion();
            String query = "UPDATE pelicula " +
                           "SET precio = ?," +
                           "id_categoria = ?," +
                           "formato4k = ?," +
                           "nombre = ?" +
                           "WHERE codigo = ?";
            PreparedStatement insertar = conexion9.prepareStatement(query);
    
            insertar.setInt(1, p.getPrecio());
            insertar.setInt(2, p.getId_categoria());
            insertar.setString(3, p.getFormato4k());
            insertar.setString(4, p.getNombre());
            insertar.setInt(5, p.getCodigo());
            insertar.execute();
            insertar.close();
            conexion9.close();
            return true;
        } catch (SQLException s) {
            System.out.println("Error SQL al agregar" + s.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar" + e.getMessage());
            return false;
        }
    }    
    
     //Editar por categoria
     public static boolean editarCat(categoria c) {

        try {
            Connection conexion10 = conexion.getconexion();
            String query = "UPDATE categoria " +
                           "SET descripcion = ?" +
                           "WHERE id = ?";
            PreparedStatement insertar = conexion10.prepareStatement(query);
    
            insertar.setString(1, c.getDescripcion());
            insertar.setInt(2, c.getId());
            insertar.execute();
            insertar.close();
            conexion10.close();
            return true;
        } catch (SQLException s) {
            System.out.println("Error SQL al agregar" + s.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar" + e.getMessage());
            return false;
        }
    }    
     
     //Mostrar por categoria
     
    public static ArrayList<peliculaaux> mostrarPelisxCat(int id){
        ArrayList lista2=new ArrayList();
        try{
            Connection conexion11 = conexion.getconexion();
            String cad = "select * FROM pelicula peli JOIN categoria ON (peli.id_categoria = categoria.id) where categoria.id = " + id ;
            PreparedStatement mostrar = conexion11.prepareStatement(cad);
            ResultSet rs = mostrar.executeQuery();
            while(rs.next()){
                peliculaaux p = new peliculaaux();
                p.setCodigo(rs.getInt("codigo"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getInt("precio"));
                p.setFormato4k(rs.getString("formato4k"));
                lista2.add(p);
            }
        }
        catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return lista2;
    }

   
     //Eliminar por categoria
    public static int eliminarCat(int codcat) {
        int n = 0;
        PreparedStatement borrar;
        try {
            Connection conexion12 = conexion.getconexion();
            if (codcat == 0) {
                String query = "DELETE FROM categoria";
                borrar = conexion12.prepareStatement(query);
            } else {
                String query = "DELETE FROM categoria WHERE id=?";
                borrar = conexion12.prepareStatement(query);
                borrar.setInt(1, codcat);
            }

            n = borrar.executeUpdate();
            borrar.close();
            conexion12.close();
        } catch (SQLException s) {
            System.out.println("Error SQL al eliminar" + s.getMessage());
        } catch (Exception e) {
            System.out.println("Error al eliminar" + e.getMessage());

        }
        return n;
    }

    
    //Eliminar pelicula
    public static int eliminarPeli(int codigo) {
        int n = 0;
        PreparedStatement borrar;
        try {
            Connection conexion13 = conexion.getconexion();
            if (codigo == 0) {
                String query = "DELETE FROM pelicula";
                borrar = conexion13.prepareStatement(query);
            } else {
                String query = "DELETE FROM pelicula WHERE codigo=?";
                borrar = conexion13.prepareStatement(query);
                borrar.setInt(1, codigo);
            }

            n = borrar.executeUpdate();
            borrar.close();
            conexion13.close();
        } catch (SQLException s) {
            System.out.println("Error SQL al eliminar" + s.getMessage());
        } catch (Exception e) {
            System.out.println("Error al eliminar" + e.getMessage());

        }
        return n;
    
    }
    
    
    
    
}
