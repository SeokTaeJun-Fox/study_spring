package com.app.threetier.service;

import com.app.threetier.vo.StudentVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class StudentServiceTests {

    @Autowired
    private StudentService studentService;

    @Test
    public void registerStudentTest() {
        StudentVO studentVO = new StudentVO();
        studentVO.setStudentName("장보고");
        studentVO.setEng(30);
        studentVO.setKor(50);
        studentVO.setMath(77);
        studentService.registerStudent(studentVO);
    }

    @Test
    public void getStudentListTest() {
        log.info("list : {} ", studentService.getStudentList());
    }

    @Test
    public void updateStudentTest() {
        StudentVO studentVO = new StudentVO();
        studentVO.setStudentName("김수최");
        studentVO.setEng(40);
        studentVO.setKor(60);
        studentVO.setMath(88);
        studentVO.setId(3L);
        studentService.updateStudent(studentVO);
    }

    @Test
    public void deleteStudentTest() {
        studentService.deleteStudent(3L);
    }
}
