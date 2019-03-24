/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.model;

/**
 *
 * @author Siron
 */
public class Student {
    private int id;
    private String name;
    private String gender;
    private String hobbies;
    private int course;
    private String country;

    public Student() {
    }

    public Student(String name, String gender, String hobbies, int course,String country) {
        this.name = name;
        this.gender = gender;
        this.hobbies = hobbies;
        this.course = course;
        this.country=country;
    }

    public Student(int id, String name, String gender, String hobbies, int course,String country) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.hobbies = hobbies;
        this.course = course;
        this.country=country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
       public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
    
    
    
}
