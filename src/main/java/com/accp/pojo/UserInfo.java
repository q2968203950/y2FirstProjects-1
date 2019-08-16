package com.accp.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class UserInfo implements Serializable {
    private Integer userId;
    private String userName;
    private String sex;
    private Integer age;
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;
    private String deptName;
    private BigDecimal sal;

    public UserInfo() {
    }

    public UserInfo(String userName, String sex, Integer age, Date birthday, String deptName, BigDecimal sal) {
        this.userName = userName;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
        this.deptName = deptName;
        this.sal = sal;
    }

    public UserInfo(Integer userId,String userName, String sex, Integer age, Date birthday, String deptName, BigDecimal sal) {
        this.userId = userId;
        this.userName = userName;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
        this.deptName = deptName;
        this.sal = sal;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }
}
