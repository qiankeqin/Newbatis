package com.dayuarchi.custom.newbatis.v2.mapper;

import com.dayuarchi.custom.newbatis.v2.domain.UserDomain;

public interface UserMapper {
    UserDomain selectByPrimaryKey(int id);

}
