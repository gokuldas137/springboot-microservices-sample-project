package com.sampleproject.student.controller;

import com.course.course.CircuitBreakerController;
import com.sampleproject.student.CourseProxy;
import com.sampleproject.student.entity.Student;
import com.sampleproject.student.entity.StudentResponse;
import com.sampleproject.student.service.StudentService;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseProxy courseProxy;

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @PostMapping("/student/{courseIds}")
    public Student saveStudentDetails(@RequestBody Student student, @PathVariable List<Long> courseIds) {
        return studentService.saveStudentDetails(student, courseIds);
    }

    //    @CircuitBreaker(name = "default",fallbackMethod = "fallbackResponse")
    @Retry(name = "getStudentsApi", fallbackMethod = "fallbackResponse")
    @GetMapping("student/{studentId}")
    public StudentResponse getStudentDetailsWithCoursesById(@PathVariable Long studentId) {
        logger.info("Sample api call received");
        return studentService.getStudentDetailsWithCoursesById(studentId);
    }

    public String fallbackResponse(Exception ex) {
        return "fallback-response";
    }
}
