package com.app.oauth.domain.vo;

import com.app.oauth.domain.dto.MemberDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class SocialMemberVO {
    Long id;
    private String socialMemberProviderId;
    private String socialMemberProvider;
    private Long memberId;

    public static SocialMemberVO from(MemberDTO memberJoinDTO) {
        SocialMemberVO socialMemberVO = new SocialMemberVO();
        socialMemberVO.setId(memberJoinDTO.getId());
        socialMemberVO.setSocialMemberProvider(memberJoinDTO.getSocialMemberProvider() != null ? memberJoinDTO.getSocialMemberProvider() : "local");
        socialMemberVO.setSocialMemberProviderId(memberJoinDTO.getSocialMemberProviderId());
        socialMemberVO.setMemberId(memberJoinDTO.getMemberId());
        return socialMemberVO;
    }
}
