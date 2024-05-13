package CONTROLADORES;

import MODELOS.Producto;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GestorBDR {
    
    private Connection conexion;
    
    /**
     * Se conecta con la BDR por recibiendo una ruta de fichero como parametro separando las partes de usuario, clave y url
     * @param fichero
     * @return Se devuelve si la conecxion se ha realizado correctamente o hay algun error
     */
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

    /**
     * Se cierra la conecxion con la base de datos
     * @return 
     */
    public boolean desconectarBDR() {
        boolean correcto = false;
        try {
            conexion.close();
            correcto = true;
        } catch (SQLException e) {

        }
        return correcto;
    }
    
    /**
     * Se añade un producto a la BDR recibiendo un producto como parametro y añadiendo los valores de este
     * @param producto
     * @return Se devuelve si se ha añadido correctamente el producto
     */
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
    
    /**
     * Se borra un producto eliminandolo por su nombre 
     * @param nombre
     * @return se devuelve si se ha borrado correctamente
     */
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

    /**
     * Se convierten los datos de la BDR a un arraylist
     * @return Se devuelve el arraylist con los datos de la BDR
     */
    public ArrayList convertirBDRALista() {
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

        } catch (SQLException e) {
        }

        return datos;
    }

    /**
     * Se añaden a la BDR los productos de un fichero xml a traves de la ruta
     * @param nomArchivo
     * @return se devuelve si los datos han sido cargados correctamente
     */
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
        }
        return correcto;
    }
    
    /**
     * Se guardan los productos en un fichero XML con los datos de el array[][] y la ruta del archivo
     * @param datos
     * @param nomArchivo
     * @return Se devuelve si se han guardado correctamente los datos
     */
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
        }
        return correcto;
    }

}