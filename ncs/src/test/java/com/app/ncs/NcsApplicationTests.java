package com.app.ncs;

import com.app.ncs.domain.vo.MemberVO;
import com.app.ncs.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class NcsApplicationTests {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    void contextLoads() {

    }

    @Test
    void insertTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberName("ss");
        memberVO.setMemberPassword("1234");
        memberVO.setMemberEmail("sssss");
        memberMapper.insert(memberVO);
    }

    @Test
    void selectTest() {
        //MemberVO vo = memberMapper.selectByMemberEmailAndMemberPassword(1L).get();
        //log.info("vo : {}", vo);
    }

    @Test
    void updateTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberPassword("11122");
        memberVO.setMemberEmail("emaill");
        memberVO.setMemberName("스스");
        memberVO.setId(2L);
        memberMapper.update(memberVO);
    }

}
