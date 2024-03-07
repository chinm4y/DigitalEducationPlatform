/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI.Main;

import Business.Profiles.ProfessorProfile;
import Business.Profiles.Profile;
import Business.Profiles.StudentProfile;
import Business.Courses.Course;
import Business.Courses.CourseOffering;
import Business.Utils.Utilities;

/**
 *
 * @author ameysatwe
 */
public class Configurator {

    private static void addCourses(Utilities utils,String profName,String[] courses) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        for(Integer i=0;i<courses.length;i++){
        Business.Courses.Course nCourse = new Course(utils.getProfessorByUserName(profName));
        
        nCourse.setCourseCredits(4);
        nCourse.setCourseID(i.toString());
        nCourse.setCourseTitle(courses[i]);
        nCourse.setDescription(courses[i]);
        nCourse.setLanguage("English");
        nCourse.setRegion("Boston,MA");
        
        utils.AddCourse(nCourse);
        
        }
        
    }
    private static void addProfessor(Utilities utils,String Name,String uname,String pwd){
        Profile newProfile = new Profile();
        newProfile.setType(Profile.ProfileType.PROFESSOR);
        newProfile.setName(Name);
        newProfile.setUsername(uname);
        newProfile.setIsEnabled(true);
        
        
        utils.addProfile(newProfile);
        utils.AddPasswordAndEncrypt(uname,pwd.toCharArray());
        
        ProfessorProfile prof = new ProfessorProfile(newProfile);
        
        utils.AddProfessors(prof);
        
    }

//    private static void addCourseOfferings(Utilities utils) {
////        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    public Configurator(){
        
    }
    public static void init(Utilities utils){
       Profile newProfile = new Profile();
        newProfile.setType(Profile.ProfileType.PROFESSOR);
        newProfile.setName("John Doe");
        newProfile.setUsername("amey");
        newProfile.setIsEnabled(true);
        
        
        utils.addProfile(newProfile);
        utils.AddPasswordAndEncrypt("amey", "amey".toCharArray());
        
        ProfessorProfile prof = new ProfessorProfile(newProfile);
        
        utils.AddProfessors(prof);
        
        Profile stud = new Profile();
        stud.setType(Profile.ProfileType.STUDENT);
        stud.setName("Amey Satwe");
        stud.setUsername("Amey");
        stud.setEmail("asatwe@gmail.com");
        stud.setIsEnabled(true);
        
        utils.addProfile(stud);
        
        StudentProfile student = new StudentProfile(stud);
        utils.AddStudents(student);
        utils.AddPasswordAndEncrypt("Amey", "amey".toCharArray());
        
        utils.AddSemester("Fall 2023");
        utils.AddSemester("Spring 2024");
        utils.AddSemester("Summer 2024");
        utils.AddSemester("Fall 2024");
        
        
        addCourses(utils,"amey",new String[]{"AED","DMDD"});
//        addCourseOfferings(utils);

        addProfessor(utils,"Amey","satwe","amey");
        addProfessor(utils, "Ella", "Smith", "ella");
        addProfessor(utils, "Oliver", "Johnson", "oliver");
        addProfessor(utils, "Sophia", "Williams", "sophia");
        addProfessor(utils, "Liam", "Jones", "liam");
        addProfessor(utils, "Ava", "Brown", "ava");
        addProfessor(utils, "Noah", "Davis", "noah");
        addProfessor(utils, "Isabella", "Miller", "isabella");
        addProfessor(utils, "Mason", "Wilson", "mason");
        addProfessor(utils, "Olivia", "Moore", "olivia");
        addProfessor(utils, "Ethan", "Taylor", "ethan");
//
        addCourses(utils, "satwe",new String[]{"AED","WEBD"});
        addCourses(utils, "Smith", new String[]{"DMDD","DADABI"});
        addCourses(utils, "Johnson", new String[]{"DSMT","PSA"});
        addCourses(utils, "Williams", new String[]{"CLD","BDS"});
        addCourses(utils, "Jones", new String[]{"DMDD","DADABI"});
        addCourses(utils, "Brown", new String[]{"DSMT","PSA"});
        addCourses(utils, "Davis", new String[]{"CLD","BDS"});
        addCourses(utils, "Miller", new String[]{"DMDD","DADABI"});
        addCourses(utils, "Wilson", new String[]{"DSMT","PSA"});
        addCourses(utils, "Moore", new String[]{"CLD","BDS"});
        addCourses(utils, "Taylor", new String[]{"DMDD","DADABI"});
        
        CourseOffering co = utils.addCourseOffering();
        co.setClassSize(10);
        co.setProfessor(utils.getProfessorByUserName("amey"));
        co.setCourse(utils.getCourseByCourseID("0"));
        co.setSemester("Fall 2023");
        co.setTiming("10-1");
//        
//        CourseOffering co3 = utils.addCourseOffering();
//        co.setClassSize(10);
//        co.setProfessor(utils.getProfessorByUserName("Smith"));
//        co.setCourse(utils.getC);
//        co.setSemester("Fall 2023");
//        co.setTiming("10-1");
         
        CourseOffering co2 = utils.addCourseOffering();
        co2.setClassSize(10);
        co2.setProfessor(utils.getProfessorByUserName("amey"));
        co2.setCourse(utils.getCourseByCourseID("1"));
        co2.setSemester("Fall 2023");
        co2.setTiming("10-1");
        
        
        
        Profile admin = new Profile();
        admin.setType(Profile.ProfileType.ADMIN);
        admin.setName("Amey Satwe");
        admin.setUsername("admin");
        admin.setEmail("asatwe@gmail.com");
        admin.setIsEnabled(true);
        
        utils.addProfile(admin);
        utils.AddPasswordAndEncrypt("admin", "admin".toCharArray());

    }
    
    
}
