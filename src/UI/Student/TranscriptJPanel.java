/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Student;

import Business.Courses.CourseOffering;
import Business.Profiles.Profile;
import Business.Profiles.StudentProfile;
import Business.Utils.Utilities;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chinm
 */
public class TranscriptJPanel extends javax.swing.JPanel {

    /**
     * Creates new form TranscriptJPanel
     */
    public TranscriptJPanel() {
        initComponents();
    }
    
    
     private JPanel workArea;
    private Utilities utils;
    
    public TranscriptJPanel(JPanel WorkArea, Utilities utils) {
        initComponents();
        this.workArea = WorkArea;
        this.utils = utils;
        
        populateTranscriptDetails();
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
        TranscriptJTable = new javax.swing.JTable();
        gradbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        TranscriptJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Course Name", "Credits", "Semester", "Grade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TranscriptJTable);

        gradbtn.setText("Graduate");
        gradbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradbtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("CURRENT TRANSCRIPT");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(gradbtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton1)
                        .addGap(127, 127, 127)
                        .addComponent(jLabel1)))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(gradbtn)
                .addGap(59, 59, 59))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void gradbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradbtnActionPerformed
      StudentProfile student = utils.getCurrentStudent();
      ArrayList<CourseOffering> cs = student.getCourses();
      if(student.getCredits() >=32 && cs.size()>=8){
          utils.addStudentToGradList(student);
          JOptionPane.showMessageDialog(this,"Your transcript was sent to the evaluator. Please wait");
      }
      else{
           JOptionPane.showMessageDialog(this,"We regret to inform you that you will not be able to graduate this semester");
      }
          

        // TODO add your handling code here:
    }//GEN-LAST:event_gradbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        workArea.remove(this);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.previous(workArea);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TranscriptJTable;
    private javax.swing.JButton gradbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void populateTranscriptDetails() {
        
        DefaultTableModel dtm = (DefaultTableModel) TranscriptJTable.getModel();
        dtm.setRowCount(0);
        
        StudentProfile student = utils.getCurrentStudent();
//        
        ArrayList<CourseOffering> courses = student.getCourses();
        if(courses!=null){
        for(var x : courses){
            Object[] row = new Object[6];
            row[0] = x.getCourse().getCourseTitle();
            row[1] = x.getCourse().getCourseCredits();
            row[2] = x.getSemester();
            row[3] = student.getGrade(x.getCourse().getCourseID());
            dtm.addRow(row);
    }
        }
    }
}
