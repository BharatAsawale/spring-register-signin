package com.bezkoder.spring.jwt.mongodb.payload.request;

import java.util.Set;

import javax.validation.constraints.*;
 
public class SignupRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String firstname;

    @NotBlank
    @Size(min = 3, max = 20)
    private String lastname;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    private Set<String> roles;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    private String profilepic;

    private String coverpic;
  
    public String getUsername() {
        return email;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRoles() {
      return this.roles;
    }
    
    public void setRole(Set<String> roles) {
      this.roles = roles;
    }

    public String getProfilepic() { return profilepic; }

    public void setProfilepic(String profilepic) { this.profilepic = profilepic; }

    public String getCoverpic() { return coverpic; }

    public void setCoverpic(String coverpic) { this.coverpic = coverpic; }

    public String getFirstname() {return firstname;}

    public void setFirstname(String firstname) {this.firstname = firstname;}

    public String getLastname() {return lastname;}

    public void setLastname(String lastname) {this.lastname = lastname;}
}
