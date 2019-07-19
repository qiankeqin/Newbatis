package com.dayuarchi.custom.newbatis.v1copy.mapper;

import com.dayuarchi.custom.newbatis.v1copy.domain.Student;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-19 11:02
 */
public interface StudentMapper {
    Student selectByPrimaryKey(String name);
}