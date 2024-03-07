/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Profiles;

import Business.Courses.Course;
import Business.Courses.CourseOffering;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ameysatwe
 */
public class StudentProfile extends Profile {
    
    private String id;
    private ArrayList<CourseOffering> courses;

    public StudentProfile(Profile newProfile) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     super(newProfile);
     this.courses = new ArrayList();
     this.courseGradeMap = new HashMap();
     this.credits = 0;
    }
    public StudentProfile(){
        this.courses = new ArrayList();
        this.courseGradeMap = new HashMap();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    private Map<String,Integer> courseGradeMap;

    public void AssignGrade(String CourseID,Integer Grade){

        courseGradeMap.put(CourseID,Grade);
    }
    
    public Integer getGrade(String CourseID){
        return courseGradeMap.get(CourseID);
    }
    
    
    public void addCourse(CourseOffering c){
        this.courses.add(c);
    }
    
    public ArrayList<CourseOffering> getCourses(){
        return courses;
    }
    
    private String program;
    private int credits;
    private boolean readyToGrad;

    public boolean isReadyToGrad() {
        return readyToGrad;
    }

    public void setReadyToGrad(boolean readyToGrad) {
        this.readyToGrad = readyToGrad;
    }

    public double getGpa() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        double gpa = 1.0;
        int ctr=1;
        for(var x : courseGradeMap.keySet()){
            int curr_grade = courseGradeMap.get(x);
            gpa += curr_grade;
            ctr++;
        }
        return gpa/ctr;
    }

    public void removeCourse(CourseOffering co) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        this.courses.remove(co);
        this.courseGradeMap.remove(co.getCourse().getCourseID());
    }
    
}
