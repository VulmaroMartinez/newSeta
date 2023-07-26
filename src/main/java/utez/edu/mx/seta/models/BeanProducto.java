package utez.edu.mx.seta.models;

import java.io.InputStream;

public class BeanProducto {

    private int id_producto;
    private  String nombre;
    private double precio;
    private int existencias;
    private  String estado;
    private String descripcion;
    private int id_categoria;
    private InputStream imagen_1;
    private InputStream imagen_2;
    private InputStream imagen_3;
    private BeanCategoria categoria;







    // Constructor
    public BeanProducto() {
    }


    // Métodos getter y setter para cada propiedad


    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public InputStream getImagen_1() {
        return imagen_1;
    }

    public void setImagen_1(InputStream imagen_1) {
        this.imagen_1 = imagen_1;
    }

    public InputStream getImagen_2() {
        return imagen_2;
    }

    public void setImagen_2(InputStream imagen_2) {
        this.imagen_2 = imagen_2;
    }

    public InputStream getImagen_3() {
        return imagen_3;
    }

    public void setImagen_3(InputStream imagen_3) {
        this.imagen_3 = imagen_3;
    }

    public BeanCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(BeanCategoria categoria) {
        this.categoria = categoria;
    }
}
