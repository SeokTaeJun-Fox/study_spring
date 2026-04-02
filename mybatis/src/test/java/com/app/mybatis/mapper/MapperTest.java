package com.app.mybatis.mapper;

import com.app.mybatis.domain.vo.MemberVO;
import com.app.mybatis.domain.vo.PostVO;
import com.app.mybatis.domain.dto.PostDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MapperTest {

    @Autowired
    private TimeMapper timeMapper;

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private MemberVO memberVO;

    @Autowired
    private PostMapper postMapper;

    @Test
    public void mapperTests() {
        log.info(timeMapper.getTime());
    }

    @Test
    public void mapperTests2() {
        log.info(timeMapper.getTime2());
    }

    @Test
    public void mapperTests3() {
        log.info(memberMapper.selectAll().toString());
    }

    @Test
    public void mapperTest4() {
        memberMapper.select(1L).map(MemberVO::toString).ifPresent(log::info);   //옵셔널의 map을 쓴다.
    }

    @Test
    public void mapperTest5() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test456@gmail.com");
        memberVO.setMemberPassword("test123!@#");
        memberVO.setMemberName("이순신");
        memberMapper.insert(memberVO);
        log.info("memberVO : {}", memberVO);
    }

    @Test
    public void mapperTest6() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test456@gmail.com");
        memberVO.setMemberPassword("test123!@#");
        memberVO.setMemberName("장길동");
        memberVO.setId(11L);
        memberMapper.update(memberVO);
        //log.info("memberVO : {}", memberVO);
        memberMapper.select(11L).map(MemberVO::toString).ifPresent(log::info);
    }

    @Test
    public void mapperTest7() {
        memberMapper.delete(11L);
    }

    //Post
//    @Test
//    public void mapperTest8() {
//        PostVO postVO = new PostVO();
//        postVO.setPostTitle("為 이 한자는 무엇입니까?");
//        postVO.setPostContent("為 이 한자는 일격 이펙트 곡선이 있어 일격 캮이라고 부릅니다.");
//        postVO.setMemberId(1L);
//        postVO.setPostReadCount(29L);
//        postMapper.insert(postVO);
//        log.info("postVO : {}", postVO);
//    }
//
//    @Test
//    public void mapperTest9() {
//        log.info("postDTO : {}", postMapper.selectAll());
//    }
//
//    @Test
//    public void mapperTest10() {
//        postMapper.select(3L).map(PostDTO::toString).ifPresent(log::info);
//    }
//
//    @Test
//    public void mapperTest11() {
//        postMapper.selectPostReadCountById(2L).map(Object::toString).ifPresent(log::info);
//    }
//
//    @Test
//    public void mapperTest12() {
//        PostVO postVO = new PostVO();
//        postVO.setId(2L);
//        postVO.setPostTitle("為 이 한자는 무엇입니까?");
//        postVO.setPostContent("為 이 한자는 일격 이펙트 곡선이 있어 일격 캮이라고 부릅니다.");
//        postMapper.update(postVO);
//    }
//
//    @Test
//    public void mapperTest13() {
//        postMapper.delete(3L);
//    }
}
