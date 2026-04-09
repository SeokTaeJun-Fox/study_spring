package com.app.threetier.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/company/*")
public class CompanyController {

    private final HttpSession session;

    @GetMapping("/get-to-work")
    public void getToWork(String name) {
        log.info("get to work name : {}", name);
    }

    @GetMapping("/work")
    public void work(String name) {
        session.setAttribute("name", name);
    }

    @GetMapping("/late")
    public void late(String name) {
        session.setAttribute("name", name);
    }

    @GetMapping("/leaveWork")
    public void leaveWork() {
        session.invalidate();
    }
}
