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
            e.printStackTrace();
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
            e.printStackTrace();
        }

        return administrador;
    }

    public boolean añadirUsuario(String nombre, String contraseña, Usuario.Rol rol, boolean activo) {
        Usuario u1 = new Usuario(nombre, contraseña, rol, activo);
        try {
            em.getTransaction().begin();
            em.persist(u1);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean borrarUsuarioPorNombre(String nombre) {
        try {
            em.getTransaction().begin();
            String jpql = "DELETE FROM Usuario u WHERE u.nombre= :nombre";
            Query qModif = em.createQuery(jpql);
            qModif.setParameter("nombre", nombre);
            int filasEliminadas = qModif.executeUpdate();
            em.getTransaction().commit();
            return filasEliminadas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean vaciarUsuarios() {
        try {
            em.getTransaction().begin();
            String jpql = "DELETE FROM Usuario u";
            Query qModif = em.createQuery(jpql);
            int filasEliminadas = qModif.executeUpdate();
            em.getTransaction().commit();
            return filasEliminadas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void cargarUsuario() {
        Usuario u1 = new Usuario("Pablo", "1234", Usuario.Rol.ADMINISTRADOR, true);
        em.getTransaction().begin();
        em.persist(u1);
        em.getTransaction().commit();
    }

    public Object[][] convertirBDOADTM() {
        boolean inicioSesion = false;

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
            e.printStackTrace();
        }

        return datos;

    }

    public String convertirContraseña(char caracteresContraseña[]) {
        String contraseña = "";
        for (char c : caracteresContraseña) {
            contraseña = contraseña+ c;
        }
        return contraseña.trim();
    }

}
