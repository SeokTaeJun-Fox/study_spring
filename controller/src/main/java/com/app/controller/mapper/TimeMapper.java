package com.app.controller.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TimeMapper {
    public String getTime();

//    또다른 방법(하나의 파일에는 하나의 언어로 사용하므로 사용하지 않는다)
    @Select("SELECT CURRENT_TIMESTAMP FROM DUAL")
    public String getTime2();
}
