package com.dayuarchi.custom.newbatis.v1.mapper;

import com.dayuarchi.custom.newbatis.v1.domain.UserDomain;

public interface UserMapper {
    UserDomain selectByPrimaryKey(Integer id);

}
