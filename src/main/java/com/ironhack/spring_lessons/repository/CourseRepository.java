package com.ironhack.spring_lessons.repository;

import com.ironhack.spring_lessons.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    //Métodos propios en JPA de consulta
    //los nombres del método siempre tiene que ser así: "findBy" + la prop de búsqueda

    // JPA Keywords

    Optional<Course> findByHours(Integer hours);
    List<Course> findAllByClassroom(String classroom);
    List<Course> findAllByCourseContaining(String str);
    List<Course> findAllByHoursLessThan(Integer hours);

    // JPQL

//    @Query("SELECT c FROM Course c WHERE c.hours = 150")
//    List<Course> findAllWhereHours150();
//
//    @Query("SELECT c FROM Course c WHERE c.classroom = ?1 AND c.hours <= ?2")
//    List<Course> findAllWhereClassroomAndHoursParams(String classroom Integer hours);




}
