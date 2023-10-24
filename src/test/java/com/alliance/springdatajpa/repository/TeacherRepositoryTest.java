package com.alliance.springdatajpa.repository;

import com.alliance.springdatajpa.entity.Course;
import com.alliance.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

  @Autowired
  TeacherRepository teacherRepository;

  @Test
  public void saveTeacher(){

    Course course = Course.builder()
      .title("bio")
      .credit(1)
      .build();
    Course course2 = Course.builder()
      .title("geo")
      .credit(1)
      .build();
    Teacher teacher = Teacher.builder()
      .fName("fils")
      .lName("dios")
//      .courses(List.of(course, course2))
      .build();

    teacherRepository.save(teacher);
  }

}
