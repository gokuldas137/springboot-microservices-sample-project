package com.course.course;

import com.course.course.response.CourseMaterial;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "course-material", url = "localhost:8091")
@FeignClient(name = "course-material")
public interface CourseMaterialProxy {
    @GetMapping("/courseMaterial/{courseName}")
    public CourseMaterial getCourseMaterialByName(@PathVariable String courseName);

}
