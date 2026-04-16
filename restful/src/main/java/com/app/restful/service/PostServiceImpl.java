package com.app.restful.service;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.dto.PostListRequestDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import com.app.restful.domain.dto.PostWriteRequestDTO;
import com.app.restful.exception.PostException;
import com.app.restful.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;

    @Override
    public List<PostListRequestDTO> getPostInfoList(String order) {
        Map<String, String> orders = new HashMap<>();
        orders.put("order", order);

        log.info("order : {}", postDAO.findAll(orders));
        return postDAO.findAll(orders)
                .stream()
                .map(PostListRequestDTO::from)
                .toList();
    }

    @Override
    public PostListRequestDTO readPostInfo(Long id) {

        increasePostReadCount(id);

        return postDAO
                .findById(id)
                .map(PostListRequestDTO::from)
                .orElseThrow(() -> new PostException("게시글이 존재하지 않습니다.", HttpStatus.NOT_FOUND));
    }

    @Override
    public void increasePostReadCount(Long id) {
        postDAO.increasePostReadCount(id);
    }

    //writePost(PostWriteRequestDTO postWriteRequestDTO, Long id)
    @Override
    public void writePost(PostWriteRequestDTO postWriteRequestDTO) {
        postDAO.save(PostDTO.from(postWriteRequestDTO));
    }

    @Override
    public void updatePost(PostUpdateRequestDTO postUpdateRequestDTO, Long id) {
        PostDTO postDTO = PostDTO.from(postUpdateRequestDTO);
        postDTO.setId(id);
        postDAO.update(postDTO);
    }

    @Override
    public void deletePost(Long id) {
        postDAO.delete(id);
    }

    @Override
    public void deletePostByMemberId(Long id) {
        postDAO.deletePostByMemberId(id);
    }
}
