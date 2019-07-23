package com.dayuarchi.custom.newbatis.v2;

import com.dayuarchi.custom.newbatis.v2.domain.UserDomain;

import java.util.HashMap;
import java.util.Map;

public class GPMapperRegistry {
    public static final Map<String,GPMapperData> methodSqlMapping = new HashMap<>();

    //使用1 在这里配置
    //2。Java bean的属性名字要和数据库表的名字一样
    public GPMapperRegistry(){
        methodSqlMapping.put("com.dayuarchi.custom.newbatis.v2.mapper.UserMapper.selectByPrimaryKey",
                new GPMapperData("", UserDomain.class));
    }

    public GPMapperData get(String methodName){
        return methodSqlMapping.get(methodName);
    }

}
