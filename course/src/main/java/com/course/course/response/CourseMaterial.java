package com.course.course.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseMaterial {

    private Long courseMaterialId;
    private String courseName;
    private Long credit;
    private String url;




}
