package com.studentcourse.EnrollmentService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.studentcourse.EnrollmentService.dto.StudentResponse;

@FeignClient(name = "student-service", url = "${enrollment-service.feign.student-service.url}")
public interface StudentServiceClient {

    @GetMapping("/api/students/{id}")
    StudentResponse getStudentById(@PathVariable("id") Long id);
}