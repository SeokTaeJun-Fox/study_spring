package com.app.threetier.repository;

import com.app.threetier.mapper.StudentMapper;
import com.app.threetier.vo.ProductVO;
import com.app.threetier.vo.StudentDTO;
import com.app.threetier.vo.StudentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// FM
// Mapper, DAO는 Optional로 감싸지 않는다.
// 유지보수에서 혼란이 생길 수 있다.
@Repository
@RequiredArgsConstructor
public class StudentDAO {
    private final StudentMapper studentMapper;
    
    //학생 추가
    public void save(StudentVO studentVO) {
        studentMapper.insert(studentVO);
    }
    
    //학생 조회
    public List<StudentDTO> findAll() {
        return studentMapper.selectAll();
    }
    
    //학생 단일 조회
    public StudentDTO findById(Long id) {
        return studentMapper.select(id);
    }
    
    // 학생 수정
    public void update(StudentVO studentVO) {
        studentMapper.update(studentVO);
    }
    
    //학생 삭제
    public void delete(Long id) {
        studentMapper.delete(id);
    }
}
