package view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.Curso;
import model.CursoHorario;
import model.Seccion;
import persistencia.CursoDAO;
import persistencia.HorarioDAO;
import persistencia.SeccionDAO;

public class JFrameAsignacionHorarios extends javax.swing.JFrame {

    private final CursoDAO cursoDAO = new CursoDAO();
    private final SeccionDAO seccionDAO = new SeccionDAO();
    private final HorarioDAO horarioDAO = new HorarioDAO();
    private List<CursoHorario> cursosHorarios; // Assuming you have a class to represent CursoHorario
    private DefaultTableModel tableModel;

    public JFrameAsignacionHorarios() {
        initComponents();
        initTable();
        cargarCursos(); // Load courses when the frame is initialized
        cargarSecciones();
        cargarHorarios();
    }

    private void initTable() {
        // Initialize the JTable
        tableModel = (DefaultTableModel) jTable1.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbCurso = new javax.swing.JComboBox<>();
        cmbHorario = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cmbSeccion = new javax.swing.JComboBox<>();
        cmbDia = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Asignación de Horarios");

        jLabel2.setText("Curso");

        cmbCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));
        cmbCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCursoActionPerformed(evt);
            }
        });

        cmbHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));
        cmbHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHorarioActionPerformed(evt);
            }
        });

        jLabel3.setText("Horario");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"             8am - 10am", null, null, null, null, null, null},
                {"            10am - 12pm", null, null, null, null, null, null},
                {"            12pm - 2pm", null, null, null, null, null, null},
                {"             2pm - 4pm", null, null, null, null, null, null},
                {"             4pm - 6pm", null, null, null, null, null, null},
                {"             6pm-8pm", null, null, null, null, null, null},
                {"             8pm-10pm", null, null, null, null, null, null}
            },
            new String [] {
                "Hora", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setText("Sección");

        cmbSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));
        cmbSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSeccionActionPerformed(evt);
            }
        });

        cmbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));
        cmbDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(cmbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(589, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbSeccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCursoActionPerformed

    private void cmbHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHorarioActionPerformed

        String selectedCurso = (String) cmbCurso.getSelectedItem();
        String selectedSeccion = (String) cmbSeccion.getSelectedItem();
        String selectedHorario = (String) cmbHorario.getSelectedItem();
        String selectedDia = (String) cmbDia.getSelectedItem();

        // Determine the row and column indices for the selected curso, seccion, horario, and dia
        int rowIndex = getRowIndex(selectedHorario, selectedDia);
        int columnIndex = getColumnIndex(selectedCurso, selectedSeccion, selectedDia);

        if (rowIndex != -1 && columnIndex != -1) {
            // Set the background color to green
            jTable1.setValueAt("Occupied", rowIndex, columnIndex);
            jTable1.getCellRenderer(rowIndex, columnIndex)
                    .getTableCellRendererComponent(jTable1, null, false, false, rowIndex, columnIndex)
                    .setBackground(Color.GREEN);
        }
        }//GEN-LAST:event_cmbHorarioActionPerformed

    private void cmbSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSeccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSeccionActionPerformed

    private void cmbDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDiaActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        // Clear the existing items in the cmbdia JComboBox
        cmbDia.removeAllItems();

        // Populate the JComboBox with the days of the week
        List<String> daysOfWeek = Arrays.asList("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado");
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(daysOfWeek.toArray(new String[0]));
        cmbDia.setModel(model);
    }//GEN-LAST:event_cmbDiaActionPerformed

    private void cargarCursos() {
        List<Curso> cursos = cursoDAO.obtenerCursos();
        for (Curso curso : cursos) {
            cmbCurso.addItem(curso.getNombre());
        }
    }

    private void cargarSecciones() {
        // Assuming seccionDAO is a class to retrieve Seccion objects from a database
        List<Seccion> secciones = seccionDAO.obtenerSecciones();
        for (Seccion seccion : secciones) {
            cmbSeccion.addItem(seccion.getNombre());
        }
    }

    private void cargarHorarios() {
        List<CursoHorario> horarios = horarioDAO.obtenerHorarios();
        for (CursoHorario horario : horarios) {
            cmbHorario.addItem(horario.getHorario());
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameAsignacionHorarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbCurso;
    private javax.swing.JComboBox<String> cmbDia;
    private javax.swing.JComboBox<String> cmbHorario;
    private javax.swing.JComboBox<String> cmbSeccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private int getRowIndex(String selectedHorario, String selectedDia) {
        // Implement logic to get the row index for the selected Horario and Dia
        // You might need to adjust this based on your table structure
        //int horarioIndex = obtenerHorarios("Selecciona").indexOf(selectedHorario);
        int diaIndex = obtenerDias().indexOf(selectedDia);

        if (diaIndex != -1) {
            // Assuming there are 7 rows for each day in the table
            return (7 * diaIndex);
        } else {
            return -1;
        }
    }

    private int getColumnIndex(String selectedCurso, String selectedSeccion, String selectedDia) {
        // Implement logic to get the column index for the selected Curso, Seccion, and Dia
        // You might need to adjust this based on your table structure
        int cursoIndex = cmbCurso.getSelectedIndex() + 1; // Assuming cmbCurso is the first column
        int seccionIndex = cmbSeccion.getSelectedIndex() + 1; // Assuming cmbSeccion is the second column
        int diaIndex = obtenerDias().indexOf(selectedDia);

        if (cursoIndex != -1 && seccionIndex != -1 && diaIndex != -1) {
            return cursoIndex + (seccionIndex * 7) + (diaIndex * 7);
        } else {
            return -1;
        }
    }

    private List<String> obtenerDias() {
        // Assuming the days are hardcoded in the table and not dynamic
        return Arrays.asList("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado");
    }

}
