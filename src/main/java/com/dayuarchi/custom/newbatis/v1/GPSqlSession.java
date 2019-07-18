package com.dayuarchi.custom.newbatis.v1;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-18 19:42
 */
public class GPSqlSession {
    //Configuration configuration
    private GPConfiguration configuration;
    //Executor executor
    private GPExecutor executor;

    public GPSqlSession(GPConfiguration configuration, GPExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }


}