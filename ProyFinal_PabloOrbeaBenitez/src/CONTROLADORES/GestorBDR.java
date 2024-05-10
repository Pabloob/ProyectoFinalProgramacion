package CONTROLADORES;

import MODELOS.Producto;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
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

            if (producto.getImagen() != null) {
                preparedStatement.setBytes(4, producto.getImagen());
            } else {
                preparedStatement.setNull(4, 0);
            }

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
                producto.setImagen(rs.getBytes("IMAGEN"));
                datos.add(producto);
            }

        } catch (Exception e) {
        }

        return datos;
    }

    public boolean guardarProductosEnFichero(Object[][] datos, String nomArchivo) throws IOException {
        boolean correcto = false;
        try (FileOutputStream fos = new FileOutputStream(nomArchivo); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(datos);
            correcto = true;
        } catch (IOException e) {
        }
        return correcto;
    }

    public boolean cargarProductosDeFichero(String nomArchivo) throws ClassNotFoundException, IOException {
        boolean correcto = false;
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
            correcto = true;
        } catch (ClassNotFoundException | IOException e) {
        }
        return correcto;
    }

    public byte[] jLbalelABytes(JLabel jlbl) {
        byte[] bytesImagen = null;
        try {
            ImageIcon icono = (ImageIcon) jlbl.getIcon();
            Image imagen = icono.getImage();
            BufferedImage bufferedImage = new BufferedImage(imagen.getWidth(null), imagen.getHeight(null), BufferedImage.TYPE_INT_RGB);
            Graphics g = bufferedImage.getGraphics();
            g.drawImage(imagen, 0, 0, null);
            g.dispose();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            bytesImagen = baos.toByteArray();
        } catch (Exception e) {
        }
        return bytesImagen;
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
}
