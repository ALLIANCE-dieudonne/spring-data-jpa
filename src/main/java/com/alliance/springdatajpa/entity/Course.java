package com.alliance.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

  @Id
  @SequenceGenerator(
    name = "course_sequence",
    sequenceName = "course_sequence",
    allocationSize = 1
  )

  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "course_sequence"
  )
  private Long courseId;
  private String title;
  private int credit;

  @ManyToOne(
    cascade = CascadeType.ALL
  )
  @JoinColumn(
    name = "teacher_id",
    referencedColumnName = "teacherId"
  )
  private Teacher teacher;

}
