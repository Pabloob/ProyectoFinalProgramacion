package CONTROLADORES;

import MODELOS.Producto;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Comparator;

public class GestorBDR {

    private Connection conexion;

    public void conectar(String url, String usuario, String clave) {
        try {
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void desconectar() {
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public byte[] getImagen(String Ruta) {
        File imagen = new File(Ruta);
        try {
            byte[] icono = new byte[(int) imagen.length()];
            InputStream input = new FileInputStream(imagen);
            input.read(icono);
            return icono;
        } catch (Exception ex) {
            return null;
        }
    }

    public void añadir(Producto producto) throws FileNotFoundException, IOException {
        Statement sentencia;
        String sql;

        try {
            sentencia = conexion.createStatement();

            sql = "INSERT INTO productos (NOMBRE, PRECIO, CANTIDAD, IMAGEN) VALUES"
                    + "('" + producto.getNombre() + "', '" + producto.getPrecio() + "', '" + producto.getCantidad() + "','" + producto.getImagen() + "');";
            sentencia.executeUpdate(sql);

        } catch (SQLException e) {
            e.getMessage();
            e.getSQLState();
            e.getErrorCode();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

    }

    public boolean borrarNombre(String nombre) {
        try {
            Statement sentencia = conexion.createStatement();
            String sql = "DELETE FROM productos WHERE NOMBRE ='" + nombre + "'";
            int filasAfectadas = sentencia.executeUpdate(sql);
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void vaciar() {
        Statement sentencia;
        String sql;
        try {
            sentencia = conexion.createStatement();

            sql = "DELETE FROM productos;";

            sentencia.executeUpdate(sql);

        } catch (SQLException e) {
            e.getMessage();
            e.getSQLState();
            e.getErrorCode();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

//    public Producto[] getProductos() {
//        Producto[] productos = null;
//        Statement sentencia;
//        ResultSet rs;
//        try {
//            sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            rs = sentencia.executeQuery("SELECT * FROM productos");
//
//            rs.last();
//            int numRows = rs.getRow();
//            rs.beforeFirst();
//
//            productos = new Producto[numRows];
//            int indice = 0;
//
//            while (rs.next()) {
//                String nombre = rs.getString("NOMBRE");
//                int precio = rs.getInt("PRECIO");
//                int cantidad = rs.getInt("CANTIDAD");
//                byte icono[] = rs.getBytes("IMAGEN");
//
//                Producto producto = new Producto();
//                producto.setNombre(nombre);
//                producto.setPrecio(precio);
//                producto.setCantidad(cantidad);
//                producto.setImagen(icono);
//                
//                productos[indice] = producto;
//
//                indice++;
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//        return productos;
//    }

    public Object[][] convertir() {
        Object[][] datos = null;
        Statement sentencia;
        ResultSet rs;
        try {
            sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = sentencia.executeQuery("SELECT * FROM productos");

            rs.last();
            int numRows = rs.getRow();
            rs.beforeFirst();

            datos = new Object[numRows][4];
            int indice = 0;

            while (rs.next()) {
                String nombre = rs.getString("NOMBRE");
                int precio = rs.getInt("PRECIO");
                int cantidad = rs.getInt("CANTIDAD");
                byte img [] = rs.getBytes("IMAGEN");
                datos[indice][0] = nombre;
                datos[indice][1] = precio;
                datos[indice][2] = cantidad;
                datos[indice][3] = img;
                indice++;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }
    
    public byte [] getByte (){
    byte[] img = null;
        Statement sentencia;
        ResultSet rs;
        try {
            sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = sentencia.executeQuery("SELECT * FROM productos");

            rs.last();
            int numRows = rs.getRow();
            rs.beforeFirst();

            img = new byte[4];
            int indice = 0;

            while (rs.next()) {
                img  = rs.getBytes("IMAGEN");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return img;
    }
    
    public void guardarEnFichero(Object[][] datos, String nomArchivo) throws IOException {

        FileOutputStream fos;
        XMLEncoder xmle;

        try {
            fos = new FileOutputStream(nomArchivo);
            xmle = new XMLEncoder(new BufferedOutputStream(fos));
            xmle.writeObject(datos);
            xmle.close();
        } catch (Exception e) {
        }

    }

    public void cargarDeFichero(String nomArchivo) throws ClassNotFoundException, IOException {

        FileInputStream fis;
        XMLDecoder xmld;
        Object[][] datos = null;
        try {
            fis = new FileInputStream(nomArchivo);
            xmld = new XMLDecoder(fis);
            datos = (Object[][]) xmld.readObject();
            xmld.close();
        } catch (Exception e) {
        }

        for (Object[] dato : datos) {
            String nombre = dato[0].toString();
            int precio = Integer.parseInt(dato[1].toString());
            int cantidad = Integer.parseInt(dato[2].toString());
            byte icono[] = (byte[]) dato[3];
            Producto producto = new Producto(nombre, precio, cantidad, icono);
            añadir(producto);
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
                Integer precio1 = (Integer) fila1[1];
                Integer precio2 = (Integer) fila2[1];
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
