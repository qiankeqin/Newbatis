package com.dayuarchi.custom.newbatis.v2;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-18 19:44
 */
public interface GPExecutor {
    /**
     * 查询方法
     * @param statement sql语句
     * @param parameter 参数
     * @param <T>
     * @return
     */
    <T> T query(String statement, String parameter);

    <T> T query(String statement, String parameter, Class<T> type);
}
