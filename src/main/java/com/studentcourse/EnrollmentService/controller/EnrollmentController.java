package com.studentcourse.EnrollmentService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.studentcourse.EnrollmentService.dto.EnrollmentRequest;
import com.studentcourse.EnrollmentService.dto.EnrollmentResponse;
import com.studentcourse.EnrollmentService.service.EnrollmentService;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@AllArgsConstructor
public class EnrollmentController {
    private EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentResponse> enrollStudent(@RequestBody EnrollmentRequest enrollmentRequest) {
        EnrollmentResponse enrollment = enrollmentService.enrollStudentInCourse(enrollmentRequest);
        return new ResponseEntity<>(enrollment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentResponse> getEnrollmentById(@PathVariable Long id) {
        EnrollmentResponse enrollment = enrollmentService.getEnrollmentById(id);
        return ResponseEntity.ok(enrollment);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<EnrollmentResponse>> getEnrollmentsByStudentId(@PathVariable Long studentId) {
        List<EnrollmentResponse> enrollments = enrollmentService.getEnrollmentsByStudentId(studentId);
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<EnrollmentResponse>> getEnrollmentsByCourseId(@PathVariable Long courseId) {
        List<EnrollmentResponse> enrollments = enrollmentService.getEnrollmentsByCourseId(courseId);
        return ResponseEntity.ok(enrollments);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.noContent().build();
    }
}