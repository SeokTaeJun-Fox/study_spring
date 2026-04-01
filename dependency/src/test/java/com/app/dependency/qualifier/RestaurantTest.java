package com.app.dependency.qualifier;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RestaurantTest {

    @Autowired @Qualifier("outback")
    private Restaurant outback;

    @Autowired @Qualifier("vips")
    private Restaurant vips;

    @Test
    public void outbackTest() {
        log.info("outback : {}", outback);
        log.info("outback : {}", outback.isAvailableSaladBar());
    }

    @Test
    public void vipsTest() {
        log.info("vips : {}", vips);
        log.info("vips : {}", vips.isAvailableSaladBar());
    }
}
