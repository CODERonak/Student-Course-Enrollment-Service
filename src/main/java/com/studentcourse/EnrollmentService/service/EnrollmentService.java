package com.studentcourse.EnrollmentService.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.studentcourse.EnrollmentService.client.*;
import com.studentcourse.EnrollmentService.dto.*;
import com.studentcourse.EnrollmentService.mapper.EnrollmentMapper;
import com.studentcourse.EnrollmentService.model.Enrollment;
import com.studentcourse.EnrollmentService.repository.EnrollmentRepository;

import feign.FeignException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnrollmentService {
   private final EnrollmentRepository enrollmentRepository;
   private final StudentServiceClient studentServiceClient;
   private final CourseServiceClient courseServiceClient;
   private final EnrollmentMapper enrollmentMapper;

   public EnrollmentResponse enrollStudentInCourse(EnrollmentRequest enrollmentRequest) {
      StudentResponse student = null;
      try {
         student = studentServiceClient.getStudentById(enrollmentRequest.getStudentId());
      } catch (FeignException.NotFound e) {
         throw new RuntimeException("Student not found with ID: " + enrollmentRequest.getStudentId());
      }

      CourseResponse course = null;
      try {
         course = courseServiceClient.getCourseById(enrollmentRequest.getCourseId());
      } catch (FeignException.NotFound e) {
         throw new RuntimeException("Course not found with ID: " + enrollmentRequest.getCourseId());
      }

      if (enrollmentRepository.existsByStudentIdAndCourseId(enrollmentRequest.getStudentId(),
            enrollmentRequest.getCourseId())) {
         throw new RuntimeException("Student is already enrolled in this course.");
      }

      Enrollment enrollment = new Enrollment();
      enrollment.setStudentId(enrollmentRequest.getStudentId());
      enrollment.setCourseId(enrollmentRequest.getCourseId());
      enrollment.setEnrollmentDate(LocalDateTime.now());

      Enrollment savedEnrollment = enrollmentRepository.save(enrollment);

      // Use the mapper for initial conversion, then populate nested DTOs
      EnrollmentResponse response = enrollmentMapper.toDto(savedEnrollment);
      response.setStudent(student);
      response.setCourse(course);

      return response;
   }

   public EnrollmentResponse getEnrollmentById(Long id) {
      Enrollment enrollment = enrollmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));

      StudentResponse student = null;
      try {
         student = studentServiceClient.getStudentById(enrollment.getStudentId());
      } catch (FeignException.NotFound e) {
         System.err.println("Student not found for enrollment " + id + ", studentId: " + enrollment.getStudentId());
      }

      CourseResponse course = null;
      try {
         course = courseServiceClient.getCourseById(enrollment.getCourseId());
      } catch (FeignException.NotFound e) {
         System.err.println("Course not found for enrollment " + id + ", courseId: " + enrollment.getCourseId());
      }

      // Use the mapper for initial conversion, then populate nested DTOs
      EnrollmentResponse response = enrollmentMapper.toDto(enrollment);
      response.setStudent(student);
      response.setCourse(course);

      return response;
   }

   public List<EnrollmentResponse> getEnrollmentsByStudentId(Long studentId) {
      try {
         studentServiceClient.getStudentById(studentId);
      } catch (FeignException.NotFound e) {
         throw new RuntimeException("Student not found with ID: " + studentId);
      }

      return enrollmentRepository.findByStudentId(studentId).stream()
            .map(enrollment -> {
               StudentResponse student = null;
               try {
                  student = studentServiceClient.getStudentById(enrollment.getStudentId());
               } catch (FeignException.NotFound e) {
                  /* handle */ }

               CourseResponse course = null;
               try {
                  course = courseServiceClient.getCourseById(enrollment.getCourseId());
               } catch (FeignException.NotFound e) {
                  /* handle */ }

               // Use the mapper for initial conversion, then populate nested DTOs
               EnrollmentResponse response = enrollmentMapper.toDto(enrollment);
               response.setStudent(student);
               response.setCourse(course);
               return response;
            })
            .collect(Collectors.toList());
   }

   public List<EnrollmentResponse> getEnrollmentsByCourseId(Long courseId) {
      try {
         courseServiceClient.getCourseById(courseId);
      } catch (FeignException.NotFound e) {
         throw new RuntimeException("Course not found with ID: " + courseId);
      }

      return enrollmentRepository.findByCourseId(courseId).stream()
            .map(enrollment -> {
               StudentResponse student = null;
               try {
                  student = studentServiceClient.getStudentById(enrollment.getStudentId());
               } catch (FeignException.NotFound e) {
                  /* handle */ }

               CourseResponse course = null;
               try {
                  course = courseServiceClient.getCourseById(enrollment.getCourseId());
               } catch (FeignException.NotFound e) {
                  /* handle */ }

               // Use the mapper for initial conversion, then populate nested DTOs
               EnrollmentResponse response = enrollmentMapper.toDto(enrollment);
               response.setStudent(student);
               response.setCourse(course);
               return response;
            })
            .collect(Collectors.toList());
   }

   public void deleteEnrollment(Long id) {
      if (!enrollmentRepository.existsById(id)) {
         throw new RuntimeException("Enrollment not found with id: " + id);
      }
      enrollmentRepository.deleteById(id);
   }
}