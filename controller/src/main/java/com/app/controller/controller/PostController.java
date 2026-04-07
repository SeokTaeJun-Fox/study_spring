package com.app.controller.controller;

import com.app.controller.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts/*")
@RequiredArgsConstructor
public class PostController {

    private final PostMapper postMapper;

    @GetMapping("list")
    public void goTolist(Model model) {
        model.addAttribute("posts", postMapper.selectAll());
    }
}
