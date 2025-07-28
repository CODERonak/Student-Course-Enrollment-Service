package com.studentcourse.EnrollmentService.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class StudentResponse {
    private Long id;
    private String fullname;
    private Integer age;
    private LocalDate dateOfBirth;
    private String email;
}