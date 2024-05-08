package VISTA;

import CONTROLADORES.GestorBDR;
import CONTROLADORES.GestorEstilosGUI;
import MODELOS.Producto;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Ventana1 extends javax.swing.JFrame {

    //Gestores de la base de datos
    GestorBDR gestorBDR = new GestorBDR();
    GestorEstilosGUI gestorEstilos = new GestorEstilosGUI();

    //Nombres de las columnas
    String[] nomCols = {"NOMBRE", "PRECIO", "CANTIDAD", "IMAGEN"};
    //Array de datos
    Object[][] datosProductos;
    Object[][] datosEstilos;

    //Objeto tabla interfaz
    DefaultTableModel listaProductos = new DefaultTableModel(datosProductos, nomCols) {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    //Nombres de ficheros
    String nomArchivo = "productos.dat";
    String ficheroUsrContUrl = "ConexionBD.txt";
    String nomArchivoEstilos = "estilos.dat";

    //Ruta imagen a añadir
    String ruta;

    //Se conecta la base de datos y se inicia la ventana
    public Ventana1() {
        conectarBDR(ficheroUsrContUrl);
        setTitle("Control inventario tienda");
        initComponents();
        actualizarTabla();
        setAlwaysOnTop(true);
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
        ImagenButton = new javax.swing.JButton();
        ImagenLabel = new javax.swing.JLabel();
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

        ImagenButton.setText("IMAGEN");
        ImagenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ImagenButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
                        .addComponent(BotonAñadir, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(240, 240, 240)
                        .addComponent(HORA, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
                        .addGap(0, 48, Short.MAX_VALUE)
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
                                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel2Layout.createSequentialGroup()
                                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Cantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ORDENAR, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(OrdenarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(Panel2Layout.createSequentialGroup()
                                        .addComponent(DISEÑO, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(DiseñoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(ActualizarEstilos)))
                        .addGap(15, 15, 15)
                        .addComponent(ImagenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
                        .addComponent(BotonGestionarUsuarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonConfigurarpantalla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(BotonCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ImagenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FECHA, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        Panel2Layout.setVerticalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panel2Layout.createSequentialGroup()
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ORDENAR)
                            .addComponent(OrdenarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ImagenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DISEÑO)
                    .addComponent(DiseñoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ActualizarEstilos)
                    .addComponent(ImagenButton))
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel2Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(HORA, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotonAñadir)
                            .addComponent(BotonEliminar)
                            .addComponent(BotonActualizar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonConfigurarpantalla)
                    .addComponent(BotonGestionarUsuarios)
                    .addComponent(FECHA, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(BotonGuardar)
                    .addComponent(BotonCargar))
                .addContainerGap())
        );

        Panel1.setBackground(new java.awt.Color(255, 255, 255));
        Panel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TablaProductos.setBackground(new java.awt.Color(255, 255, 255));
        TablaProductos.setForeground(new java.awt.Color(255, 255, 255));

        jTablaProductos.setBackground(new java.awt.Color(255, 255, 255));
        jTablaProductos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "PRECIO", "CANTIDAD", "IMAGEN"
            }
        ));
        jTablaProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
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
        //Se guardan los datos de los productos en el nombre del archivo
        try {
            gestorBDR.guardarProductosEnFichero(datosProductos, nomArchivo);
            JOptionPane.showMessageDialog(this, "Se han guardado los datos", "Guardado", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ha habido un error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BotonGuardarMousePressed

    private void BotonCargarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonCargarMousePressed
        //Se cargan los datos del fichero y se añaden a la base de datos
        try {
            gestorBDR.vaciarBDR();
            gestorBDR.cargarProductosDeFichero(nomArchivo);
            actualizarTabla();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ha habido un error", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_BotonCargarMousePressed

    private void jTablaProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaProductosMousePressed
        int filaSeleccionada = jTablaProductos.getSelectedRow();
        String nombre = (String) datosProductos[filaSeleccionada][0];
        String precio = (String) datosProductos[filaSeleccionada][1].toString().replaceAll("[^\\d.]", "");
        String cantidad = (String) datosProductos[filaSeleccionada][2].toString();
        TextFieldNombre.setText(nombre);
        TextFieldCantidad.setText(cantidad);
        TextFieldPrecio.setText(precio);

        try {
            JLabel imagenLabel = (JLabel) datosProductos[filaSeleccionada][3];
            ImageIcon imagenIcono = (ImageIcon) imagenLabel.getIcon();
            Image imagenOriginal = imagenIcono.getImage();
            Image imagenEscalada = imagenOriginal.getScaledInstance(ImagenLabel.getWidth(), ImagenLabel.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imagenEscaladaIcono = new ImageIcon(imagenEscalada);
            ImagenLabel.setIcon(imagenEscaladaIcono);
        } catch (Exception e) {
            ImagenLabel.setIcon(null);
            ImagenLabel.setText("NO HAY IMAGEN DISPONIBLE");
        }


    }//GEN-LAST:event_jTablaProductosMousePressed

    private void BotonEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEliminarMousePressed
        //Se verifica si se ha seleccionado alguna fila y se borra el producto

        int filaSeleccionado = jTablaProductos.getSelectedRow();
        if (filaSeleccionado >= 0) {
            String nombre = (String) datosProductos[filaSeleccionado][0];
            gestorBDR.borrarProductoPorNombre(nombre);
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        vaciarTextField();
    }//GEN-LAST:event_BotonEliminarMousePressed

    private void BotonAñadirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAñadirMousePressed
        //Se añade un producto con los datos de los textfields y se comprueban los datos

        String nombre = TextFieldNombre.getText();
        float precio = 0;
        int cantidad = 0;
        byte img[] = conseguirImagenPorRuta(ruta);
        boolean precioCorrecto = false;
        boolean cantidadCorrecto = false;

        try {
            precio = Float.parseFloat(TextFieldPrecio.getText());
            if (precio > 0) {
                precioCorrecto = true;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debes introducir un numero entero", "Precio", JOptionPane.WARNING_MESSAGE);
        }
        try {
            cantidad = Integer.parseInt(TextFieldCantidad.getText());
            if (cantidad > 0) {
                cantidadCorrecto = true;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debes introducir un numero entero", "Cantidad", JOptionPane.WARNING_MESSAGE);
        }

        if (precioCorrecto && cantidadCorrecto) {

            if (!nombre.isEmpty()) {
                try {
                    Producto producto = new Producto();
                    producto.setNombre(nombre);
                    producto.setPrecio(precio);
                    producto.setCantidad(cantidad);
                    if (img == null) {
                        producto.setImagen(null);
                    } else {
                        producto.setImagen(conseguirImagenPorRuta(ruta));
                    }
                    gestorBDR.añadirProducto(producto);
                    actualizarTabla();
                    vaciarTextField();
                } catch (IOException ex) {
                }
            } else {
                JOptionPane.showMessageDialog(this, "No puede haber ningun campo vacio", "No añadido", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_BotonAñadirMousePressed

    private void BotonActualizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonActualizarMousePressed
        //Se muestran los datos de el producto seleccionado en los texfields y se cogen los nuevos datos actualizando el producto 
        Producto producto = new Producto();
        int filaSeleccionada = jTablaProductos.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String nombreBorrar = (String) datosProductos[filaSeleccionada][0];

            String nombre = TextFieldNombre.getText();
            byte img[] = gestorBDR.jLbalelABytes(ImagenLabel);
            float precio = 0;
            int cantidad = 0;
            boolean precioCorrecto = false;
            boolean cantidadCorrecto = false;

            try {
                precio = Float.parseFloat(TextFieldPrecio.getText());
                if (precio < 0) {
                    precioCorrecto = false;
                }
                precioCorrecto = true;
            } catch (NumberFormatException e) {
            }
            try {
                cantidad = Integer.parseInt(TextFieldCantidad.getText());
                if (cantidad < 0) {
                    cantidadCorrecto = false;
                }
                cantidadCorrecto = true;
            } catch (NumberFormatException e) {
            }
            if (precioCorrecto && cantidadCorrecto) {

                if (!nombre.isEmpty()) {
                    gestorBDR.borrarProductoPorNombre(nombreBorrar);
                    actualizarTabla();
                    producto.setNombre(nombre);
                    producto.setPrecio(precio);
                    producto.setCantidad(cantidad);
                    if (img == null) {
                        producto.setImagen(null);
                    } else {
                        producto.setImagen(img);
                    }
                    try {
                        gestorBDR.añadirProducto(producto);
                        actualizarTabla();
                        vaciarTextField();
                    } catch (IOException ex) {
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Debes rellenar todos los campos", "No añadido", JOptionPane.WARNING_MESSAGE);
                }

            }
        } else {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningun producto", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BotonActualizarMousePressed

    private void BotonGestionarUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonGestionarUsuariosMousePressed
        //Boton activar la ventana 2 
        Ventana2 ventana = new Ventana2();
        ventana.setVisible(true);
    }//GEN-LAST:event_BotonGestionarUsuariosMousePressed

    private void BotonConfigurarpantallaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonConfigurarpantallaMousePressed
        //Boton activar la ventana 3
        Ventana3 ventana = new Ventana3();
        ventana.setVisible(true);

    }//GEN-LAST:event_BotonConfigurarpantallaMousePressed

    private void ActualizarEstilosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActualizarEstilosMousePressed
        //Boton que actualiza los estilos disponibles
        actualizarOpcionesEstilos();
    }//GEN-LAST:event_ActualizarEstilosMousePressed

    private void ImagenButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenButtonMousePressed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        fileChooser.setFileFilter(extensionFilter);

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            ruta = fileChooser.getSelectedFile().getAbsolutePath();
            Image mImagen = new ImageIcon(ruta).getImage();
            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(ImagenLabel.getWidth(), ImagenLabel.getHeight(), 0));
            ImagenLabel.setIcon(mIcono);
        }

    }//GEN-LAST:event_ImagenButtonMousePressed

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
    private javax.swing.JButton ImagenButton;
    private javax.swing.JLabel ImagenLabel;
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

    //Metodo actualizar la tabla con los valores de el array[][]
    private void actualizarTabla() {
        jTablaProductos.setDefaultRenderer(Object.class, new ImagenTabla());

        ArrayList productos = gestorBDR.convertirBDRADTM();
        Producto producto;
        datosProductos = new Object[productos.size()][4];

        if (productos != null) {
            for (int i = 0; i < productos.size(); i++) {
                producto = (Producto) productos.get(i);
                datosProductos[i][0] = producto.getNombre();
                datosProductos[i][1] = producto.getPrecio() + "€";
                datosProductos[i][2] = producto.getCantidad();

                try {
                    byte[] imagen = producto.getImagen();
                    BufferedImage bufferedImage = null;
                    InputStream inputStream = new ByteArrayInputStream(imagen);
                    bufferedImage = ImageIO.read(inputStream);
                    ImageIcon mIcono = new ImageIcon(bufferedImage.getScaledInstance(100, 100, 0));
                    datosProductos[i][3] = new JLabel(mIcono);
                } catch (Exception e) {
                    datosProductos[i][3] = new JLabel("No imagen");
                }
            }
        }

        listaProductos = new DefaultTableModel(datosProductos, nomCols) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        jTablaProductos.setModel(listaProductos);
        jTablaProductos.setRowHeight(100);
        jTablaProductos.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTablaProductos.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTablaProductos.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTablaProductos.getColumnModel().getColumn(3).setPreferredWidth(100);

    }

    //se actualizan los datos de la tabla con los datos de los productos 
    //Este metodo se usa solamente para ordenar los productos
    private void actualizarTablaOrdenada() {
        listaProductos.setDataVector(datosProductos, nomCols);
    }

    //Metodo para vaciar los textFields
    private void vaciarTextField() {
        TextFieldCantidad.setText(null);
        TextFieldNombre.setText(null);
        TextFieldPrecio.setText(null);
        ImagenLabel.setText(null);
        ImagenLabel.setIcon(null);
        ruta = null;
    }

    //Metodo para activar o desactivar los botones de las ventanas de administrador
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

    //Metodo para el reloj
    Timer reloj = new Timer(0, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Date ahora = new Date();
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
            String horaFormateada = formatoHora.format(ahora);
            FECHA.setText(horaFormateada);
        }
    });

    //Metodo para ordenar los datos de la tabla dependiendo de la opcion del desplegable que se elija
    private void eventoOrdenar() {
        OrdenarPor.addActionListener(new ActionListener() {
            String opcion = null;

            @Override
            public void actionPerformed(ActionEvent e) {
                opcion = (String) OrdenarPor.getSelectedItem();
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
                actualizarTablaOrdenada();
            }
        });
    }

    //Evento para aplicar el estilo seleccionado de el desplegable
    private void eventoEstilos() {
        DiseñoComboBox.addActionListener(new ActionListener() {
            String opcion = null;
            JPanel paneles[] = {Panel1, Panel2};
            JLabel textos[] = {Nombre, Precio, Cantidad, ORDENAR, DISEÑO, FECHA};
            Color color;

            @Override
            public void actionPerformed(ActionEvent e) {
                opcion = (String) DiseñoComboBox.getSelectedItem();
                color = gestorEstilos.buscarColorEnFichero(opcion, 1, nomArchivoEstilos, datosEstilos);
                gestorEstilos.cambiarColorFondo(paneles, color);
                color = gestorEstilos.buscarColorEnFichero(opcion, 2, nomArchivoEstilos, datosEstilos);
                gestorEstilos.cambiarColorTexto(textos, color);
            }
        });
    }

    //Metodo que refresca las opciones del deplegable con los datos de el fichero de estilos
    private void actualizarOpcionesEstilos() {
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
        }
    }

    //Metodo de conectar con la base de datos con los datos de un fichero 
    private void conectarBDR(String fichero) {
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
        }

        usuario = datosFichero.get(0);
        clave = datosFichero.get(1);
        url = datosFichero.get(2);

        gestorBDR.conectarBDR(url, usuario, clave);

    }

    public byte[] conseguirImagenPorRuta(String Ruta) {
        if (Ruta != null) {
            File imagen = new File(Ruta);
            try {
                byte[] icono = new byte[(int) imagen.length()];
                InputStream input = new FileInputStream(imagen);
                input.read(icono);
                return icono;
            } catch (Exception ex) {
                return null;
            }
        } else {
            return null;
        }
    }

}
