package MODELOS;

import java.io.Serializable;
import java.util.Date;

public abstract class Configuracion implements Comparable<Configuracion>, Serializable {

    private String titulo;
    private int ID;
    private String UsuarioCrea;
    private Date fechaHora;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }


    public Configuracion(String titulo, int ID, String UsuarioCrea, Date fechaHora) {
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
}
