package com.app.mybatis.mapper;

import com.app.mybatis.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

//RDB중심 설계
@Mapper
public interface MemberMapper {
    public List<MemberVO> selectAll();
    public Optional<MemberVO> select(Long id);  //optional로감싸면 optional감싼 객체로 반환된다.
    public void insert(MemberVO memberVO);
    public void update(MemberVO memberVO);
    public void delete(Long id);
}
