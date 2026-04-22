package com.app.oauth.mapper;

import com.app.oauth.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public void insert(MemberVO oauthMember);
    public MemberVO select(Long id);
}
