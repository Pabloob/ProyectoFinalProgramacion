package MODELOS;

import java.io.Serializable;
import java.util.Date;

public abstract class Configuracion implements Comparable<Configuracion>, Serializable {

    private String titulo;
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

    public Configuracion(String titulo, Date fechaHora) {
        this.titulo = titulo;
        this.fechaHora = fechaHora;
    }

    public Configuracion(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public int compareTo(Configuracion conf) {
        return this.titulo.compareTo(conf.titulo);
    }
}
