package com.inStudentApi.model;

import java.util.List;


public class Student {
    private String id;
    private String name;
    private List<Course> courses;

    // Constructors, Getters, and Setters
    public Student(String id, String name, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }
}
