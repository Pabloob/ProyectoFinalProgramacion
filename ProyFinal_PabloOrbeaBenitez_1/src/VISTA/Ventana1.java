package VISTA;

import CONTROLADORES.GestorBDR;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ventana1 extends javax.swing.JFrame {

    GestorBDR gestorBDR = new GestorBDR();

    //Nombres de las columnas
    String[] nomCols = {"NOMBRE",
        "PRECIO",
        "CANTIDAD"};

    //Array de datos
    Object[][] datos;

    //Objeto tabla interfaz
    DefaultTableModel listaProductos = new DefaultTableModel(datos, nomCols);
    
    String nomArchivo = "productos.dat";

    public Ventana1() {
        initComponents();
        setAlwaysOnTop(true);
        actualizarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel2 = new javax.swing.JPanel();
        BotonActualizar = new javax.swing.JToggleButton();
        TextFieldPrecio = new javax.swing.JTextField();
        TextFieldNombre = new javax.swing.JTextField();
        TextFieldCantidad = new javax.swing.JTextField();
        BotonEliminar = new javax.swing.JToggleButton();
        BotonCargar = new javax.swing.JToggleButton();
        BotonGuardar = new javax.swing.JToggleButton();
        Nombre = new javax.swing.JLabel();
        Precio = new javax.swing.JLabel();
        Cantidad = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Panel1 = new javax.swing.JPanel();
        TablaProductos = new javax.swing.JScrollPane();
        jTablaProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BotonActualizar.setText("Actualizar");
        BotonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonActualizarMouseClicked(evt);
            }
        });

        BotonEliminar.setText("Eliminar");
        BotonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonEliminarMouseClicked(evt);
            }
        });

        BotonCargar.setText("Cargar");
        BotonCargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonCargarMouseClicked(evt);
            }
        });

        BotonGuardar.setText("Guardar");
        BotonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonGuardarMouseClicked(evt);
            }
        });

        Nombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nombre.setText("NOMBRE");

        Precio.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Precio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Precio.setText("PRECIO");

        Cantidad.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Cantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cantidad.setText("CANTIDAD");

        jButton1.setText("jButton1");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(Panel2Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextFieldNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextFieldPrecio)
                    .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        Panel2Layout.setVerticalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre)
                    .addComponent(Precio)
                    .addComponent(Cantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(110, 110, 110)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonEliminar)
                    .addComponent(BotonActualizar)
                    .addComponent(BotonCargar)
                    .addComponent(BotonGuardar)
                    .addComponent(jButton1))
                .addContainerGap(204, Short.MAX_VALUE))
        );

        Panel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Precio", "Cantidad"
            }
        ));
        jTablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaProductosMouseClicked(evt);
            }
        });
        TablaProductos.setViewportView(jTablaProductos);

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
            .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TablaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
            .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TablaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEliminarMouseClicked

        //Se guarda la fila seleccionada
        int filaSeleccionado = jTablaProductos.getSelectedRow();

        //Se comprueba que se ha seleccionado alguna fila
        if (filaSeleccionado >= 0) {
            //Se saca el valor del nombre de la fila seleccionada
            String nombre = (String) datos[filaSeleccionado][0];

            //Se recorre la miniagenda buscando el deportista con el mismo nombre y se borra y se actualiza la tabla
            gestorBDR.borrarNombre(nombre);
            actualizarTabla();

        } else {
            //En caso de que no haya ninguna fila seleccionada se muestra un mensaje de error
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        vaciarTextField();

    }//GEN-LAST:event_BotonEliminarMouseClicked

    private void BotonActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonActualizarMouseClicked

//Se guarda la fila seleccionada 
        int filaSeleccionada = jTablaProductos.getSelectedRow();

        if (filaSeleccionada >= 0) {
            String nombreBorrar = (String) datos[filaSeleccionada][0];
            String nombre = TextFieldNombre.getText();
            int precio = TextFieldPrecio.getText().isEmpty() ? 0 : Integer.parseInt(TextFieldPrecio.getText());
            int cantidad = TextFieldCantidad.getText().isEmpty() ? 0 : Integer.parseInt(TextFieldCantidad.getText());

            if (!nombre.isEmpty()) {

                gestorBDR.borrarNombre(nombreBorrar);
                actualizarTabla();

                gestorBDR.añadir(nombre, precio, cantidad);
                actualizarTabla();

            } else {
                //En caso de que el campo nombre este vacio muestra un mensaje de error
                JOptionPane.showMessageDialog(this, "El campo del nombre no puede estar vacío", "No añadido", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningun producto", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        vaciarTextField();

    }//GEN-LAST:event_BotonActualizarMouseClicked

    private void jTablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaProductosMouseClicked
        int filaSeleccionada = jTablaProductos.getSelectedRow();
        String nombre = (String) datos[filaSeleccionada][0];
        String precio = (String) datos[filaSeleccionada][1].toString();
        String cantidad = (String) datos[filaSeleccionada][2].toString();

        TextFieldNombre.setText(nombre);
        TextFieldCantidad.setText(cantidad);
        TextFieldPrecio.setText(precio);

    }//GEN-LAST:event_jTablaProductosMouseClicked

    private void BotonCargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonCargarMouseClicked
        try {
            gestorBDR.vaciar();
            gestorBDR.cargarDeFichero(nomArchivo);
            actualizarTabla();
        }  catch (ClassNotFoundException | IOException e) {
            JOptionPane.showMessageDialog(this, "Ha habido un error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BotonCargarMouseClicked

    private void BotonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonGuardarMouseClicked
        try {
            gestorBDR.guardarEnFichero(datos,nomArchivo);
            JOptionPane.showMessageDialog(this, "Se han guardado los datos", "Guardado", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Ha habido un error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BotonGuardarMouseClicked

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        String nombre = TextFieldNombre.getText();
        int precio = 0;
        int cantidad = 0;
        boolean precioCorrecto;
        boolean cantidadCorrecto;

        try {
            precio = TextFieldPrecio.getText().isEmpty() ? 0 : Integer.parseInt(TextFieldPrecio.getText());
            precioCorrecto = true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debes introducir un numero entero", "Precio", JOptionPane.WARNING_MESSAGE);
        }
        try {
            cantidad = TextFieldCantidad.getText().isEmpty() ? 0 : Integer.parseInt(TextFieldCantidad.getText());
            cantidadCorrecto = true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debes introducir un numero entero", "Cantidad", JOptionPane.WARNING_MESSAGE);
        }

        gestorBDR.añadir(nombre, precio, cantidad);
        actualizarTabla();
        vaciarTextField();
    }//GEN-LAST:event_jButton1MousePressed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotonActualizar;
    private javax.swing.JToggleButton BotonCargar;
    private javax.swing.JToggleButton BotonEliminar;
    private javax.swing.JToggleButton BotonGuardar;
    private javax.swing.JLabel Cantidad;
    private javax.swing.JLabel Nombre;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JLabel Precio;
    private javax.swing.JScrollPane TablaProductos;
    private javax.swing.JTextField TextFieldCantidad;
    private javax.swing.JTextField TextFieldNombre;
    private javax.swing.JTextField TextFieldPrecio;
    private javax.swing.JButton jButton1;
    private javax.swing.JTable jTablaProductos;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        datos = gestorBDR.convertir();
        listaProductos = new DefaultTableModel(datos, nomCols) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        jTablaProductos.setModel(listaProductos);

    }
public void vaciarTextField() {
        TextFieldCantidad.setText("");
        TextFieldNombre.setText("");
        TextFieldPrecio.setText("");
    }

}
