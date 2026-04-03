package com.app.mybatis.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class PostResponseDTO {
    private Long postPageCount;
    private Long totalPostCount;
    private List<PostDTO> posts;
}
