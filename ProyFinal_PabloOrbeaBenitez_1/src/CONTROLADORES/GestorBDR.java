package CONTROLADORES;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorBDR {

    private Connection conexion;
    String usuario = "Pablo";
    String clave = "1234";
    String url = "jdbc:mysql://localhost:3306/proyfinal_datos";

    public void añadir(String nombre, int precio, int cantidad) {
        Statement sentencia;
        String sql;

        try {
            conexion = DriverManager.getConnection(url, usuario, clave);
            sentencia = conexion.createStatement();

            // INSERT INTO para añadir un deportista individual a la base de datos
            sql = "INSERT INTO productos (NOMBRE, PRECIO, CANTIDAD) VALUES"
                    + "('" + nombre + "', '" + precio + "', '" + cantidad + "');";

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
            conexion = DriverManager.getConnection(url, usuario, clave);
            Statement sentencia = conexion.createStatement();
            String sql = "DELETE FROM productos WHERE NOMBRE ='" + nombre+"'";
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
            conexion = DriverManager.getConnection(url, usuario, clave);
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
    
    public Object[][] convertir() {
        Object[][] datos = null;
        Statement sentencia;
        ResultSet rs;
        try {
            conexion = DriverManager.getConnection(url, usuario, clave);
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

                datos[indice][0] = nombre;
                datos[indice][1] = precio;
                datos[indice][2] = cantidad;

                indice++;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return datos;
    }

    public void guardarEnFichero(Object[][] datos, String nomArchivo) throws IOException {
        try (ObjectOutputStream objectOutputDatos = new ObjectOutputStream(
                new FileOutputStream(nomArchivo))) {
            objectOutputDatos.writeObject(datos);
        }
    }

    public void cargarDeFichero(String nomArchivo) throws ClassNotFoundException, IOException {
        try (ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(nomArchivo))) {
            Object[][] datos = (Object[][]) objectInput.readObject();
            for (Object[] dato : datos) {
                String nombre = dato[0].toString();
                int precio = Integer.parseInt(dato[1].toString());
                int cantidad = Integer.parseInt(dato[2].toString());
                añadir(nombre, precio, cantidad);
            }

        }
    }

}
