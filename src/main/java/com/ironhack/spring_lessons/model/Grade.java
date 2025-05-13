package com.ironhack.spring_lessons.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gradeId;

    private String studentName;
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    public Grade(String studentName, Integer score, Section section) {
        this.studentName = studentName;
        this.score = score;
        this.section = section;
    }
}
