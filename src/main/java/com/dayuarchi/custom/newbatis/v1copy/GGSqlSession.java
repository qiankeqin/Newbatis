package com.dayuarchi.custom.newbatis.v1copy;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-19 10:52
 */
public class GGSqlSession {
    private GGConfiguration configuration;

    private GGExecutor executor;

    public GGSqlSession(GGConfiguration configuration, GGExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<T> clazz){
        return configuration.getMapper(clazz,this);
    }

    public <T> T selectOne(String statement,String args){
        return executor.query(statement,args);
    }
}