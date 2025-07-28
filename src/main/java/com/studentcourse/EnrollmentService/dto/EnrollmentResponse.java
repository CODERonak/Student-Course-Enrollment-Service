package com.studentcourse.EnrollmentService.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EnrollmentResponse {
    private Long id;
    private Long studentId;
    private Long courseId;
    private LocalDateTime enrollmentDate;

    private StudentResponse student;
    private CourseResponse course;
}