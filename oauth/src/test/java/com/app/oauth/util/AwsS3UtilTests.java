package com.app.oauth.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AwsS3UtilTests {

    @Autowired
    AwsS3Util awsS3Util;

    //@Test
    //public void getPathTest(){
        //log.info("{}",awsS3Util.getPath());

        @Test
        public void displayTest(){
            log.info("{}",awsS3Util.display("2026/04/30/44af2c9a-0b0b-45be-9686-50e2a48c9f98_KakaoTalk_20260430_114415925.jpg"));
        }
    }

