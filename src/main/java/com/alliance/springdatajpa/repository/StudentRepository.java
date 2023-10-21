package com.alliance.springdatajpa.repository;

import com.alliance.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  public List<Student> findByFirstName(String name);

  public List<Student> findByFirstNameContaining(String name);

  //using sql queries(JPQL)
  @Query("SELECT s FROM Student s WHERE s.guardian.name = :name ")
  public List<Student> findByGuardian(String name);

  public List<Student> findByLastNameNotNull();

  public List<Student> findByGuardianEmail(String email);
 }
