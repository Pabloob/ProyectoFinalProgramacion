package VISTA;

import CONTROLADORES.GestorEstilosGUI;
import LIBRERIAS.MisUtiles;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static VISTA.GestionProductos.nombreFicheroEstilos;

public class GestionConfiguracionesGraficas extends javax.swing.JFrame implements Serializable {

    //Gestos de estilos
    GestorEstilosGUI gestorEstilos = new GestorEstilosGUI();

    //Nombre de las columnas
    String[] nomCols = {"ID", "USR. CREADOR", "TITULO", "COLOR FONDO", "COLOR TEXTO", "FECHA"};

    //Array de datos
    Object[][] datos;

    //DTM
    DefaultTableModel listaEstilos = new DefaultTableModel(datos, nomCols);

    //Variable para el usuario que ha iniciado sesion
    String usr;
    //Variable para la fila seleccionada anteriormente
    int filaSeleccionadaAnteriormente=-1;

    public GestionConfiguracionesGraficas() {
        setTitle("Configuracion de estilos");
        initComponents();
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        cargar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        Datos = new javax.swing.JPanel();
        TITULO = new javax.swing.JLabel();
        ColorFondo = new javax.swing.JLabel();
        TituloTextField = new javax.swing.JTextField();
        VaciarDespuesAñadirCheckBox = new javax.swing.JCheckBox();
        ColoresFondoButton = new javax.swing.JToggleButton();
        ColorTexto = new javax.swing.JLabel();
        ColoresTextoButton = new javax.swing.JToggleButton();
        PanelPrevisualizacion = new javax.swing.JPanel();
        TextoPrevisualizacion = new javax.swing.JLabel();
        BotonesBorrar = new javax.swing.JPanel();
        CargarEjemplosButton = new javax.swing.JButton();
        VaciarButton = new javax.swing.JButton();
        ActualizarButton = new javax.swing.JButton();
        AñadirButton = new javax.swing.JButton();
        BorrarSeleccionadoButton = new javax.swing.JButton();
        Tabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaEstilos = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        Datos.setBackground(new java.awt.Color(255, 255, 255));
        Datos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TITULO.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TITULO.setText("TITULO");

        ColorFondo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ColorFondo.setText("COLOR FONDO");

        TituloTextField.setBackground(new java.awt.Color(204, 204, 204));
        TituloTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TituloTextFieldActionPerformed(evt);
            }
        });

        VaciarDespuesAñadirCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        VaciarDespuesAñadirCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        VaciarDespuesAñadirCheckBox.setText("Vaciar despues de añadir");
        VaciarDespuesAñadirCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VaciarDespuesAñadirCheckBoxActionPerformed(evt);
            }
        });

        ColoresFondoButton.setBackground(new java.awt.Color(255, 255, 255));
        ColoresFondoButton.setText("COLORES");
        ColoresFondoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ColoresFondoButtonMousePressed(evt);
            }
        });

        ColorTexto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ColorTexto.setText("COLOR TEXTO");

        ColoresTextoButton.setBackground(new java.awt.Color(255, 255, 255));
        ColoresTextoButton.setText("COLORES");
        ColoresTextoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ColoresTextoButtonMousePressed(evt);
            }
        });

        PanelPrevisualizacion.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrevisualizacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TextoPrevisualizacion.setBackground(new java.awt.Color(255, 255, 255));
        TextoPrevisualizacion.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        TextoPrevisualizacion.setForeground(new java.awt.Color(0, 0, 0));
        TextoPrevisualizacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextoPrevisualizacion.setText("PRUEBA");

        javax.swing.GroupLayout PanelPrevisualizacionLayout = new javax.swing.GroupLayout(PanelPrevisualizacion);
        PanelPrevisualizacion.setLayout(PanelPrevisualizacionLayout);
        PanelPrevisualizacionLayout.setHorizontalGroup(
            PanelPrevisualizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TextoPrevisualizacion, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
        );
        PanelPrevisualizacionLayout.setVerticalGroup(
            PanelPrevisualizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TextoPrevisualizacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DatosLayout = new javax.swing.GroupLayout(Datos);
        Datos.setLayout(DatosLayout);
        DatosLayout.setHorizontalGroup(
            DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DatosLayout.createSequentialGroup()
                        .addComponent(VaciarDespuesAñadirCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(165, 165, 165))
                    .addGroup(DatosLayout.createSequentialGroup()
                        .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ColorTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TITULO)
                            .addComponent(ColorFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ColoresFondoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                .addComponent(TituloTextField))
                            .addComponent(ColoresTextoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(PanelPrevisualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        DatosLayout.setVerticalGroup(
            DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DatosLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DatosLayout.createSequentialGroup()
                        .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TITULO)
                            .addComponent(TituloTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ColorFondo)
                            .addComponent(ColoresFondoButton))
                        .addGap(18, 18, 18)
                        .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ColorTexto)
                            .addComponent(ColoresTextoButton))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(PanelPrevisualizacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(VaciarDespuesAñadirCheckBox)
                .addGap(32, 32, 32))
        );

        BotonesBorrar.setBackground(new java.awt.Color(255, 255, 255));
        BotonesBorrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        CargarEjemplosButton.setBackground(new java.awt.Color(255, 255, 255));
        CargarEjemplosButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CargarEjemplosButton.setText("Cargar ejemplos");
        CargarEjemplosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarEjemplosButtonActionPerformed(evt);
            }
        });

        VaciarButton.setBackground(new java.awt.Color(255, 255, 255));
        VaciarButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        VaciarButton.setText("Vaciar campos");
        VaciarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VaciarButtonActionPerformed(evt);
            }
        });

        ActualizarButton.setBackground(new java.awt.Color(255, 255, 255));
        ActualizarButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ActualizarButton.setText("Actualizar");
        ActualizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarButtonActionPerformed(evt);
            }
        });

        AñadirButton.setBackground(new java.awt.Color(255, 255, 255));
        AñadirButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AñadirButton.setText("Añadir");
        AñadirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirButtonActionPerformed(evt);
            }
        });

        BorrarSeleccionadoButton.setBackground(new java.awt.Color(255, 255, 255));
        BorrarSeleccionadoButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BorrarSeleccionadoButton.setText("Borrar");
        BorrarSeleccionadoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BorrarSeleccionadoButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BotonesBorrarLayout = new javax.swing.GroupLayout(BotonesBorrar);
        BotonesBorrar.setLayout(BotonesBorrarLayout);
        BotonesBorrarLayout.setHorizontalGroup(
            BotonesBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonesBorrarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(VaciarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BorrarSeleccionadoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AñadirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ActualizarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CargarEjemplosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        BotonesBorrarLayout.setVerticalGroup(
            BotonesBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotonesBorrarLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(BotonesBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VaciarButton)
                    .addComponent(ActualizarButton)
                    .addComponent(AñadirButton)
                    .addComponent(CargarEjemplosButton)
                    .addComponent(BorrarSeleccionadoButton))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        Tabla.setBackground(new java.awt.Color(255, 255, 255));
        Tabla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTablaEstilos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "USR. CREADOR", "Titulo", "Color fondo", "Color texto", "Fecha"
            }
        ));
        jTablaEstilos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTablaEstilosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTablaEstilos);

        javax.swing.GroupLayout TablaLayout = new javax.swing.GroupLayout(Tabla);
        Tabla.setLayout(TablaLayout);
        TablaLayout.setHorizontalGroup(
            TablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                .addContainerGap())
        );
        TablaLayout.setVerticalGroup(
            TablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(BotonesBorrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Datos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addComponent(Datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonesBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TituloTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TituloTextFieldActionPerformed
    }//GEN-LAST:event_TituloTextFieldActionPerformed

    private void VaciarDespuesAñadirCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VaciarDespuesAñadirCheckBoxActionPerformed
    }//GEN-LAST:event_VaciarDespuesAñadirCheckBoxActionPerformed

    private void AñadirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirButtonActionPerformed
        //Se añaden los datos de el nuevo estilo y se calcula el id mas bajo disponible
        int id = MisUtiles.calcularNumMayor(datos, 0);
        String titulo = TituloTextField.getText().strip();
        Color colorFondo = PanelPrevisualizacion.getBackground();
        Color colorTexto = TextoPrevisualizacion.getForeground();

        //Si el titulo no esta vacio se añade el nuevo estilo
        if (!titulo.isEmpty()) {
            if (gestorEstilos.añadirEstilo(id, usr.strip(), titulo, colorFondo, colorTexto)) {
                actualizarTabla();
                if (VaciarDespuesAñadirCheckBox.isSelected()) {
                    vaciarDatos();
                }
            } else {
                mostrarMensajeError("Se ha producido un error al añadir el estilo");
            }

        } else {
            mostrarMensajeError("El campo titulo no puede estar vacio");
        }

    }//GEN-LAST:event_AñadirButtonActionPerformed

    private void VaciarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VaciarButtonActionPerformed
        //Vacia todos los text fields
        vaciarDatos();
    }//GEN-LAST:event_VaciarButtonActionPerformed

    private void ActualizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarButtonActionPerformed
        int filaSeleccionada = jTablaEstilos.getSelectedRow();

        //Se comprueba que se ha seleccionado alguna fila
        if (filaSeleccionada >= 0) {

            //Se añaden los datos necesarios
            String nombreCreadorEstilos = (String) datos[filaSeleccionada][1];
            if (nombreCreadorEstilos.equalsIgnoreCase(usr)) {
                int id = MisUtiles.calcularNumMayor(datos, 0);
                Color colorFondo = PanelPrevisualizacion.getBackground();
                Color colorTexto = TextoPrevisualizacion.getForeground();
                String nombreBorrar = (String) datos[filaSeleccionada][2];
                String titulo = TituloTextField.getText().strip();

                //Se comprueba que el titulo no sea nulo
                if (titulo != null) {

                    if (gestorEstilos.borrarEstilo(nombreBorrar) && gestorEstilos.añadirEstilo(id, usr.strip(), titulo, colorFondo, colorTexto)) {
                        actualizarTabla();
                        if (VaciarDespuesAñadirCheckBox.isSelected()) {
                            vaciarDatos();
                        }
                    } else {
                        mostrarMensajeError("Se ha producido un error al actualizar los datos del estilo");
                    }

                } else {
                    mostrarMensajeError("El campo titulo no puede estar vacío");
                }
            } else {
                mostrarMensajeError("No puedes eliminar el estilo de otro usuario");
            }
        } else {
            mostrarMensajeError("No se ha seleccionado ninguna fila");
        }

    }//GEN-LAST:event_ActualizarButtonActionPerformed

    private void CargarEjemplosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarEjemplosButtonActionPerformed
        //Se añaden los ejemplos
        if (gestorEstilos.añadirEjemplosEstilos(usr)) {
            actualizarTabla();
            mostrarMensajeInformacion("Se han cargado los estilos correctamente");
        } else {
            mostrarMensajeError("Se ha producido un error cargar los estilos");
        }
    }//GEN-LAST:event_CargarEjemplosButtonActionPerformed

    private void jTablaEstilosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaEstilosMousePressed

        int filaSeleccionada = jTablaEstilos.getSelectedRow();
        //Se comprueba que la fila seleccionada anteriomente no sea la misma
        
        if (filaSeleccionada != filaSeleccionadaAnteriormente) {
            //Se añaden los datos de la fila seleccionada a los campos correspondientes si no es la misma que la anterior
            Color colorFondo, colorTexto;
            String titulo = (String) datos[filaSeleccionada][2];
            colorFondo = gestorEstilos.conseguirColorPorRGB((String) datos[filaSeleccionada][3]);
            colorTexto = gestorEstilos.conseguirColorPorRGB((String) datos[filaSeleccionada][4]);
            TituloTextField.setText(titulo);
            PanelPrevisualizacion.setBackground(colorFondo);
            TextoPrevisualizacion.setForeground(colorTexto);
            filaSeleccionadaAnteriormente = filaSeleccionada;
        } else {
            //Si es la misma fila se vaciaran los campos y se pondra como fila seleccionada anteriormente una que nunca se puede seleccionar
            vaciarDatos();
        }


    }//GEN-LAST:event_jTablaEstilosMousePressed

    private void ColoresFondoButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ColoresFondoButtonMousePressed

        //Se abre una ventana para seleccionar el color de fondo y se añade a la previsualizacion
        Color color = JColorChooser.showDialog(this, "Selecciona color", null);
        PanelPrevisualizacion.setBackground(color);
    }//GEN-LAST:event_ColoresFondoButtonMousePressed

    private void ColoresTextoButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ColoresTextoButtonMousePressed

        //Se abre una ventana para seleccionar el color de texto y se añade a la previsualizacion
        Color color = JColorChooser.showDialog(this, "Selecciona color", null);
        TextoPrevisualizacion.setForeground(color);
    }//GEN-LAST:event_ColoresTextoButtonMousePressed

    private void BorrarSeleccionadoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BorrarSeleccionadoButtonMouseClicked
        int filaSeleccionada = jTablaEstilos.getSelectedRow();

        //Se comprueba que se ha seleccionado alguna fila
        if (filaSeleccionada >= 0) {
            String nombreCreadorEstilos = (String) datos[filaSeleccionada][1];
            if (nombreCreadorEstilos.equalsIgnoreCase(usr)) {
                String nombre = (String) datos[filaSeleccionada][2];
                //Se borra el estilo
                if (gestorEstilos.borrarEstilo(nombre)) {

                    actualizarTabla();
                    vaciarDatos();
                } else {
                    mostrarMensajeError("Se ha producido un error al borrar el estilo");
                }
            } else {
                mostrarMensajeError("No puedes eliminar el estilo de otro usuario");
            }
        } else {
            mostrarMensajeError("No se ha seleccionado ninguna fila");
        }
    }//GEN-LAST:event_BorrarSeleccionadoButtonMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionConfiguracionesGraficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new GestionConfiguracionesGraficas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarButton;
    private javax.swing.JButton AñadirButton;
    private javax.swing.JButton BorrarSeleccionadoButton;
    private javax.swing.JPanel BotonesBorrar;
    private javax.swing.JButton CargarEjemplosButton;
    private javax.swing.JLabel ColorFondo;
    private javax.swing.JLabel ColorTexto;
    private javax.swing.JToggleButton ColoresFondoButton;
    private javax.swing.JToggleButton ColoresTextoButton;
    private javax.swing.JPanel Datos;
    private javax.swing.JPanel PanelPrevisualizacion;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JLabel TITULO;
    private javax.swing.JPanel Tabla;
    private javax.swing.JLabel TextoPrevisualizacion;
    private javax.swing.JTextField TituloTextField;
    private javax.swing.JButton VaciarButton;
    private javax.swing.JCheckBox VaciarDespuesAñadirCheckBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaEstilos;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        //Se actualiza la tabla con los datos de el array
        datos = gestorEstilos.convertirListaADTM();
        listaEstilos = new DefaultTableModel(datos, nomCols) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        jTablaEstilos.setModel(listaEstilos);
        guardar();
    }

    private void vaciarDatos() {
        TituloTextField.setText(null);
        PanelPrevisualizacion.setBackground(null);
        TextoPrevisualizacion.setForeground(null);
        filaSeleccionadaAnteriormente = -1;
    }

    private void cargar() {
        //Metodo para cargar los datos de el fichero donde se almacenan los datos de estilos
        Color colorFondo;
        Color colorTexto;
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(nombreFicheroEstilos);
            ois = new ObjectInputStream(fis);
            datos = (Object[][]) ois.readObject();
            for (Object[] dato : datos) {
                int id = (int) dato[0];
                String usuario = (String) dato[1];
                String titulo = (String) dato[2];
                String fondo = (String) dato[3];
                String texto = (String) dato[4];
                String fecha = (String) dato[5];
                colorFondo = gestorEstilos.conseguirColorPorRGB(fondo);
                colorTexto = gestorEstilos.conseguirColorPorRGB(texto);
                gestorEstilos.añadirEstilo(id, usuario, titulo, colorFondo, colorTexto, fecha);
                actualizarTabla();
            }
        } catch (IOException | ClassNotFoundException e) {
        }
    }

    private void guardar() {

        //Metodo para guardar los datos de los estilos en un fichero
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(nombreFicheroEstilos);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(gestorEstilos.convertirListaADTM());
        } catch (IOException e) {
        }
    }

    public void setNombreUsuario(String nombreUsuario) {
        //Metodo para guardar el nombre del usuario que ha iniciado sesion
        this.usr = nombreUsuario;
    }

    private void mostrarMensajeError(String mensaje) {
        //Metodo para mostrar mensajes de error
        JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    private void mostrarMensajeInformacion(String mensaje) {
        //Metodos para mostrar mensajes informativos
        JOptionPane.showMessageDialog(this, mensaje, "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datosNuevos) {

        //Se actualizan los datos con un nuevo array[][]
        gestorEstilos.vaciar();
        datos = datosNuevos;

        for (Object[] dato : datos) {

            int id = MisUtiles.calcularNumMayor(datos, 0);
            String nombreUsuario = (String) dato[1];
            String titulo = (String) dato[2];
            Color colorFondo = gestorEstilos.conseguirColorPorRGB((String) dato[3]);
            Color colorTexto = gestorEstilos.conseguirColorPorRGB((String) dato[4]);
            gestorEstilos.añadirEstilo(id, nombreUsuario, titulo, colorFondo, colorTexto);
            vaciarDatos();

        }
        actualizarTabla();
    }

}
