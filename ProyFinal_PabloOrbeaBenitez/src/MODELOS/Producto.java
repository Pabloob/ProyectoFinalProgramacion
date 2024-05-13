package MODELOS;

import java.io.Serializable;


public class Producto implements Serializable {
    
    private String nombre;
    private float precio;
    private int cantidad;
    private String rutaImagen;

    public Producto() {
    }

    public Producto(String nombre, float precio, int cantidad,String rutaImagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.rutaImagen = rutaImagen;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getrutaImagen() {
        return rutaImagen;
    }

    public void setrutaImagen(String imagen) {
        this.rutaImagen = imagen;
    }
    
}