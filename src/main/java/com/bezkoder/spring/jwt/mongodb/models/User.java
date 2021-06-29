package com.bezkoder.spring.jwt.mongodb.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
  @Id
  private String id;

  @NotBlank
  @Size(min= 3, max = 20)
  private String firstname;

  @NotBlank
  @Size(min= 3, max = 20)
  private String lastname;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;

  @Size(max = 120)
  private String profilepic;

  @Size(max = 120)
  private String coverpic;

  private List<String> follower;

  private List<String> following;

  @DBRef
  private Set<Role> roles = new HashSet<>();

  public User() {
  }

  public User(List<String> follower, List<String> following) {
    this.follower = follower;
    this.following = following;
  }

  public User(String firstname, String lastname, String email, String password, String profilepic, String coverpic) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.password = password;
    this.profilepic = profilepic;
    this.coverpic = coverpic;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

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

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public String getProfilepic() { return profilepic; }

  public void setProfilepic(String profilepic) { this.profilepic = profilepic; }

  public String getCoverpic() { return coverpic; }

  public void setCoverpic(String coverpic) { this.coverpic = coverpic; }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public List<String> getFollower() {
    return follower;
  }

  public void setFollower(List<String> follower) {
    this.follower = follower;
  }

  public List<String> getFollowing() {
    return following;
  }

  public void setFollowing(List<String> following) {
    this.following = following;
  }
}
