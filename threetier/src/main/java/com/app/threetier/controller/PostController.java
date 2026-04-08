package com.app.threetier.controller;

import com.app.threetier.mapper.PostMapper;
import com.app.threetier.mapper.PostMapper;
import com.app.threetier.service.PostService;
import com.app.threetier.vo.PostDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/posts/*")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;

    @GetMapping("list")
    public void goTolist(Model model) {
        model.addAttribute("posts", postService.getPosts());
    }

    @GetMapping("/read")
    public void goToRead(Long id, Model model) {
        model.addAttribute("post", postService.getPost(id));
    }

    @GetMapping("/update")
    public void goToUpdate(Long id, Model model) {
        model.addAttribute("post", postService.getPost(id));
    }

    @PostMapping("/update")
    public RedirectView update(PostDTO postDTO) {
        postService.updatePost(postDTO);
        return new RedirectView("/posts/list");
    }

    @GetMapping("/delete")
    public RedirectView delete(Long id) {
        log.info("id: {}", id);
        postService.deletePost(id);
        return new RedirectView("/posts/list");
    }
}
