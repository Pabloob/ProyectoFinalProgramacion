package MODELOS;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

public class ConfigPantalla extends Configuracion {

    private Color colorFondo;
    private Color colorTexto;

    public void setColorTexto(Color colorTexto) {
        this.colorTexto = colorTexto;
    }

    public String getColorTexto() {
        return "[r=" + colorTexto.getRed() + ",g=" + colorTexto.getGreen() + ",b=" + colorTexto.getBlue() + "]";
    }

    public void setColorFondo(Color colorFondo) {
        this.colorFondo = colorFondo;
    }

    public String getColorFondo() {
        return "[r=" + colorFondo.getRed() + ",g=" + colorFondo.getGreen() + ",b=" + colorFondo.getBlue() + "]";
    }

    public void setColor(Color color) {
        this.colorFondo = color;
    }

    public ConfigPantalla(Color colorFondo, Color colorTexto, String titulo, Date fechaHora) {
        super(titulo, fechaHora);
        this.colorFondo = colorFondo;
        this.colorTexto = colorTexto;
    }

    public ConfigPantalla(String titulo) {
        super(titulo);
    }

}
