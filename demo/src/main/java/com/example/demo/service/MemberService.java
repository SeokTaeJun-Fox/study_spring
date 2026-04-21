package com.example.demo.service;

import com.example.demo.domain.dto.MemberJoinDTO;
import com.example.demo.domain.vo.MemberVO;
import org.springframework.stereotype.Service;

public interface MemberService {
    public void join(MemberJoinDTO memberJoinDTO);
    public void existMemberEmail(String email);
}
