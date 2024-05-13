package VISTA;

import CONTROLADORES.GestorUsuariosBDO;
import java.io.IOException;

public class InicioSesion {

    public static void main(String[] args) throws IOException {
        //Se crea el objeto de gestion de usuario
        GestorUsuariosBDO gestorUsuarios = new GestorUsuariosBDO();
        
        //Se asignan el maximo de fallos
        int fallos = 4;
        
        // Variable para comprobar si el inicio de sesion a sigo correcto
        boolean inicioCorrecto = false;
        
        //Bucle mientras los fallos sean mayores a 0 y el inicio de sesion sea incorrecto
        do {
            //Se leen el nombre y contraseña por terminal
            String nombre = LIBRERIAS.Leer.leerCadena("Introduce el nombre: ");
            String contraseña = LIBRERIAS.Leer.leerCadena("Introduce la contraseña: ");

            //Se comprueba si el inicio de sesion a sido correcto con el usuario y contraseña leidos por terminal
            if (gestorUsuarios.comprobarInicioSesion(nombre, contraseña)) {
                //Si el inicio de sesion ha sido correcto se muestra la ventana 1 
                Ventana1 ventana = new Ventana1();
                ventana.setVisible(true);
                
                //Se comprueba si el usuario es administrador para trabajar con la ventana 1 y se guarda el nombre de ususario 
                //Metodos de ventana 1
                ventana.setAdministrador(gestorUsuarios.comprobarUsuarioAdministrador(nombre));
                ventana.setNombreUsuario(nombre);
                
                //Se asigna que el inicio de sesion ha sido correcto
                    inicioCorrecto = true;

            } else {
                //Si el inicio de sesion ha sido incorrecto se resta un fallo y se muestran los fallos que quedan
                fallos--;
                System.out.println("Error el usuario o contraseña son incorrectos tienes " + fallos + " fallos más");
            }

        } while (fallos > 0 && !inicioCorrecto);
    }

}