/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Utils;

import Business.Profiles.ProfessorProfile;
import Business.Profiles.Profile;
import Business.Profiles.StudentProfile;
import Business.Courses.Course;
import Business.Courses.CourseOffering;
import at.favre.lib.crypto.bcrypt.BCrypt;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ameysatwe
 */
public class Utilities {
    private ArrayList<ProfessorProfile> professors;
    private ArrayList<StudentProfile> students;
    private ArrayList<Course> courses;
    private ArrayList<CourseOffering> courseOfferings;
    private ArrayList<Profile> profiles;
    private ArrayList<StudentProfile> studentsReadyToGrad;

    public ArrayList<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(ArrayList<Profile> profiles) {
        this.profiles = profiles;
    }
    private HashMap<String,ArrayList<String>> userNamePasswordMap = null;
    private Profile currentProfile;
    private ArrayList<String> semesters;

    public Profile getCurrentProfile() {
        return currentProfile;
    }

    public void setCurrentProfile(Profile currentProfile) {
        this.currentProfile = currentProfile;
    }
    
    
    
    public Utilities(){
        
        this.professors = new ArrayList();
        this.students = new ArrayList();
        this.courses = new ArrayList();
        this.courseOfferings = new ArrayList();
        this.profiles = new ArrayList();
        this.userNamePasswordMap = new HashMap();
        this.semesters = new ArrayList();
        this.studentsReadyToGrad = new ArrayList();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<CourseOffering> getCourseOfferings() {
        return courseOfferings;
    }

    public void setCourseOfferings(ArrayList<CourseOffering> courseOfferings) {
        this.courseOfferings = courseOfferings;
    }

    public ArrayList<ProfessorProfile> getProfessors() {
        return professors;
    }

    public void setProfessors(ArrayList<ProfessorProfile> professors) {
        this.professors = professors;
    }

    public ArrayList<StudentProfile> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<StudentProfile> students) {
        this.students = students;
    }
    
    public Profile getProfileByUsername(String uname){
        for(Profile p:profiles){
            if(uname.equals(p.getUsername())){
                return p;
            }
        }
        return null;
    }
    
    public boolean ValidateLogin(String userName,char[] password){
        
        Profile currProfile = this.getProfileByUsername(userName);
        
        BCrypt.Result result = BCrypt.verifyer().verify(password, currProfile.getPassword());
        
        return result.verified && currProfile.IsEnabled();
    }
    
    public int AddPasswordAndEncrypt(String username,char[] raw_password){
        
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, raw_password);
        
        ArrayList<String> pwds = new ArrayList();
        Profile cP = getProfileByUsername(username);

        
        if(!this.userNamePasswordMap.keySet().contains(cP.getUsername())){
            pwds.add(bcryptHashString);
            this.userNamePasswordMap.put(cP.getUsername(),pwds);
            cP.setPassword(bcryptHashString);
            return 0;
        }
        else{
            ArrayList<String> oldPasswordsHash = this.userNamePasswordMap.get(cP.getUsername());
            for(String o:oldPasswordsHash){
                BCrypt.Result result = BCrypt.verifyer().verify(raw_password, o.toCharArray());
                if(result.verified){
                    return -1;
                }
            }
            oldPasswordsHash.add(bcryptHashString);
            this.userNamePasswordMap.put(cP.getUsername(),oldPasswordsHash);
            cP.setPassword(bcryptHashString);
            return 0;
            }
         
    }
    
    
    public void AddCourse(Course c){
//        Course c = new Course(prof);
        this.courses.add(c);
        System.out.println(this.courses);
    }
    
    
    public CourseOffering addCourseOffering(){
       CourseOffering co = new CourseOffering();
       this.courseOfferings.add(co);
       return co;
    }    

    public void addProfile(Profile newProfile) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     this.profiles.add(newProfile);
    }
    
    
    public ArrayList getCurrentCourses(){
        ArrayList<Course> ans = new ArrayList();
        for(var x:courses){
            if(getCurrentProfessor().equals(x.getProfessor())){
                ans.add(x);
            }
        }
        return ans;
    }
    
    
    public ProfessorProfile getCurrentProfessor(){
        for(var x : professors){
            if(getCurrentProfile().getUsername().equals(x.getUsername())){
                return x;
            }
        }
        return null;
    }
    
    
    public void AddProfessors(ProfessorProfile prof){
        this.professors.add(prof);
    }
    
    public void AddStudents(StudentProfile student){
        this.students.add(student);
    }
    

    public ArrayList<StudentProfile> getStudents(String courseID, ProfessorProfile currentProfessor) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        for(var x:courseOfferings){
            if(x.getProfessor().equals(currentProfessor) && x.getCourse().getCourseID().equals(courseID)){
                return x.getStudents();
            }
        }
       return null; 
    }

