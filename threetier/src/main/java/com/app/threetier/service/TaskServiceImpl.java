package com.app.threetier.service;

import com.app.threetier.vo.TaskVO;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    public Float getAverage(TaskVO taskVO) {
        return (taskVO.getMath() + taskVO.getEng() + taskVO.getKor())/3f;
    }
}
