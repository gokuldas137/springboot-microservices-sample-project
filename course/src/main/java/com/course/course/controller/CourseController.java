package com.course.course.controller;


import com.course.course.entity.Course;
import com.course.course.response.CourseResponse;
import com.course.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/course")
    public Course saveCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @GetMapping("/course/{courseId}")
    public CourseResponse getCourseById(@PathVariable Long courseId) {
        return courseService.getCourseById(courseId);
    }


    @GetMapping("/course-feign/{courseId}")
    public CourseResponse getCourseByIdFeign(@PathVariable Long courseId) {
        return courseService.getCourseByIdFeign(courseId);
    }

    //Get multiple courses with the id
    @GetMapping("course/course-details/{courseIds}")
    public List<Course> getCourseDetailsByIds(@PathVariable List<Long> courseIds) {
        return courseService.getCourseDetailsByIds(courseIds);
    }

    @GetMapping("/hi")
    public String getHi() {
        return "hi";
    }

}
