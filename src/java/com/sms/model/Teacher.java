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
public class Teacher {
     private int id;
     private String subject;
     private String name;
     private Double salary;

    public Teacher() {
    }

    public Teacher(int id, String subject, String name, Double salary) {
        this.id = id;
        this.subject = subject;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", subject=" + subject + ", name=" + name + ", salary=" + salary + '}';
    }
     
     
    
}
