package MODELOS;

import java.awt.Color;
import java.util.Date;

public class ConfigPantalla extends Configuracion {
    private Color color;

    public String getColor() {
        return "[r=" + color.getRed() + ",g=" + color.getGreen() + ",b=" + color.getBlue() + "]";
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ConfigPantalla(Color color, String titulo, Date fechaHora) {
        super(titulo, fechaHora);
        this.color = color;
    }

    public ConfigPantalla(String titulo) {
        super(titulo);
    }
    
}
