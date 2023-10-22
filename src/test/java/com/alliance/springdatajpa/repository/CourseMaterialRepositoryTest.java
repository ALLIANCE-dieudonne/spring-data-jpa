package com.alliance.springdatajpa.repository;

import com.alliance.springdatajpa.entity.Course;
import com.alliance.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseMaterialRepositoryTest {

  @Autowired
  private CourseMaterialRepository courseMaterialRepository;

  @Test
  public void saveCourseMaterial(){

    Course course = Course.builder()
      .title("math")
      .credit(6)
      .build();

    CourseMaterial courseMaterial = CourseMaterial.builder()
      .url("www.google.com")
      .course(course)
      .build();

    courseMaterialRepository.save(courseMaterial);

  }
}
