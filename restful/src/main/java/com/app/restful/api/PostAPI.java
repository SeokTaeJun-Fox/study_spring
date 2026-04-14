package com.app.restful.api;

import com.app.restful.domain.dto.PostListRequestDTO;
import com.app.restful.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts") //Rest api에서 /.*을 쓰지 않는게 좋다
@Slf4j
public class PostAPI {

    private final PostService postService;

    @GetMapping("")
    @Operation(summary = "게시글 목록 조회 서비스", description = "게시글 목록을 조회해서 리스트로 반환하는 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 목록 조회 성공")
    public List<PostListRequestDTO> getPostList() {
        return postService.getPostInfoList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "게시글 목록 조회 서비스", description = "게시글 목록을 조회해서 리스트로 반환하는 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 목록 조회 성공")
    @Parameter(
            name = "id",
            description = "게시글 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number") // 스키마 타입
    )
    public PostListRequestDTO getPostInfo(@PathVariable Long id) {
        return postService.getPostInfo(id);
    }
}
