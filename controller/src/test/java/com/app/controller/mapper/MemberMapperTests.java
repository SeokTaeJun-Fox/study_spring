package com.app.controller.mapper;

import com.app.controller.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@Slf4j
@SpringBootTest
public class MemberMapperTests {

    @Autowired
    private MemberMapper memberMapper;

//    쿼리 > config > mapper > mapperClass >
//    오류뜨면 역순
    @Test
    public void memberInsertTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test888@gmail.com");
        memberVO.setMemberPassword("1234");
        memberVO.setMemberName("김영희");
        memberMapper.insert(memberVO);
    }

    @Test
    public void selectByMemberEmailAndMemberPasswordTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test123@gmail.com");
        memberVO.setMemberPassword("test123");
        Optional<MemberVO> member = memberMapper.selectByMemberEmailAndMemberPassword(memberVO);
        log.info("member: {}", member);
    }

    @Test
    public void updateTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("ab@gmail.com");
        memberVO.setMemberPassword("123456");
        memberVO.setMemberName("수정됨");
        memberMapper.update(memberVO);
    }

    @Test
    public void deleteTest() {
        memberMapper.delete(1L);

    }
}
