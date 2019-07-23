package com.dayuarchi.custom.newbatis.v2;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 结果返回值操作
 */
public class GPResultSetHandler {

    private final GPConfiguration configuration;

    public GPResultSetHandler(GPConfiguration configuration) {
        this.configuration = configuration;
    }

    public <E> E handle(PreparedStatement preparedStatement, GPMapperData mapperData) throws SQLException {
        //使用ObjectFactory常见类实例
        Object resultObj = new DefaultObjectFactory().create(mapperData.getType());
        ResultSet resultSet = preparedStatement.getResultSet();
        if(resultSet.next()){
            int i = 0;
            for(Field field : resultObj.getClass().getDeclaredFields()){
                setValue(resultObj,field,resultSet,i);
            }
        }
        return (E)resultObj;
    }

    private void setValue(Object resultObj, Field field, ResultSet resultSet, int i) {

    }
}
