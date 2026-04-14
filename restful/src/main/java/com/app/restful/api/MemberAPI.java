package com.app.restful.api;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberResponseDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import com.app.restful.domain.vo.MemberVO;
import com.app.restful.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 서비스 호출
// 리턴값을 JSON으로 처리
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members") //Rest api에서 /.*을 쓰지 않는게 좋다
@Slf4j
public class MemberAPI {

    private final MemberService memberService;

    // 회원 목록 조회 서비스
    @Operation(summary = "회원 목록 조회 서비스", description = "회원 목록을 조회해서 리스트로 반환하는 서비스")
    @ApiResponse(responseCode = "200", description = "회원 목록 조회 성공")
    @GetMapping("")
    public List<MemberResponseDTO> getMemberList() {
        return memberService.getMemberInfoList();
    }

    //회원 정보 조회 서비스
    @GetMapping("/{id}")
    @Operation(summary = "회원 단일 조회 서비스", description = "회원 조회해서 객체로 반환하는 서비스")
    @ApiResponse(responseCode = "200", description = "회원 목록 조회 성공")
    @Parameter(
            name = "id",
            description = "회원 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number") // 스키마 타입
    )
    public MemberResponseDTO getMemberInfo(@PathVariable Long id) {
        return memberService.getMemberInfo(id);
    }

    // 회원 추가 서비스
    @PostMapping("join")
    @Operation(summary = "회원가입 서비스", description = "회원 정보를 받아서 회원가입을 시켜주는 서비스")
    @ApiResponse(responseCode = "201", description = "회원가입 성공")
    //fetch에서 body로 데이터를 심었다. requestBody에는 데이터가 있다?
    public void join(@RequestBody MemberJoinRequestDTO memberRequestDTO) {
        memberService.join(memberRequestDTO);
    }

//    @PostMapping("update")
//    @Operation(summary = "회원수정 서비스", description = "회원 정보를 받아서 회원 수정하는 서비스")
//    @ApiResponse(responseCode = "202", description = "회원수정 성공")
//    public void update(@RequestBody MemberUpdateRequestDTO memberUpdateRequestDTO) {
//        memberService.updateMember(memberUpdateRequestDTO);
//    }

//    @PostMapping("delete")
//    @Operation(summary = "회원삭제 서비스", description = "회원 id를 받아서 회원삭제 시켜주는 서비스")
//    @ApiResponse(responseCode = "203", description = "회원삭제 성공")
//    public void delete(@RequestParam Long id) {
//        memberService.withdraw(id);
//    }

    @PostMapping("login")
    @Operation(summary = "로그인 서비스", description = "이메일과 비밀번호를 검증 후 로그인 서비스")
    @ApiResponse(responseCode = "202", description = "로그인 성공")
    public void login(@RequestBody MemberVO memberVO) { //MemberLoginRequestDTO
        MemberResponseDTO find = memberService.login(memberVO);
    }

    @Operation(summary = "회원 수정 서비스", description = "회원 정보를 받아서 회원 수정하는 서비스")
    @ApiResponse(responseCode = "203", description = "회원 수정 성공")
    @Parameter(
            name = "id",
            description = "회원 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number") // 스키마 타입
    )
    @PutMapping("/{id}")
    //업데이트는 PutMapping을 쓴다.
    public void updateMember(@RequestBody MemberUpdateRequestDTO memberUpdateRequestDTO,
                             @PathVariable Long id) {
        memberUpdateRequestDTO.setId(id);
        memberService.updateMember(memberUpdateRequestDTO);
    }

    // 삭제 컨트롤러
    @DeleteMapping("/{id}")
    @Operation(summary = "회원 탈퇴 서비스", description = "회원 아이디로 회원 탈퇴해주는 서비스")
    @ApiResponse(responseCode = "204", description = "회원 삭제 성공")
    @Parameter(
            name = "id",
            description = "회원 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number") // 스키마 타입
    )
    public void withdraw(@PathVariable Long id) {
        memberService.withdraw(id);
    }

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
}
