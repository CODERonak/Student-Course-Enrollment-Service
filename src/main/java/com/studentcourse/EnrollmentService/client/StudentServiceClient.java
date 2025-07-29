package com.studentcourse.EnrollmentService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.studentcourse.EnrollmentService.dto.StudentResponse;

// Change this line: Add the full external URL
@FeignClient(name = "student-service", url = "https://8080-firebase-student-service-1753414465664.cluster-cd3bsnf6r5bemwki2bxljme5as.cloudworkstations.dev")
public interface StudentServiceClient {

    @GetMapping("/api/students/{id}")
    StudentResponse getStudentById(@PathVariable("id") Long id);
}