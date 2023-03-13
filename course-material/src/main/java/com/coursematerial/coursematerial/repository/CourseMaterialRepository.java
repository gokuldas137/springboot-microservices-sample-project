package com.coursematerial.coursematerial.repository;


import com.coursematerial.coursematerial.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {

    CourseMaterial findByCourseNameIgnoreCase(String courseName);
}