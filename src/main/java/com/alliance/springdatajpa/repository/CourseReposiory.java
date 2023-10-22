package com.alliance.springdatajpa.repository;

import com.alliance.springdatajpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseReposiory extends JpaRepository<Course, Long> {
}
