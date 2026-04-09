package com.app.threetier.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TaskVO {
    private Long id;
    private int kor;
    private int eng;
    private int math;
}
