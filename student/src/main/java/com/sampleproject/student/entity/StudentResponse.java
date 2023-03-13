package com.sampleproject.student.entity;

import com.sampleproject.student.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {

    private Long studentId;
    private String firstName;
    private String lastName;
    private String emailId;

    private List<Course> courses;
}
