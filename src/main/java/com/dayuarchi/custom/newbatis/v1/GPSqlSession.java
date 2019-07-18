package com.dayuarchi.custom.newbatis.v1;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-18 19:42
 */
public class GPSqlSession {

    private GPConfiguration configuration;

    private GPExecutor executor;

    public GPSqlSession(GPConfiguration configuration, GPExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<T> clazz){
        //从configuration中返回Mapper
        return configuration.getMapper(clazz);
    }

    public <T> T selectOne(String statement,String parameter){
        return executor.query(statement,parameter);
    }

}