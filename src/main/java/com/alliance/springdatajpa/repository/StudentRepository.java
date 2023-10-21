package com.alliance.springdatajpa.repository;

import com.alliance.springdatajpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  public List<Student> findByFirstName(String name);

  public List<Student> findByFirstNameContaining(String name);

  //using sql queries(JPQL)
  //named queries
  @Query("SELECT s FROM Student s WHERE s.guardian.name = :name ")
  public List<Student> findByGuardian(String name);

  public List<Student> findByLastNameNotNull();

  public List<Student> findByGuardianEmail(String email);

  @Query(
    value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1",
    nativeQuery = true
  )
  public Student getStudentByEmailAddressNative(String email);

//  used when defining record modifying quries
  @Modifying
  @Transactional
  @Query(
    value = "UPDATE tbl_student SET first_name = ?1 WHERE email_address = ?2",
    nativeQuery = true
  )
  public void updateStudentFirstNameByEmail(String name, String email);



 }
