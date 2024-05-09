package CONTROLADORES;

import MODELOS.Producto;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GestorBDR {

    private Connection conexion;

    public void conectarBDR(String url, String usuario, String clave) {
        try {
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException e) {
        }
    }

    public void desconectarBDR() {
        try {
            conexion.close();
        } catch (SQLException e) {
        }
    }

    public boolean añadirProducto(Producto producto) {
        PreparedStatement preparedStatement = null;
        String SQL_AGREGAR = "INSERT INTO productos (NOMBRE, PRECIO, CANTIDAD, IMAGEN) VALUES (?, ?, ?, ?)";
        try {
            preparedStatement = conexion.prepareStatement(SQL_AGREGAR);
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setFloat(2, producto.getPrecio());
            preparedStatement.setInt(3, producto.getCantidad());

            if (producto.getImagen() != null) {
                preparedStatement.setBytes(4, producto.getImagen());
            } else {
                preparedStatement.setNull(4, 0);
            }

            int filasAfectadas = preparedStatement.executeUpdate();
            return (filasAfectadas > 0);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean borrarProductoPorNombre(String nombre) {
        try {
            Statement sentencia = conexion.createStatement();
            String sql = "DELETE FROM productos WHERE NOMBRE ='" + nombre + "'";
            int filasAfectadas = sentencia.executeUpdate(sql);
            return filasAfectadas > 0;
        } catch (SQLException e) {
            return false;
        }
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
                producto.setImagen(rs.getBytes("IMAGEN"));
                datos.add(producto);
            }

        } catch (Exception e) {
            return null;
        }

        return datos;
    }

    public boolean guardarProductosEnFichero(Object[][] datos, String nomArchivo) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(nomArchivo); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(datos);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean cargarProductosDeFichero(String nomArchivo) throws ClassNotFoundException, IOException {
        try (FileInputStream fis = new FileInputStream(nomArchivo); ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object[][] datos = (Object[][]) ois.readObject();
            for (Object[] dato : datos) {
                Producto producto = new Producto();
                producto.setNombre((String) dato[0]);
                producto.setPrecio(Float.parseFloat(dato[1].toString()));
                producto.setCantidad(Integer.parseInt(dato[2].toString()));
                producto.setImagen(jLbalelABytes((JLabel) dato[3]));
                añadirProducto(producto);
            }
            return true;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public byte[] jLbalelABytes(JLabel jlbl) {

        try {
            ImageIcon icono = (ImageIcon) jlbl.getIcon();
            Image imagen = icono.getImage();
            BufferedImage bufferedImage = new BufferedImage(imagen.getWidth(null), imagen.getHeight(null), BufferedImage.TYPE_INT_RGB);
            Graphics g = bufferedImage.getGraphics();
            g.drawImage(imagen, 0, 0, null);
            g.dispose();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            byte[] bytesImagen = baos.toByteArray();
            return bytesImagen;
        } catch (Exception e) {
            return null;
        }

    }

    public Object[][] ordenarNombre(Object[][] datos) {
        Comparator<Object[]> comparador = new Comparator<Object[]>() {
            @Override
            public int compare(Object[] fila1, Object[] fila2) {
                String nombre1 = (String) fila1[0];
                String nombre2 = (String) fila2[0];
                return nombre1.compareTo(nombre2);
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
}
