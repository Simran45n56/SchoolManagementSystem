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
public class Course {
    
    private int id;
    private String title;
    private String duration;
    private Double price;

    public Course() {
    }
       public Course(String title, String duration, Double price) {
        this.title = title;
        this.duration = duration;
        this.price = price;
    }

    public Course(int id, String title, String duration, Double price) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", title=" + title + ", duration=" + duration + ", price=" + price + '}';
    }
    

 
    
    
    
}
