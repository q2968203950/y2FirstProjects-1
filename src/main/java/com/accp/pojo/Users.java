package com.accp.pojo;


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

    public Users() {
    }

    public Users(String username, String passowrd) {
        this.username = username;
        this.passowrd = passowrd;
    }

    public Users(int userid, String username, String passowrd, Integer powerid, Integer deliveryspotid, int empid) {
        this.userid = userid;
        this.username = username;
        this.passowrd = passowrd;
        this.powerid = powerid;
        this.deliveryspotid = deliveryspotid;
        this.empid = empid;
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

        if (userid != users.userid) return false;
        if (empid != users.empid) return false;
        if (username != null ? !username.equals(users.username) : users.username != null) return false;
        if (passowrd != null ? !passowrd.equals(users.passowrd) : users.passowrd != null) return false;
        if (powerid != null ? !powerid.equals(users.powerid) : users.powerid != null) return false;
        if (deliveryspotid != null ? !deliveryspotid.equals(users.deliveryspotid) : users.deliveryspotid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (passowrd != null ? passowrd.hashCode() : 0);
        result = 31 * result + (powerid != null ? powerid.hashCode() : 0);
        result = 31 * result + (deliveryspotid != null ? deliveryspotid.hashCode() : 0);
        result = 31 * result + empid;
        return result;
    }

    public Users() {
    }

    public Users(int userid, String username, String passowrd, Integer powerid, Integer deliveryspotid, int empid) {
        this.userid = userid;
        this.username = username;
        this.passowrd = passowrd;
        this.powerid = powerid;
        this.deliveryspotid = deliveryspotid;
        this.empid = empid;
    }
}
