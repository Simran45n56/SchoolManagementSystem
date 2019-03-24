/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.model;

import java.time.LocalDate;

/**
 *
 * @author Siron
 */
public class UserDetail {
    private int id;
    private String firstName;
    private String lastName;
    private String image;
    private LocalDate dob;
    private String email;
    private String username;
    private String password;
    private String authority;
    private String active;
     
      public UserDetail() {
    }

    public UserDetail(String firstName, String lastName, String image, LocalDate dob, String email, String username, String password, String authority, String active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
        this.dob = dob;
        this.email = email;
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.active = active;
    }

    public UserDetail(int id, String firstName, String lastName, String image, LocalDate dob, String email, String username, String password, String authority, String active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
        this.dob = dob;
        this.email = email;
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
      
    
    
}
