package VISTA;

import CONTROLADORES.GestorUsuariosBDO;
import java.io.IOException;

public class InicioSesion {

    public static void main(String[] args) throws IOException {
        GestorUsuariosBDO gestor = new GestorUsuariosBDO();
        String nombre = LIBRERIAS.Leer.leerCadena("Introduce el nombre: ", 20);
        int contraseña = LIBRERIAS.Leer.leerNumero("Introduce la contraseña: ");
        System.out.println(gestor.comprobarInicioSesion(nombre, contraseña));
    }
}
