/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.uv.uvtest;

import org.uv.uvtest.Data.Preguntas;
import org.uv.uvtest.Data.Equivalencias;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.uv.uvtest.Data.Alumno;
import org.uv.uvtest.Data.DaoAlumno;

/**
 *
 * @author GAMR_
 */
public class TablaPuntuacion extends javax.swing.JPanel {

    private static TablaPuntuacion ventana = null;
    private Preguntas preguntas;
    private DefaultTableModel modelo1 = null;
    private DefaultTableModel modelo2 = null;
    private List<List<Integer>> resultados;
    private List<Integer> moreResultados;
    private List<Integer> lessResultados;
    private List<Integer> totalResultados;
    
    private Equivalencias equivalencias;
    
    private List<Integer> resultadosM;
    private List<Integer> resultadosL;
    private List<Integer> resultadosT;
    
    private double resultadoFinal;
    private Alumno alumno;
    private DaoAlumno dao;
   
    /**
     * Creates new form TablaPuntuacion
     */
    public TablaPuntuacion() {
        initComponents();
        this.preguntas = Preguntas.getVentana();
        this.preguntas.obtenerResultados();
        this.resultados = this.preguntas.getResultadosTotales();
        this.moreResultados = resultados.get(0);
        this.lessResultados = resultados.get(1);
        this.totalResultados = resultados.get(2);
        dao = new DaoAlumno();
        this.equivalencias = new Equivalencias();
        this.llenarDatosTabla1();
        this.llenarDatosTabla2();
    }
    
    public static TablaPuntuacion getVentana(){
        if (ventana == null) 
            ventana = new TablaPuntuacion();
        return ventana;
    }
    
    public static void resetVentana(){
        ventana =null;
    }

    public void llenarDatosTabla1(){
        
        try{
            modelo1 = (DefaultTableModel) table1.getModel();
            System.out.println(resultados);
            for(int i = 0; i < moreResultados.size()-1; i++){
                modelo1.setValueAt(resultados.get(i).get(0),i, 1);
                modelo1.setValueAt(resultados.get(i).get(1),i, 2);
                modelo1.setValueAt(resultados.get(i).get(2),i, 3);
                modelo1.setValueAt(resultados.get(i).get(3),i, 4);
            }
        }catch(Exception e){
            System.out.println("Error al llenar la tabla: " + e);
        }
    }
    
    public void llenarDatosTabla2(){
        
        this.resultadosM = new ArrayList<Integer>();
        this.resultadosL = new ArrayList<Integer>();
        this.resultadosT = new ArrayList<Integer>();
        
        
        try{
            modelo2 = (DefaultTableModel) table2.getModel();
            
            //Llenar los valores de los datos MORE
            modelo2.setValueAt(this.equivalencias.getDmList().get(moreResultados.get(0)),0, 1);
            resultadosM.add(this.equivalencias.getDmList().get(moreResultados.get(0)));
            modelo2.setValueAt(this.equivalencias.getImList().get(moreResultados.get(1)),0, 2);
            resultadosM.add(this.equivalencias.getImList().get(moreResultados.get(1)));
            modelo2.setValueAt(this.equivalencias.getSmList().get(moreResultados.get(2)),0, 3);
            resultadosM.add(this.equivalencias.getSmList().get(moreResultados.get(2)));
            modelo2.setValueAt(this.equivalencias.getCmList().get(moreResultados.get(3)),0, 4);
            resultadosM.add(this.equivalencias.getCmList().get(moreResultados.get(3)));
            
            //Llenar los valores de los datos LESS
            modelo2.setValueAt(this.equivalencias.getDlList().get(lessResultados.get(0)),1, 1);
            resultadosL.add(this.equivalencias.getDlList().get(lessResultados.get(0)));
            modelo2.setValueAt(this.equivalencias.getIlList().get(lessResultados.get(1)),1, 2);
            resultadosL.add(this.equivalencias.getIlList().get(lessResultados.get(1)));
            modelo2.setValueAt(this.equivalencias.getSlList().get(lessResultados.get(2)),1, 3);
            resultadosL.add(this.equivalencias.getSlList().get(lessResultados.get(2)));
            modelo2.setValueAt(this.equivalencias.getClList().get(lessResultados.get(3)),1, 4);
            resultadosL.add(this.equivalencias.getClList().get(lessResultados.get(3)));
           
            //Llenar los valores de los datos TOTALES
            modelo2.setValueAt(this.equivalencias.getDtList().get(totalResultados.get(0)+this.equivalencias.getDtRango()),2, 1);
            resultadosT.add(this.equivalencias.getDtList().get(totalResultados.get(0)+this.equivalencias.getDtRango()));
            this.lblNormal.setText(String.valueOf(resultadosT.get(0))+" Puntos");
            modelo2.setValueAt(this.equivalencias.getItList().get(totalResultados.get(1)+this.equivalencias.getItRango()),2, 2);
            resultadosT.add(this.equivalencias.getItList().get(totalResultados.get(1)+this.equivalencias.getItRango()));
            this.lblPrecision.setText(String.valueOf(resultadosT.get(1))+" Puntos");
            modelo2.setValueAt(this.equivalencias.getStList().get(totalResultados.get(2)+this.equivalencias.getStRango()),2, 3);
            resultadosT.add(this.equivalencias.getStList().get(totalResultados.get(2)+this.equivalencias.getStRango()));
            this.lblMotivacion.setText(String.valueOf(resultadosT.get(2))+" Puntos");
            modelo2.setValueAt(this.equivalencias.getCtList().get(totalResultados.get(3)+this.equivalencias.getCtRango()),2, 4);
            resultadosT.add(this.equivalencias.getCtList().get(totalResultados.get(3)+this.equivalencias.getCtRango()));
            
        }catch(Exception e){
            System.out.println("Error al llenar la tabla: " + e);
        }
        
        Collections.sort(resultadosM);
        Collections.sort(resultadosL);
        Collections.sort(resultadosT);
        
        this.resultadoFinal = (resultadosM.get(resultadosM.size()-1) 
                              + resultadosL.get(resultadosL.size()-1)
                              + resultadosT.get(resultadosT.size()-1)) / 3;
        
        this.lblNormal.setText(String.valueOf(resultadosT.get(0))+" pts.");
        this.lblPrecision.setText(String.valueOf(resultadosT.get(1))+" pts.");
        this.lblMotivacion.setText(String.valueOf(resultadosT.get(2))+" pts.");
        
        this.resultadoFinalLabel.setText(String.valueOf(this.resultadoFinal));
        
    };
    
