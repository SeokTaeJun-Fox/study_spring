package com.example.demo.repository;

import com.example.demo.domain.vo.MemberVO;
import com.example.demo.mapper.MemberMapper;
import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private final MemberMapper memberMapper;

    public void save(MemberVO memberVO) {
        memberMapper.insert(memberVO);
    }

    public int existMemberEmail(String email) {
        return memberMapper.existMemberEmail(email);
    }
}
