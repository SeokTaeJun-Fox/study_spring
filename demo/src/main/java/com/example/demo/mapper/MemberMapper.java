package com.example.demo.mapper;

import com.example.demo.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public void insert(MemberVO memberVO);
    public int existMemberEmail(String email);
}
