package com.coursematerial.coursematerial.service;

import com.coursematerial.coursematerial.entity.CourseMaterial;
import com.coursematerial.coursematerial.repository.CourseMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseMaterialService {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    public CourseMaterial saveCourseMaterial(CourseMaterial courseMaterial) {
        return courseMaterialRepository.save(courseMaterial);

    }

    public CourseMaterial getCourseMaterialByName(String courseName) {
        return courseMaterialRepository.findByCourseNameIgnoreCase(courseName);
    }

    public Optional<CourseMaterial> getCourseMaterialById(Long courseMaterialId) {
        return courseMaterialRepository.findById(courseMaterialId);
    }
}
