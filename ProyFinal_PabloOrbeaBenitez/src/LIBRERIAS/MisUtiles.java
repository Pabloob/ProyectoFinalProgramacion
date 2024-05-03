package LIBRERIAS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MisUtiles {
    
    //Metodo para confirmar en el que se pide a el usuario que introduzca s(true) o n(false)
    public static boolean confirmar(String msj) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String auxiliar;
        boolean confirmar = false;
        boolean correcto = false;

        do {
            System.out.print(msj);
            auxiliar = teclado.readLine().toLowerCase().trim();

            try {
                if (!auxiliar.equals("s") && !auxiliar.equals("n")) {
                    System.err.println("\tError: Debe introducir una letra");
                } else {
                    correcto = true;
                    if ("s".equals(auxiliar)) {
                        confirmar = true;
                    }
                }
            } catch (Exception e) {
                System.err.println("\tError: Debe introducir una letra");
            }

        } while (!correcto);

        return confirmar;
    }
    
    //Metodo para hacer una pausa hasta que el usuario pulse una tecla
    public static void pausa(String msj) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        System.out.println(msj);
        teclado.readLine();
    }
    
    //Metodo que limpia la pantalla
    public static void limpiar() throws IOException {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    //Metodo que valida el acceso comparando el ssuario y contraseña que el usuario introduce con los usuarios y contraseñas que hay en el array
    public static boolean validarAcceso(String usuario, String contraseña) throws IOException {
        String verde = "\u001B[32m";
        String reset = "\u001B[0m";
        String usuarioContraseña[][] = {{"Pablo", "Pablo"}, {"Lobezno", "Lobezno1234"},
            {"Ciclope", "Contraseña"}, {"Tormenta", "Llueve"}, {"Ismael", "Ismael111"},
            {"Kevin", "Kevin"}, {"Esteban", "Estbanco"}, {"Sergio", "Sergio"}, {"Maikel", "Maikel"}, {"Jesus", "Jesusito"}};
        boolean validado = false;

        for (String[] usuarioContraseña1 : usuarioContraseña) {
            if (usuarioContraseña1[0].toLowerCase().equals(usuario.toLowerCase()) && usuarioContraseña1[1].equals(contraseña)) {
                validado = true;
            }
        }
        if (validado) {
            System.out.println(verde + "Acceso permitido." + reset);
        } else {
            System.err.println("Acceso no válido.");
        }
        return validado;
    }

    //Metodo que pide 2 numeros un numero maximo y un numero minimo y devuelve un numero entre estos dos 
    public static int numAleatorio(int min, int max) {
        int valor = (int) (Math.random() * (max - min + 1) + min);
        return valor;
    }
    
    //Metodo que muestra el indice resumido 
    public static void mostrarIndiceResumido() {
        System.out.println(String.format("%-5s%-15s%-15s%-20s",
                "ID", "Nombre", "NúmeroTelf", "Email"));
    }
    
    //Metodo que muestra el indice completo
    public static void mostrarIndiceCompleto() {
        System.out.println(String.format("%-5s%-15s%-14s%-10s%-7s%-20s%-19s%-15s%-13s%-15s%-10s",
                "ID", "Nombre", "NúmeroTelf", "Altura", "Edad", "FraseTípica", "Email", "Es Anónimo", "Sexo", "Usa Artefactos","Puede volar"));
    }

}
