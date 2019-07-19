package com.dayuarchi.custom.newbatis.v1copy.domain;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-19 11:02
 */
public class UserDomain {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDomain{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}