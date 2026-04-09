package com.app.threetier.repository;

import com.app.threetier.mapper.PostMapper;
import com.app.threetier.vo.PostDTO;
import com.app.threetier.vo.PostVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// 레포지트리(Repository)
// 엔티티에 의해 생성된 데이터베이스 테이블에 직접 접근하는 메서드를 가진 객체 또는 인터페이스
// 객체지향 스럽게 만든것이 DAO
@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

    public List<PostDTO> findAll() {
        return postMapper.selectAll();
    }

    public Optional<PostDTO> findById(Long id) {
        return postMapper.select(id);
    }

    public void update(PostVO postVO) {
        postMapper.update(postVO);
    }

    public void updateReadCount(Long id) {
        postMapper.updateReadCount(id);
    }

    public void delete(Long id) {
        postMapper.delete(id);
    }
}
