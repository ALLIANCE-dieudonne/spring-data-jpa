package com.alliance.springdatajpa.repository;

import com.alliance.springdatajpa.entity.Course;
import com.alliance.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {
  @Autowired
  private CourseRepository courseRepository;

  @Test
  public void getAllCourses() {
    List<Course> courses = courseRepository.findAll();
    System.out.println(courses);

  }

  @Test
  public void saveCourseWithTeacher() {
    Teacher teacher = Teacher.builder()
      .fName("kagabo")
      .lName("Eric")
      .build();

    Course course = Course.builder()
      .title("biology")
      .credit(4)
      .teacher(teacher)
      .build();

    courseRepository.save(course);
  }

  @Test
  public void findAllPagination() {
    PageRequest firstPageWithThreeRecords =
      PageRequest.of(0, 3);

    Pageable secondPageWithTwoRequests =
      PageRequest.of(1, 2);

    List<Course> courses =
      courseRepository.findAll(secondPageWithTwoRequests).getContent();

    Long totalElements = courseRepository.findAll(secondPageWithTwoRequests).getTotalElements();

    Long totalPages = (long) courseRepository.findAll(secondPageWithTwoRequests).getTotalPages();

    System.out.println(courses);
  }


}
