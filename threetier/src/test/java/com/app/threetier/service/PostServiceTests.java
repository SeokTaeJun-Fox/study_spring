package com.app.threetier.service;

import com.app.threetier.repository.PostDAO;
import com.app.threetier.vo.PostDTO;
import com.app.threetier.vo.PostVO;
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
    public void increaseReadCountTest(){
        postService.increaseReadCount(3L);
    }

    @Test
    void updatePostTest(){
        PostVO postVO = new PostVO();
        postVO.setId(3L);
        postVO.setPostTitle("test");
        postVO.setPostContent("test2");
        postService.updatePost(postVO);

        log.info("post: {}", postService.getPost(1L));
    }
}
