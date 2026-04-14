package com.app.restful.repository;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

    public List<PostDTO> findAll() {
        return postMapper.selectAll();
    }

    public Optional<PostDTO> findById(Long id) {
        return Optional.ofNullable(postMapper.selectById(id));
    }
}
