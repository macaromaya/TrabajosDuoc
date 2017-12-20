package vbuster;


public class pelicula {
    protected int codigo;
    protected int precio;
    protected int id_categoria;
    protected String formato4k;
    protected String nombre;

    public pelicula() {
    }

    public pelicula(int codigo, int precio, int id_categoria, String formato4k, String nombre) {
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

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
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
        return "Pelicula=" + "codigo=" + codigo + ", precio=" + precio + ", id_categoria=" + id_categoria + ", formato4k=" + formato4k + ", nombre=" + nombre + '}';
    }
    
    
}
