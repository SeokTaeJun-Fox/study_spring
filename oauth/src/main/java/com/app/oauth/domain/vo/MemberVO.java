package com.app.oauth.domain.vo;

//ID NUMBER CONSTRAINT PK_OAUTH_MEMBER PRIMARY KEY,
//MEMBER_EMAIL VARCHAR2(255) UNIQUE NOT NULL,
//MEMBER_PASSWORD VARCHAR2(255),
//MEMBER_PICTURE VARCHAR2(255) DEFAULT '/default.jpg',
//MEMBER_NAME VARCHAR2(255),
//MEMBER_NICKNAME VARCHAR2(255) DEFAULT '개복치 1단계',
//MEMBER_PROVIDER VARCHAR2(255) DEFAULT 'local'

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberVO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberPicture;
    private String memberName;
    private String memberNickname;
    private String memberProvider;
}
