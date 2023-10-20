package com.alliance.springdatajpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
  private Long studentId;


  @NotNull(message = "The name should not be empty!")
  @Min(10)
  @Max(25)
  private String fName;

  @NotNull(message = "The name should not be empty!")
  @Min(10)
  @Max(25)
  private String lName;

  @Column(name = "email_address", nullable = false)
  private String emailId;
  private String guardianName;

  @Email(message = "Enter a valid email")
  private String guardianEmail;

  private String guardianMobile;


}
