package com.app.restful.domain.vo;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberLoginRequestDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
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

    // 정적 팩토리 메서드
    public static MemberVO from (MemberJoinRequestDTO memberJoinRequestDTO) {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail(memberJoinRequestDTO.getMemberEmail());
        memberVO.setMemberPassword(memberJoinRequestDTO.getMemberPassword());
        memberVO.setMemberName(memberJoinRequestDTO.getMemberName());
        return memberVO;
    }

    public static MemberVO from (MemberLoginRequestDTO memberLoginRequestDTO) {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail(memberLoginRequestDTO.getMemberEmail());
        memberVO.setMemberPassword(memberLoginRequestDTO.getMemberPassword());
        return memberVO;
    }

    public static MemberVO from (MemberUpdateRequestDTO memberLoginRequestDTO) {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberPassword(memberLoginRequestDTO.getMemberPassword());
        memberVO.setMemberName(memberLoginRequestDTO.getMemberName());
        memberVO.setId(memberLoginRequestDTO.getId());
        return memberVO;
    }
}
