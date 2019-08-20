package com.accp.pojo;

import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: Users
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
public class Users {
    private int userid;
    private String username;
    private String passowrd;
    private Integer powerid;
    private Integer deliveryspotid;
    private int empid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    public Integer getPowerid() {
        return powerid;
    }

    public void setPowerid(Integer powerid) {
        this.powerid = powerid;
    }

    public Integer getDeliveryspotid() {
        return deliveryspotid;
    }

    public void setDeliveryspotid(Integer deliveryspotid) {
        this.deliveryspotid = deliveryspotid;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return userid == users.userid &&
                empid == users.empid &&
                Objects.equals(username, users.username) &&
                Objects.equals(passowrd, users.passowrd) &&
                Objects.equals(powerid, users.powerid) &&
                Objects.equals(deliveryspotid, users.deliveryspotid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, username, passowrd, powerid, deliveryspotid, empid);
    }
}
