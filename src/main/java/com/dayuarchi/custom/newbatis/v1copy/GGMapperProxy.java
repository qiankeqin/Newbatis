package com.dayuarchi.custom.newbatis.v1copy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-19 10:55
 */
public class GGMapperProxy implements InvocationHandler {

    private GGSqlSession sqlSession;

    public GGMapperProxy(GGSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //反射调用
        if(method.getDeclaringClass().getName().equals(GGConfiguration.UserMapperXml.namespace)){
            return sqlSession.selectOne(GGConfiguration.UserMapperXml.methodSqlMapping.get(method.getName()),String.valueOf(args[0]));
        } else if(method.getDeclaringClass().getName().equals(GGConfiguration.StudentMapperXml.namespace)){
            return sqlSession.selectOne(GGConfiguration.StudentMapperXml.methodSqlMapping.get(method.getName()),String.valueOf(args[0]));
        }
        return method.invoke(this,args);
    }
}