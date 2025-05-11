package com.ironhack.spring_lessons.repository;


import com.ironhack.spring_lessons.model.Course;
import com.ironhack.spring_lessons.model.Teacher;
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
    //estas líneas crean un obj (con la librería Spring)

    @Autowired
    TeacherRepository teacherRepository;

    @BeforeEach
    public void setUp() {
        Optional<Teacher> teacherOptional = teacherRepository.findById(2);
        if (teacherOptional.isPresent()) {
            Course algebra = new Course("Algebra", 50, "B1", "2weeks", teacherOptional.get());
            courseRepository.save(algebra);
            System.out.println(algebra);

        }
//
    }

    @AfterEach
    public void tearDown() {
        courseRepository.deleteById("Algebra");
    }

    //JPA Test
    @Test
    public void findAll_courses_courseList() {
        List<Course> courseList = courseRepository.findAll();
        System.out.println(courseList);
        assertEquals(6, courseList.size());
    }

    @Test
    public void finById_validCourse_correctCourse() {
        Optional<Course> courseOptional = courseRepository.findById("Algebra");
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
        assertEquals(3, courseList.size());
    }
// JPQL Test

    @Test
    public void findAllWhereHours150_courses_courseList() {
        List<Course> courseList = courseRepository.findAllWhereHours150();
        System.out.println(courseList);
        assertEquals(2, courseList.size());

    }

    @Test
    public void findAllWhereClassroomAndHoursParams_courses_courselist() {
        List<Course> courseList = courseRepository.findAllWhereClassroomAndHoursParams("B1", 150);
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    // Native SQL Test

    @Test
    public void nativeFindAllWhereHours150_courses_courseList() {
        List<Course> courseList = courseRepository.nativeFindAllWhereHours150();
        System.out.println(courseList);
        assertEquals(2, courseList.size());

    }

    @Test
    public void nativeFindAllWhereClassroomAndHoursParams_courses_courselist() {
        List<Course> courseList = courseRepository.naitveFindAllWhereClassroomAndHoursParams("B1", 150);
        System.out.println(courseList);
        assertEquals(3, courseList.size());

    }
}