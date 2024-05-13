package MODELOS;

import java.awt.Color;

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

    public ConfigPantalla(int ID, String UsuarioCrea, String titulo, Color colorFondo, Color colorTexto, String fechaHora) {
        super(titulo, ID, UsuarioCrea, fechaHora);
        this.colorFondo = colorFondo;
        this.colorTexto = colorTexto;
    }

    public ConfigPantalla(String titulo) {
        super(titulo);
    }

    public ConfigPantalla() {
    }

    @Override
    public void presentarInformacion() {
        String format = "%-5s%-15s%-15s%-20s%-20s%-30s%n";
        System.out.printf(format, "ID", "Usuario Creador", "Título", "Color de Fondo", "Color de Texto", "Fecha y Hora");
        System.out.printf(format, getID(), getUsuarioCrea(), getTitulo(), getColorFondo(), getColorTexto(), getFechaHora());
    }

    @Override
    public void presentarTabulado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}