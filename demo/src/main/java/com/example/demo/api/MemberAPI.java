package com.example.demo.api;

import com.example.demo.domain.dto.ApiResponseDTO;
import com.example.demo.domain.dto.MemberJoinDTO;
import com.example.demo.domain.vo.MemberVO;
import com.example.demo.repository.MemberDAO;
import com.example.demo.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
@Slf4j
@RequiredArgsConstructor
public class MemberAPI {

    private final MemberService memberService;

    @PostMapping("join")
    @Operation(summary = "회원가입 서비스", description = "회원가입을 시켜주는 서비스")
    @ApiResponse(responseCode = "200", description = "회원가입 성공")
    @ApiResponse(responseCode = "409", description = "회원 중복 가입")
    public ResponseEntity<ApiResponseDTO> join(@RequestBody MemberJoinDTO memberJoinDTO) {
        memberService.join(memberJoinDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("회원가입 성공"));
    }
}
