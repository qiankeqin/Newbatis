package com.dayuarchi.custom.newbatis.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * MapperProxy是用来找到sql的
 */
public class GPMapperProxy implements InvocationHandler {

    private GPSqlSession sqlSession;

    public GPMapperProxy(GPSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //因为这个方法没有selectByPrimaryKey，并且不想代理这个对象，所以需要去找Mapper对象和Xml对象的映射
        String statement = "";
        if(method.getDeclaringClass().getName().equals(GPConfiguration.UserMapperXml.namespace)){
            statement = GPConfiguration.UserMapperXml.methodSqlMapping.get(method.getName());
            sqlSession.selectOne(statement,args.toString());
        } else {
            //其他mapper类
        }
        return method.invoke(this,args);
    }
}
