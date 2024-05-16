package VISTA;

import CONTROLADORES.GestorBDR;
import CONTROLADORES.GestorEstilosGUI;
import LIBRERIAS.MisUtiles;
import MODELOS.Producto;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

public class GestionProductos extends javax.swing.JFrame {

    //Nombres de ficheros de tipo final que no se modificaran y static para compartirlos con las 3 ventanas
    public static final String nombreFicheroXMLProductos = "archivosConfiguracion\\Productos.xml";
    public static final String nombreFicheroConectarBDR = "archivosConfiguracion\\ConexionBDR.txt";
    public static final String nombreFicheroEstilos = "archivosConfiguracion\\estilos.dat";

    //Gestores de la base de datos
    GestorBDR gestorBDR = new GestorBDR();
    GestorEstilosGUI gestorEstilos = new GestorEstilosGUI();

    //Nombres de las columnas
    String[] nomCols = {"NOMBRE", "PRECIO", "CANTIDAD", "IMAGEN"};

    //Array de datos
    Object[][] datosProductos;
    Object[][] datosEstilos;

    //Dtm de la tabla con los datos de los productos y los nombres de las columnas
    DefaultTableModel listaProductos = new DefaultTableModel(datosProductos, nomCols) {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    //Variables
    boolean imagenPulsada = false;
    boolean imagenAñadida = false;
    int filaSeleccionadaAnteriormente = -1;

    //Variables de la ruta de la imagen que se añadira y el nombre de usuario con el que se ha iniciado sesion
    String rutaImagenAñadir;
    String nombreUsuario;

    public GestionProductos() {
        //Se intenta conectar con la base de datos con el fichero de conecxion de la BDR 
        if (gestorBDR.conectarPorFicheroBDR(nombreFicheroConectarBDR)) {
            //Si se ha conectado se añade el titulo de la ventana y se inician todos los componentes y configuracion de la ventana
            setTitle("Control inventario tienda");
            setAlwaysOnTop(true);
            initComponents();
            actualizarTabla();
            setLocationRelativeTo(null);
            eventoOrdenar();
            eventoEstilos();
            eventoCerrarVentana();
            relojFecha.start();
            actualizarOpcionesEstilos();
            jTablaProductos.setRowHeight(100);
            jTablaProductos.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTablaProductos.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTablaProductos.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTablaProductos.getColumnModel().getColumn(3).setPreferredWidth(100);

        } else {
            //Si no se ha conectado se muestra el mensaje de error y se cierra el programa
            System.err.println("Ha ocurrido un error al conectar con la base de datos");
            System.exit(0);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        FECHA = new javax.swing.JLabel();
        PanelBotones = new javax.swing.JPanel();
        BotonGestionarUsuarios = new javax.swing.JButton();
        BotonAñadir = new javax.swing.JButton();
        BotonEliminarSeleccionado = new javax.swing.JButton();
        BotonConfigurarpantalla = new javax.swing.JButton();
        BotonEliminarPorNombre = new javax.swing.JButton();
        BotonCargar = new javax.swing.JButton();
        BotonActualizar = new javax.swing.JButton();
        BotonGuardar = new javax.swing.JButton();
        PanelDatos = new javax.swing.JPanel();
        DISEÑO = new javax.swing.JLabel();
        ORDENAR = new javax.swing.JLabel();
        Cantidad = new javax.swing.JLabel();
        Precio = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        TextFieldNombre = new javax.swing.JTextField();
        TextFieldPrecio = new javax.swing.JTextField();
        TextFieldCantidad = new javax.swing.JTextField();
        OrdenarPor = new javax.swing.JComboBox<>();
        DiseñoComboBox = new javax.swing.JComboBox<>();
        ImagenButton = new javax.swing.JButton();
        ActualizarDiseñosButton = new javax.swing.JButton();
        PanelImagen = new javax.swing.JPanel();
        ImagenLabel = new javax.swing.JLabel();
        PanelTabla = new javax.swing.JPanel();
        TablaProductos = new javax.swing.JScrollPane();
        jTablaProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1350, 600));
        setResizable(false);

        PanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        FECHA.setBackground(new java.awt.Color(255, 255, 255));
        FECHA.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        FECHA.setForeground(new java.awt.Color(0, 0, 0));

        PanelBotones.setBackground(new java.awt.Color(255, 255, 255));

        BotonGestionarUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        BotonGestionarUsuarios.setText("Gestionar Usuarios");
        BotonGestionarUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonGestionarUsuariosMousePressed(evt);
            }
        });

        BotonAñadir.setBackground(new java.awt.Color(255, 255, 255));
        BotonAñadir.setText("AÑADIR");
        BotonAñadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonAñadirMousePressed(evt);
            }
        });

        BotonEliminarSeleccionado.setBackground(new java.awt.Color(255, 255, 255));
        BotonEliminarSeleccionado.setText("ELIMINAR SELECCIONADO");
        BotonEliminarSeleccionado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonEliminarSeleccionadoMousePressed(evt);
            }
        });

        BotonConfigurarpantalla.setBackground(new java.awt.Color(255, 255, 255));
        BotonConfigurarpantalla.setText("Configurar pantalla");
        BotonConfigurarpantalla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonConfigurarpantallaMousePressed(evt);
            }
        });

        BotonEliminarPorNombre.setBackground(new java.awt.Color(255, 255, 255));
        BotonEliminarPorNombre.setText("ELIMINAR POR NOMBRE");
        BotonEliminarPorNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonEliminarPorNombreMousePressed(evt);
            }
        });

        BotonCargar.setBackground(new java.awt.Color(255, 255, 255));
        BotonCargar.setText("CARGAR");
        BotonCargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonCargarMousePressed(evt);
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

        javax.swing.GroupLayout PanelBotonesLayout = new javax.swing.GroupLayout(PanelBotones);
        PanelBotones.setLayout(PanelBotonesLayout);
        PanelBotonesLayout.setHorizontalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBotonesLayout.createSequentialGroup()
                .addContainerGap(563, Short.MAX_VALUE)
                .addGroup(PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addGroup(PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelBotonesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelBotonesLayout.createSequentialGroup()
                            .addComponent(BotonAñadir, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BotonEliminarSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BotonEliminarPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(204, 204, 204))
                        .addGroup(PanelBotonesLayout.createSequentialGroup()
                            .addComponent(BotonGestionarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BotonConfigurarpantalla, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BotonCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        PanelBotonesLayout.setVerticalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(BotonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelBotonesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BotonAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotonEliminarSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotonEliminarPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(55, 55, 55)
                    .addGroup(PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BotonConfigurarpantalla, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotonGestionarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotonCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        PanelDatos.setBackground(new java.awt.Color(255, 255, 255));

        DISEÑO.setBackground(new java.awt.Color(255, 255, 255));
        DISEÑO.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        DISEÑO.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DISEÑO.setText("DISEÑO");

        ORDENAR.setBackground(new java.awt.Color(255, 255, 255));
        ORDENAR.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ORDENAR.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ORDENAR.setText("ORDENAR POR");

        Cantidad.setBackground(new java.awt.Color(255, 255, 255));
        Cantidad.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Cantidad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Cantidad.setText("CANTIDAD");

        Precio.setBackground(new java.awt.Color(255, 255, 255));
        Precio.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Precio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Precio.setText("PRECIO");

        Nombre.setBackground(new java.awt.Color(255, 255, 255));
        Nombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Nombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Nombre.setText("NOMBRE");

        TextFieldNombre.setBackground(new java.awt.Color(204, 204, 204));

        TextFieldPrecio.setBackground(new java.awt.Color(204, 204, 204));

        TextFieldCantidad.setBackground(new java.awt.Color(204, 204, 204));

        OrdenarPor.setBackground(new java.awt.Color(255, 255, 255));
        OrdenarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NOMBRE", "PRECIO", "CANTIDAD"}));

        DiseñoComboBox.setBackground(new java.awt.Color(255, 255, 255));
        DiseñoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        ImagenButton.setBackground(new java.awt.Color(255, 255, 255));
        ImagenButton.setText("IMAGEN");
        ImagenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ImagenButtonMousePressed(evt);
            }
        });

        ActualizarDiseñosButton.setBackground(new java.awt.Color(255, 255, 255));
        ActualizarDiseñosButton.setText("Actualizar diseños");
        ActualizarDiseñosButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ActualizarDiseñosButtonMousePressed(evt);
            }
        });

        PanelImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ImagenLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ImagenLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PanelImagenLayout = new javax.swing.GroupLayout(PanelImagen);
        PanelImagen.setLayout(PanelImagenLayout);
        PanelImagenLayout.setHorizontalGroup(
            PanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
            .addGroup(PanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelImagenLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ImagenLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        PanelImagenLayout.setVerticalGroup(
            PanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 165, Short.MAX_VALUE)
            .addGroup(PanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelImagenLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ImagenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout PanelDatosLayout = new javax.swing.GroupLayout(PanelDatos);
        PanelDatos.setLayout(PanelDatosLayout);
        PanelDatosLayout.setHorizontalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addComponent(DISEÑO, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DiseñoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(ActualizarDiseñosButton)
                        .addGap(64, 64, 64))
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addComponent(ORDENAR, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OrdenarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ImagenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63))
            .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelDatosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelDatosLayout.createSequentialGroup()
                            .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelDatosLayout.createSequentialGroup()
                            .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelDatosLayout.createSequentialGroup()
                            .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(450, Short.MAX_VALUE)))
        );
        PanelDatosLayout.setVerticalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDatosLayout.createSequentialGroup()
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ORDENAR)
                        .addComponent(OrdenarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(ImagenButton))
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ActualizarDiseñosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DISEÑO)
                            .addComponent(DiseñoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelDatosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Nombre)
                        .addComponent(TextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Precio))
                    .addGap(18, 18, 18)
                    .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Cantidad))
                    .addContainerGap(99, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addComponent(PanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FECHA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelDatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                .addComponent(FECHA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(PanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        PanelTabla.setBackground(new java.awt.Color(255, 255, 255));
        PanelTabla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        javax.swing.GroupLayout PanelTablaLayout = new javax.swing.GroupLayout(PanelTabla);
        PanelTabla.setLayout(PanelTablaLayout);
        PanelTablaLayout.setHorizontalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TablaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTablaLayout.setVerticalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
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
                .addComponent(PanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonGuardarMousePressed
        //Se guardan los datos de los productos en el fichero XML y se muestra un mensaje informativo
        ArrayList productos = gestorBDR.convertirBDRALista();
        Object productosTemp[][] = convertirListaAArray(productos);
        if (gestorBDR.guardarProductosEnFicheroXML(productosTemp, nombreFicheroXMLProductos)) {
            mostrarMensajeInformacion("Se han guardado los productos correctamente");
        } else {
            mostrarMensajeError("Se ha producido un error al guardar los productos");
        }
        vaciarDatos();
    }//GEN-LAST:event_BotonGuardarMousePressed

    private void BotonCargarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonCargarMousePressed
        //Se cargan los datos del fichero XML en la BDR y se muestra un mensaje informativo
        if (gestorBDR.cargarProductosDeFicheroXML(nombreFicheroXMLProductos)) {
            actualizarTabla();
            mostrarMensajeInformacion("Se han cargado los productos correctamente");
        } else {
            mostrarMensajeError("Se ha producido un error cargar los productos");
        }
        vaciarDatos();
    }//GEN-LAST:event_BotonCargarMousePressed

    private void jTablaProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaProductosMousePressed
        int filaSeleccionada = jTablaProductos.getSelectedRow();

        //Se comprueba si la fila seleccionada anteriormente es igual a la fila seleccionada actual
        if (filaSeleccionada != filaSeleccionadaAnteriormente) {
            //En caso de que no sea la misma fila se muestran los datos
            //Se añaden los datos de el producto seleccionado a los textFields, desplegables y label
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
            }
            filaSeleccionadaAnteriormente = filaSeleccionada;
        } else {
            //Si es la misma fila se vacian los textfields y se resetea la filaseleccionada anteriormente a una fila que nunca se puede seleccionar
            vaciarDatos();
        }

    }//GEN-LAST:event_jTablaProductosMousePressed

    private void BotonEliminarSeleccionadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEliminarSeleccionadoMousePressed

        //Se verifica si se ha seleccionado alguna fila
        int filaSeleccionado = jTablaProductos.getSelectedRow();
        if (filaSeleccionado >= 0) {
            //Se borra el producto de la fila seleccionada por el nombre
            ArrayList productos = gestorBDR.convertirBDRALista();
            Producto producto = (Producto) productos.get(filaSeleccionado);
            String nombre = (String) datosProductos[filaSeleccionado][0];
            if (gestorBDR.borrarProductoPorNombre(nombre)) {
                actualizarTabla();
            } else {
                mostrarMensajeError("Se ha producido un error al borrar el producto");
            }
        } else {
            mostrarMensajeError("No se ha seleccionado ninguna fila");
        }
        vaciarDatos();
    }//GEN-LAST:event_BotonEliminarSeleccionadoMousePressed

    private void BotonAñadirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAñadirMousePressed

        //Se añaden los datos de los textFields, desplegables y imagen a las variables comprobando el precio y cantidad
        String nombre = TextFieldNombre.getText().strip();
        float precio = MisUtiles.comprobarFloatPositivo(TextFieldPrecio.getText());
        int cantidad = MisUtiles.comprobarIntPositivo(TextFieldCantidad.getText());
        if (precio > 0 && cantidad > 0) {
            //Si el precio y cantidad son correctos se añaden los datos a el nuevo producto
            if (!nombre.isEmpty()) {
                Producto producto = new Producto();
                producto.setNombre(nombre);
                producto.setPrecio(precio);
                producto.setCantidad(cantidad);
                if (rutaImagenAñadir == null) {
                    producto.setrutaImagen(null);
                } else {
                    producto.setrutaImagen(rutaImagenAñadir);
                }
                if (gestorBDR.añadirProducto(producto)) {
                    actualizarTabla();
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
        vaciarDatos();
    }//GEN-LAST:event_BotonAñadirMousePressed

    private void BotonActualizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonActualizarMousePressed
        //Se comprueba si se ha seleccionado alguna fila
        int filaSeleccionada = jTablaProductos.getSelectedRow();

        if (filaSeleccionada >= 0) {
            //Si se ha seleccionado alguna fila se crea un nuevo producto con los nuevos datos
            Producto productoAñadir = new Producto();
            String nombreBorrar = (String) datosProductos[filaSeleccionada][0];

            ArrayList productos = gestorBDR.convertirBDRALista();
            Producto producto = (Producto) productos.get(filaSeleccionada);
            String nombre = TextFieldNombre.getText().strip();
            float precio = MisUtiles.comprobarFloatPositivo(TextFieldPrecio.getText());
            int cantidad = MisUtiles.comprobarIntPositivo(TextFieldCantidad.getText());
            if (precio > 0 && cantidad > 0) {

                if (!nombre.isEmpty()) {
                    productoAñadir.setNombre(nombre);
                    productoAñadir.setPrecio(precio);
                    productoAñadir.setCantidad(cantidad);

                    if (!imagenAñadida && !imagenPulsada) {
                        productoAñadir.setrutaImagen(producto.getrutaImagen());
                    } else {
                        if (rutaImagenAñadir == null) {
                            productoAñadir.setrutaImagen(null);
                        } else {
                            productoAñadir.setrutaImagen(rutaImagenAñadir);
                        }
                    }

                    if (gestorBDR.borrarProductoPorNombre(nombreBorrar) && gestorBDR.añadirProducto(productoAñadir)) {
                        actualizarTabla();
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
        vaciarDatos();
    }//GEN-LAST:event_BotonActualizarMousePressed

    private void BotonGestionarUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonGestionarUsuariosMousePressed
        //Boton activar la ventana 2 
        GestionUsuarios ventanaUsuarios = new GestionUsuarios();
        ventanaUsuarios.setVisible(true);
    }//GEN-LAST:event_BotonGestionarUsuariosMousePressed

    private void BotonConfigurarpantallaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonConfigurarpantallaMousePressed
        //Boton activar la ventana 3 y añadir el nombre de usuario
        GestionConfiguracionesGraficas ventanaEstilos = new GestionConfiguracionesGraficas();
        ventanaEstilos.setVisible(true);
        ventanaEstilos.setNombreUsuario(nombreUsuario);
    }//GEN-LAST:event_BotonConfigurarpantallaMousePressed

    private void ImagenButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenButtonMousePressed
        //Boton que muestra una ventana para elegir la imagen
        JFileChooser fileChooser = new JFileChooser();
        //Las extensiones disponibles para añadir
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        fileChooser.setFileFilter(extensionFilter);

        //Se comrueba si se ha seleccionado alguna imagen y es valida
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            //Se asigna la ruta a la variable y se copia la imagen en una carpeta llamada IMAGENES que se encuentra dentro del proyecto
            rutaImagenAñadir = fileChooser.getSelectedFile().getAbsolutePath();
            rutaImagenAñadir = MisUtiles.copiarImagen(rutaImagenAñadir, "respaldoImagenes\\");
            //Se asigna la imagen a el jlabel
            Image mImagen = new ImageIcon(rutaImagenAñadir).getImage();
            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(ImagenLabel.getWidth(), ImagenLabel.getHeight(), 0));
            ImagenLabel.setIcon(null);
            ImagenLabel.setText(null);
            ImagenLabel.setIcon(mIcono);
            imagenAñadida = true;
        }

    }//GEN-LAST:event_ImagenButtonMousePressed

    private void ImagenLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenLabelMousePressed
        //Si el jlabel es presionado se asignan todas las variables corrspondientes en null
        ImagenLabel.setIcon(null);
        ImagenLabel.setText(null);
        rutaImagenAñadir = null;
        imagenPulsada = true;
    }//GEN-LAST:event_ImagenLabelMousePressed

    private void BotonEliminarPorNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEliminarPorNombreMousePressed
        //Se muestra una ventana para añadir el nombre del producto
        String nombre = JOptionPane.showInputDialog(this, "Introduce el nombre exacto del producto", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION);
        if (nombre != null) {
            //Si el nombre no es nulo se borra el producto y la imagen de la carpeta IMAGENES
            ArrayList productos = gestorBDR.convertirBDRALista();

            for (int i = 0; i < productos.size(); i++) {
                Producto producto = (Producto) productos.get(i);
                if (producto.getNombre().equals(nombre)) {
                }
            }

            if (gestorBDR.borrarProductoPorNombre(nombre)) {
                actualizarTabla();
            } else {
                mostrarMensajeError("Se ha producido un error al borrar un usuario por nombre, "
                        + "verifica que el usuario es correcto");
            }
        }
        vaciarDatos();
    }//GEN-LAST:event_BotonEliminarPorNombreMousePressed

    private void ActualizarDiseñosButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActualizarDiseñosButtonMousePressed
        actualizarOpcionesEstilos();
    }//GEN-LAST:event_ActualizarDiseñosButtonMousePressed

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
            java.util.logging.Logger.getLogger(GestionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarDiseñosButton;
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
    private javax.swing.JButton ImagenButton;
    private javax.swing.JLabel ImagenLabel;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel ORDENAR;
    private javax.swing.JComboBox<String> OrdenarPor;
    private javax.swing.JPanel PanelBotones;
    private javax.swing.JPanel PanelDatos;
    private javax.swing.JPanel PanelImagen;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel PanelTabla;
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
        datosProductos = convertirListaAArray(productos);

        for (Object producto[] : datosProductos) {
            producto[1] = producto[1] + "€";
            try {
                rutaImagenAñadir = (String) producto[3];
                //Si la ruta no es nula se crea una imagenen con la ruta y se añade como jlabel dentro de la tabla
                if (rutaImagenAñadir == null) {
                    producto[3] = new JLabel("NO HAY IMAGEN");
                } else {
                    ImageIcon icono = new ImageIcon(rutaImagenAñadir);
                    Image imagen = icono.getImage();
                    Image nuevaImagen = imagen.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
                    Icon iconoEscalado = new ImageIcon(nuevaImagen);
                    producto[3] = new JLabel(iconoEscalado);
                }
            } catch (Exception e) {
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
        //Se actualizan solamente los productos 
        //Este metodo se usa solamente al ordenar los datos por x
        listaProductos.setDataVector(datosProductos, nomCols);
    }

    private Object[][] convertirListaAArray(ArrayList productos) {
        //Se convierte una lita a array
        Producto producto;
        Object datosTemp[][] = new Object[productos.size()][4];

        if (productos != null) {
            for (int i = 0; i < productos.size(); i++) {
                producto = (Producto) productos.get(i);
                datosTemp[i][0] = producto.getNombre();
                datosTemp[i][1] = producto.getPrecio();
                datosTemp[i][2] = producto.getCantidad();
                datosTemp[i][3] = producto.getrutaImagen();
            }
        }
        return datosTemp;
    }

    private void vaciarDatos() {
        //Metodo para vaciar los textFields
        TextFieldCantidad.setText(null);
        TextFieldNombre.setText(null);
        TextFieldPrecio.setText(null);
        ImagenLabel.setText(null);
        ImagenLabel.setIcon(null);
        rutaImagenAñadir = null;
        imagenPulsada = false;
        imagenAñadida = false;
        filaSeleccionadaAnteriormente = -1;
    }

    public void setAdministrador(boolean esAdmin) {
        //Metodo para activar o desactivar los botones de las ventanas de administrador
        //Este metodo se usa en el inicio de sesion
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

    Timer relojFecha = new Timer(0, new ActionListener() {
        // Método para la fehca del reloj
        @Override
        public void actionPerformed(ActionEvent e) {
            Date ahora = new Date();
            SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
            String fechaHoraFormateada = formatoFechaHora.format(ahora);
            FECHA.setText(fechaHoraFormateada);
        }
    });

    private void eventoOrdenar() {
        //Metodo para ordenar los datos de la tabla dependiendo de la opcion del desplegable que se elija
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

    private void eventoEstilos() {
        //Evento para aplicar el estilo seleccionado de el desplegable
        DiseñoComboBox.addActionListener(new ActionListener() {
            String opcion = null;
            JPanel paneles[] = {PanelTabla, PanelPrincipal, PanelDatos, PanelBotones};
            JLabel textos[] = {Nombre, Precio, Cantidad, ORDENAR, DISEÑO, FECHA};
            Color color;

            @Override
            public void actionPerformed(ActionEvent e) {
                //Se usa el metodo de buscar color en fichero con el nombre de la opcion de el comboBox
                opcion = (String) DiseñoComboBox.getSelectedItem();
                color = gestorEstilos.buscarColorEnFichero(opcion, 3, nombreFicheroEstilos, datosEstilos);
                gestorEstilos.cambiarColor(paneles, color);
                color = gestorEstilos.buscarColorEnFichero(opcion, 4, nombreFicheroEstilos, datosEstilos);
                gestorEstilos.cambiarColor(textos, color);

            }
        });
    }

    private void actualizarOpcionesEstilos() {
        //Se actualizan los estilos de la comboBox con los nuevos estilos de el fichero
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

    private void eventoCerrarVentana() {
        //Se cierra la ventna y se desconecta de la base de datos
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                gestorBDR.desconectarBDR();
                System.exit(0);
            }
        });
    }

    //Metodo para guardar el nombre del usuario que ha iniciado sesion que se usa en el inicio de sesion
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    private void mostrarMensajeError(String mensaje) {
        //Metodo para mostrar los mensajes de erro
        JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    private void mostrarMensajeInformacion(String mensaje) {
        //Metodo para mostrar los mensajes de informacion
        JOptionPane.showMessageDialog(this, mensaje, "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
    }

}
