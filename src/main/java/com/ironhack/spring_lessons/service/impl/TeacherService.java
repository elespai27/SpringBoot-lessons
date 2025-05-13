package com.ironhack.spring_lessons.service.impl;

import com.ironhack.spring_lessons.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    //where we do the petition
    @Autowired
    TeacherRepository teacherRepository;

}
