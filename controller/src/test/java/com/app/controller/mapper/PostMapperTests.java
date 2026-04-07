package com.app.controller.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class PostMapperTests {

    @Autowired
    private PostMapper postMapper;

    @Test
    public void selectAllTest() {
        log.info("selectAll: {}", postMapper.selectAll());
    }
}
