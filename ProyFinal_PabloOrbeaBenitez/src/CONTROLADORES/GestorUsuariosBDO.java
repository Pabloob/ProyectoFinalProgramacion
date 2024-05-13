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

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/ProyFinal.odb");
    EntityManager em = emf.createEntityManager();

    /**
     * Se comprueba si el usuario y contraseña son iguales a algun usuario de la
     * BDO y si el usuario esta activo
     *
     * @param nomUsuario
     * @param contraseña
     * @return Se devuelve si el inicio de sesion es correcto
     */
    public boolean comprobarInicioSesion(String nomUsuario, String contraseña) {
        boolean inicioSesion = false;
        try {
            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
            List<Usuario> usuarios = query.getResultList();

            for (Usuario usuario : usuarios) {
                if (usuario.getNombre().equals(nomUsuario) && usuario.getContraseña().equals(contraseña) && usuario.isActivo()) {
                    inicioSesion = true;
                }
            }

        } catch (Exception e) {
        }

        return inicioSesion;
    }

    /**
     * Se comprueba si el usuario es administrador
     *
     * @param nomUsuario
     * @return Se devuelve si el usuario es administrador o no
     */
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

    /**
     * Se añade el usuario recibiendo como parametro el usuario
     * @param u1
     * @return Se devuelve si se ha añadido correctamente
     */
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

    /**
     * Se borra un usuario por nombre
     * @param nombre
     * @return Se devuelve si se ha borrado correctamente
     */
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

    /**
     * Se convierten los datos de la BDO a array[][]
     * @return Se devuelve el array[][]
     */
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

}