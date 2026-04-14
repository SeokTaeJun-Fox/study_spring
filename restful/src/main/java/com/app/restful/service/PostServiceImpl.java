package com.app.restful.service;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.dto.PostListRequestDTO;
import com.app.restful.exception.PostException;
import com.app.restful.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;

    @Override
    public List<PostListRequestDTO> getPostInfoList() {
        return postDAO.findAll()
                .stream()
                .map(PostListRequestDTO::from)
                .toList();
    }

    @Override
    public PostListRequestDTO getPostInfo(Long id) {

        return postDAO
                .findById(id)
                .map(PostListRequestDTO::from)
                .orElseThrow(() -> new PostException("게시글이 존재하지 않습니다."));
    }
}
