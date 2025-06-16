/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.uv.uvtest;

import org.uv.uvtest.Data.Preguntas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonModel;

/**
 *
 * @author GAMR_
 */
public class PreguntasForm extends javax.swing.JPanel {

    private Preguntas preguntasClass;
    private String[][] preguntas;    
    private int paso = 0;
    private boolean siguienteFlag = true;
    private boolean atrasFlag = false;
    private int puntuacion = 0;
    
    private boolean moreGroupValidator = true;
    private boolean lessGroupValidator = true;
    
    //Arrays de checkbox seleccionados
    int[] mSelected = new int[24];
    int[] lSelected = new int[24];
    
    
    /**
     * Creates new form PreguntasForm
     */
    public PreguntasForm() {
        initComponents();
        this.preguntasClass = Preguntas.getVentana();
        this.preguntas = this.preguntasClass.getPreguntas();
        r1.setText(this.preguntas[0][0]);
        r2.setText(this.preguntas[0][1]);
        r3.setText(this.preguntas[0][2]);
        r4.setText(this.preguntas[0][3]);
        this.pasoLabel.setText("1 de 24");
    }
    
    public void siguiente(){
        
        System.out.println(this.paso);
        
        this.capturarMoreWord();
        this.capturarLessWord();
        if(this.moreGroupValidator && this.lessGroupValidator){
            this.paso++;
            r1.setText(this.preguntas[this.paso][0]);
            r2.setText(this.preguntas[this.paso][1]);
            r3.setText(this.preguntas[this.paso][2]);
            r4.setText(this.preguntas[this.paso][3]);
            this.pasoLabel.setText( String.valueOf(this.paso + 1) + " de 24");
            this.atrasFlag = true;
            //Limpiar checkbox
            this.moreGroup.clearSelection();
            this.lessGroup.clearSelection();
            this.validLabel.setText("");
        }else{
            this.validLabel.setText("Selecciona ambas opciones");
        }
        
        
    }
    
    public void atras(){
        this.paso--;
        r1.setText(this.preguntas[this.paso][0]);
        r2.setText(this.preguntas[this.paso][1]);
        r3.setText(this.preguntas[this.paso][2]);
        r4.setText(this.preguntas[this.paso][3]);
        if(this.paso == 0){
            
            this.atrasFlag = false;
        }else{
            this.atrasFlag = true;
            int stepCheckMore = this.mSelected[this.paso];
            if(stepCheckMore == 1){

                moreGroup.setSelected((ButtonModel) this.m1, true);
            }else
            this.moreGroup.clearSelection();
            this.lessGroup.clearSelection();
            this.siguienteFlag = true;
        }
        System.out.println(this.paso);
    }
    
    public void capturarMoreWord(){
        String moreWord;
        
        //Comprobas More Word
        if(m1.isSelected()){
            moreWord = r1.getText();
            mSelected[this.paso] = 1;
            this.moreGroupValidator = true;
        }else if(m2.isSelected()){
            moreWord = r2.getText();
            mSelected[this.paso] = 2;
            this.moreGroupValidator = true;
        }else if(m3.isSelected()){
            moreWord = r3.getText();
            mSelected[this.paso] = 3;
            this.moreGroupValidator = true;
        }else if(m4.isSelected()){
            moreWord = r4.getText();
            mSelected[this.paso] = 4;
            this.moreGroupValidator = true;
        }else{
            moreWord = "";
            this.moreGroupValidator = false;
        }
        System.out.println(moreWord);
        this.preguntasClass.buscarPalabra(moreWord, "m");
    }
    
