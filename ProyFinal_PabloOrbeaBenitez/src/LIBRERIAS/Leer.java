package LIBRERIAS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Leer {

    //Metodo que lee un nombre de menos de 10 digitos
    public static String leerCadena(String msj, int maxCaracteres) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String valor;
        boolean correcto;
        do {
            correcto = false;
            System.out.print(msj);
            valor = teclado.readLine().trim().replaceAll("\\s", "");
            if (valor.isEmpty()) {
                correcto = true;
                System.err.println("\tError: No puedes introducir un nombre vacio");
            } else if (valor.length() > maxCaracteres) {
                correcto = true;
                System.out.println("\tEl nombre no puede tener mas de " + maxCaracteres + " caracteres");
            }
        } while (correcto);
        return valor;
    }

    //Metodo que lee un numero de telefono hasta que tenga 9 cifras
    public static String leerNumeroTelefono(String msj) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String valor = null;
        boolean correcto;
        do {
            correcto = false;
            System.out.print(msj);
            try {
                valor = teclado.readLine().trim().replaceAll("\\s", "");
                if (valor.length() != 9) {
                    System.out.println("\tIntroduce un numero de telefono con sus 9 digitos");
                    correcto = true;
                }
            } catch (IOException e) {
                correcto = true;
                System.out.println("Error introduce una opcion valida");
            }

        } while (correcto);
        return valor;
    }

    //Metodo que lee el email, no puede tener mas de 20 caracteres y tiene que tener formato de email
    public static String leerEmail(String msj) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader teclado = new BufferedReader(flujo);
        String valor = "";
        boolean emailOK;
        boolean correcto = false;

        do {
            System.out.print(msj);
            valor = teclado.readLine().trim();
            if (valor.length() > 20) {
                correcto = false;
                System.out.println("\tEl correo no puede tener mas de 20 caracteres");
            } else {
                try {
                    valor = valor.strip();
                } catch (Exception e) {
                    System.out.println("\tIntroduce un email correcto");
                }
                String regex = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(valor);
                emailOK = matcher.matches();

                if (!emailOK) {
                    System.out.println("\tIntroduce un email correcto");
                } else {
                    correcto = true;
                }
            }
        } while (!correcto);
        return valor;
    }

    //Pide 2 numeros uno minimo y otro maximo y lee el numero entre estos dos 
    public static int leerNumeroEntreMinMax(String msj, int min, int max) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int valor = 0;
        String auxiliar;
        boolean correcto;
        do {
            correcto = false;
            System.out.print(msj);
            try {
                auxiliar = teclado.readLine().trim();
                valor = Integer.parseInt(auxiliar);
                if (valor < min || valor > max) {
                    correcto = true;
                    System.out.println("Introduce una opcion valida");
                }
            } catch (IOException | NumberFormatException e) {
                correcto = true;
                System.out.println("Error introduce una opcion valida");
            }

        } while (correcto);
        return valor;
    }

    public static int leerNumero(String msj) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int valor = 0;
        String auxiliar;
        boolean correcto;
        do {
            correcto = false;
            System.out.print(msj);
            try {
                auxiliar = teclado.readLine().trim();
                valor = Integer.parseInt(auxiliar);
            } catch (IOException | NumberFormatException e) {
                correcto = true;
                System.out.println("Error introduce una opcion valida");
            }
        } while (correcto);
        return valor;
    }
    
    //Lee un numero 
    public static int leerNumero(String msj, int max) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int valor = 0;
        String auxiliar;
        boolean correcto;
        do {
            correcto = false;
            System.out.print(msj);
            try {
                auxiliar = teclado.readLine().trim();
                valor = Integer.parseInt(auxiliar);
                if (valor > max) {
                    correcto = true;
                    System.out.println("Introduce una opcion valida");
                }
            } catch (IOException | NumberFormatException e) {
                correcto = true;
                System.out.println("Error introduce una opcion valida");
            }

        } while (correcto);
        return valor;
    }

    //Metodo que lee un booleano
    public static boolean leerBoolean(String msj, String FEM, String MASC) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        boolean sexoMasc = false;
        boolean correcto = false;

        do {
            System.out.print(msj);
            String auxiliar = teclado.readLine().toLowerCase().trim();

            if (auxiliar.equals(FEM)) {
                sexoMasc = false;
                correcto = true;
            } else if (auxiliar.equals(MASC)) {
                sexoMasc = true;
                correcto = true;
            } else {
                System.err.println("\tError: Debe introducir " + FEM + " o " + MASC);
            }

        } while (!correcto);
        
        return sexoMasc;
    }

}
