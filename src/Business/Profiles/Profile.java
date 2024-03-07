/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Profiles;

/**
 *
 * @author ameysatwe
 */
public class Profile {
    private String name;
    private String email;
    private String contact;
    private String ssn;
    private String photoURL;
    private String birthDate;
    
    private String username;
    private String password;
    private boolean Enabled = false;
    
    public enum ProfileType{
        STUDENT,
        PROFESSOR,
        EMPLOYER,
        EVALUATOR,
        ADMIN;
    }
    public Profile(){
        
    }
    private ProfileType type;
    
    public Profile(Profile profile){
        this.name = profile.getName();
        this.email = profile.getEmail();
        this.username = profile.getUsername();
    }

    public boolean IsEnabled() {
        return Enabled;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.Enabled = isEnabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    private String nationality;
    
    
    public void setType(ProfileType type){
        this.type = type;
    }
    
    public ProfileType getType(){
        return type;
    }

    @Override
    public String toString() {
//        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        return username;
    }
    
    
}
