package com.ironhack.spring_lessons.repository;


import com.ironhack.spring_lessons.model.Course;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    //inyección de dependencias para que implemente lo de JpaRepository de la Interface
    CourseRepository courseRepository;
    //estas líneas crean un obj (con la libreria Spring)


    @BeforeEach
    public void setUp() {
        Course algebra = new Course("Algebra", 50, "B1", "2weeks", 3);
        courseRepository.save(algebra);
        System.out.println(algebra);
    }

    @AfterEach
     public void tearDown() {
        courseRepository.deleteById("Algebra");
    }

    @Test
    public void findAll_courses_courseList() {
        List<Course> courseList = courseRepository.findAll();
        System.out.println(courseList);
        assertEquals(7, courseList.size());
    }

    @Test
    public void finById_validCourse_correctCourse() {
        Optional<Course> courseOptional= courseRepository.findById("English");
        assertTrue(courseOptional.isPresent());
        System.out.println(courseOptional.get());
        assertEquals(50, courseOptional.get().getHours());
    }

    @Test
    public void findById_invalidCourse_incorrectCourse() {
        Optional<Course> courseOptional = courseRepository.findById("Economía");
        assertTrue(courseOptional.isEmpty());
    }

    @Test
    public void findByHours_validHours_correctCourse() {
        Optional<Course> courseOptional = courseRepository.findByHours(200);
        assertTrue(courseOptional.isPresent());
        System.out.println(courseOptional.get());
        assertEquals("Physics", courseOptional.get().getCourse());
    }

    @Test
    public void findAllByClassroom_validClassroom_courseList() {
        List<Course> courseList = courseRepository.findAllByClassroom("B1");
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }
@Test
    public void findAllByCourseContaining_str_courseList() {
        List<Course> courseList = courseRepository.findAllByCourseContaining("p");
    System.out.println(courseList);
    assertEquals(3, courseList.size());
}

@Test
    public void findAllByHoursLessThan_validaHours_courseList() {
        List<Course> courseList = courseRepository.findAllByHoursLessThan(150);
    System.out.println(courseList);
    assertEquals(4, courseList.size());
}

}