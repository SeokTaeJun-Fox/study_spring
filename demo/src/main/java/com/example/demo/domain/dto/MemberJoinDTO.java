package com.example.demo.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberJoinDTO {
    private String memberEmail;
    private String memberName;
    private String memberPassword;
}
