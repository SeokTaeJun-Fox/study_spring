package com.app.oauth;

import com.app.oauth.domain.vo.MemberVO;
import com.app.oauth.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class OauthMemberTests {

    @Autowired
    private MemberMapper oauthMapper;

    @Test
    public void testInsert(){
        MemberVO oauthMember = new MemberVO();
        oauthMember.setMemberEmail("test12533@gmail.com");
        oauthMember.setMemberPassword("123456");
        oauthMember.setMemberName("수최");
        oauthMember.setMemberPicture("수최.jpg");
        oauthMember.setMemberNickname("DaNon");
        oauthMember.setMemberProvider("locall");
        oauthMapper.insert(oauthMember);
    }

    @Test
    public void testSelect(){
        log.info("{}", oauthMapper.select(1L));
    }
}
