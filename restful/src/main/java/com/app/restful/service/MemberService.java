package com.app.restful.service;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberResponseDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import com.app.restful.domain.vo.MemberVO;//회원 추가

import java.util.List;
//public void save(MemberVO memberVO) {
//    memberMapper.insert(memberVO);
//}
//
////회원 단일 조회(ID)
//public MemberVO findById(Long id) {
//    return memberMapper.selectById(id);
//}
//
////회원 단일 조회(Email, Password)
//public MemberVO findByEmailAndPassword(MemberVO memberVO) {
//    return memberMapper.selectByMemberEmailAndMemberPassword(memberVO);
//}
//
////회원 수정
//public void update(MemberVO memberVO) {
//    memberMapper.update(memberVO);
//}
//
////회원 삭제
//public void delete(Long id) {
//    memberMapper.delete(id);
//}

public interface MemberService {
    //회원 가입
    public void join(MemberJoinRequestDTO memberJoinRequestDTO);

    //이메일 중복 확인
    public void checkMemberEmailDuplicate(String memberEmail);

    //로그인
    public MemberResponseDTO login(MemberVO memberVO);

    //회원 정보 조회
    public MemberResponseDTO getMemberInfo(Long id);

    //모든 회원 정보 조회
    public List<MemberResponseDTO> getMemberInfoList();

    //회원 정보 변경
    public void updateMember(MemberUpdateRequestDTO MemberUpdateRequestDTO);
    //회원 비밀번호 변경(마이페이지)
    //회원 비밀번호 변경(로그인 하기 전)
    //회원 탈퇴
    public void withdraw(Long id);
}
