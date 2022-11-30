/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.patcare_system;

/**
 *
 * @author Mathe
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class OpenningScreen extends javax.swing.JFrame {



    /**
     * Creates new form OpenningScreen
     */
    public OpenningScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Pat");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 204, 0));
        jLabel2.setText("Care");

        jButton1.setText("Enter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(207, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jButton1)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            LoginScreen nextScreen = new LoginScreen();
            this.setVisible(false);
            nextScreen.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(OpenningScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpenningScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpenningScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpenningScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpenningScreen().setVisible(true);
                
                
                OffsetDateTime offset = OffsetDateTime.now();
                int month =offset.getMonthValue();
                System.out.println(month);
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String readerline ;
                
                String[] categories = {"M","F","over18","under18","1","0","D1Y","D2Y","Op1Y","OP2Y"} ;
                
                int primCa1Total = 1;
                int primCa2Total = 0;
                int secondCa11Total= 0;
                int secondCa12Total= 0;
                int secondCa21Total= 0;
                int secondCa22Total= 0;
            
                int[] nonTotals11 = {0,0,0,0,0,0};
                int[] nonTotals12 = {0,0,0,0,0,0};
                int[] nonTotals21 = {0,0,0,0,0,0};
                int[] nonTotals22 = {0,0,0,0,0,0};
                 
                try{
                  FileReader fr = new FileReader("CurrentPatientRecords.txt");
                  BufferedReader br = new BufferedReader(fr);
                    while( (readerline=br.readLine()) != null  ){
                        String[] record =readerline.split(" ");
                        
                        //System.out.println(record[1]);
                        
                        LocalDate timestamp = LocalDate.parse(record[3], format);
                        LocalDate op1time = LocalDate.parse(record[11], format);
                        int op1month= op1time.getMonthValue();
                        //System.out.println(op1month);
                
                        LocalDate op2time = LocalDate.parse(record[14], format);
                        int op2month= op2time.getMonthValue() ;
                
                        int timeStampMonth = timestamp.getMonthValue();
                        //System.out.println(timeStampMonth);
                        if(!(timeStampMonth == month)){}
                        else{
                            for (int i =1; i<15 ;i++){
                                //System.out.println(record[i]);
                                //System.out.println(categories[0]);
                                if ( record[i].equals(categories[0])  ){
                                    //System.out.println("here");
                                    primCa1Total++;
                                    //System.out.println(primCa1Total);
                                    for (int x=4; x<15; x++){
                                        //System.out.println(record[x]);
                                        //System.out.println(categories[2]);
                                        if (( record[x].equals(categories[2])) ){
                                            //secondCa11Total++;
                                            //System.out.println("here");
                                            for (int y =4; y<9 ; y++){
                                                for (int m =4; m<15 ;m++){
                                                    if(record[m].equals(categories[y])){
                                                    nonTotals11[y-4]++;}
                                                    //System.out.println(nonTotals11[y-4]);
                                                    
                                            }   }
                                        }//else if(){}
                                    }
                                }//else if(){}
                            }
                        }
                    }
                
                for  (int q = 1; q !=0 ;q++){
                if ((readerline=br.readLine()) != null){
                q=0;}else{   
                for (int w=0; w<10; w++){
                    for (int y =4; y<9 ; y++){
                        nonTotals12[y-4]++ ;
                        //nonTotals12[y-4] += nonTotals12[y-4] +1;
                        secondCa11Total++;}}}}
                System.out.println("no mo");    
                System.out.println(readerline);
                System.out.println(nonTotals11[1]);
                //System.out.println(nonTotals11[2]);
                //System.out.println(nonTotals11[3]);
                //System.out.println(nonTotals11[4]);
                //System.out.println(nonTotals11[5]);
                }catch(IOException e){e.printStackTrace();}
                
            }   
        });
    }
    
    //showMessageDialoge() use for error handelling

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}