package com.dayuarchi.custom.newbatis.v2;

import com.dayuarchi.custom.newbatis.v2.domain.UserDomain;
import com.dayuarchi.custom.newbatis.v2.mapper.UserMapper;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-19 08:47
 */
public class Entry {
    public static void main(String[] args) {
        GPSqlSession sqlSession = new GPSqlSession(new GPConfiguration(),new GPSimpleExecutor(new GPConfiguration()));
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserDomain userDomain = mapper.selectByPrimaryKey(1);
        System.out.println(userDomain.toString());
    }
}