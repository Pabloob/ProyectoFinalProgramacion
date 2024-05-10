package LIBRERIAS;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MisUtiles {

    public static int comprobarIntPositivo(String num) {
        int numero = -1;
            try {
                numero = Integer.parseInt(num.trim());
                if (numero <= 0) {
                    numero = -1;
                }
            } catch (Exception e) {
            }
        return numero;
    }

    public static float comprobarFloatPositivo(String num) {
        float numero=-1;

            try {
                numero = Float.parseFloat(num.trim());
                if (numero <= 0) {
                    numero = -1;
                }
            } catch (Exception e) {
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
            } catch (Exception ex) {
                return null;
            }
        } else {
            return null;
        }
    }
    
    public static int calcularNumMayor(Object datos[][],int posNum){
        
        int num = 0;
        for (Object numero [] : datos) {
            int tempNum = (int) numero[posNum];
            if (num == tempNum) {
                num++;
            }
        }
        return num;
    }
    
}
