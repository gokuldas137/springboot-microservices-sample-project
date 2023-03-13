package com.coursematerial.coursematerial.controller;

import com.coursematerial.coursematerial.service.CourseMaterialService;
import com.coursematerial.coursematerial.entity.CourseMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CourseMaterialController {

    @Autowired
    private CourseMaterialService courseMaterialService;

    @PostMapping("/courseMaterial")
    public CourseMaterial saveCourseMaterial(@RequestBody CourseMaterial courseMaterial){
        return courseMaterialService.saveCourseMaterial(courseMaterial);
    }

    @GetMapping("/courseMaterial/{courseName}")
    public CourseMaterial getCourseMaterialByName(@PathVariable String courseName){
        return courseMaterialService.getCourseMaterialByName(courseName);
    }

    @GetMapping("/courseMaterial/id/{courseMaterialId}")
    public Optional<CourseMaterial> getCourseMaterialById(@PathVariable Long courseMaterialId){
        return courseMaterialService.getCourseMaterialById(courseMaterialId);
    }




}
