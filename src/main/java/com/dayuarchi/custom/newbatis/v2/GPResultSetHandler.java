package com.dayuarchi.custom.newbatis.v2;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    public <E> E handle(PreparedStatement preparedStatement, GPMapperData mapperData) throws SQLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
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

    private void setValue(Object resultObj, Field field, ResultSet resultSet, int i) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, SQLException {
        //拿到对象中的set属性的方法
        Method setMethod = resultObj.getClass().getMethod("set" + upperCapital(field.getName()), field.getType());
        setMethod.invoke(resultObj,getResult(field,resultSet));
    }

    private Object getResult(Field field, ResultSet resultSet) throws SQLException {
        //Mybatis这里用了typeHandler
        Class<?> type = field.getType();
        if(Integer.class == type){
            return resultSet.getInt(field.getName());
        }
        if(String.class == type){
            return resultSet.getString(field.getName());
        }
        return null;
    }

    private String upperCapital(String name) {
        return name.substring(0,1).toUpperCase()+name.substring(1);
    }
}
