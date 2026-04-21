package com.example.demo;

import com.example.demo.domain.dto.MemberJoinDTO;
import com.example.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberServiceTests {

    @Autowired
    MemberService memberService;

    @Test
    public void memberJoinTest() {
        MemberJoinDTO memberJoinDTO = new MemberJoinDTO();
        memberJoinDTO.setMemberEmail("테스트1");
        memberJoinDTO.setMemberPassword("111111");
        memberJoinDTO.setMemberName("URA");
        memberService.join(memberJoinDTO);
    }
}
