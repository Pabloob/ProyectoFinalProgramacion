package CONTROLADORES;

import MODELOS.ConfigPantalla;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GestorEstilosGUI {

    private TreeSet<ConfigPantalla> estilos = new TreeSet<>();
    private Date hora = new Date();
    private SimpleDateFormat formato = new SimpleDateFormat("d-M-y HH:mm");

    /**
     * Se añaden dos ejemplos de estilos
     *
     * @return Se devuelve si se han añadido correctamente
     */
    public boolean añadirEjemplosEstilos(String usr) {
        boolean correcto = false;

        try {
            ConfigPantalla c1 = new ConfigPantalla(0, usr, "CLARO", Color.WHITE, Color.BLACK, formato.format(hora));
            ConfigPantalla c2 = new ConfigPantalla(1, usr, "OSCURO", Color.BLACK, Color.WHITE, formato.format(hora));

            estilos.add(c1);
            estilos.add(c2);
            correcto = true;
        } catch (Exception e) {
        }
        return correcto;

    }

    /**
     * Metodo sobrecargado Se añade un estilo con los datos de el estilo como
     * parametro y la fecha de cuando se ha añadido o modificado
     *
     * @param id
     * @param usr
     * @param titulo
     * @param colorFondo
     * @param colorTexto
     * @return Se devuelve si se ha añadido correctamente
     */
    public boolean añadirEstilo(int id, String usr, String titulo, Color colorFondo, Color colorTexto) {
        boolean correcto = false;
        try {
            ConfigPantalla config = new ConfigPantalla(id, usr, titulo.toUpperCase(), colorFondo, colorTexto, formato.format(hora));
            estilos.add(config);
            correcto = true;
        } catch (Exception e) {
        }
        return correcto;
    }

    /**
     * Metodo sobrecargado Se añade un estilo con los datos de el estilo como
     * parametro incluida la fecha
     *
     * @param id
     * @param usr
     * @param titulo
     * @param colorFondo
     * @param colorTexto
     * @param fechaEstilo
     * @return Se devuelve si se ha añadido correctamente
     */
    public boolean añadirEstilo(int id, String usr, String titulo, Color colorFondo, Color colorTexto, String fechaEstilo) {
        boolean correcto = false;
        try {
            ConfigPantalla config = new ConfigPantalla(id, usr, titulo.toUpperCase(), colorFondo, colorTexto, fechaEstilo);
            estilos.add(config);
            correcto = true;
        } catch (Exception e) {
        }
        return correcto;
    }

    /**
     * Se borra un estilo por nombre
     *
     * @param nombre
     * @return Se devuelve si se ha borrado correctamente
     */
    public boolean borrarEstilo(String nombre) {
        boolean correcto = false;
        try {
            estilos.remove(new ConfigPantalla(nombre));
            correcto = true;
        } catch (Exception e) {
        }
        return correcto;
    }

    /**
     * Metodo sobrecargado
     * Se cambia el color de los paneles recibidos como parametro y el color
     * @param paneles
     * @param color
     * @return Se devuelve si se ha cambiado el color correctamente
     */
    public boolean cambiarColor(JPanel[] paneles, Color color) {
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

    /**
     * Metodo sobrecargado
     * Se cambia el color de los textos recibidos como parametro y el color
     * @param textos
     * @param color
     * @return Se devuelve si se ha cambiado el color correctamente
     */
    public boolean cambiarColor(JLabel[] textos, Color color) {
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

    /**
     * Se consigue el color de un parametro rgb haciendo un split de las partes r,g,b y sacando solamente los numeros
     * @param rgbColor
     * @return Se devuelve el color
     */
    public Color conseguirColorPorRGB(String rgbColor) {
        Color color;
        int r, g, b;
        String[] rgb = rgbColor.replaceAll("[^0-9,]", "").split(",");
        r = Integer.parseInt(rgb[0]);
        g = Integer.parseInt(rgb[1]);
        b = Integer.parseInt(rgb[2]);
        color = new Color(r, g, b);
        return color;
    }

    /**
     * Se busca un color en un fichero por su nombre con la posicion en el array que ocupa el color en el array
     * @param titulo
     * @param indice
     * @param nomArchivoEstilos
     * @param datosEstilos
     * @return Se devuelve el color
     */
    public Color buscarColorEnFichero(String titulo, int indice, String nomArchivoEstilos, Object[][] datosEstilos) {
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
                    String tituloArchivo = (String) dato[2];
                    if (titulo.equalsIgnoreCase(tituloArchivo)) {
                        String rgbColor = (String) dato[indice];
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

    /**
     * Se convierten los datos de la lista a array[][] con un iterador
     * @return Se devuelve el array[][]
     */
    public Object[][] convertirListaADTM() {
        Object[][] matrizObjeto = new Object[estilos.size()][6];
        Iterator<ConfigPantalla> iterator = estilos.iterator();
        int id = 0;
        while (iterator.hasNext()) {
            ConfigPantalla conf = iterator.next();
            matrizObjeto[id][0] = conf.getID();
            matrizObjeto[id][1] = conf.getUsuarioCrea();
            matrizObjeto[id][2] = conf.getTitulo();
            matrizObjeto[id][3] = conf.getColorFondo();
            matrizObjeto[id][4] = conf.getColorTexto();
            matrizObjeto[id][5] = conf.getFechaHora();
            id++;
        }
        return matrizObjeto;
    }

    /**
     * Se vacian todos los datos de la lista
     */
    public void vaciar() {
        estilos.removeAll(estilos);
    }

}