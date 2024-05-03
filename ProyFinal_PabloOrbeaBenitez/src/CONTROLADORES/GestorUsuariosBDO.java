package CONTROLADORES;

import MODELOS.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class GestorUsuariosBDO implements Serializable{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/ProyFinal.odb");
    EntityManager em = emf.createEntityManager();

    public boolean comprobarInicioSesion(String nomUsuario, int contraseña) {
        boolean inicioSesion = false;

        Object[][] usrContraseña;
        try {
            TypedQuery<Long> countQuery = em.createQuery("SELECT COUNT(u) FROM Usuario u", Long.class);
            long numUsuarios = countQuery.getSingleResult();

            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
            List<Usuario> usuarios = query.getResultList();

            usrContraseña = new Object[(int) numUsuarios][2];

            int indice = 0;
            for (Usuario usuario : usuarios) {
                usrContraseña[indice][0] = usuario.getNombre();
                usrContraseña[indice][1] = usuario.getContraseña();
                indice++;
            }

            for (Object[] usrContraseña1 : usrContraseña) {
                if (usrContraseña1[0].equals(nomUsuario) && usrContraseña1[1].equals(contraseña)) {
                    inicioSesion = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            }

        return inicioSesion;
    }
    
    public void añadir(String nombre, int contraseña, boolean admin, boolean activo) {
        Usuario u1 = new Usuario(nombre, contraseña, admin, activo);
        try {
            em.getTransaction().begin();
            em.persist(u1);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean borrarNombre(String nombre) {
        try {
            em.getTransaction().begin();
            String jpql = "DELETE FROM Usuario u WHERE u.Nombre= :nombre";
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

    public boolean vaciar() {
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
    
    public void cargarDeportistas() {
        Usuario u1 = new Usuario("Pablo", 1234, true, true);
        em.getTransaction().begin();
        em.persist(u1);
        em.getTransaction().commit();
    }
}
