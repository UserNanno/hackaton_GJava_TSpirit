package view;

import controller.SemestreController;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Semestre;
import javax.swing.JOptionPane;

public class JFrameAsignacionSemestres extends javax.swing.JFrame {

    private DefaultTableModel semestreModel;
    private final SemestreController semestreController;
    private int idSemestreEditando = -1;

    public JFrameAsignacionSemestres() {
        initComponents();
        txtSemestre.setEnabled(false); // Desactiva el JTextField al inicio
        semestreController = new SemestreController();
        cargarSemestresEnTabla();

        btnEditar.addActionListener((java.awt.event.ActionEvent evt) -> {
            int filaSeleccionada = tblSemestre.getSelectedRow();
            if (filaSeleccionada != -1) {
                int idSemestre = (int) tblSemestre.getValueAt(filaSeleccionada, 0);
                String semestreSeleccionado = (String) tblSemestre.getValueAt(filaSeleccionada, 1);
                txtSemestre.setText(semestreSeleccionado);
                txtSemestre.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona un semestre para editar.", "Sin selección", JOptionPane.WARNING_MESSAGE);
            }
        });

        btnNuevo.addActionListener((java.awt.event.ActionEvent evt) -> {
            txtSemestre.setText(""); // Limpia el campo
            txtSemestre.setEnabled(true); // Habilita la edición
        });

        btnGuardar.addActionListener((java.awt.event.ActionEvent evt) -> {
            String nombreSemestre = txtSemestre.getText().trim(); // Obtiene el texto sin espacios adicionales

            if (nombreSemestre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un nombre de semestre válido.", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
            } else if (semestreController.existeSemestre(nombreSemestre)) {
                JOptionPane.showMessageDialog(null, "El nombre de semestre ya existe.", "Nombre Duplicado", JOptionPane.WARNING_MESSAGE);
            } else {
                nombreSemestre = nombreSemestre.toUpperCase(); // Convierte el nombre a mayúsculas

                if (idSemestreEditando != -1) {
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas actualizar este semestre?", "Confirmar actualización", JOptionPane.YES_NO_OPTION);

                    if (opcion == JOptionPane.YES_OPTION) {
                        semestreController.actualizarSemestre(idSemestreEditando, nombreSemestre);
                        cargarSemestresEnTabla();
                        txtSemestre.setEnabled(false);
                        idSemestreEditando = -1;
                    } else {
                        JOptionPane.showMessageDialog(null, "La actualización ha sido cancelada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas agregar este nuevo semestre?", "Confirmar adición", JOptionPane.YES_NO_OPTION);

                    if (opcion == JOptionPane.YES_OPTION) {
                        Semestre semestre = new Semestre();
                        semestre.setNombre(nombreSemestre);
                        semestreController.agregarSemestre(semestre);
                        cargarSemestresEnTabla();
                        txtSemestre.setEnabled(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "La adición ha sido cancelada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        btnEliminar.addActionListener((java.awt.event.ActionEvent evt) -> {
            int filaSeleccionada = tblSemestre.getSelectedRow();
            if (filaSeleccionada != -1) {
                int idSemestre = (int) tblSemestre.getValueAt(filaSeleccionada, 0);
                int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas eliminar este semestre?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

                if (opcion == JOptionPane.YES_OPTION) {
                    semestreController.eliminarSemestre(idSemestre);
                    cargarSemestresEnTabla();
                    txtSemestre.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "La eliminación ha sido cancelada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona un semestre para eliminar.", "Sin selección", JOptionPane.WARNING_MESSAGE);
            }
        });

    }

    private void cargarSemestresEnTabla() {
        semestreModel = new DefaultTableModel();
        semestreModel.addColumn("ID");
        semestreModel.addColumn("Nombre");

        List<Semestre> semestres = semestreController.obtenerSemestres();

        for (Semestre semestre : semestres) {
            semestreModel.addRow(new Object[]{semestre.getId(), semestre.getNombre()});
        }

        tblSemestre.setModel(semestreModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtSemestre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnRetroceder = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSemestre = new javax.swing.JTable();
        btnAño = new javax.swing.JComboBox<>();
        btnCicloAcademico = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Asignación de Semestres");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtSemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSemestreActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnRetroceder.setText("Retroceder");
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });

        tblSemestre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "id_semestre", "Semestre"
            }
        ));
        jScrollPane2.setViewportView(tblSemestre);

        btnAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        btnAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñoActionPerformed(evt);
            }
        });

        btnCicloAcademico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        btnCicloAcademico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCicloAcademicoActionPerformed(evt);
            }
        });

        jLabel2.setText("Año");

        jLabel3.setText("Ciclo Académico");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNuevo)
                                    .addComponent(btnEditar))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnEliminar)
                                                .addGap(88, 88, 88)
                                                .addComponent(btnAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel1))))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCicloAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(btnGuardar)
                                        .addGap(31, 31, 31))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnRetroceder)
                        .addGap(18, 18, 18)
                        .addComponent(txtSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditar)
                            .addComponent(btnEliminar)
                            .addComponent(btnAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCicloAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(btnNuevo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGuardar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRetroceder)
                    .addComponent(txtSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = tblSemestre.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idSemestre = (int) tblSemestre.getValueAt(filaSeleccionada, 0);
            String semestreSeleccionado = (String) tblSemestre.getValueAt(filaSeleccionada, 1);
            txtSemestre.setText(semestreSeleccionado);
            txtSemestre.setEnabled(true);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSemestreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSemestreActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        txtSemestre.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        // TODO add your handling code here:
        this.dispose();
        JFrameMain main = new JFrameMain();
        main.setVisible(true);

    }//GEN-LAST:event_btnRetrocederActionPerformed

    private void btnAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAñoActionPerformed

    private void btnCicloAcademicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCicloAcademicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCicloAcademicoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new JFrameAsignacionSemestres().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> btnAño;
    private javax.swing.JComboBox<String> btnCicloAcademico;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblSemestre;
    private javax.swing.JTextField txtSemestre;
    // End of variables declaration//GEN-END:variables
}
