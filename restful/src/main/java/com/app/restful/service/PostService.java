package com.app.restful.service;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.dto.PostListRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    public List<PostListRequestDTO> getPostInfoList();
    public PostListRequestDTO getPostInfo(Long id);
}
