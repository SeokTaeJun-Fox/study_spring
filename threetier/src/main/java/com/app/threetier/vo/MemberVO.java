package com.app.threetier.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
// vo는 데이터를 주고받는 vo다. 다른 서버와 소통이 이루어지는 vo다.
public class MemberVO implements Serializable {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
}
