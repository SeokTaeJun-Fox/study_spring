package com.app.oauth.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SmsUtilTests {

    @Autowired
    private SmsUtil smsUtil;

    @Test
    public void smsTest(){
        //smsUtil.sendOneMemberPhone("01050441018", "메세지 확인");
        smsUtil.sendMemberEmail("moderneuropean81@gmail.com", "테스트 제목", "테스트 내용");
    }
}
