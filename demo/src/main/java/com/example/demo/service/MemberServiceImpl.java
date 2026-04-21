package com.example.demo.service;

import com.example.demo.domain.dto.MemberJoinDTO;
import com.example.demo.domain.vo.MemberVO;
import com.example.demo.exception.MemberException;
import com.example.demo.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    @Override
    public void join(MemberJoinDTO memberJoinDTO) {

        existMemberEmail(memberJoinDTO.getMemberEmail());

        MemberVO memberVO = MemberVO.from(memberJoinDTO);
        memberDAO.save(memberVO);
    }

    @Override
    public void existMemberEmail(String email) {
        if(memberDAO.existMemberEmail(email) != 0) {
            throw new MemberException("이메일이 존재합니다", HttpStatus.CONFLICT);
        }
    }
}
