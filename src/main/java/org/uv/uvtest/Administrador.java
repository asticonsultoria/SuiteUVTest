/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package org.uv.uvtest;

import java.awt.Dimension;
import org.uv.uvtest.Data.Alumno;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.uv.uvtest.Data.DaoAlumno;

/**
 *
 * @author GAMR_
 */
public class Administrador extends javax.swing.JInternalFrame {

    private List<Alumno> alumnos;
    public DefaultTableModel modelo = null;
    private final DaoAlumno dao ;
    
    /**
     * Creates new form Administrador
     */
    public Administrador() {
        initComponents();
        
        Dimension size = new Dimension(700, 600);
        setSize(size);
        setPreferredSize(size);
        
        dao = new DaoAlumno();
        llenarDatos();
    }
    
    private void llenarDatos(){
        try{
            alumnos = dao.readAll();
            modelo = (DefaultTableModel) tablaAlumnos.getModel();
            modelo.setRowCount(0);
            for(int i = 0; i < alumnos.size(); i++){
                Object[] arr = new Object[8];
                arr[0] = alumnos.get(i).getDni();
                arr[1] = alumnos.get(i).getNombre();
                arr[2] = alumnos.get(i).getApellidoPaterno() + " " + alumnos.get(i).getApellidoMaterno();
                arr[3] = alumnos.get(i).getFecha();
                arr[4] = alumnos.get(i).getNormal();
                arr[5] = alumnos.get(i).getMotivacion();
                arr[6] = alumnos.get(i).getPresicion();
                arr[7] = alumnos.get(i).getCalificacion();
                modelo.addRow(arr);
            }
        }catch(Exception e){
            Inicio.APP_LOGER.log(Level.SEVERE, "Error al llenar la tabla", e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setClosable(true);

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellidos", "Fecha", "Normal", "Motivación", "Presición", "Calificacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaAlumnos);
        if (tablaAlumnos.getColumnModel().getColumnCount() > 0) {
            tablaAlumnos.getColumnModel().getColumn(0).setResizable(false);
        }

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Alumnos registrados");
        jPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        btnEliminar.setText("Eliminar registro");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRefresh.setText("Actualizar registros");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnRefresh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       int index = tablaAlumnos.getSelectionModel().getMinSelectionIndex();
       if(index < 0){
           Inicio.showInfoMessage("Selecciona un registro.");
           return;
       }
       if (tablaAlumnos.getSelectionModel().isSelectedIndex(index)){
           int r =  JOptionPane.showConfirmDialog(null, "Desea eliminar el registro?", "Atención",
			JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
           if(r == JOptionPane.YES_OPTION){
               Alumno alumno = new Alumno();
               String dni = modelo.getValueAt(index, 0).toString();
               alumno.setDni(dni);
               boolean result = dao.delete(alumno);
               if(result){
                    modelo.removeRow(index);
                    modelo.fireTableDataChanged();
               }else{
                   Inicio.showErrorMessage("No fue posible eliminar el registro. Contacte con el proveedor.");
               }
           }
       }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
       llenarDatos();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAlumnos;
    // End of variables declaration//GEN-END:variables
}
