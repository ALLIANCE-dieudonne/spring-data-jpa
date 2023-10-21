package com.alliance.springdatajpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
  name = "tbl_student",
  uniqueConstraints = @UniqueConstraint(
    name = "unique_email",
    columnNames = "email_address"
  )
)
public class Student {

  @Id
  @SequenceGenerator(
    name = "student_sequence",
    sequenceName = "student_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "student_sequence"
  )
  @Column(name = "student_id")
  private Long studentId;

  @NotNull(message = "The first name should not be empty!")
  @Column(name = "first_name", nullable = false)
  private String firstName;

  @NotNull(message = "The last name should not be empty!")
  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "email_address", nullable = false, unique = true)
  private String emailId;

  @Embedded
  private Guardian guardian;

}
