package com.app.threetier.vo;

//ID, STUDENT_NAME, KOR, ENG, MATH,
//KOR + ENG + MATH AS TOTAL,
//ROUND((KOR+ENG+MATH)/3, 2) AS AVERAGE

import lombok.Data;
import org.springframework.stereotype.Controller;

@Controller
@Data
public class StudentVO {
    private Long id;
    private String studentName;
    private Integer kor;
    private Integer eng;
    private Integer math;
    private Integer total;
    private Double average;
}
