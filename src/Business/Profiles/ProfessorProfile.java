/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Profiles;

import java.util.ArrayList;

/**
 *
 * @author ameysatwe
 */
public class ProfessorProfile extends Profile{
    
    private String speciality;
    private String language;
    private String region;
    private String rankings;
    private int reputationIndex;

    public int getReputationIndex() {
        return reputationIndex;
    }

    public void setReputationIndexFromEmployer(int reputationIndex) {
        this.reputationIndex = reputationIndex;
    }
    
    private ArrayList<String> coursesTaught;
    
    public ProfessorProfile(Profile profile){
        super(profile);
    }
    
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRankings() {
        return rankings;
    }

    public void setRankings(String rankings) {
        this.rankings = rankings;
    }

    public void setRepIndexFromEmployer(Integer integer) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        this.reputationIndex = integer;
    }
    
    
}
