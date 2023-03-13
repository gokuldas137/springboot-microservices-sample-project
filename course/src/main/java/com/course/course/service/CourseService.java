package com.course.course.service;

import com.course.course.CourseMaterialProxy;
import com.course.course.repository.CourseRepository;
import com.course.course.entity.Course;
import com.course.course.response.CourseMaterial;
import com.course.course.response.CourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMaterialProxy proxy;

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

//    USING REST TEMPLATE
    public CourseResponse getCourseById(Long courseId) {
        Course course = courseRepository.findById(courseId).get();

        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("courseName", course.getCourseName());

        ResponseEntity<CourseMaterial> responseEntity =
                new RestTemplate().getForEntity("http://localhost:8765/courseMaterial/{courseName}", CourseMaterial.class, uriVariables);

        CourseMaterial courseMaterial = responseEntity.getBody();

        CourseResponse courseResponse = new CourseResponse();

        courseResponse.setCourseId(courseId);
        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setCredit(course.getCredit());
        courseResponse.setCourseMaterialId(courseMaterial.getCourseMaterialId());
        courseResponse.setUrl(courseMaterial.getUrl());

        return courseResponse;

    }

    public Course getCourseByName(String courseName) {
        return courseRepository.findByCourseName(courseName);
    }


//    USING FEIGN CLIENT
    public CourseResponse getCourseByIdFeign(Long courseId) {

        Course course = courseRepository.findById(courseId).get();
        CourseMaterial courseMaterial = proxy.getCourseMaterialByName(course.getCourseName());

        CourseResponse courseResponse = new CourseResponse();

        courseResponse.setCourseId(courseId);
        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setCredit(course.getCredit());
        courseResponse.setCourseMaterialId(courseMaterial.getCourseMaterialId());
        courseResponse.setUrl(courseMaterial.getUrl());

        return courseResponse;
    }


    public List<Course> getCourseDetailsByIds(List<Long> courseIds) {
        return courseRepository.findAllById(courseIds);
    }
}
