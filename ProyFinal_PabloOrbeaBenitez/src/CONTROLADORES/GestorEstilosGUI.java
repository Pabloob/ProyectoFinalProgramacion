package CONTROLADORES;

import MODELOS.ConfigPantalla;
import java.awt.Color;
import java.util.Date;
import java.util.TreeSet;
import javax.swing.JPanel;

public class GestorEstilosGUI {

    private TreeSet<ConfigPantalla> estilos = new TreeSet<>();
    Date hora = new Date();

    public void añadirEjemplos() {

        ConfigPantalla c1 = new ConfigPantalla(Color.WHITE, "CLARO", hora);
        ConfigPantalla c2 = new ConfigPantalla(Color.BLACK, "OSCURO", hora);

        estilos.add(c1);
        estilos.add(c2);

    }

    public void añadir(String titulo, Color color) {

        ConfigPantalla config = new ConfigPantalla(color, titulo.toUpperCase(), hora);
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

    public Object[][] convertirAMatrizObjetos() {
        Object[][] matrizObjeto = new Object[estilos.size()][3];
        int id = 0;
        for (ConfigPantalla conf : this.estilos) {
            matrizObjeto[id][0] = conf.getTitulo();
            matrizObjeto[id][1] = conf.getColor();
            matrizObjeto[id][2] = conf.getFechaHora();
            id++;
        }
        return matrizObjeto;
    }

}
