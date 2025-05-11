package com.ironhack.spring_lessons.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
//Representa la tabla teacher de la BBDD
public class Teacher {
    @Id
    //Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String teacher;

    @OneToOne(cascade = CascadeType.ALL) //Relación uno a uno//realiza la op en cascada
    private Address address;
//  Use only if absolutely necessary bidirectional relationship
//  If used, we must be careful not to create a stackOverflow Error

//  @OneToMany(mappedBy = "teacher")
//  private List<Course> courses;

    // Empty constructor is absolutely necessary for spring to work
    public Teacher() {
    }

    public Teacher(String teacher, Address address) {
        this.teacher = teacher;
        this.address = address;
    }

    public Teacher(String teacher) {
        this.teacher = teacher;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

//    public List<Course> getCourses() {
//        return courses;
//    }

//    public void setCourses(List<Course> courses) {
//        this.courses = courses;
//    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacher='" + teacher + '\'' +
                ", address=" + address +
                '}';
    }
}
