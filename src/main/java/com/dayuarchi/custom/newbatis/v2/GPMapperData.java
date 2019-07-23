package com.dayuarchi.custom.newbatis.v2;

import com.dayuarchi.custom.newbatis.v2.domain.UserDomain;

/**
 * 用来存储sql对应的类型和Java Bean类型
 * @param <T>
 */
public class GPMapperData<T> {

    private String sql;
    private Class<T> type;

    public GPMapperData(String sql, Class<T> type) {
        this.sql = sql;
        this.type = type;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Class<T> getType() {
        return type;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }
}
