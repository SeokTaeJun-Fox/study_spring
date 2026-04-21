package com.example.demo.domain.vo;

import com.example.demo.domain.dto.MemberJoinDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MemberVO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    public static MemberVO from(MemberJoinDTO memberJoinDTO) {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail(memberJoinDTO.getMemberEmail());
        memberVO.setMemberName(memberJoinDTO.getMemberName());
        memberVO.setMemberPassword(memberJoinDTO.getMemberPassword());
        return memberVO;
    }
}
