/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Professor;

import Business.Courses.Course;
import Business.Courses.CourseOffering;
import Business.Utils.Utilities;
import java.awt.CardLayout;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

/**
 *
 * @author ameysatwe
 */
public class ProfessorAddScheduleJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProfessorAddScheduleJPanel
     */
    public ProfessorAddScheduleJPanel() {
        initComponents();
    }

    private JPanel workArea;
    private Utilities utils;
    ProfessorAddScheduleJPanel(JPanel workArea, Utilities utils) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        initComponents();
        this.workArea = workArea;
        this.utils = utils;
        populateCombos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        courseComboBox = new javax.swing.JComboBox<>();
        SemComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TimingsTxtField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        addScheduleBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ClassSizeTxt = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));

        courseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[100]));

        SemComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[100]));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Course : ");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Semester : ");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Timings : ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Add Course Schedule");

        addScheduleBtn.setBackground(new java.awt.Color(51, 255, 255));
        addScheduleBtn.setText("Add Schedule");
        addScheduleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addScheduleBtnActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Class Size : ");

        backButton.setBackground(new java.awt.Color(51, 255, 255));
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 163, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(courseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TimingsTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ClassSizeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 87, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(addScheduleBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TimingsTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ClassSizeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(addScheduleBtn)
                .addContainerGap(229, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ClassSizeTxt, SemComboBox, TimingsTxtField, addScheduleBtn, courseComboBox});

    }// </editor-fold>//GEN-END:initComponents

    private void addScheduleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addScheduleBtnActionPerformed
        // TODO add your handling code here:
        
        // add new course schedule for the current prof.
        
        CourseOffering co = utils.addCourseOffering();
        co.setClassSize(Integer.parseInt(ClassSizeTxt.getText()));
        co.setSemester(SemComboBox.getSelectedItem().toString());
        String selected_course = courseComboBox.getSelectedItem().toString();
        ArrayList<Course> courses = utils.getCurrentCourses();
        Course course = null;
        for(var x : courses){
            if(selected_course.equals(x.getCourseTitle())){
                course = x;
            }
        }
        co.setCourse(course);
        co.setProfessor(utils.getCurrentProfessor());
        
    }//GEN-LAST:event_addScheduleBtnActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        workArea.remove(this);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.previous(workArea);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ClassSizeTxt;
    private javax.swing.JComboBox<String> SemComboBox;
    private javax.swing.JTextField TimingsTxtField;
    private javax.swing.JButton addScheduleBtn;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> courseComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

    private void populateCombos() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        ArrayList<Course> courses = utils.getCurrentCourses();
        ArrayList<String> courseNames = new ArrayList();
        for(var x:courses){
            courseNames.add(x.getCourseTitle());
        }
        ComboBoxModel<String> courseModel;
        courseModel = new DefaultComboBoxModel(courseNames.toArray());
        courseComboBox.setModel(courseModel);
        
        
        ArrayList<String> availableSems = utils.getAvailableSemesters();
        ComboBoxModel<String> semModel = new DefaultComboBoxModel(availableSems.toArray());
        SemComboBox.setModel(semModel);
    }
}
