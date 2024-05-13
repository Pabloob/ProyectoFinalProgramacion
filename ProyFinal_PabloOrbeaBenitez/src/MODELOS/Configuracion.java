package MODELOS;

import java.io.Serializable;

public abstract class Configuracion implements Comparable<Configuracion>, Serializable, MostrarInfo {

    private String titulo;
    private int ID;
    private String UsuarioCrea;
    private String fechaHora;
    private static final int version = 1;

    public static int getVersion() {
        return version;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Configuracion(String titulo, int ID, String UsuarioCrea, String fechaHora) {
        this.titulo = titulo;
        this.ID = ID;
        this.UsuarioCrea = UsuarioCrea;
        this.fechaHora = fechaHora;
    }

    public Configuracion() {
    }

    public Configuracion(String titulo) {
        this.titulo = titulo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsuarioCrea() {
        return UsuarioCrea;
    }

    public void setUsuarioCrea(String UsuarioCrea) {
        this.UsuarioCrea = UsuarioCrea;
    }

    @Override
    public int compareTo(Configuracion conf) {
        return this.titulo.compareTo(conf.titulo);
    }

    public abstract void presentarInformacion();
    

}