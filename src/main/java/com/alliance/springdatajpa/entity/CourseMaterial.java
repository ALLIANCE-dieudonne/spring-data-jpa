package com.alliance.springdatajpa.entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@DataAmount
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseMaterial {

  @Id
  @SequenceGenerator(
    name = "course_material_sequence",
    sequenceName = "course_material_sequence",
    allocationSize = 1
  )

  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "course_material_sequence"
  )
  private Long courseMaterialId;
  private String url;

  @OneToOne(
    cascade = CascadeType.ALL
  )
  @JoinColumn(
    name = "course_Id",
    referencedColumnName = "courseId"

  )
  private Course course;
}
