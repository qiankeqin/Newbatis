package com.dayuarchi.custom.newbatis.v1;

import com.dayuarchi.custom.newbatis.v1.mapper.UserMapper;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-18 19:45
 */
public class GPConfiguration {
    public <T> T getMapper(Class<T> clazz,GPSqlSession sqlSession) {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},new GPMapperProxy(sqlSession));
    }

    //1解析xml
    //
    static class UserMapperXml{
        //namespace
        public static final String namespace = "com.dayuarchi.custom.newbatis.v1.mapper.UserMapper";

        //sql集合
        public static final Map<String,String> methodSqlMapping = new HashMap<>();

        //初始化加载方法
        static {
            //模拟记载
            methodSqlMapping.put("selectByPrimaryKey","select * from user where id=%d");
        }
    }
}