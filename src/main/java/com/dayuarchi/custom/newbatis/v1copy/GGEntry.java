package com.dayuarchi.custom.newbatis.v1copy;

import com.dayuarchi.custom.newbatis.v1copy.domain.UserDomain;
import com.dayuarchi.custom.newbatis.v1copy.mapper.UserMapper;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-19 13:25
 */
public class GGEntry {
    public static void main(String[] args) {
        GGSqlSession sqlSession= new GGSqlSession(new GGConfiguration(),new SimpleGGExecutor());
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserDomain userDomain = mapper.selectByPK(1);
        System.out.println(userDomain.toString());
    }
}