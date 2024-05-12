package VISTA;

import CONTROLADORES.GestorBDR;
import CONTROLADORES.GestorEstilosGUI;
import LIBRERIAS.MisUtiles;
import MODELOS.Producto;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Icon;
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
    public static final String nombreFicheroXMLProductos = "ARCHIVOS\\Productos.xml";
    public static final String nombreFicheroConectarBDR = "ARCHIVOS\\ConexionBDR.txt";
    public static final String nombreFicheroEstilos = "ARCHIVOS\\estilos.dat";

    //Ruta imagen a añadir
    String ruta;

    String nombreUsuario;

    //Se conecta la base de datos y se inicia la ventana
    public Ventana1() {
        if (gestorBDR.conectarPorFicheroBDR(nombreFicheroConectarBDR)) {
            setTitle("Control inventario tienda");
            initComponents();
            actualizarTabla();
            setAlwaysOnTop(true);
            setLocationRelativeTo(null);
            eventoOrdenar();
            eventoEstilos();
            reloj.start();
            jTablaProductos.setRowHeight(100);
            jTablaProductos.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTablaProductos.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTablaProductos.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTablaProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
        } else {
            mostrarMensajeError("Se ha producido un error al conectar con la base de datos");
            System.exit(0);
        }

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
        BotonEliminarSeleccionado = new javax.swing.JButton();
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
        BotonEliminarPorNombre = new javax.swing.JButton();
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

        BotonEliminarSeleccionado.setBackground(new java.awt.Color(255, 255, 255));
        BotonEliminarSeleccionado.setText("ELIMINAR");
        BotonEliminarSeleccionado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonEliminarSeleccionadoMousePressed(evt);
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

        ImagenLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ImagenLabelMousePressed(evt);
            }
        });

        BotonEliminarPorNombre.setBackground(new java.awt.Color(255, 255, 255));
        BotonEliminarPorNombre.setText("ELIMINAR");
        BotonEliminarPorNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonEliminarPorNombreMousePressed(evt);
            }
        });

        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addComponent(BotonGestionarUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonConfigurarpantalla)
                .addGap(18, 18, 18)
                .addComponent(BotonCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(HORA, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(Panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
                        .addComponent(BotonAñadir, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonEliminarSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonEliminarPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(FECHA, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
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
                                .addComponent(ImagenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))))))
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
                        .addGap(141, 141, 141)
                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotonAñadir)
                            .addComponent(BotonEliminarSeleccionado)
                            .addComponent(BotonActualizar)
                            .addComponent(BotonEliminarPorNombre))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FECHA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BotonConfigurarpantalla)
                        .addComponent(BotonGestionarUsuarios)
                        .addComponent(BotonGuardar)
                        .addComponent(BotonCargar))
                    .addComponent(HORA, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jTablaProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        if (gestorBDR.guardarProductosEnFicheroXML(datosProductos, nombreFicheroXMLProductos)) {
            mostrarMensajeInformacion("Se han guardado los productos correctamente");
        } else {
            mostrarMensajeError("Se ha producido un error al guardar los productos");
        }
    }//GEN-LAST:event_BotonGuardarMousePressed

    private void BotonCargarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonCargarMousePressed
        //Se guardan los datos de los productos en el nombre del archivo
        if (gestorBDR.cargarProductosDeFicheroXML(nombreFicheroXMLProductos)) {
            mostrarMensajeInformacion("Se han cargado los productos correctamente");
        } else {
            mostrarMensajeError("Se ha producido un error cargar los productos");
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
            if (imagenIcono == null) {
                ImagenLabel.setIcon(null);
                ImagenLabel.setText("NO HAY IMAGEN DISPONIBLE");
            } else {
                Image imagenOriginal = imagenIcono.getImage();
                Image imagenEscalada = imagenOriginal.getScaledInstance(ImagenLabel.getWidth(), ImagenLabel.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imagenEscaladaIcono = new ImageIcon(imagenEscalada);
                ImagenLabel.setIcon(imagenEscaladaIcono);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jTablaProductosMousePressed

    private void BotonEliminarSeleccionadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEliminarSeleccionadoMousePressed
        //Se verifica si se ha seleccionado alguna fila y se borra el producto

        int filaSeleccionado = jTablaProductos.getSelectedRow();
        if (filaSeleccionado >= 0) {
            ArrayList productos = gestorBDR.convertirBDRALista();
            Producto producto = (Producto) productos.get(filaSeleccionado);
            String nombre = (String) datosProductos[filaSeleccionado][0];
            if (gestorBDR.borrarProductoPorNombre(nombre)) {
                MisUtiles.borrarImagen(producto.getrutaImagen());
                actualizarTabla();
                vaciarTextField();
            } else {
                mostrarMensajeError("Se ha producido un error al borrar el producto");
            }
        } else {
            mostrarMensajeError("No se ha seleccionado ninguna fila");
        }
    }//GEN-LAST:event_BotonEliminarSeleccionadoMousePressed

    private void BotonAñadirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAñadirMousePressed
        //Se añade un producto con los datos de los textfields y se comprueban los datos

        String nombre = TextFieldNombre.getText().strip();
        float precio = MisUtiles.comprobarFloatPositivo(TextFieldPrecio.getText());
        int cantidad = MisUtiles.comprobarIntPositivo(TextFieldCantidad.getText());
        if (precio > 0 && cantidad > 0) {
            if (!nombre.isEmpty()) {
                Producto producto = new Producto();
                producto.setNombre(nombre);
                producto.setPrecio(precio);
                producto.setCantidad(cantidad);
                if (ruta == null) {
                    producto.setrutaImagen(null);
                } else {
                    producto.setrutaImagen(ruta);
                }
                if (gestorBDR.añadirProducto(producto)) {
                    actualizarTabla();
                    vaciarTextField();
                } else {
                    mostrarMensajeError("Se ha producido un error al añadir el producto");
                }
            } else {
                mostrarMensajeError("El campo nombre no puede estar vacio");
            }
        } else {
            mostrarMensajeError("Comprueba que precio y cantidad estan rellenados "
                    + "con valores positivos y sin datos que no sean numeros");
        }

    }//GEN-LAST:event_BotonAñadirMousePressed

    private void BotonActualizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonActualizarMousePressed
        //Se muestran los datos de el producto seleccionado en los texfields y se cogen los nuevos datos actualizando el producto 
        int filaSeleccionada = jTablaProductos.getSelectedRow();

        if (filaSeleccionada >= 0) {
            ArrayList productos = gestorBDR.convertirBDRALista();
            Producto producto = (Producto) productos.get(filaSeleccionada);
            Producto productoAñadir = new Producto();
            String nombreBorrar = (String) datosProductos[filaSeleccionada][0];

            String nombre = TextFieldNombre.getText().strip();
            float precio = MisUtiles.comprobarFloatPositivo(TextFieldPrecio.getText());
            int cantidad = MisUtiles.comprobarIntPositivo(TextFieldCantidad.getText());

            if (precio > 0 && cantidad > 0) {

                if (!nombre.isEmpty()) {
                    productoAñadir.setNombre(nombre);
                    productoAñadir.setPrecio(precio);
                    productoAñadir.setCantidad(cantidad);
                    if (ruta == null) {
                        productoAñadir.setrutaImagen(null);
                    } else {
                        productoAñadir.setrutaImagen(ruta);
                    }

                    if (gestorBDR.borrarProductoPorNombre(nombreBorrar) && gestorBDR.añadirProducto(productoAñadir)) {
                        MisUtiles.borrarImagen(producto.getrutaImagen());
                        actualizarTabla();

                        vaciarTextField();
                    } else {
                        mostrarMensajeError("Se ha producido un error actualizando el "
                                + "producto al actualizar los datos");
                    }
                } else {
                    mostrarMensajeError("El campo nombre no puede estar vacio");
                }

            } else {
                mostrarMensajeError("Comprueba que precio y cantidad estan rellenados "
                        + "con valores positivos y sin datos que no sean numeros");
            }
        } else {
            mostrarMensajeError("No se ha seleccionado ninguna fila");
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
        ventana.setNombreUsuario(nombreUsuario);

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
            ruta = MisUtiles.copiarImagen(ruta, "IMAGENES\\");
            Image mImagen = new ImageIcon(ruta).getImage();
            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(ImagenLabel.getWidth(), ImagenLabel.getHeight(), 0));
            ImagenLabel.setIcon(mIcono);
        }

    }//GEN-LAST:event_ImagenButtonMousePressed

    private void ImagenLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenLabelMousePressed

        ImagenLabel.setIcon(null);
        ImagenLabel.setText(null);
        ruta = null;
    }//GEN-LAST:event_ImagenLabelMousePressed

    private void BotonEliminarPorNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEliminarPorNombreMousePressed

        String nombre = JOptionPane.showInputDialog(this, "Introduce el nombre exacto del producto", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION);
        if (nombre != null) {
            ArrayList productos = gestorBDR.convertirBDRALista();

            for (int i = 0; i < productos.size(); i++) {
                Producto producto = (Producto) productos.get(i);
                if (producto.getNombre().equals(nombre)) {
                    MisUtiles.borrarImagen(producto.getrutaImagen());
                }
            }

            if (gestorBDR.borrarProductoPorNombre(nombre)) {
                actualizarTabla();
            } else {
                mostrarMensajeError("Se ha producido un error al borrar un usuario por nombre, "
                        + "verifica que el usuario es correcto");
            }
        }

    }//GEN-LAST:event_BotonEliminarPorNombreMousePressed

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
    private javax.swing.JButton BotonEliminarPorNombre;
    private javax.swing.JButton BotonEliminarSeleccionado;
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

        ArrayList productos = gestorBDR.convertirBDRALista();
        Producto producto;
        datosProductos = new Object[productos.size()][4];

        if (productos != null) {
            for (int i = 0; i < productos.size(); i++) {
                producto = (Producto) productos.get(i);
                datosProductos[i][0] = producto.getNombre();
                datosProductos[i][1] = producto.getPrecio() + "€";
                datosProductos[i][2] = producto.getCantidad();
                datosProductos[i][3] = producto.getrutaImagen();

                try {
                    ruta = (String) datosProductos[i][3];
                    if (ruta == null) {
                        datosProductos[i][3] = new JLabel("NO HAY IMAGEN");
                    } else {
                        ImageIcon icono = new ImageIcon(ruta);
                        Image imagen = icono.getImage();
                        Image nuevaImagen = imagen.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
                        Icon iconoEscalado = new ImageIcon(nuevaImagen);
                        datosProductos[i][3] = new JLabel(iconoEscalado);
                    }
                } catch (Exception e) {
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

    }

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
                        datosProductos = MisUtiles.ordenarNombre(datosProductos);
                        break;
                    case "PRECIO":
                        datosProductos = MisUtiles.ordenarPrecio(datosProductos);
                        break;
                    case "CANTIDAD":
                        datosProductos = MisUtiles.ordenarCantidad(datosProductos);
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
                color = gestorEstilos.buscarColorEnFichero(opcion, 3, nombreFicheroEstilos, datosEstilos);
                gestorEstilos.cambiarColor(paneles, color);
                color = gestorEstilos.buscarColorEnFichero(opcion, 4, nombreFicheroEstilos, datosEstilos);
                gestorEstilos.cambiarColor(textos, color);

            }
        });
    }

    private void actualizarOpcionesEstilos() {
        try {
            DiseñoComboBox.removeAllItems();
            FileInputStream fis = new FileInputStream(nombreFicheroEstilos);
            ObjectInputStream ois = new ObjectInputStream(fis);
            datosEstilos = (Object[][]) ois.readObject();
            for (Object[] dato : datosEstilos) {
                String titulo = (String) dato[2];
                DiseñoComboBox.addItem(titulo);
            }
        } catch (IOException | ClassNotFoundException e) {
        }
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    private void mostrarMensajeInformacion(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }

}
