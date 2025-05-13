package com.ironhack.spring_lessons.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Section {

    @Id
    @Column(name = "section_id", length = 8)
    private String sectionId;

    @ManyToOne
    @JoinColumn(name = "course")
    private Course course;

    private Short roomNum;
    private String instructor;

}
