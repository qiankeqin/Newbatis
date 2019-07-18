package com.dayuarchi.custom.newbatis.v1;

import java.lang.reflect.Proxy;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-18 19:45
 */
public class GPConfiguration {
    public <T> T getMapper(Class<T> clazz,GPSqlSession sqlSession) {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},new GPMapperProxy(sqlSession));
    }
}