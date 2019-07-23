package com.dayuarchi.custom.newbatis.v2;

import org.apache.ibatis.binding.MapperRegistry;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * MapperProxy是用来找到sql的
 */
public class GPMapperProxy<T> implements InvocationHandler {

    private GPSqlSession sqlSession;

    private final Class<T> mapperInterface;

    public GPMapperProxy(GPSqlSession sqlSession,Class<T> clazz) {
        this.sqlSession = sqlSession;
        this.mapperInterface = clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //因为这个方法没有selectByPrimaryKey，并且不想代理这个对象，所以需要去找Mapper对象和Xml对象的映射
        GPMapperData mapperData = sqlSession.getConfiguration()
                .getMapperRegistry()
                .get(method.getDeclaringClass().getName());
        if(mapperData!=null){
            System.out.println(String.format("Sql [ %s ], parameter [%s]",mapperData.getSql(),args.toString()));
            return sqlSession.selectOne(mapperData.getSql(),String.valueOf(args[1]),mapperData.getType());
        }
        return method.invoke(this,args);
    }
}
