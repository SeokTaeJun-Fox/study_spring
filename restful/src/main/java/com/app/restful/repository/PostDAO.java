package com.app.restful.repository;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.mapper.PostMapper;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PostDAO {
    private final PostMapper postMapper;

    public List<PostDTO> findAll(Map<String, String> params) {
        return postMapper.selectAll(params);
    }

    public Optional<PostDTO> findById(Long id) {
        return Optional.ofNullable(postMapper.selectById(id));
    }

    public void increasePostReadCount(Long id) {
        postMapper.updatePostReadCount(id);
    }

    public void save(PostDTO postDTO) {
        postMapper.insert(postDTO);
    }

    public void update(PostDTO postDTO) {
        //log.info("postDTO : {}", postDTO);
        postMapper.update(postDTO);
    }

    public void delete(Long id) {
        postMapper.delete(id);
    }

    public void deletePostByMemberId(Long id) {
        postMapper.deleteByMemberId(id);
    }
}
