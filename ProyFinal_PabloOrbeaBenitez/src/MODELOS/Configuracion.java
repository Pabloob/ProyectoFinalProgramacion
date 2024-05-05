package MODELOS;

public abstract class Configuracion {

    private int id;
    private String titulo;
    private String nomUsuario;
    private int fechaHora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public int getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(int fechaHora) {
        this.fechaHora = fechaHora;
    }

}
