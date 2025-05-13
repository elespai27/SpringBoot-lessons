package com.ironhack.spring_lessons.service.interfaces;

import com.ironhack.spring_lessons.model.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    List<Course> getAllCourses();
    Course getCourseById(String course);
    List<Course> getCourseByHoursLessThan(Integer hours);
    List<Course> getCourseByClassroomAndHours(String classroom, Optional<Integer> hours);

    void saveCourse(Course course);

    void deleteCourse(String id);
}
