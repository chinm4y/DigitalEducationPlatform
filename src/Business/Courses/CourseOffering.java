/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Courses;

import Business.Profiles.ProfessorProfile;
import Business.Profiles.StudentProfile;
import java.util.ArrayList;

/**
 *
 * @author ameysatwe
 */


public class CourseOffering {
    private ProfessorProfile professor;
    private String semester;
    private Course course;
    private ArrayList<StudentProfile> students;
    private int classSize;

    public int getClassSize() {
        return classSize;
    }

    public void setClassSize(int classSize) {
        this.classSize = classSize;
    }
    private String timing;

    public String getTiming() {
        return timing;
    }
    
    public void setTiming(String timing) {
        this.timing = timing;
    }
    
    public CourseOffering(){
        this.students = new ArrayList();
    }

    public ProfessorProfile getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorProfile professor) {
        this.professor = professor;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ArrayList<StudentProfile> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<StudentProfile> students) {
        this.students = students;
    }

    
    
    public void addStudentToCourse(StudentProfile student){
        this.students.add(student);
        student.addCourse(this);
//        int curr_creds = Integer.parseInt(student.getCredits()+this.course.getCourseCredits());
//        student.setCredits(String.valueOf(curr_creds));
        int curr = student.getCredits() + this.course.getCourseCredits();
        student.setCredits(curr);
        this.classSize--;
    }

    @Override
    public String toString() {
//        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        return getCourse().getCourseTitle();
    }

    public void removeStudentFromCourse(StudentProfile currentStudent) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        this.students.remove(currentStudent);
        this.classSize++;
    }
    
    
    
}
