package com.app.oauth.domain.vo;

//ID NUMBER CONSTRAINT PK_OAUTH_MEMBER PRIMARY KEY,
//MEMBER_EMAIL VARCHAR2(255) UNIQUE NOT NULL,
//MEMBER_PASSWORD VARCHAR2(255),
//MEMBER_PICTURE VARCHAR2(255) DEFAULT '/default.jpg',
//MEMBER_NAME VARCHAR2(255),
//MEMBER_NICKNAME VARCHAR2(255) DEFAULT '개복치 1단계',
//MEMBER_PROVIDER VARCHAR2(255) DEFAULT 'local'

import com.app.oauth.domain.dto.MemberDTO;
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
    //private String memberProvider;

//    {
////        초기화 블럭
//        this.setMemberPicture("default.jpg");
//        this.setMemberNickname("개복치 1단계");
//    }

    public static MemberVO from(MemberDTO memberJoinDTO){
        MemberVO vo = new MemberVO();
        vo.setId(memberJoinDTO.getId());
        vo.setMemberEmail(memberJoinDTO.getMemberEmail());
        vo.setMemberPassword(memberJoinDTO.getMemberPassword());
        vo.setMemberPicture(memberJoinDTO.getMemberPicture() != null ? memberJoinDTO.getMemberPicture() : "default.jpg");
        vo.setMemberName(memberJoinDTO.getMemberName());
        vo.setMemberNickname(memberJoinDTO.getMemberNickname() != null ? memberJoinDTO.getMemberNickname() : "개복치 1단계");
        return vo;
    }
}
