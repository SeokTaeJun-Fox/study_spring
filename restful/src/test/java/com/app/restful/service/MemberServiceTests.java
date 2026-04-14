package com.app.restful.service;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberServiceTests {

    @Autowired
    private MemberService memberService;

    @Test
    public void getMember(){
        log.info("memberService : {}", memberService.getMemberInfo(1L));
    }

    @Test
    public void getMemberAllTest() {
        log.info("memberService : {}", memberService.getMemberInfoList());
    }

    @Test
    public void insertMemberTest() {
        MemberJoinRequestDTO memberJoinRequestDTO = new MemberJoinRequestDTO();
        memberJoinRequestDTO.setMemberEmail("test149@gmail.com");
        memberJoinRequestDTO.setMemberName("장기동");
        memberJoinRequestDTO.setMemberPassword("1234");
        memberService.join(memberJoinRequestDTO);
    }

    @Test
    public void updateMemberTest() {
        MemberUpdateRequestDTO memberUpdateRequestDTO = new MemberUpdateRequestDTO();
        memberUpdateRequestDTO.setMemberName("홍갈동");
        memberUpdateRequestDTO.setMemberPassword("12345678");
        memberUpdateRequestDTO.setId(1L);
        memberService.updateMember(memberUpdateRequestDTO);
    }

    @Test
    public void deleteMemberTest() {
        memberService.withdraw(44L);
    }

}
