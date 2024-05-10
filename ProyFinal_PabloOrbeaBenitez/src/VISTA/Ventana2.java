package VISTA;

import CONTROLADORES.GestorUsuariosBDO;
import MODELOS.Usuario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ventana2 extends javax.swing.JFrame {

    GestorUsuariosBDO gestorUsuarios = new GestorUsuariosBDO();

    //Nombres de las columnas
    String[] nomCols = {"NOMBRE", "CONTRASEÑA", "ROL", "ACTIVO"};

    //Array de datos
    Object[][] datos;

    //Objeto tabla interfaz
    DefaultTableModel listaProductos = new DefaultTableModel(datos, nomCols);

    public Ventana2() {
        setTitle("Control usuarios");
        initComponents();
        setAlwaysOnTop(true);
        actualizarTabla();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel1 = new javax.swing.JPanel();
        TablaUsuarios = new javax.swing.JScrollPane();
        jTablaUsuarios = new javax.swing.JTable();
        Panel2 = new javax.swing.JPanel();
        BotonAñadir = new javax.swing.JButton();
        BotonBorrar = new javax.swing.JButton();
        BotonActualizar = new javax.swing.JButton();
        Nombre = new javax.swing.JLabel();
        Contraseña = new javax.swing.JLabel();
        Activo = new javax.swing.JLabel();
        ActivoCheckBox = new javax.swing.JCheckBox();
        Rol = new javax.swing.JLabel();
        RolComboBox = new javax.swing.JComboBox<>();
        NombreTextField = new javax.swing.JTextField();
        ContraseñaPasswordField = new javax.swing.JPasswordField();

        setMaximumSize(new java.awt.Dimension(970, 430));
        setPreferredSize(new java.awt.Dimension(970, 430));

        Panel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NOMBRE", "CONTRASEÑA", "ROL", "ACTIVO"
            }
        ));
        jTablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTablaUsuariosMousePressed(evt);
            }
        });
        TablaUsuarios.setViewportView(jTablaUsuarios);

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TablaUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TablaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        Panel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BotonAñadir.setText("AÑADIR");
        BotonAñadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonAñadirMousePressed(evt);
            }
        });

        BotonBorrar.setText("BORRAR");
        BotonBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonBorrarMousePressed(evt);
            }
        });

        BotonActualizar.setText("ACTUALIZAR");
        BotonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonActualizarMousePressed(evt);
            }
        });

        Nombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nombre.setText("NOMBRE");

        Contraseña.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Contraseña.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Contraseña.setText("CONTRASEÑA");

        Activo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Activo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Activo.setText("ACTIVO");

        ActivoCheckBox.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        Rol.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Rol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Rol.setText("ROL");

        RolComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USUARIO", "ADMINISTRADOR"}));
        RolComboBox.setMaximumSize(new java.awt.Dimension(20, 26));
        RolComboBox.setMinimumSize(new java.awt.Dimension(20, 26));
        RolComboBox.setPreferredSize(new java.awt.Dimension(20, 26));

        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
                        .addComponent(BotonAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18))
                                .addComponent(ContraseñaPasswordField))
                            .addGroup(Panel2Layout.createSequentialGroup()
                                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Rol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(RolComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
                                        .addComponent(ActivoCheckBox)
                                        .addGap(20, 20, 20))
                                    .addComponent(Activo))
                                .addGap(5, 5, 5)))
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
                        .addComponent(NombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143))))
        );
        Panel2Layout.setVerticalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(Nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Contraseña)
                .addGap(36, 36, 36)
                .addComponent(ContraseñaPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Activo)
                    .addComponent(Rol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RolComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ActivoCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonAñadir)
                    .addComponent(BotonBorrar)
                    .addComponent(BotonActualizar))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonAñadirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAñadirMousePressed
        //Boton que añade un usuario comprobando sus datos y pidiendo siempre usuario y contraseña
        String nombre = NombreTextField.getText().trim();
        String contraseña = gestorUsuarios.convertirContraseña(ContraseñaPasswordField.getPassword());
        String rol = RolComboBox.getSelectedItem().toString();
        boolean activo = ActivoCheckBox.isSelected();

        if (!nombre.isEmpty() && !contraseña.isEmpty()) {
            Usuario usr = new Usuario(nombre, contraseña, activo);

            if (rol.equals("USUARIO")) {
                usr.setRol(Usuario.Rol.USUARIO);
            } else if (rol.equals("ADMINISTRADOR")) {
                usr.setRol(Usuario.Rol.ADMINISTRADOR);
            }

            if (gestorUsuarios.añadirUsuario(usr)) {
                actualizarTabla();
                vaciarTextField();
            } else {
                JOptionPane.showMessageDialog(this, "No se ha podido añadir comprueba que el usuario no exista ya", "Error", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "El campo del nombre y contraseña no pueden estar vacíos", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_BotonAñadirMousePressed

    private void BotonBorrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonBorrarMousePressed
        //Se borra el usuario seleccionado

        int filaSeleccionado = jTablaUsuarios.getSelectedRow();
        if (filaSeleccionado >= 0) {
            String nombre = (String) datos[filaSeleccionado][0];
            if (gestorUsuarios.borrarUsuarioPorNombre(nombre)) {
                actualizarTabla();
                vaciarTextField();
            } else {
                JOptionPane.showMessageDialog(this, "No se ha podido borrar el usuario", "Error", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro", "Error", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_BotonBorrarMousePressed

    private void BotonActualizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonActualizarMousePressed
        //Se modifican los datos con los datos nuevos que se hayan insertado

        int filaSeleccionada = jTablaUsuarios.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String nombreBorrar = (String) datos[filaSeleccionada][0];
            String nombre = NombreTextField.getText();
            String contraseña = gestorUsuarios.convertirContraseña(ContraseñaPasswordField.getPassword());
            String rol = RolComboBox.getSelectedItem().toString();
            boolean activo = ActivoCheckBox.isSelected();

            if (!nombreBorrar.trim().isEmpty() && !contraseña.trim().isEmpty()) {
                Usuario usr = new Usuario(nombre, contraseña, activo);

                if (rol.equals("USUARIO")) {
                    usr.setRol(Usuario.Rol.USUARIO);
                } else if (rol.equals("ADMINISTRADOR")) {
                    usr.setRol(Usuario.Rol.ADMINISTRADOR);
                }
                if (gestorUsuarios.borrarUsuarioPorNombre(nombreBorrar) && gestorUsuarios.añadirUsuario(usr)) {
                    actualizarTabla();
                    vaciarTextField();
                } else {
                    JOptionPane.showMessageDialog(this, "No se ha podido actualizar el usuario", "Error", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "El campo del nombre y contraseña no pueden estar vacíos", "No añadido", JOptionPane.WARNING_MESSAGE);
            }
            vaciarTextField();
        } else {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningun producto", "Message", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_BotonActualizarMousePressed

    private void jTablaUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaUsuariosMousePressed
        //Se muestra la informacion de el usuario en los campos correspondientes

        int filaSeleccionada = jTablaUsuarios.getSelectedRow();
        String activo = (String) datos[filaSeleccionada][3].toString();
        NombreTextField.setText(datos[filaSeleccionada][0].toString());
        ContraseñaPasswordField.setText(datos[filaSeleccionada][1].toString());
        RolComboBox.setSelectedItem(datos[filaSeleccionada][2].toString());

        if (activo.equals("true")) {
            ActivoCheckBox.setSelected(true);
        } else {
            ActivoCheckBox.setSelected(false);
        }

    }//GEN-LAST:event_jTablaUsuariosMousePressed

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
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Activo;
    private javax.swing.JCheckBox ActivoCheckBox;
    private javax.swing.JButton BotonActualizar;
    private javax.swing.JButton BotonAñadir;
    private javax.swing.JButton BotonBorrar;
    private javax.swing.JLabel Contraseña;
    private javax.swing.JPasswordField ContraseñaPasswordField;
    private javax.swing.JLabel Nombre;
    private javax.swing.JTextField NombreTextField;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JLabel Rol;
    private javax.swing.JComboBox<String> RolComboBox;
    private javax.swing.JScrollPane TablaUsuarios;
    private javax.swing.JTable jTablaUsuarios;
    // End of variables declaration//GEN-END:variables

    //Se actualiza la tabla con los datos de el array [][]
    private void actualizarTabla() {
        datos = gestorUsuarios.convertirBDOADTM();
        listaProductos = new DefaultTableModel(datos, nomCols) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        jTablaUsuarios.setModel(listaProductos);

    }

    //se vacian los camposs
    public void vaciarTextField() {
        NombreTextField.setText("");
        ContraseñaPasswordField.setText("");
    }
}