    public double getPuntuacionFinal(){
        return this.resultadoFinal;
    }
    
    public void setDatosAlumno(Alumno alumno){
        this.nombreLabel.setText(alumno.getNombre());
        this.puestoLabel.setText(alumno.getPuesto());
        this.folioLabel.setText(alumno.getFolio());
        this.fechaLabel.setText(alumno.getFecha());
        
        this.alumno = alumno;
        
    }
    
    public Alumno getAlumno(){
        return this.alumno;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        resultadoFinalLabel = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        puestoLabel = new javax.swing.JLabel();
        folioLabel = new javax.swing.JLabel();
        fechaLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblNormal = new javax.swing.JLabel();
        lblMotivacion = new javax.swing.JLabel();
        lblPrecision = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnTerminar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Resultado Final:");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        table2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"M", null, null, null, null},
                {"L", null, null, null, null},
                {"TOTAL", null, null, null, null}
            },
            new String [] {
                "", "D", "I", "S", "C"
            }
        ));
        jScrollPane1.setViewportView(table2);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        table1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"M", null, null, null, null},
                {"L", null, null, null, null},
                {"TOTAL", null, null, null, null}
            },
            new String [] {
                "", "D", "I", "S", "C"
            }
        ));
        jScrollPane2.setViewportView(table1);

        resultadoFinalLabel.setBackground(new java.awt.Color(204, 255, 102));
        resultadoFinalLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        resultadoFinalLabel.setText("0");

        nombreLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nombreLabel.setText("jLabel2");

        puestoLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        puestoLabel.setText("jLabel2");

        folioLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        folioLabel.setText("jLabel3");

        fechaLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fechaLabel.setText("jLabel4");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Normal");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Precision");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Motivacion");

        lblNormal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNormal.setText("jLabel2");

        lblMotivacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMotivacion.setText("jLabel7");

        lblPrecision.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPrecision.setText("jLabel8");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Datos del alumno");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Sgnificado");

        jLabel7.setText("D: Dominante");

        jLabel8.setText("I: Influyente");

        jLabel9.setText("S: Estable");

        jLabel10.setText("C: Concienzudo");

        btnTerminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTerminar.setText("Terminar");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(resultadoFinalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(puestoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(folioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(nombreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 81, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lblNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(lblMotivacion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(lblPrecision, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fechaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(resultadoFinalLabel))
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(nombreLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(puestoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(folioLabel)
                        .addGap(9, 9, 9)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblNormal)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(lblMotivacion)
                            .addComponent(lblPrecision)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(fechaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(btnTerminar)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        this.alumno = DatosAlumnoForm.getVentana().getAlumno();
        this.alumno.setCalificacion(this.resultadoFinal);
        boolean result = dao.update(alumno);
        if(result){
            MensajeFinal eva = new MensajeFinal();
            eva.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "La información del Alumno no fue guardada, contacte al proveedor.");
        }
    }//GEN-LAST:event_btnTerminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTerminar;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JLabel folioLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMotivacion;
    private javax.swing.JLabel lblNormal;
    private javax.swing.JLabel lblPrecision;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JLabel puestoLabel;
    private javax.swing.JLabel resultadoFinalLabel;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
}
