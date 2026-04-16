package com.app.restful.service;

import com.app.restful.domain.dto.PostListRequestDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import com.app.restful.domain.dto.PostWriteRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    public List<PostListRequestDTO> getPostInfoList(String order);
    public PostListRequestDTO readPostInfo(Long id);
    public void increasePostReadCount(Long id);
    public void writePost(PostWriteRequestDTO postWriteRequestDTO);
    public void updatePost(PostUpdateRequestDTO postUpdateRequestDTO, Long id);
    public void deletePost(Long id);
    public void deletePostByMemberId(Long id);
}
