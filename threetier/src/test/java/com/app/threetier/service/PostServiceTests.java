package com.app.threetier.service;

import com.app.threetier.repository.PostDAO;
import com.app.threetier.vo.PostDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostServiceTests {

    @Autowired
    private PostService postService;
    @Autowired
    private PostDAO postDAO;
    @Autowired
    private PostDTO postDTO;

    @Test
    void getPostTest(){
        log.info("post: {}", postService.getPost(1000L));
    }

    @Test
    void updatePostTest(){
        PostDTO postDTO = new PostDTO();
        postDTO.setId(20L);
        postDTO.setPostContent("새로운");
        postDTO.setPostTitle("새로운 제목");
        postService.updatePost(postDTO);
    }
}
