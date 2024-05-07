package VISTA;

import CONTROLADORES.GestorBDR;
import CONTROLADORES.GestorEstilosGUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class Ventana1 extends javax.swing.JFrame {

    GestorBDR gestorBDR = new GestorBDR();
    GestorEstilosGUI gestorEstilos = new GestorEstilosGUI();
    //Nombres de las columnas
    String[] nomCols = {"NOMBRE",
        "PRECIO",
        "CANTIDAD"};

    //Array de datos
    Object[][] datosProductos;
    Object[][] datosEstilos;

    //Objeto tabla interfaz
    DefaultTableModel listaProductos = new DefaultTableModel(datosProductos, nomCols);

    String nomArchivo = "productos.xml";
    String ficheroUsrContUrl = "ConexionBD.txt";
    String nomArchivoEstilos = "estilos.dat";

    public Ventana1() {
        conectarBD(ficheroUsrContUrl);
        setTitle("Control inventario tienda");
        initComponents();
        setAlwaysOnTop(true);
        actualizarTabla();
        setLocationRelativeTo(null);
        eventoOrdenar();
        eventoEstilos();
        reloj.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel2 = new javax.swing.JPanel();
        TextFieldPrecio = new javax.swing.JTextField();
        TextFieldNombre = new javax.swing.JTextField();
        TextFieldCantidad = new javax.swing.JTextField();
        Nombre = new javax.swing.JLabel();
        Precio = new javax.swing.JLabel();
        Cantidad = new javax.swing.JLabel();
        BotonAñadir = new javax.swing.JButton();
        BotonEliminar = new javax.swing.JButton();
        BotonActualizar = new javax.swing.JButton();
        BotonGuardar = new javax.swing.JButton();
        BotonCargar = new javax.swing.JButton();
        BotonConfigurarpantalla = new javax.swing.JButton();
        BotonGestionarUsuarios = new javax.swing.JButton();
        FECHA = new javax.swing.JLabel();
        HORA = new javax.swing.JLabel();
        OrdenarPor = new javax.swing.JComboBox<>();
        ORDENAR = new javax.swing.JLabel();
        DISEÑO = new javax.swing.JLabel();
        DiseñoComboBox = new javax.swing.JComboBox<>();
        ActualizarEstilos = new javax.swing.JToggleButton();
        Panel1 = new javax.swing.JPanel();
        TablaProductos = new javax.swing.JScrollPane();
        jTablaProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel2.setBackground(new java.awt.Color(255, 255, 255));
        Panel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TextFieldPrecio.setBackground(new java.awt.Color(204, 204, 204));

        TextFieldNombre.setBackground(new java.awt.Color(204, 204, 204));

        TextFieldCantidad.setBackground(new java.awt.Color(204, 204, 204));

        Nombre.setBackground(new java.awt.Color(255, 255, 255));
        Nombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Nombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Nombre.setText("NOMBRE");

        Precio.setBackground(new java.awt.Color(255, 255, 255));
        Precio.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Precio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Precio.setText("PRECIO");

        Cantidad.setBackground(new java.awt.Color(255, 255, 255));
        Cantidad.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Cantidad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Cantidad.setText("CANTIDAD");

        BotonAñadir.setBackground(new java.awt.Color(255, 255, 255));
        BotonAñadir.setText("AÑADIR");
        BotonAñadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonAñadirMousePressed(evt);
            }
        });

        BotonEliminar.setBackground(new java.awt.Color(255, 255, 255));
        BotonEliminar.setText("ELIMINAR");
        BotonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonEliminarMousePressed(evt);
            }
        });

        BotonActualizar.setBackground(new java.awt.Color(255, 255, 255));
        BotonActualizar.setText("ACTUALIZAR");
        BotonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonActualizarMousePressed(evt);
            }
        });

        BotonGuardar.setBackground(new java.awt.Color(255, 255, 255));
        BotonGuardar.setText("GUARDAR");
        BotonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonGuardarMousePressed(evt);
            }
        });

        BotonCargar.setBackground(new java.awt.Color(255, 255, 255));
        BotonCargar.setText("CARGAR");
        BotonCargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonCargarMousePressed(evt);
            }
        });

        BotonConfigurarpantalla.setBackground(new java.awt.Color(255, 255, 255));
        BotonConfigurarpantalla.setText("Configurar pantalla");
        BotonConfigurarpantalla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonConfigurarpantallaMousePressed(evt);
            }
        });

        BotonGestionarUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        BotonGestionarUsuarios.setText("Gestionar Usuarios");
        BotonGestionarUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonGestionarUsuariosMousePressed(evt);
            }
        });

        FECHA.setBackground(new java.awt.Color(255, 255, 255));
        FECHA.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        HORA.setBackground(new java.awt.Color(255, 255, 255));

        OrdenarPor.setBackground(new java.awt.Color(204, 204, 204));
        OrdenarPor.setForeground(new java.awt.Color(255, 255, 255));
        OrdenarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NOMBRE", "PRECIO", "CANTIDAD"}));

        ORDENAR.setBackground(new java.awt.Color(255, 255, 255));
        ORDENAR.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ORDENAR.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ORDENAR.setText("ORDENAR POR");

        DISEÑO.setBackground(new java.awt.Color(255, 255, 255));
        DISEÑO.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        DISEÑO.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DISEÑO.setText("DISEÑO");

        DiseñoComboBox.setBackground(new java.awt.Color(204, 204, 204));
        DiseñoComboBox.setForeground(new java.awt.Color(255, 255, 255));
        DiseñoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        ActualizarEstilos.setText("ACTUALIZAR DISEÑOS");
        ActualizarEstilos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ActualizarEstilosMousePressed(evt);
            }
        });

        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotonGestionarUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonConfigurarpantalla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 329, Short.MAX_VALUE)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FECHA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HORA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel2Layout.createSequentialGroup()
                        .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel2Layout.createSequentialGroup()
                        .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel2Layout.createSequentialGroup()
                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel2Layout.createSequentialGroup()
                                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(Panel2Layout.createSequentialGroup()
                                        .addComponent(DISEÑO, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(DiseñoComboBox, 0, 150, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel2Layout.createSequentialGroup()
                                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Cantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ORDENAR, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(OrdenarPor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(TextFieldCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ActualizarEstilos))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel2Layout.createSequentialGroup()
                                .addComponent(BotonAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        Panel2Layout.setVerticalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre)
                    .addComponent(TextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Precio))
                .addGap(18, 18, 18)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cantidad))
                .addGap(18, 18, 18)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ORDENAR)
                    .addComponent(OrdenarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DISEÑO)
                    .addComponent(DiseñoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ActualizarEstilos))
                .addGap(58, 58, 58)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonAñadir)
                    .addComponent(BotonEliminar)
                    .addComponent(BotonActualizar)
                    .addComponent(BotonGuardar)
                    .addComponent(BotonCargar))
                .addGap(88, 88, 88)
                .addComponent(HORA, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonConfigurarpantalla)
                    .addComponent(BotonGestionarUsuarios)
                    .addComponent(FECHA, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addContainerGap())
        );

        Panel1.setBackground(new java.awt.Color(255, 255, 255));
        Panel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TablaProductos.setBackground(new java.awt.Color(255, 255, 255));
        TablaProductos.setForeground(new java.awt.Color(255, 255, 255));

        jTablaProductos.setBackground(new java.awt.Color(255, 255, 255));
        jTablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NOMBRE", "PRECIO", "CANTIDAD"
            }
        ));
        jTablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTablaProductosMousePressed(evt);
            }
        });
        TablaProductos.setViewportView(jTablaProductos);

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TablaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TablaProductos)
                .addContainerGap())
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonGuardarMousePressed
        try {
            gestorBDR.guardarEnFichero(datosProductos, nomArchivo);
            JOptionPane.showMessageDialog(this, "Se han guardado los datos", "Guardado", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Ha habido un error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BotonGuardarMousePressed

    private void BotonCargarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonCargarMousePressed

        try {
            gestorBDR.vaciar();
            gestorBDR.cargarDeFichero(nomArchivo);
            actualizarTabla();
        } catch (ClassNotFoundException | IOException e) {
            JOptionPane.showMessageDialog(this, "Ha habido un error", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_BotonCargarMousePressed

    private void jTablaProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaProductosMousePressed
        int filaSeleccionada = jTablaProductos.getSelectedRow();
        String nombre = (String) datosProductos[filaSeleccionada][0];
        String precio = (String) datosProductos[filaSeleccionada][1].toString();
        String cantidad = (String) datosProductos[filaSeleccionada][2].toString();

        TextFieldNombre.setText(nombre);
        TextFieldCantidad.setText(cantidad);
        TextFieldPrecio.setText(precio);
        
    }//GEN-LAST:event_jTablaProductosMousePressed

    private void BotonEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEliminarMousePressed
        //Se guarda la fila seleccionada
        int filaSeleccionado = jTablaProductos.getSelectedRow();

        //Se comprueba que se ha seleccionado alguna fila
        if (filaSeleccionado >= 0) {
            //Se saca el valor del nombre de la fila seleccionada
            String nombre = (String) datosProductos[filaSeleccionado][0];

            //Se recorre la miniagenda buscando el deportista con el mismo nombre y se borra y se actualiza la tabla
            gestorBDR.borrarNombre(nombre);
            actualizarTabla();

        } else {
            //En caso de que no haya ninguna fila seleccionada se muestra un mensaje de error
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        vaciarTextField();
    }//GEN-LAST:event_BotonEliminarMousePressed

    private void BotonAñadirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAñadirMousePressed
        String nombre = TextFieldNombre.getText();
        int precio = 0;
        int cantidad = 0;
        boolean precioCorrecto = false;
        boolean cantidadCorrecto = false;

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
        if (precioCorrecto && cantidadCorrecto) {

            if (!TextFieldNombre.getText().trim().isEmpty()) {
                gestorBDR.añadir(nombre, precio, cantidad);
                actualizarTabla();
                vaciarTextField();
            } else {
                JOptionPane.showMessageDialog(this, "El campo del nombre no puede estar vacío", "No añadido", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_BotonAñadirMousePressed

    private void BotonActualizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonActualizarMousePressed
        //Se guarda la fila seleccionada 
        int filaSeleccionada = jTablaProductos.getSelectedRow();

        if (filaSeleccionada >= 0) {
            String nombreBorrar = (String) datosProductos[filaSeleccionada][0];
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
    }//GEN-LAST:event_BotonActualizarMousePressed

    private void BotonGestionarUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonGestionarUsuariosMousePressed
        Ventana2 ventana = new Ventana2();
        ventana.setVisible(true);
    }//GEN-LAST:event_BotonGestionarUsuariosMousePressed

    private void BotonConfigurarpantallaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonConfigurarpantallaMousePressed

        Ventana3 ventana = new Ventana3();
        ventana.setVisible(true);

    }//GEN-LAST:event_BotonConfigurarpantallaMousePressed

    private void ActualizarEstilosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActualizarEstilosMousePressed

        actualizarOpciones();

    }//GEN-LAST:event_ActualizarEstilosMousePressed

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
    private javax.swing.JToggleButton ActualizarEstilos;
    private javax.swing.JButton BotonActualizar;
    private javax.swing.JButton BotonAñadir;
    private javax.swing.JButton BotonCargar;
    private javax.swing.JButton BotonConfigurarpantalla;
    private javax.swing.JButton BotonEliminar;
    private javax.swing.JButton BotonGestionarUsuarios;
    private javax.swing.JButton BotonGuardar;
    private javax.swing.JLabel Cantidad;
    private javax.swing.JLabel DISEÑO;
    private javax.swing.JComboBox<String> DiseñoComboBox;
    private javax.swing.JLabel FECHA;
    private javax.swing.JLabel HORA;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel ORDENAR;
    private javax.swing.JComboBox<String> OrdenarPor;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JLabel Precio;
    private javax.swing.JScrollPane TablaProductos;
    private javax.swing.JTextField TextFieldCantidad;
    private javax.swing.JTextField TextFieldNombre;
    private javax.swing.JTextField TextFieldPrecio;
    private javax.swing.JTable jTablaProductos;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        datosProductos = gestorBDR.convertir();
        listaProductos = new DefaultTableModel(datosProductos, nomCols) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        jTablaProductos.setModel(listaProductos);
    }

    private void ordenarTabla() {
        listaProductos.setDataVector(datosProductos, nomCols);
    }

    public void vaciarTextField() {
        TextFieldCantidad.setText("");
        TextFieldNombre.setText("");
        TextFieldPrecio.setText("");
    }

    public void setAdministrador(boolean esAdmin) {
        if (esAdmin) {
            BotonGestionarUsuarios.setVisible(true);
            BotonGestionarUsuarios.setEnabled(true);
            BotonConfigurarpantalla.setVisible(true);
            BotonConfigurarpantalla.setEnabled(true);
        } else {
            BotonGestionarUsuarios.setVisible(false);
            BotonGestionarUsuarios.setEnabled(false);
            BotonConfigurarpantalla.setVisible(false);
            BotonConfigurarpantalla.setEnabled(false);
        }
    }

    Timer reloj = new Timer(0, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Date ahora = new Date();
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
            String horaFormateada = formatoHora.format(ahora);
            FECHA.setText(horaFormateada);
        }
    });

    public void eventoOrdenar() {
        OrdenarPor.addActionListener(new ActionListener() {
            String opcion = null;

            @Override
            public void actionPerformed(ActionEvent e) {
                opcion = (String) OrdenarPor.getSelectedItem();
                System.out.println(opcion);
                switch (opcion.toUpperCase()) {
                    case "NOMBRE":
                        datosProductos = gestorBDR.ordenarNombre(datosProductos);
                        break;
                    case "PRECIO":
                        datosProductos = gestorBDR.ordenarPrecio(datosProductos);
                        break;
                    case "CANTIDAD":
                        datosProductos = gestorBDR.ordenarCantidad(datosProductos);
                        break;
                    default:
                        throw new AssertionError();
                }
                ordenarTabla();
            }
        });
    }

    public void eventoEstilos() {
        DiseñoComboBox.addActionListener(new ActionListener() {
            String opcion = null;
            JPanel paneles[] = {Panel1, Panel2};
            Color color;

            @Override
            public void actionPerformed(ActionEvent e) {
                opcion = (String) DiseñoComboBox.getSelectedItem();
                color = buscarColor(opcion);
                gestorEstilos.cambiarColorFondo(paneles, color);
            }
        });
    }

    public void actualizarOpciones() {
        FileInputStream fis;
        ObjectInputStream ois;
        DiseñoComboBox.removeAllItems();
        
        try {
            fis = new FileInputStream(nomArchivoEstilos);
            ois = new ObjectInputStream(fis);
            datosEstilos = (Object[][]) ois.readObject();
            for (Object[] dato : datosEstilos) {
                String titulo = (String) dato[0];
                DiseñoComboBox.addItem(titulo);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Color buscarColor(String titulo) {
        int r, g, b;
        Color color = null;
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(nomArchivoEstilos);
            ois = new ObjectInputStream(fis);
            datosEstilos = (Object[][]) ois.readObject();
            for (Object[] dato : datosEstilos) {
                String tituloArchivo = (String) dato[0];
                if (titulo.equalsIgnoreCase(tituloArchivo)) {
                    String rgbColor = (String) dato[1];
                    String[] rgb = rgbColor.replaceAll("[^0-9,]", "").split(",");
                    r = Integer.parseInt(rgb[0]);
                    g = Integer.parseInt(rgb[1]);
                    b = Integer.parseInt(rgb[2]);
                    color = new Color(r, g, b);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return color;
    }

    public void conectarBD(String fichero) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }

        usuario = datosFichero.get(0);
        clave = datosFichero.get(1);
        url = datosFichero.get(2);

        gestorBDR.conectar(url, usuario, clave);

    }
}
