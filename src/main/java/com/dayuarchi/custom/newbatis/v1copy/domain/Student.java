package com.dayuarchi.custom.newbatis.v1copy.domain;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-19 11:02
 */
public class Student {
    private Integer id;
    private String stuName;
    private String clazzNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getClazzNo() {
        return clazzNo;
    }

    public void setClazzNo(String clazzNo) {
        this.clazzNo = clazzNo;
    }
}