    public void capturarLessWord(){
        String lessWord;
        
        //Comprobas More Word
        if(l1.isSelected()){
            lessWord = r1.getText();
            lSelected[this.paso] = 1;
            this.lessGroupValidator = true;
        }else if(l2.isSelected()){
            lessWord = r2.getText();
            lSelected[this.paso] = 2;
            this.lessGroupValidator = true;
        }else if(l3.isSelected()){
            lessWord = r3.getText();
            lSelected[this.paso] = 3;
            this.lessGroupValidator = true;
        }else if(l4.isSelected()){
            lessWord = r4.getText();
            lSelected[this.paso] = 4;
            this.lessGroupValidator = true;
        }else{
            this.lessGroupValidator = false;
            lessWord = "";
        }
        this.preguntasClass.buscarPalabra(lessWord, "l");
    }

    public boolean getSiguienteFlag() {
        return siguienteFlag;
    }

    public boolean getAtrasFlag() {
        return atrasFlag;
    }
    
    public int getPaso(){
        return this.paso;
    }
    
    public Preguntas getPreguntasClass(){
        return this.preguntasClass;
    }
    
    public void validarMoreGroup(){
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        moreGroup = new javax.swing.ButtonGroup();
        lessGroup = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        r1 = new javax.swing.JLabel();
        r2 = new javax.swing.JLabel();
        r3 = new javax.swing.JLabel();
        r4 = new javax.swing.JLabel();
        m1 = new javax.swing.JRadioButton();
        l1 = new javax.swing.JRadioButton();
        m2 = new javax.swing.JRadioButton();
        l2 = new javax.swing.JRadioButton();
        m3 = new javax.swing.JRadioButton();
        l3 = new javax.swing.JRadioButton();
        m4 = new javax.swing.JRadioButton();
        l4 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        validLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        pasoLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Siga las siguientes intrucciones.");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea1.setRows(2);
        jTextArea1.setTabSize(6);
        jTextArea1.setText("1.Seleccione la palabra que más se parezca a usted en la columna “M” (more en inglés)\n\n2.Seleccione la palabra que menos se parezca a usted en la columna “L” (Less en inglés)\n");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        r1.setText("jLabel2");

        r2.setText("jLabel3");

        r3.setText("jLabel4");

        r4.setText("jLabel5");

        moreGroup.add(m1);

        lessGroup.add(l1);

        moreGroup.add(m2);

        lessGroup.add(l2);

        moreGroup.add(m3);

        lessGroup.add(l3);

        moreGroup.add(m4);

        lessGroup.add(l4);

        jLabel2.setText("M");

        jLabel3.setText("L");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r1)
                    .addComponent(r2)
                    .addComponent(r3)
                    .addComponent(r4))
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(m2)
                            .addComponent(m3)
                            .addComponent(m4)
                            .addComponent(jLabel2))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(l3)
                                    .addComponent(l2)
                                    .addComponent(l4)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(m1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l1)))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(m1)
                    .addComponent(l1)
                    .addComponent(r1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(r2)
                        .addComponent(m2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(r3)
                        .addComponent(m3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(r4)
                        .addComponent(m4)))
                .addGap(26, 26, 26))
        );

        validLabel.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(169, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(validLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(151, 151, 151)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(validLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel3, java.awt.BorderLayout.CENTER);

        pasoLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pasoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(524, Short.MAX_VALUE)
                .addComponent(pasoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pasoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        add(jPanel4, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton l1;
    private javax.swing.JRadioButton l2;
    private javax.swing.JRadioButton l3;
    private javax.swing.JRadioButton l4;
    private javax.swing.ButtonGroup lessGroup;
    private javax.swing.JRadioButton m1;
    private javax.swing.JRadioButton m2;
    private javax.swing.JRadioButton m3;
    private javax.swing.JRadioButton m4;
    private javax.swing.ButtonGroup moreGroup;
    private javax.swing.JLabel pasoLabel;
    private javax.swing.JLabel r1;
    private javax.swing.JLabel r2;
    private javax.swing.JLabel r3;
    private javax.swing.JLabel r4;
    private javax.swing.JLabel validLabel;
    // End of variables declaration//GEN-END:variables
}
