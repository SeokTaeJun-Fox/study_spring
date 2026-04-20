package com.app.restful.service;

import com.app.restful.domain.dto.PostUpdateRequestDTO;
import com.app.restful.domain.dto.PostWriteRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostServiceTests {

    @Autowired
    private PostService postService;

    @Test
    public void getPostInfoList(){

        log.info("postService : {}", postService.getPostInfoList("oldest"));
    }

    @Test
    public void readPostInfoTest(){
        log.info("postService : {}", postService.readPostInfo(1L));
    }

    @Test
    public void postWriteTest(){
            PostWriteRequestDTO postWriteRequestDTO = new PostWriteRequestDTO();
            postWriteRequestDTO.setMemberId(1L);
            postWriteRequestDTO.setPostTitle("테스트 제목");
            postWriteRequestDTO.setPostContent("테스트 내용");
            postService.writePost(postWriteRequestDTO);
    }

    @Test
    public void updatePostTest(){
        PostUpdateRequestDTO postUpdateRequestDTO = new PostUpdateRequestDTO();
        postUpdateRequestDTO.setPostTitle("수정 제목11");
        postUpdateRequestDTO.setPostContent("수정 내용11");
        postService.updatePost(postUpdateRequestDTO, 1L);
    }

    @Test
    public void deletePostTest(){
        postService.deletePost(62L);
    }


}
