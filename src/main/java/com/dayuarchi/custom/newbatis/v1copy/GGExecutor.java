package com.dayuarchi.custom.newbatis.v1copy;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-19 10:52
 */
public interface GGExecutor {
    <T> T query(String statement, String args);
}
