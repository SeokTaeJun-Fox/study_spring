package com.app.restful.mapper;


import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper
public interface PostMapper {
    public List<PostDTO> selectAll(Map<String, String> order);
    public PostDTO selectById(Long id);
    public void updatePostReadCount(Long id);
    public void insert(PostDTO postDTO);
    public void update(PostDTO postDTO);
    public void delete(Long id);
    public void deleteByMemberId(Long id);
}