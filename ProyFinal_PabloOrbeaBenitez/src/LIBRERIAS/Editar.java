package LIBRERIAS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Editar {
    //Estos metodos piden el valor antiguo que es el valor que tenia el contacto anteriormente
    //Y si el usuario no introduce nada coge este valor
    
    //Metodo que lee una cadena
     public static String leerCadena(String msj,String antiguoValor, int maxCaracteres) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String valor;
        boolean correcto;
        do {
            correcto = false;
            System.out.print(msj);
            valor = teclado.readLine().trim().replaceAll("\\s", "");
            if (valor.isEmpty()) {
                return antiguoValor;
            } else if (valor.length() > maxCaracteres) {
                correcto = true;
                System.out.println("\tEl nombre no puede tener mas de "+ maxCaracteres + " caracteres");
            }
        } while (correcto);
        return valor;
    }

    //Metodo que lee un numero de telefono de 9 digitos
    public static String leerNumeroTelefono(String msj, String valorAntiguo) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String valor = null;
        boolean correcto;
        do {
            correcto = false;
            System.out.print(msj);
            try {
                valor = teclado.readLine().trim();
                if (valor.isEmpty()) {
                    return valorAntiguo;
                }
                if (valor.length()!=9) {
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
    public static String leerEmail(String msj, String valorAntiguo) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader teclado = new BufferedReader(flujo);
        String valor = "";
        boolean emailOK;
        boolean correcto = false;

        do {
            System.out.print(msj);
            valor = teclado.readLine().trim();
            if (valor.isEmpty()) {
                return valorAntiguo;
            }
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

    //Metodo que lee un numero 
    public static int leerNumero(String msj, int valorAntiguo) throws IOException {
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
                if (auxiliar.isEmpty()) {
                    return valorAntiguo;
                }
                valor = Integer.parseInt(auxiliar);
            } catch (IOException | NumberFormatException e) {
                correcto = true;
                System.out.println("Error introduce una opcion valida");
            }

        } while (correcto);
        return valor;
    }

    //Metodo que lee un decimal
    public static float leerDeciaml(String msj, float valorAntiguo) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        float valor = 0;
        String auxiliar;
        boolean correcto;
        do {
            correcto = false;
            System.out.print(msj);
            try {
                auxiliar = teclado.readLine().trim();
                if (auxiliar.isEmpty()) {
                    return valorAntiguo;
                }
                valor = Float.parseFloat(auxiliar);
            } catch (IOException | NumberFormatException e) {
                correcto = true;
                System.out.println("Error introduce una opcion valida");
            }

        } while (correcto);
        return valor;
    }

    //Metodo que lee un booleano
    public static boolean leerBoolean(String msj, String valor1, String valor2, boolean valorAntiguo) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
    
        boolean correcto = false;
        boolean confirmar = valorAntiguo;
    
        do {
            System.out.print(msj);
            String auxiliar = teclado.readLine().toLowerCase().trim();
    
            if (auxiliar.isEmpty()) {
                return valorAntiguo;
            }
    
            if (auxiliar.equals(valor1) || auxiliar.equals(valor2)) {
                correcto = true;
                confirmar = auxiliar.equals(valor1);
            } else {
                System.err.println("\tError: Debe introducir " + valor1 + " o " + valor2 );
            }
    
        } while (!correcto);
    
        return confirmar;
    }
    
}
