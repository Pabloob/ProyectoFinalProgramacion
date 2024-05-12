package VISTA;

import CONTROLADORES.GestorUsuariosBDO;
import java.io.IOException;

public class InicioSesion {

    public static void main(String[] args) throws IOException {
        GestorUsuariosBDO gestorUsuarios = new GestorUsuariosBDO();
        int fallos = 4;
        boolean inicioCorrecto = false;
        do {
            String nombre = LIBRERIAS.Leer.leerCadena("Introduce el nombre: ");
            String contraseña = LIBRERIAS.Leer.leerCadena("Introduce la contraseña: ");

            if (gestorUsuarios.comprobarInicioSesion(nombre, contraseña)) {
                Ventana1 ventana = new Ventana1();
                ventana.setVisible(true);
                ventana.setAdministrador(gestorUsuarios.comprobarUsuarioAdministrador(nombre));
                ventana.setNombreUsuario(nombre);
                if (gestorUsuarios.comprobarUsuarioActivo(nombre)) {
                    System.out.println("activo");
                } else {
                    System.out.println("mal");
                }
                    inicioCorrecto = true;

            } else {
                fallos--;
                System.out.println("Error el usuario o contraseña son incorrectos tienes " + fallos + " fallos más");
            }

        } while (fallos > 0 && !inicioCorrecto);
    }

}
