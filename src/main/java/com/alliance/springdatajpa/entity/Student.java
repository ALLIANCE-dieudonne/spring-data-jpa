package com.alliance.springdatajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
  @Id
  private Long studentId;
  private String fName;
  private String lName;
  private String emailId;
  private String guardianName;
  private String guardianEmail;
  private String guardianMobile;


}
