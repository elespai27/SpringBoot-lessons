package com.ironhack.spring_lessons.repository;

import com.ironhack.spring_lessons.model.Grade;
import com.ironhack.spring_lessons.model.Section;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GradeRepositoryTest {
    @Autowired
    GradeRepository gradeRepository;

    @Autowired
    SectionRepository sectionRepository;

    private Grade grade1;


    @BeforeEach
    public void setUp() {
        Optional<Section> sectionOptional = sectionRepository.findById("CS103-A");
        assertTrue(sectionOptional.isPresent());
        grade1 = new Grade("Julian Gomez", 65, sectionOptional.get());
        gradeRepository.save(grade1);

    }

    @AfterEach
    public void tearDown() {
        gradeRepository.deleteById(grade1.getGradeId());
    }

    @Test
    public void testFindAll() {
        List<Grade> gradeList = gradeRepository.findAll();
        assertEquals(1, gradeList.size());
    }

    @Test
    public void testUpdate() {
        grade1.setScore(75);
        gradeRepository.save(grade1);
        System.out.println(gradeRepository);
        Optional<Grade> gradeOptional = gradeRepository.findById(grade1.getGradeId());
        assertTrue(gradeOptional.isPresent());
        System.out.println(gradeOptional.get());
        assertEquals(grade1.getGradeId(), gradeOptional.get().getGradeId());
    }

    @Test
    public void testDelete() {
        gradeRepository.delete(grade1);
        List<Grade> gradeList = gradeRepository.findAll();
        assertEquals(0, gradeList.size());
    }





}