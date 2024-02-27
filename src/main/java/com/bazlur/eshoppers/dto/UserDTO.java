package com.bazlur.eshoppers.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDTO {

  @NotEmpty
  @Size(min = 4, max = 32)
  private String username;

  @NotEmpty
  @Size(min = 6, max = 16)
  private String password;

  @NotEmpty
  @Size(min = 6, max = 16)
  private String confirmPassword;

  @NotEmpty
  @Size(min = 1, max = 32)
  private String firstName;

  @NotEmpty
  @Size(min = 1, max = 32)
  private String lastName;

  @NotEmpty
  @Size(min = 4, max = 64)
  @Email
  private String email;

  // getters and setters
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

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "UserDTO{" +
        "username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", confirmPassword='" + confirmPassword + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        '}';
  }

}
