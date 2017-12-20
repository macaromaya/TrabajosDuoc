/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vbuster;

/**
 *
 * @author Duoc UC
 */
public class peliculaaux {

    protected int codigo;
    protected int precio;
    protected String id_categoria;
    protected String formato4k;
    protected String nombre;

    public peliculaaux() {
    }

    public peliculaaux(int codigo, int precio, String id_categoria, String formato4k, String nombre) {
        this.codigo = codigo;
        this.precio = precio;
        this.id_categoria = id_categoria;
        this.formato4k = formato4k;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getFormato4k() {
        return formato4k;
    }

    public void setFormato4k(String formato4k) {
        this.formato4k = formato4k;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "codigo=" + codigo + ", precio=" + precio + ", id_categoria=" + id_categoria + ", formato4k=" + formato4k + ", nombre=" + nombre + '}';
    }

}