//    public CourseOffering.Semesters getSemester(String courseID) {
////        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        for(var x: courseOfferings){
//            if(courseID.equals(x.getCourse().getCourseID())){
//                return x.getSemester();
//            }
//        }
//        return null;
//    }

    public String getCourseNameByCourseID(String courseID) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       for(var x : courseOfferings){
           if(courseID.equals(x.getCourse().getCourseID())){
               return x.getCourse().getCourseTitle();
           }
       }
       return null;
    }

    public void doLogout() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        setCurrentProfile(null);
    }

    public ArrayList searchCourseByTitle(String title) {
        ArrayList<CourseOffering> ans = new ArrayList();
        for(var x : courseOfferings){
            if(x.getCourse().getCourseTitle().equals(title)){
                ans.add(x);
            }
        }
        return ans;
    }

    public ArrayList searchCourseByProfName(String profName) {
        ArrayList<CourseOffering> ans = new ArrayList();
        for(var x : courseOfferings){
            if(x.getProfessor().getName().equals(profName)){
                ans.add(x);
            }
        }
        return ans;
    }

    public ArrayList searchCourseByLang(String language) {
        ArrayList<CourseOffering> ans = new ArrayList();
        for(var x : courseOfferings){
            if(x.getCourse().getLanguage().equals(language)){
                ans.add(x);
            }
        }
        return ans;
    }

    public ArrayList searchCourseByRegion(String region) {
        ArrayList<CourseOffering> ans = new ArrayList();
        for(var x : courseOfferings){
            if(x.getCourse().getRegion().equals(region)){
                ans.add(x);
            }
        }
        return ans;
    }

    public ArrayList<String> getAvailableSemesters() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return semesters;
    }
    
    public void AddSemester(String sem){
        this.semesters.add(sem);
    }
    
    public StudentProfile getCurrentStudent(){
       for(var x : students){
            if(getCurrentProfile().getUsername().equals(x.getUsername())){
                return x;
            }
        }
       return null;
    }    
    
    public ProfessorProfile getProfessorByUserName(String uname){
        for(var x:professors){
            if(x.getUsername().equals(uname)){
                return x;
            }
        }
        return null;
    }
    
    public Course getCourseByCourseID(String id){
        for(var x: courses){
            if(x.getCourseID().equals(id)){
                return x;
            }
        }
        return null;
    }

    public ArrayList<CourseOffering> getCourseOfferingsforCurrentProf() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        ArrayList<CourseOffering> ans = new ArrayList();
        for(var x:courseOfferings){
            if(getCurrentProfessor().equals(x.getProfessor())){
                ans.add(x);
            }
        }
        return ans;
    }

    public ArrayList<StudentProfile> getStudentsReadyToGraduate() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return studentsReadyToGrad;
    }
    
    public void addStudentToGradList(StudentProfile student){
        this.studentsReadyToGrad.add(student);
    }

    public int getTotalStudents(ProfessorProfile p) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            int student_count = 0;
           for(var x:courseOfferings){
               if(x.getProfessor().equals(p)){
                   student_count += x.getStudents().size();
               }
           }
           return student_count;
    }
    
}
