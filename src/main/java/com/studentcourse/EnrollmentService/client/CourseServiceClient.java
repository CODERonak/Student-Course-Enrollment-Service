package com.studentcourse.EnrollmentService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.studentcourse.EnrollmentService.dto.CourseResponse;

@FeignClient(name = "course-service", url = "${enrollment-service.feign.course-service.url}")
public interface CourseServiceClient {

    @GetMapping("/api/courses/{id}")
    CourseResponse getCourseById(@PathVariable("id") Long id);
}