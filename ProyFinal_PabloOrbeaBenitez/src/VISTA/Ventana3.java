package VISTA;

import CONTROLADORES.GestorEstilosGUI;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ventana3 extends javax.swing.JFrame implements Serializable {

    //Gestos de estilos
    GestorEstilosGUI gestorEstilos = new GestorEstilosGUI();

    //Nombre archivo de estilos
    String nomArchivo = "estilos.dat";
    String nomArchivoxml = "exportar.xml";

    //Nombre de las columnas
    String[] nomCols = {"TITULO", "COLOR FONDO", "COLOR TEXTO", "FECHA"};

    //Array de datos
    Object[][] datos;

    //DTM
    DefaultTableModel listaEstilos = new DefaultTableModel(datos, nomCols);

    public Ventana3() {
        initComponents();
        setAlwaysOnTop(true);
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
        BorrarSeleccionadoButton = new javax.swing.JButton();
        CargarEjemplosButton = new javax.swing.JButton();
        VaciarButton = new javax.swing.JButton();
        ActualizarButton = new javax.swing.JButton();
        AñadirButton = new javax.swing.JButton();
        Tabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaEstilos = new javax.swing.JTable();
        GUARDAR = new javax.swing.JButton();
        CARGAR = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));

        Datos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TITULO.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TITULO.setText("TITULO");

        ColorFondo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ColorFondo.setText("COLOR FONDO");

        TituloTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TituloTextFieldActionPerformed(evt);
            }
        });

        VaciarDespuesAñadirCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        VaciarDespuesAñadirCheckBox.setText("Vaciar despues de añadir");
        VaciarDespuesAñadirCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VaciarDespuesAñadirCheckBoxActionPerformed(evt);
            }
        });

        ColoresFondoButton.setBackground(new java.awt.Color(214, 217, 223));
        ColoresFondoButton.setText("COLORES");
        ColoresFondoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ColoresFondoButtonMousePressed(evt);
            }
        });

        ColorTexto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ColorTexto.setText("COLOR TEXTO");

        ColoresTextoButton.setBackground(new java.awt.Color(214, 217, 223));
        ColoresTextoButton.setText("COLORES");
        ColoresTextoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ColoresTextoButtonMousePressed(evt);
            }
        });

        PanelPrevisualizacion.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrevisualizacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TextoPrevisualizacion.setBackground(new java.awt.Color(255, 255, 255));
        TextoPrevisualizacion.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
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
                        .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DatosLayout.createSequentialGroup()
                                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TITULO)
                                    .addComponent(ColorFondo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ColoresFondoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                    .addComponent(TituloTextField)))
                            .addGroup(DatosLayout.createSequentialGroup()
                                .addComponent(ColorTexto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ColoresTextoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)))
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

        BotonesBorrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BorrarSeleccionadoButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BorrarSeleccionadoButton.setText("Borrar seleccionado");
        BorrarSeleccionadoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BorrarSeleccionadoButtonMousePressed(evt);
            }
        });
        BorrarSeleccionadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarSeleccionadoButtonActionPerformed(evt);
            }
        });

        CargarEjemplosButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CargarEjemplosButton.setText("Cargar ejemplos");
        CargarEjemplosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarEjemplosButtonActionPerformed(evt);
            }
        });

        VaciarButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        VaciarButton.setText("Vaciar campos");
        VaciarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VaciarButtonActionPerformed(evt);
            }
        });

        ActualizarButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ActualizarButton.setText("Actualizar");
        ActualizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarButtonActionPerformed(evt);
            }
        });

        AñadirButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AñadirButton.setText("Añadir");
        AñadirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BotonesBorrarLayout = new javax.swing.GroupLayout(BotonesBorrar);
        BotonesBorrar.setLayout(BotonesBorrarLayout);
        BotonesBorrarLayout.setHorizontalGroup(
            BotonesBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotonesBorrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VaciarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BorrarSeleccionadoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AñadirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ActualizarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CargarEjemplosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BotonesBorrarLayout.setVerticalGroup(
            BotonesBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonesBorrarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BotonesBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VaciarButton)
                    .addComponent(ActualizarButton)
                    .addComponent(AñadirButton)
                    .addComponent(BorrarSeleccionadoButton)
                    .addComponent(CargarEjemplosButton))
                .addGap(52, 52, 52))
        );

        Tabla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTablaEstilos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Titulo", "Color fondo", "Color texto", "Fecha"
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
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        TablaLayout.setVerticalGroup(
            TablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TablaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        GUARDAR.setText("GUARDAR");
        GUARDAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GUARDARMousePressed(evt);
            }
        });

        CARGAR.setText("CARGAR");
        CARGAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CARGARMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(GUARDAR)
                        .addGap(46, 46, 46)
                        .addComponent(CARGAR))
                    .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GUARDAR)
                    .addComponent(CARGAR))
                .addGap(0, 88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TituloTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TituloTextFieldActionPerformed
    }//GEN-LAST:event_TituloTextFieldActionPerformed

    private void VaciarDespuesAñadirCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VaciarDespuesAñadirCheckBoxActionPerformed
    }//GEN-LAST:event_VaciarDespuesAñadirCheckBoxActionPerformed

    private void AñadirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirButtonActionPerformed
        //Boton añadir un estilo con los datos

        String titulo = TituloTextField.getText();
        Color colorFondo;
        Color colorTexto;
        colorFondo = PanelPrevisualizacion.getBackground();
        colorTexto = TextoPrevisualizacion.getForeground();
        if (!titulo.isEmpty() && colorFondo != null && colorTexto != null) {
            gestorEstilos.añadirEstilo(titulo, colorFondo, colorTexto);
            actualizarTabla();
            if (VaciarDespuesAñadirCheckBox.isSelected()) {
                vaciarTextField();
            }
        } else {
            JOptionPane.showMessageDialog(this, "No puedes dejar campos vacios", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_AñadirButtonActionPerformed

    private void VaciarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VaciarButtonActionPerformed
        //Vacia todos los text fields
        vaciarTextField();
    }//GEN-LAST:event_VaciarButtonActionPerformed

    private void ActualizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarButtonActionPerformed
        //Actualizar un estilo con los nuevos datos de los campos

        int filaSeleccionada = jTablaEstilos.getSelectedRow();
        Color colorFondo;
        Color colorTexto;
        if (filaSeleccionada >= 0) {
            String nombreBorrar = (String) datos[filaSeleccionada][0];
            String titulo = TituloTextField.getText();
            colorFondo = PanelPrevisualizacion.getBackground();
            colorTexto = TextoPrevisualizacion.getForeground();
            if (!titulo.isEmpty() && colorFondo != null && colorTexto != null) {
                gestorEstilos.borrarEstilo(nombreBorrar);
                actualizarTabla();
                gestorEstilos.añadirEstilo(titulo, colorFondo, colorTexto);
                actualizarTabla();
                if (VaciarDespuesAñadirCheckBox.isSelected()) {
                    vaciarTextField();
                }
            } else {
                JOptionPane.showMessageDialog(this, "No puedes dejar campos vacios", "Error", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna configuracion", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_ActualizarButtonActionPerformed

    private void CargarEjemplosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarEjemplosButtonActionPerformed
        //Se añaden los ejemplos
        gestorEstilos.añadirEjemplosEstilos();
        actualizarTabla();
    }//GEN-LAST:event_CargarEjemplosButtonActionPerformed

    private void BorrarSeleccionadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarSeleccionadoButtonActionPerformed
//Se borra el estilo seleccionado

        int filaSeleccionado = jTablaEstilos.getSelectedRow();
        if (filaSeleccionado >= 0) {
            String nombre = (String) datos[filaSeleccionado][0];
            gestorEstilos.borrarEstilo(nombre);
            actualizarTabla();
            vaciarTextField();
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BorrarSeleccionadoButtonActionPerformed

    private void jTablaEstilosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaEstilosMousePressed
        int filaSeleccionada = jTablaEstilos.getSelectedRow();
        Color colorFondo, colorTexto;
        String titulo = (String) datos[filaSeleccionada][0];
        colorFondo = gestorEstilos.conseguirColorPorRGB((String) datos[filaSeleccionada][1]);
        colorTexto = gestorEstilos.conseguirColorPorRGB((String) datos[filaSeleccionada][2]);

        TituloTextField.setText(titulo);
        PanelPrevisualizacion.setBackground(colorFondo);
        TextoPrevisualizacion.setForeground(colorTexto);
    }//GEN-LAST:event_jTablaEstilosMousePressed

    private void BorrarSeleccionadoButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BorrarSeleccionadoButtonMousePressed

    }//GEN-LAST:event_BorrarSeleccionadoButtonMousePressed

    private void ColoresFondoButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ColoresFondoButtonMousePressed
        Color color = JColorChooser.showDialog(this, "Selecciona color", null);
        PanelPrevisualizacion.setBackground(color);
    }//GEN-LAST:event_ColoresFondoButtonMousePressed

    private void ColoresTextoButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ColoresTextoButtonMousePressed
        Color color = JColorChooser.showDialog(this, "Selecciona color", null);
        TextoPrevisualizacion.setForeground(color);
    }//GEN-LAST:event_ColoresTextoButtonMousePressed

    private void GUARDARMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GUARDARMousePressed
        gestorEstilos.guardarEstilosEnFicheroXML(datos, nomArchivoxml);
        actualizarTabla();

    }//GEN-LAST:event_GUARDARMousePressed

    private void CARGARMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CARGARMousePressed
        gestorEstilos.cargarEstilosDeFicheroXML(nomArchivo);
        actualizarTabla();

    }//GEN-LAST:event_CARGARMousePressed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Ventana3().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarButton;
    private javax.swing.JButton AñadirButton;
    private javax.swing.JButton BorrarSeleccionadoButton;
    private javax.swing.JPanel BotonesBorrar;
    private javax.swing.JButton CARGAR;
    private javax.swing.JButton CargarEjemplosButton;
    private javax.swing.JLabel ColorFondo;
    private javax.swing.JLabel ColorTexto;
    private javax.swing.JToggleButton ColoresFondoButton;
    private javax.swing.JToggleButton ColoresTextoButton;
    private javax.swing.JPanel Datos;
    private javax.swing.JButton GUARDAR;
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

    private void vaciarTextField() {
        TituloTextField.setText("");
        PanelPrevisualizacion.setBackground(Color.WHITE);
TextoPrevisualizacion.setForeground(Color.BLACK);
    }

    private void cargar() {
        int r, g, b;
        Color colorFondo;
        Color colorTexto;
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(nomArchivo);
            ois = new ObjectInputStream(fis);
            datos = (Object[][]) ois.readObject();
            for (Object[] dato : datos) {
                String titulo = (String) dato[0];
                String fondo = (String) dato[1];
                String texto = (String) dato[2];
                colorFondo = gestorEstilos.conseguirColorPorRGB(fondo);
                colorTexto = gestorEstilos.conseguirColorPorRGB(texto);
                gestorEstilos.añadirEstilo(titulo, colorFondo, colorTexto);
                actualizarTabla();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void guardar() {
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(nomArchivo);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(gestorEstilos.convertirListaADTM());
            Ventana1 ventana = new Ventana1();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
