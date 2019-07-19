package com.dayuarchi.custom.newbatis.v1copy;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-19 10:51
 */
public class GGConfiguration {
    public <T> T getMapper(Class<T> clazz,GGSqlSession sqlSession) {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},new GGMapperProxy(sqlSession));
    }

    static class UserMapperXml{
        static final String namespace = "com.dayuarchi.custom.newbatis.v1copy.mapper.UserMapper";

        static final Map<String,String> methodSqlMapping = new HashMap<>();

        static {
            methodSqlMapping.put("selectByPK","select * from user where id=%d");
        }
    }

    static class StudentMapperXml{
        static final String namespace = "com.dayuarchi.custom.newbatis.v1copy.mapper.StudentMapper";

        static final Map<String,String> methodSqlMapping = new HashMap<>();

        static {
            methodSqlMapping.put("selectByPrimaryKey","select * from student where name=%s");
        }
    }
}