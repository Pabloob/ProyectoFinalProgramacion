package CONTROLADORES;

import MODELOS.ConfigPantalla;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.TreeSet;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GestorEstilosGUI {

    private TreeSet<ConfigPantalla> estilos = new TreeSet<>();
    Date hora = new Date();

    public void añadirEjemplos() {

        ConfigPantalla c1 = new ConfigPantalla(Color.WHITE,  Color.BLACK, "CLARO", hora);
        ConfigPantalla c2 = new ConfigPantalla(Color.BLACK,  Color.WHITE, "OSCURO", hora);

        estilos.add(c1);
        estilos.add(c2);

    }

    public void añadir(String titulo, Color colorFondo, Color colorTexto) {

        ConfigPantalla config = new ConfigPantalla(colorFondo, colorTexto, titulo.toUpperCase(), hora);
        estilos.add(config);

    }

    public void borrar(String nombre) {

        estilos.remove(new ConfigPantalla(nombre));

    }

    public void cambiarColorFondo(JPanel[] paneles, Color color) {

        for (JPanel panel : paneles) {
            panel.setBackground(color);
        }

    }

    public void cambiarColorTexto(JLabel[] textos, Color color) {

        for (JLabel texto : textos) {
            texto.setForeground(color);
        }

    }
    
    public Color conseguirColor(String rgbColor) {
        Color color;
        int r, g, b;
        String[] rgb = rgbColor.replaceAll("[^0-9,]", "").split(",");
        r = Integer.parseInt(rgb[0]);
        g = Integer.parseInt(rgb[1]);
        b = Integer.parseInt(rgb[2]);

        return color = new Color(r, g, b);
    }

    public Color buscarColor(String titulo, int colorBuscar,String nomArchivoEstilos,Object[][]datosEstilos) {
        int r, g, b;
        Color color = null;
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(nomArchivoEstilos);
            ois = new ObjectInputStream(fis);
            datosEstilos = (Object[][]) ois.readObject();
            for (Object[] dato : datosEstilos) {
                String tituloArchivo = (String) dato[0];
                if (titulo.equalsIgnoreCase(tituloArchivo)) {
                    String rgbColor = (String) dato[colorBuscar];
                    String[] rgb = rgbColor.replaceAll("[^0-9,]", "").split(",");
                    r = Integer.parseInt(rgb[0]);
                    g = Integer.parseInt(rgb[1]);
                    b = Integer.parseInt(rgb[2]);
                    color = new Color(r, g, b);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return color;
    }

    public Object[][] convertirAMatrizObjetos() {
        Object[][] matrizObjeto = new Object[estilos.size()][5];
        int id = 0;
        for (ConfigPantalla conf : this.estilos) {
            matrizObjeto[id][0] = conf.getTitulo();
            matrizObjeto[id][1] = conf.getColorFondo();
            matrizObjeto[id][2] = conf.getColorTexto();
            matrizObjeto[id][3] = conf.getFechaHora();
            id++;
        }
        return matrizObjeto;
    }

}
