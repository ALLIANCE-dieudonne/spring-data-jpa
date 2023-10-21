package com.alliance.springdatajpa.repository;

import com.alliance.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

  @Autowired
  private StudentRepository studentRepository;

  @Test
  public void saveStudent(){
    Student student = Student.builder()
      .emailId("fil@gmail.com")
      .firstName("fils")
      .lastName("kabaka")
      .guardianName("kibwa")
      .guardianEmail("g@gmail.com")
      .guardianMobile("+120 478 90").build();

    studentRepository.save(student);

  }

  @Test
  public void getAllStudents(){
    List<Student> students = studentRepository.findAll();

    System.out.println(students);
  }

}
