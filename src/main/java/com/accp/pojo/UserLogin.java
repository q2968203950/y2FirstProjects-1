package com.accp.pojo;

import java.io.Serializable;

public class UserLogin implements Serializable {
    private Integer user_id;
    private String userName;
    private String passWord;

    public UserLogin() {
    }

    public UserLogin(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
