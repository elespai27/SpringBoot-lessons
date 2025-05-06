package com.ironhack.spring_lessons.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
//Representa la tabla teacher de la BBDD
public class Teacher {
    @Id
    //Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String teacher;

// Empty constructor is absolutely necessary for spring to work
    public Teacher() {
    }

    public Teacher(String teacher) {
        this.teacher = teacher;
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

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
