package com.sampleproject.student.service;

import com.sampleproject.student.CourseProxy;
import com.sampleproject.student.entity.Course;
import com.sampleproject.student.entity.Student;
import com.sampleproject.student.entity.StudentResponse;
import com.sampleproject.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseProxy courseProxy;


    public Student saveStudentDetails(Student student, List<Long> courseIds) {
        student.setCourseId(courseIds);
        return studentRepository.save(student);
    }

    public StudentResponse getStudentDetailsWithCoursesById(Long studentId) {
        Student student=studentRepository.findById(studentId).get();

        List<Course> course= courseProxy.getCourseDetailsByIds(student.getCourseId());
        StudentResponse studentResponse=new StudentResponse();

        studentResponse.setStudentId(studentId);
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setLastName(student.getLastName());
        studentResponse.setEmailId(student.getEmailId());
        studentResponse.setCourses(course);
        return studentResponse;
    }
}
