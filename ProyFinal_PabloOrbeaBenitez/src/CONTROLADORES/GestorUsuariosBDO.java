package CONTROLADORES;

import MODELOS.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class GestorUsuariosBDO implements Serializable {

    String usuarioIniciaSesion;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/ProyFinal.odb");
    EntityManager em = emf.createEntityManager();

    public boolean comprobarInicioSesion(String nomUsuario, String contraseña) {
        boolean inicioSesion = false;
        Object[][] usuarioContraseña;
        try {
            TypedQuery<Long> countQuery = em.createQuery("SELECT COUNT(u) FROM Usuario u", Long.class);
            long numUsuarios = countQuery.getSingleResult();

            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
            List<Usuario> usuarios = query.getResultList();

            usuarioContraseña = new Object[(int) numUsuarios][2];

            int indice = 0;
            for (Usuario usuario : usuarios) {
                if (usuario.getNombre().equals(nomUsuario) && usuario.getContraseña().equals(contraseña)) {
                    inicioSesion = true;
                }
            }

        } catch (Exception e) {
        }

        return inicioSesion;
    }

    public boolean comprobarUsuarioAdministrador(String nomUsuario) {
        boolean administrador = false;

        Object[][] usuarioRol;
        try {
            TypedQuery<Long> countQuery = em.createQuery("SELECT COUNT(u) FROM Usuario u", Long.class);
            long numUsuarios = countQuery.getSingleResult();

            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
            List<Usuario> usuarios = query.getResultList();

            usuarioRol = new Object[(int) numUsuarios][2];

            int indice = 0;
            for (Usuario usuario : usuarios) {
                usuarioRol[indice][0] = usuario.getNombre();
                usuarioRol[indice][1] = usuario.getRol();

                indice++;
            }
            for (Object[] usuario : usuarioRol) {
                if (usuario[0].equals(nomUsuario) && usuario[1].toString().equals("ADMINISTRADOR")) {
                    administrador = true;
                }
            }
        } catch (Exception e) {
        }

        return administrador;
    }

    public boolean añadirUsuario(Usuario u1) {
        boolean correcto = false;

        try {
            em.getTransaction().begin();
            em.persist(u1);
            em.getTransaction().commit();
            correcto = true;
        } catch (Exception e) {
        }
        return correcto;
    }

    public boolean borrarUsuarioPorNombre(String nombre) {
        boolean correcto = false;
        try {
            em.getTransaction().begin();
            String jpql = "DELETE FROM Usuario u WHERE u.nombre= :nombre";
            Query qModif = em.createQuery(jpql);
            qModif.setParameter("nombre", nombre);
            int filasEliminadas = qModif.executeUpdate();
            em.getTransaction().commit();
            if (filasEliminadas > 0) {
                correcto = true;
            }
        } catch (Exception e) {
        }
        return correcto;
    }

    public boolean vaciarUsuarios() {
        boolean correcto = false;
        try {
            em.getTransaction().begin();
            String jpql = "DELETE FROM Usuario u";
            Query qModif = em.createQuery(jpql);
            int filasEliminadas = qModif.executeUpdate();
            em.getTransaction().commit();
            if (filasEliminadas > 0) {
                correcto = true;
            }
        } catch (Exception e) {
        }
        return correcto;
    }

    public Object[][] convertirBDOADTM() {
        Object datos[][] = null;
        try {
            TypedQuery<Long> countQuery = em.createQuery("SELECT COUNT(u) FROM Usuario u", Long.class);
            long numUsuarios = countQuery.getSingleResult();

            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
            List<Usuario> usuarios = query.getResultList();

            datos = new Object[(int) numUsuarios][4];

            int indice = 0;
            for (Usuario usuario : usuarios) {
                datos[indice][0] = usuario.getNombre();
                datos[indice][1] = usuario.getContraseña();
                datos[indice][2] = usuario.getRol();
                datos[indice][3] = usuario.isActivo();
                indice++;
            }

        } catch (Exception e) {
        }

        return datos;

    }

    public String convertirContraseña(char caracteresContraseña[]) {
        String contraseña = "";
        for (char c : caracteresContraseña) {
            contraseña = contraseña + c;
        }
        return contraseña.trim();
    }

}
