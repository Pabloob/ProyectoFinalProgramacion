package CONTROLADORES;

import MODELOS.Producto;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GestorBDR {

    private Connection conexion;

    public boolean conectarPorFicheroBDR(String fichero) {
        boolean correcto = false;
        String url, usuario, clave;
        List<String> datosFichero = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fichero))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split("=");

                if (partes.length >= 2) {
                    datosFichero.add(partes[1].trim());
                }
            }
            usuario = datosFichero.get(0);
            clave = datosFichero.get(1);
            url = datosFichero.get(2);
            try {
                conexion = DriverManager.getConnection(url, usuario, clave);
                correcto = true;
            } catch (SQLException e) {
            }
        } catch (IOException e) {
        }

        return correcto;
    }

    public boolean desconectarBDR() {
        boolean correcto = false;
        try {
            conexion.close();
            correcto = true;
        } catch (SQLException e) {
        }
        return correcto;
    }

    public boolean añadirProducto(Producto producto) {
        PreparedStatement preparedStatement;
        String SQL_AGREGAR = "INSERT INTO productos (NOMBRE, PRECIO, CANTIDAD, IMAGEN) VALUES (?, ?, ?, ?)";
        boolean correcto = false;
        try {
            preparedStatement = conexion.prepareStatement(SQL_AGREGAR);
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setFloat(2, producto.getPrecio());
            preparedStatement.setInt(3, producto.getCantidad());
            preparedStatement.setString(4, producto.getrutaImagen());

            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                correcto = true;
            }
        } catch (SQLException ex) {
        }
        return correcto;
    }

    public boolean borrarProductoPorNombre(String nombre) {
        boolean correcto = false;
        try {
            Statement sentencia = conexion.createStatement();
            String sql = "DELETE FROM productos WHERE NOMBRE ='" + nombre + "'";
            int filasAfectadas = sentencia.executeUpdate(sql);
            if (filasAfectadas > 0) {
                correcto = true;
            }
        } catch (SQLException e) {
        }
        return correcto;
    }

    public ArrayList convertirBDRADTM() {
        ArrayList datos = new ArrayList();
        Statement sentencia;
        ResultSet rs;
        try {
            sentencia = conexion.createStatement();
            rs = sentencia.executeQuery("SELECT * FROM productos");

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setNombre(rs.getString("NOMBRE"));
                producto.setPrecio(rs.getFloat("PRECIO"));
                producto.setCantidad(rs.getInt("CANTIDAD"));
                producto.setrutaImagen(rs.getString("IMAGEN"));
                datos.add(producto);
            }

        } catch (Exception e) {
        }

        return datos;
    }

    public boolean cargarProductosDeFicheroXML(String nomArchivo) {
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
                Producto producto = new Producto();
                producto.setNombre((String) dato[0]);
                producto.setPrecio((float) dato[1]);
                producto.setCantidad((int) dato[2]);
                producto.setrutaImagen((String) dato[3]);

                añadirProducto(producto);
            }
            correcto = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return correcto;
    }

    public boolean guardarProductosEnFicheroXML(Object[][] datos, String nomArchivo) {
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
            e.printStackTrace();
        }
        return correcto;
    }

    public Object[][] ordenarNombre(Object[][] datos) {
        Comparator<Object[]> comparador = new Comparator<Object[]>() {
            @Override
            public int compare(Object[] fila1, Object[] fila2) {
                String nombre1 = (String) fila1[0];
                String nombre2 = (String) fila2[0];
                return nombre1.toLowerCase().compareTo(nombre2.toLowerCase());
            }
        };
        Arrays.sort(datos, comparador);
        return datos;
    }

    public Object[][] ordenarPrecio(Object[][] datos) {
        Comparator<Object[]> comparador = new Comparator<Object[]>() {
            @Override
            public int compare(Object[] fila1, Object[] fila2) {
                String precioStr1 = ((String) fila1[1]).replaceAll("[^\\d]", "");
                String precioStr2 = ((String) fila2[1]).replaceAll("[^\\d]", "");
                Float precio1 = Float.parseFloat(precioStr1);
                Float precio2 = Float.parseFloat(precioStr2);
                return precio1.compareTo(precio2);
            }
        };
        Arrays.sort(datos, comparador);
        return datos;
    }

    public Object[][] ordenarCantidad(Object[][] datos) {
        Comparator<Object[]> comparador = new Comparator<Object[]>() {
            @Override
            public int compare(Object[] fila1, Object[] fila2) {
                Integer cantidad1 = (Integer) fila1[2];
                Integer cantidad2 = (Integer) fila2[2];
                return cantidad1.compareTo(cantidad2);
            }
        };

        Arrays.sort(datos, comparador);
        return datos;
    }

    public String copiarImagen(String nombreFich) {
        String[] partes = nombreFich.split("\\\\");
        String nombreArchivo = partes[partes.length - 1];
        String[] partesNombre = nombreArchivo.split("\\.");
        String nombreSinExtension = partesNombre[0];
        String extension = partesNombre[1];
        String rutaCopia = null;
        int numFoto = 1;
        try {
            File ficheroContenido = new File(nombreFich);

            if (ficheroContenido.exists()) {
                while (ficheroContenido.exists()) {
                    rutaCopia = "IMAGENES\\" + nombreSinExtension + numFoto + "." + extension;
                    File ficheroCopia = new File(rutaCopia);
                    if (!ficheroCopia.exists()) {
                        break;
                    }
                    numFoto++;
                }
            } else {
                rutaCopia = "IMAGENES\\" + nombreSinExtension + "." + extension;
            }

            FileInputStream inputStream = new FileInputStream(nombreFich);
            FileOutputStream outputStream = new FileOutputStream(rutaCopia);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rutaCopia;
    }

    public void borrarImagen(String ruta) {
        if (ruta != null) {
            File archivo = new File(ruta);
            archivo.delete();
        }
    }
}
