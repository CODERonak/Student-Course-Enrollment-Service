package com.studentcourse.EnrollmentService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.studentcourse.EnrollmentService.dto.CourseResponse;

// Change this line: Add the full external URL
@FeignClient(name = "course-service", url = "https://8081-firebase-course-service-1753420895325.cluster-wurh6gchdjcjmwrw2tqtufvhss.cloudworkstations.dev")
public interface CourseServiceClient {

    @GetMapping("/api/courses/{id}")
    CourseResponse getCourseById(@PathVariable("id") Long id);
}