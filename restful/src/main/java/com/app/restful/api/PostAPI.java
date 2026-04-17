package com.app.restful.api;

import com.app.restful.domain.dto.*;
import com.app.restful.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts") //Rest api에서 /.*을 쓰지 않는게 좋다
@Slf4j
public class PostAPI {

    //    게시판 관련 서비스
//- 게시글 목록 조회 서비스
//- 게시글 상세보기 조회 서비스
//- 게시글 작성 서비스
//- 게시글 수정 서비스
//- 게시글 삭제 서비스
//- 게시글 삭제(탈퇴시) 서비스
//
//* Swagger 문서 정의
//* RestController로 정의(RESTful)
//* Swagger 테스트 완료!
//            * 적절한 Exception throw(Service단)
//            * 적절한 Optional(Repository단)
//* 적절한 DTO를 설계

//1. Query(원하는 데이터 조회)
//2. VO 또는 DTO를 설계
//3. Config 설정
//4. mapper.xml 정의
//5. Mapper 인터페이스(xml의 id와 메서드의 이름이 동일)
//6. DAO(단일객체는 Optional, 이름 준수)
//7. Service 인터페이스(확장성)
//8. Service Implements(트랜잭션, 예외처리, 서비스이름이 들어나도록)
//9. Test(단위 테스트)
//10. API(Rest)

    private final PostService postService;

    @GetMapping("")
    @Operation(summary = "게시글 목록 조회 서비스", description = "게시글 목록을 조회해서 리스트로 반환하는 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 목록 조회 성공")
    @ApiResponse(responseCode = "404", description = "게시글 조회 실패")
    @Parameter(
            name = "order",
            description = "게시글 정렬",
            required = true,
            in = ParameterIn.QUERY,
            schema = @Schema(type = "string") // 스키마 타입
    )
    //무조건 이 타입으로 리턴한다.
    public ResponseEntity<ApiResponseDTO> getPostList(
            @RequestParam(value = "order", defaultValue = "desc") String order
    ) {
        List<PostListRequestDTO> postList = postService.getPostInfoList(order);
//        .status: 상태코드 -> mdn 상태코드 (https://developer.mozilla.org/ko/docs/Web/HTTP/Reference/Status)
//        .body: 응답 데이터 -> ApiResponseDTO
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("게시글 목록 조회 성공", postList));
    }

    @GetMapping("/{id}")
    @Operation(summary = "게시글 목록 조회 서비스", description = "게시글 목록을 조회해서 리스트로 반환하는 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 목록 조회 성공")
    @ApiResponse(responseCode = "404", description = "게시글 조회 실패")
    @Parameter(
            name = "id",
            description = "게시글 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number") // 스키마 타입
    )
    public ResponseEntity<ApiResponseDTO> getPostInfo(@PathVariable Long id) {
        PostListRequestDTO postListRequestDTO = postService.readPostInfo(id);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("게시글 조회 성공", postListRequestDTO));
    }

    //게시글 작성
    @PostMapping("")
    @Operation(summary = "게시글 작성 서비스", description = "게시글을 작성하는 서비스")
    @ApiResponse(responseCode = "201", description = "게시글 작성 완료")
    @ApiResponse(responseCode = "400", description = "잘못된 요청")
    public ResponseEntity<ApiResponseDTO> writePost(@RequestBody PostWriteRequestDTO postWriteRequestDTO) {
        //memberId 추출 (임의로 넣은 것!)
        postService.writePost(postWriteRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseDTO.of("게시글 작성 성공"));
    }

    //게시글 수정
    @PutMapping("/{id}")
    @Operation(summary = "게시판 수정", description = "해당 번호의 게시글 내용을 변경해주는 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 수정 완료")
    @ApiResponse(responseCode = "404", description = "게시글 없음")
    public ResponseEntity<ApiResponseDTO> modifyPost(@RequestBody PostUpdateRequestDTO postUpdateRequestDTO,
                                                     @PathVariable Long id) {
        postService.updatePost(postUpdateRequestDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("게시글 수정 성공"));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "게시글 삭제 서비스", description = "아이디로 게시글을 삭제하는 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 삭제 완료")
    @ApiResponse(responseCode = "404", description = "게시글 없음")
    @Parameter(
            name = "id",
            description = "게시글 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number") // 스키마 타입
    )
    public ResponseEntity<ApiResponseDTO> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("게시글 삭제 성공"));
    }
}
