package CONTROLADORES;

import MODELOS.ConfigPantalla;
import java.awt.Color;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.TreeSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class GestorEstilosGUI {

    private TreeSet<ConfigPantalla> estilos = new TreeSet<>();
    private Date hora = new Date();

    public void añadirEjemplosEstilos() {

        ConfigPantalla c1 = new ConfigPantalla(Color.WHITE, Color.BLACK, "CLARO", hora);
        ConfigPantalla c2 = new ConfigPantalla(Color.BLACK, Color.WHITE, "OSCURO", hora);

        estilos.add(c1);
        estilos.add(c2);

    }

    public void añadirEstilo(String titulo, Color colorFondo, Color colorTexto) {

        ConfigPantalla config = new ConfigPantalla(colorFondo, colorTexto, titulo.toUpperCase(), hora);
        estilos.add(config);

    }

    public void borrarEstilo(String nombre) {

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

    public Color conseguirColorPorRGB(String rgbColor) {
        Color color;
        int r, g, b;
        String[] rgb = rgbColor.replaceAll("[^0-9,]", "").split(",");
        r = Integer.parseInt(rgb[0]);
        g = Integer.parseInt(rgb[1]);
        b = Integer.parseInt(rgb[2]);

        return color = new Color(r, g, b);
    }

    public Color buscarColorEnFichero(String titulo, int colorBuscar, String nomArchivoEstilos, Object[][] datosEstilos) {
        if (titulo != null) {
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
                return color;
            } catch (IOException | ClassNotFoundException | NumberFormatException e) {
            }
        }
        return null;
    }

    public Object[][] convertirListaADTM() {
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

    public boolean cargarEstilosDeFicheroXML(String nomArchivo) {

        FileInputStream fis;
        XMLDecoder xmld;
        Object[][] datos;
        try {
            fis = new FileInputStream(nomArchivo);
            xmld = new XMLDecoder(fis);
            datos = (Object[][]) xmld.readObject();
            xmld.close();
            for (Object[] dato : datos) {
                String titulo = (String) dato[0];
                Color colorFondo = conseguirColorPorRGB((String) dato[1]);
                Color colorTexto = conseguirColorPorRGB((String) dato[2]);
                añadirEstilo(titulo, colorFondo, colorTexto);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean guardarEstilosEnFicheroXML(Object[][] datos, String nomArchivo) {

        FileOutputStream fos;
        XMLEncoder xmle;

        try {
            fos = new FileOutputStream(nomArchivo);
            xmle = new XMLEncoder(new BufferedOutputStream(fos));
            xmle.writeObject(datos);
            xmle.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
