package com.ironhack.spring_lessons.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id") //nombre de la clave primaria de la clase Primaria
public class MultipleChoiceExam extends Exam{
    private Integer numberChoices;

    public MultipleChoiceExam() {
    }

    public Integer getNumberChoices() {
        return numberChoices;
    }

    public void setNumberChoices(Integer numberChoices) {
        this.numberChoices = numberChoices;
    }
}
