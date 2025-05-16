package com.ironhack.spring_lessons.controller.impl;

import com.ironhack.spring_lessons.controller.dto.CourseClassroomDTO;
import com.ironhack.spring_lessons.controller.dto.CourseHoursDTO;
import com.ironhack.spring_lessons.model.Course;
import com.ironhack.spring_lessons.service.interfaces.ICourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    ICourseService courseService;

    //  ****************************************************  GET (Bring the information) ******************************************

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{course}")
    public Course getCourseById(@PathVariable String course) {
        return courseService.getCourseById(course);
    }

    @GetMapping("/courses/hours")
    public List<Course> getCourseByHoursLessThan(@RequestParam(defaultValue = "200") Integer hours) {
        return courseService.getCourseByHoursLessThan(hours);
    }

    @GetMapping("/courses/classroom")
    public List<Course> getCourseByClassroomAndHours(
            @RequestParam(defaultValue = "A1") String classroom,
            @RequestParam Optional<Integer> hours
    ) {
        return courseService.getCourseByClassroomAndHours(classroom, hours);
    }

    //  ***************************************************  POST (Create the information) ****************************************

    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody @Valid Course course) {
        courseService.saveCourse(course);
    }

    //  ***************************************************  PUT (Update the Information) ****************************************

    @PutMapping("/courses/{id}")
    public Course updateCourse(@RequestBody @Valid Course course, @PathVariable String id) {
        return courseService.updateCourse(course, id);
    }

    //  ***************************************************  PATH (Update some of the Information) ****************************************

    @PatchMapping("/courses/hours/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCourseHours(@RequestBody @Valid CourseHoursDTO courseHoursDTO, @PathVariable String id) {
        courseService.updateCourseHours(courseHoursDTO.getHours(), id);

    }

    @PatchMapping("/courses/classroom/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCourseClassroom(@RequestBody @Valid CourseClassroomDTO courseClassroomDTO, @PathVariable String id)
    {
        courseService.updateCourseClassroom(courseClassroomDTO.getClassroom(), id);

    }
    //  **************************************************  DELETE (Obviously, delete the information) ****************************

    @DeleteMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }



}
