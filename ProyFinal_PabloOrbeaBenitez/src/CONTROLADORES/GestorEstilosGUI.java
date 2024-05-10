package CONTROLADORES;

import LIBRERIAS.MisUtiles;
import MODELOS.ConfigPantalla;
import java.awt.Color;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.TreeSet;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GestorEstilosGUI {

    private TreeSet<ConfigPantalla> estilos = new TreeSet<>();
    private Date hora = new Date();

    public boolean añadirEjemplosEstilos() {
        boolean correcto = false;

        try {
            ConfigPantalla c1 = new ConfigPantalla(0, "Pablo", "CLARO", Color.WHITE, Color.BLACK, hora);
            ConfigPantalla c2 = new ConfigPantalla(1, "Prueba", "OSCURO", Color.BLACK, Color.WHITE, hora);

            estilos.add(c1);
            estilos.add(c2);
            correcto = true;
        } catch (Exception e) {
        }
        return correcto;

    }

    public boolean añadirEstilo(int id, String usr, String titulo, Color colorFondo, Color colorTexto) {
        boolean correcto = false;
        try {
            ConfigPantalla config = new ConfigPantalla(id, usr, titulo.toUpperCase(), colorFondo, colorTexto, hora);
            estilos.add(config);
            correcto = true;
        } catch (Exception e) {
        }
        return correcto;

    }

    public boolean borrarEstilo(String nombre) {
        boolean correcto = false;
        try {
            for (ConfigPantalla estilo : estilos) {
                System.out.println(estilo.getTitulo());
            }

            System.out.println(nombre);
            estilos.remove(new ConfigPantalla(nombre));
            correcto = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return correcto;
    }

    public boolean cambiarColorFondo(JPanel[] paneles, Color color) {
        boolean correcto = false;
        try {
            for (JPanel panel : paneles) {
                panel.setBackground(color);
            }
            correcto = true;
        } catch (Exception e) {
        }
        return correcto;
    }

    public boolean cambiarColorTexto(JLabel[] textos, Color color) {
        boolean correcto = false;
        try {
            for (JLabel texto : textos) {
                texto.setForeground(color);
            }
            correcto = true;
        } catch (Exception e) {
        }
        return correcto;
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
        Color color = null;
        if (titulo != null) {
            int r, g, b;

            FileInputStream fis;
            ObjectInputStream ois;
            try {
                fis = new FileInputStream(nomArchivoEstilos);
                ois = new ObjectInputStream(fis);
                datosEstilos = (Object[][]) ois.readObject();
                for (Object[] dato : datosEstilos) {
                    String tituloArchivo = (String) dato[1];
                    if (titulo.equalsIgnoreCase(tituloArchivo)) {
                        String rgbColor = (String) dato[colorBuscar];
                        String[] rgb = rgbColor.replaceAll("[^0-9,]", "").split(",");
                        r = Integer.parseInt(rgb[0]);
                        g = Integer.parseInt(rgb[1]);
                        b = Integer.parseInt(rgb[2]);
                        color = new Color(r, g, b);
                    }
                }
            } catch (IOException | ClassNotFoundException | NumberFormatException e) {
            }
        }
        return color;
    }

    public Object[][] convertirListaADTM() {
        Object[][] matrizObjeto = new Object[estilos.size()][6];
        int id = 0;
        for (ConfigPantalla conf : this.estilos) {
            matrizObjeto[id][0] = conf.getID();
            matrizObjeto[id][1] = conf.getTitulo();
            matrizObjeto[id][2] = conf.getUsuarioCrea();
            matrizObjeto[id][3] = conf.getColorFondo();
            matrizObjeto[id][4] = conf.getColorTexto();
            matrizObjeto[id][5] = conf.getFechaHora();
            id++;
        }
        return matrizObjeto;
    }

    public boolean cargarEstilosDeFicheroXML(String nomArchivo) {
        boolean correcto = false;

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
                int id = (int) dato[1];
                String usr = (String) dato[2];
                Color colorTexto = conseguirColorPorRGB((String) dato[3]);
                Color colorFondo = conseguirColorPorRGB((String) dato[4]);
                añadirEstilo(id, usr, titulo, colorFondo, colorTexto);
            }
            correcto = true;
        } catch (FileNotFoundException e) {
        }
        return correcto;
    }

    public boolean guardarEstilosEnFicheroXML(Object[][] datos, String nomArchivo) {
        boolean correcto = false;

        FileOutputStream fos;
        XMLEncoder xmle;

        try {
            fos = new FileOutputStream(nomArchivo);
            xmle = new XMLEncoder(new BufferedOutputStream(fos));
            xmle.writeObject(datos);
            xmle.close();
            correcto = true;
        } catch (FileNotFoundException e) {
        }
        return correcto;
    }

}
