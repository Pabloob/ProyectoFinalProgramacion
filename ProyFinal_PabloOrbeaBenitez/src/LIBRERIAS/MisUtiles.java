package LIBRERIAS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

public class MisUtiles {

    public static int comprobarIntPositivo(String num) {
        int numero = -1;
        try {
            numero = Integer.parseInt(num.strip());
            if (numero <= 0) {
                numero = -1;
            }
        } catch (NumberFormatException e) {

        }
        return numero;
    }

    public static float comprobarFloatPositivo(String num) {
        float numero = -1;

        try {
            numero = Float.parseFloat(num.strip());
            if (numero <= 0) {
                numero = -1;
            }
        } catch (NumberFormatException e) {

        }
        return numero;
    }

    public static byte[] conseguirImagenPorRuta(String Ruta) {
        if (Ruta != null) {
            File imagen = new File(Ruta);
            try {
                byte[] icono = new byte[(int) imagen.length()];
                InputStream input = new FileInputStream(imagen);
                input.read(icono);
                return icono;
            } catch (IOException ex) {

                return null;
            }
        } else {
            return null;
        }
    }

    public static int calcularNumMayor(Object datos[][], int posNum) {

        int num = 0;
        for (Object numero[] : datos) {
            int tempNum = (int) numero[posNum];
            if (num == tempNum) {
                num++;
            }
        }
        return num;
    }

    public static Object[][] ordenarNombre(Object[][] datos) {
        Comparator<Object[]> comparador = new Comparator<Object[]>() {
            @Override
            public int compare(Object[] fila1, Object[] fila2) {
                String nombre1 = (String) fila1[0];
                String nombre2 = (String) fila2[0];
                return nombre1.toLowerCase().compareTo(nombre2.toLowerCase());
            }
        };
        Arrays.sort(datos, comparador);
        return datos;
    }

    public static Object[][] ordenarPrecio(Object[][] datos) {
        Comparator<Object[]> comparador = new Comparator<Object[]>() {
            @Override
            public int compare(Object[] fila1, Object[] fila2) {
                String precioStr1 = ((String) fila1[1]).replaceAll("[^\\d]", "");
                String precioStr2 = ((String) fila2[1]).replaceAll("[^\\d]", "");
                Float precio1 = Float.valueOf(precioStr1);
                Float precio2 = Float.valueOf(precioStr2);
                return precio1.compareTo(precio2);
            }
        };
        Arrays.sort(datos, comparador);
        return datos;
    }

    public static Object[][] ordenarCantidad(Object[][] datos) {
        Comparator<Object[]> comparador = new Comparator<Object[]>() {
            @Override
            public int compare(Object[] fila1, Object[] fila2) {
                Integer cantidad1 = (Integer) fila1[2];
                Integer cantidad2 = (Integer) fila2[2];
                return cantidad1.compareTo(cantidad2);
            }
        };

        Arrays.sort(datos, comparador);
        return datos;
    }

    public static String copiarImagen(String nombreFich, String directorioCopiar) {
        String[] partes = nombreFich.split("\\\\");
        String nombreArchivo = partes[partes.length - 1];
        String[] partesNombre = nombreArchivo.split("\\.");
        String nombreSinExtension = partesNombre[0];
        String extension = partesNombre[1];
        String rutaCopia = null;
        int numFoto = 1;
        try {
            File ficheroContenido = new File(nombreFich);

            if (ficheroContenido.exists()) {
                while (ficheroContenido.exists()) {
                    rutaCopia = directorioCopiar + nombreSinExtension + numFoto + "." + extension;
                    File ficheroCopia = new File(rutaCopia);
                    if (!ficheroCopia.exists()) {
                        break;
                    }
                    numFoto++;
                }
            } else {
                rutaCopia = directorioCopiar + nombreSinExtension + "." + extension;
            }

            FileOutputStream outputStream;
            try (FileInputStream inputStream = new FileInputStream(nombreFich)) {
                outputStream = new FileOutputStream(rutaCopia);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
            }
            outputStream.close();
        } catch (IOException e) {
        }
        return rutaCopia;
    }

    public static void borrarImagen(String ruta) {
        if (ruta != null) {
            File archivo = new File(ruta);
            archivo.delete();
        }
    }

    public static String arrayCharAString(char caracteresContraseña[]) {
        String contraseña = "";
        for (char c : caracteresContraseña) {
            contraseña = contraseña + c;
        }
        return contraseña.strip();
    }

    public void limpiarPantalla() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

}