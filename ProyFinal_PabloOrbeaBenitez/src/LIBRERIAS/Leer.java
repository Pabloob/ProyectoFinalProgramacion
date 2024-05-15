package LIBRERIAS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Leer {

    public static int leerEntero(String msj) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int valor = 0;
        String auxiliar;
        boolean correcto;
        do {
            correcto = false;
            System.out.print(msj);
            try {
                auxiliar = teclado.readLine().strip();
                valor = Integer.parseInt(auxiliar);
                correcto = true;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error introduce una opcion valida");
            }
        } while (!correcto);
        return valor;
    }

    public static int leerEnteroMayorACero(String msj) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int valor = 0;
        String auxiliar;
        boolean correcto;
        do {
            correcto = false;
            System.out.print(msj);
            try {
                auxiliar = teclado.readLine().strip();
                valor = Integer.parseInt(auxiliar);
                if (valor > 0) {
                    correcto = true;
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error introduce una opcion valida");
            }
        } while (!correcto);
        return valor;
    }

    public static int leerEnetroEntreXeY(String msj, int x, int y) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int valor = 0;
        String auxiliar;
        boolean correcto;
        do {
            correcto = false;
            System.out.print(msj);
            try {
                auxiliar = teclado.readLine().strip();
                valor = Integer.parseInt(auxiliar);
                if (valor >= x && valor <= y) {
                    correcto = true;
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error introduce una opcion valida");
            }

        } while (!correcto);
        return valor;
    }

    public static float leerDecimal(String msj) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        float valor = 0;
        String auxiliar;
        boolean correcto;
        do {
            correcto = false;
            System.out.print(msj);
            try {
                auxiliar = teclado.readLine().strip();
                valor = Float.parseFloat(auxiliar);
                correcto = true;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error introduce una opcion valida");
            }
        } while (!correcto);
        return valor;
    }

    public static float leerDecimalMayorACero(String msj) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        float valor = 0;
        String auxiliar;
        boolean correcto;
        do {
            correcto = false;
            System.out.print(msj);
            try {
                auxiliar = teclado.readLine().strip();
                valor = Float.parseFloat(auxiliar);
                if (valor > 0) {
                    correcto = true;
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error introduce una opcion valida");
            }
        } while (!correcto);
        return valor;
    }

    public static float leerDecimalEntreXeY(String msj, int x, int y) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        float valor = 0;
        String auxiliar;
        boolean correcto;
        do {
            correcto = false;
            System.out.print(msj);
            try {
                auxiliar = teclado.readLine().strip();
                valor = Float.parseFloat(auxiliar);
                if (valor >= x && valor <= y) {
                    correcto = true;
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error introduce una opcion valida");
            }

        } while (!correcto);
        return valor;
    }

    public static char leerLetra(String msj) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        char letra = 0;
        boolean correcto;

        do {
            correcto = true;
            try {
                System.out.print(msj);
                String valor = teclado.readLine().strip();
                if (valor.length() != 1) {
                    System.out.println("\tPor favor, introduce una letra válida");
                    correcto = false;
                } else {
                    letra = Character.toUpperCase(valor.charAt(0));
                }
            } catch (IOException e) {
                System.out.println("\tError al leer la entrada. Introduce una letra válida");
                correcto = false;
            }
        } while (!correcto);

        return letra;
    }

    public static char leerLetraAZ(String msj) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        char letra = 0;
        boolean correcto;

        do {
            correcto = true;
            try {
                System.out.print(msj);
                String valor = teclado.readLine().strip();
                if (valor.length() != 1 || !Character.isLetter(valor.charAt(0))) {
                    System.out.println("\tPor favor, introduce una letra válida");
                    correcto = false;
                } else {
                    letra = Character.toUpperCase(valor.charAt(0));
                }
            } catch (IOException e) {
                System.out.println("\tError al leer la entrada. Introduce una letra válida");
                correcto = false;
            }
        } while (!correcto);

        return letra;
    }

    public static String leerCadena(String msj) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String valor;
        System.out.print(msj);
        valor = teclado.readLine().strip();
        return valor;
    }

    public static String leerCadenaNoVacía(String msj) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String valor;
        boolean correcto;
        do {
            correcto = false;
            System.out.print(msj);
            valor = teclado.readLine().strip();
            if (!valor.isEmpty()) {
                correcto = true;
            }else{
                            System.err.println("\tError: No has introducido ningun dato");
            }
        } while (!correcto);
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
    
    //Metodo que lee un numero de telefono hasta que tenga 9 cifras
    public static String leerNumeroTelefono(String msj) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String valor = null;
        boolean correcto;
        do {
            correcto = true;
            System.out.print(msj);
            try {
                valor = teclado.readLine().trim().replaceAll("\\s", "");
                if (valor.length() != 9) {
                    System.out.println("\tIntroduce un numero de telefono con sus 9 digitos");
                    correcto = false;
                }
            } catch (IOException e) {
                correcto = false;
                System.out.println("Error introduce una opcion valida");
            }

        } while (correcto);
        return valor;
    }

    
}