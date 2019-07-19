package com.dayuarchi.custom.newbatis.v1copy.mapper;

import com.dayuarchi.custom.newbatis.v1copy.domain.UserDomain;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-19 11:00
 */
public interface UserMapper {
    UserDomain selectByPK(Integer id);
}