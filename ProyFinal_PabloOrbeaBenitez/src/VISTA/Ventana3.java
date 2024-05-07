package VISTA;

import CONTROLADORES.GestorEstilosGUI;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ventana3 extends javax.swing.JFrame implements Serializable {

    Color color = null;
    //Objeto miniagenda
    GestorEstilosGUI gestorEstilos = new GestorEstilosGUI();
    //Ruta del archivo para guardar y cargar
    String nomArchivo = "estilos.dat";

    //Nombres de las columnas
    String[] nomCols = {"TITULO",
        "COLOR", "FECHA"};
    Object[][] datos;
    //Objeto tabla interfaz
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
        NomYApeLabel = new javax.swing.JLabel();
        DeporteLabel = new javax.swing.JLabel();
        TituloTextField = new javax.swing.JTextField();
        VaciarDespuesAñadirCheckBox = new javax.swing.JCheckBox();
        VaciarButton = new javax.swing.JButton();
        AñadirButton = new javax.swing.JButton();
        ActualizarButton = new javax.swing.JButton();
        ColoresButton = new javax.swing.JToggleButton();
        BotonesBorrar = new javax.swing.JPanel();
        BorrarSeleccionadoButton = new javax.swing.JButton();
        CargarEjemplosButton = new javax.swing.JButton();
        Tabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaEstilos = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 0, 0));

        Datos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        NomYApeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NomYApeLabel.setText("TITULO");

        DeporteLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DeporteLabel.setText("COLOR");

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

        VaciarButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        VaciarButton.setText("Vaciar campos");
        VaciarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VaciarButtonActionPerformed(evt);
            }
        });

        AñadirButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AñadirButton.setText("Añadir");
        AñadirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirButtonActionPerformed(evt);
            }
        });

        ActualizarButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ActualizarButton.setText("Actualizar");
        ActualizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarButtonActionPerformed(evt);
            }
        });

        ColoresButton.setBackground(new java.awt.Color(214, 217, 223));
        ColoresButton.setText("COLORES");
        ColoresButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ColoresButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout DatosLayout = new javax.swing.GroupLayout(Datos);
        Datos.setLayout(DatosLayout);
        DatosLayout.setHorizontalGroup(
            DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DatosLayout.createSequentialGroup()
                        .addComponent(VaciarDespuesAñadirCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VaciarButton)
                        .addGap(59, 59, 59)
                        .addComponent(AñadirButton)
                        .addGap(103, 103, 103)
                        .addComponent(ActualizarButton))
                    .addGroup(DatosLayout.createSequentialGroup()
                        .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NomYApeLabel)
                            .addComponent(DeporteLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TituloTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                            .addComponent(ColoresButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        DatosLayout.setVerticalGroup(
            DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DatosLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomYApeLabel)
                    .addComponent(TituloTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeporteLabel)
                    .addComponent(ColoresButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VaciarDespuesAñadirCheckBox)
                    .addComponent(AñadirButton)
                    .addComponent(VaciarButton)
                    .addComponent(ActualizarButton))
                .addGap(30, 30, 30))
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

        javax.swing.GroupLayout BotonesBorrarLayout = new javax.swing.GroupLayout(BotonesBorrar);
        BotonesBorrar.setLayout(BotonesBorrarLayout);
        BotonesBorrarLayout.setHorizontalGroup(
            BotonesBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotonesBorrarLayout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(BorrarSeleccionadoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CargarEjemplosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        BotonesBorrarLayout.setVerticalGroup(
            BotonesBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonesBorrarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BotonesBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BorrarSeleccionadoButton)
                    .addComponent(CargarEjemplosButton))
                .addGap(36, 36, 36))
        );

        Tabla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTablaEstilos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Titulo", "Color", "Fecha"
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TituloTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TituloTextFieldActionPerformed
    }//GEN-LAST:event_TituloTextFieldActionPerformed

    private void VaciarDespuesAñadirCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VaciarDespuesAñadirCheckBoxActionPerformed
    }//GEN-LAST:event_VaciarDespuesAñadirCheckBoxActionPerformed

    //Boton añadir jugador
    private void AñadirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirButtonActionPerformed
        String titulo = TituloTextField.getText();
        if (!titulo.isEmpty() && color != null) {
            gestorEstilos.añadir(titulo, color);
            actualizarTabla();
            if (VaciarDespuesAñadirCheckBox.isSelected()) {
                vaciarTextField();
            }
            guardar();
        } else {
            JOptionPane.showMessageDialog(this, "No puedes dejar campos vacios", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_AñadirButtonActionPerformed

    //Vacia todos los text fields
    private void VaciarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VaciarButtonActionPerformed
        vaciarTextField();
    }//GEN-LAST:event_VaciarButtonActionPerformed

    private void ActualizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarButtonActionPerformed

        //Se guarda la fila seleccionada 
        int filaSeleccionada = jTablaEstilos.getSelectedRow();

        if (filaSeleccionada >= 0) {
            String nombreBorrar = (String) datos[filaSeleccionada][0];
            String titulo = TituloTextField.getText();
            color = ColoresButton.getBackground();
            if (!titulo.isEmpty() && color != null) {
                gestorEstilos.borrar(nombreBorrar);
                actualizarTabla();
                gestorEstilos.añadir(titulo, color);
                actualizarTabla();
                if (VaciarDespuesAñadirCheckBox.isSelected()) {
                    vaciarTextField();
                }
                guardar();
            } else {
                JOptionPane.showMessageDialog(this, "No puedes dejar campos vacios", "Error", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna configuracion", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_ActualizarButtonActionPerformed

    //Cargar ejemplos
    private void CargarEjemplosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarEjemplosButtonActionPerformed

        gestorEstilos.añadirEjemplos();
        //Actualizar tabla
        actualizarTabla();
        guardar();
    }//GEN-LAST:event_CargarEjemplosButtonActionPerformed

    //Boton borrar fila seleccionada
    private void BorrarSeleccionadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarSeleccionadoButtonActionPerformed

        //Se guarda la fila seleccionada
        int filaSeleccionado = jTablaEstilos.getSelectedRow();

        //Se comprueba que se ha seleccionado alguna fila
        if (filaSeleccionado >= 0) {
            //Se saca el valor del nombre de la fila seleccionada
            String nombre = (String) datos[filaSeleccionado][0];

            //Se recorre la miniagenda buscando el deportista con el mismo nombre y se borra y se actualiza la tabla
            gestorEstilos.borrar(nombre);
            actualizarTabla();
            vaciarTextField();
            guardar();
        } else {
            //En caso de que no haya ninguna fila seleccionada se muestra un mensaje de error
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BorrarSeleccionadoButtonActionPerformed

    private void jTablaEstilosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaEstilosMousePressed
        int r, g, b;
        int filaSeleccionada = jTablaEstilos.getSelectedRow();

        String titulo = (String) datos[filaSeleccionada][0];
        String rgbColor = (String) datos[filaSeleccionada][1];
        String[] rgb = rgbColor.replaceAll("[^0-9,]", "").split(",");

        r = Integer.parseInt(rgb[0]);
        g = Integer.parseInt(rgb[1]);
        b = Integer.parseInt(rgb[2]);

        TituloTextField.setText(titulo);
        ColoresButton.setBackground(new Color(r, g, b));
    }//GEN-LAST:event_jTablaEstilosMousePressed

    private void BorrarSeleccionadoButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BorrarSeleccionadoButtonMousePressed

    }//GEN-LAST:event_BorrarSeleccionadoButtonMousePressed

    private void ColoresButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ColoresButtonMousePressed
        color = JColorChooser.showDialog(this, "Selecciona color", null);
        ColoresButton.setBackground(color);
    }//GEN-LAST:event_ColoresButtonMousePressed

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
    private javax.swing.JButton CargarEjemplosButton;
    private javax.swing.JToggleButton ColoresButton;
    private javax.swing.JPanel Datos;
    private javax.swing.JLabel DeporteLabel;
    private javax.swing.JLabel NomYApeLabel;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel Tabla;
    private javax.swing.JTextField TituloTextField;
    private javax.swing.JButton VaciarButton;
    private javax.swing.JCheckBox VaciarDespuesAñadirCheckBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaEstilos;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        datos = gestorEstilos.convertirAMatrizObjetos();
        listaEstilos = new DefaultTableModel(datos, nomCols) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        jTablaEstilos.setModel(listaEstilos);

    }

    private void vaciarTextField() {
        TituloTextField.setText("");
        ColoresButton.setBackground(new Color(214, 217, 223));
    }

    private void cargar() {
        int r, g, b;
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(nomArchivo);
            ois = new ObjectInputStream(fis);
            datos = (Object[][]) ois.readObject();
            for (Object[] dato : datos) {
                String titulo = (String) dato[0];
                String rgbColor = (String) dato[1];
                String[] rgb = rgbColor.replaceAll("[^0-9,]", "").split(",");
                r = Integer.parseInt(rgb[0]);
                g = Integer.parseInt(rgb[1]);
                b = Integer.parseInt(rgb[2]);
                gestorEstilos.añadir(titulo, new Color(r, g, b));
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
            oos.writeObject(gestorEstilos.convertirAMatrizObjetos());
            Ventana1 ventana = new Ventana1();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
