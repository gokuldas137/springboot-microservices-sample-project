package com.sampleproject.student;

import com.sampleproject.student.entity.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


//@FeignClient(name = "course",url = "localhost:8080")
@FeignClient(name = "course")
public interface CourseProxy {
    @GetMapping("course/course-details/{courseIds}")
    public List<Course> getCourseDetailsByIds(@PathVariable List<Long> courseIds);
    }
