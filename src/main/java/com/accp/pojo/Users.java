package com.accp.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: Users
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
@Entity
public class Users {
    private int userid;
    private String username;
    private String passowrd;
    private Integer powerid;
    private Integer deliveryspotid;
    private int empid;

    @Id
    @Column(name = "USERID")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PASSOWRD")
    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    @Basic
    @Column(name = "POWERID")
    public Integer getPowerid() {
        return powerid;
    }

    public void setPowerid(Integer powerid) {
        this.powerid = powerid;
    }

    @Basic
    @Column(name = "DELIVERYSPOTID")
    public Integer getDeliveryspotid() {
        return deliveryspotid;
    }

    public void setDeliveryspotid(Integer deliveryspotid) {
        this.deliveryspotid = deliveryspotid;
    }

    @Basic
    @Column(name = "EMPID")
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
