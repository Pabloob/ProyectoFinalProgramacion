package LIBRERIAS;

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
    
}
