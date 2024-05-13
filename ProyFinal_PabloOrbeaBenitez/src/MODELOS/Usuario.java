package MODELOS;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedQuery(name = "queryEstática1", query = "SELECT u FROM Usuario u")
@Entity
public class Usuario implements Serializable {

    @Id

    private String nombre;

    public enum Rol {
        ADMINISTRADOR, USUARIO
    };

    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }
    private String contraseña;
    private Rol rol;
    private boolean activo;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario(String nombre, String contraseña, boolean activo) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    public Usuario(String nombre, String contraseña, Rol rol, boolean activo) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.rol = rol;
        this.activo = activo;
    }

    public Usuario() {
    }

}