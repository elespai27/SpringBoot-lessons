package com.ironhack.spring_lessons.repository;

import com.ironhack.spring_lessons.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, String> {
}
