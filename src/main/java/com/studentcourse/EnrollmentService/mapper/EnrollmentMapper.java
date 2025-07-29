package com.studentcourse.EnrollmentService.mapper;

import com.studentcourse.EnrollmentService.dto.EnrollmentResponse;
import com.studentcourse.EnrollmentService.model.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    @Mapping(target = "student", ignore = true)
    @Mapping(target = "course", ignore = true)  
    EnrollmentResponse toDto(Enrollment enrollment);
}