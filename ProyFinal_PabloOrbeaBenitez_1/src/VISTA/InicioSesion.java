package VISTA;

import CONTROLADORES.GestorUsuariosBDO;
import java.io.IOException;

public class InicioSesion {

    public static void main(String[] args) throws IOException {
    GestorUsuariosBDO gestor = new GestorUsuariosBDO();
    int fallos = 4;
    boolean inicioCorrecto = false;
    
    do {
        String nombre = LIBRERIAS.Leer.leerCadena("Introduce el nombre: ", 20);
        int contraseña = LIBRERIAS.Leer.leerNumero("Introduce la contraseña: ");
        
        if (gestor.comprobarInicioSesion(nombre, contraseña)) {
            Ventana1 ventana = new Ventana1();
            ventana.setVisible(true);
            inicioCorrecto = true;
        } else {
            fallos--;
            System.out.println("Error el usuario o contraseña son incorrectos tienes " + fallos + " fallos más");
        }
        
    } while (fallos > 0 && !inicioCorrecto);
}

}
