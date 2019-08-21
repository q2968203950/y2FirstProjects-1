package com.accp.pojo;

import java.sql.Date;

public class Car {
    private int carid;
    private String carno;
    private String workno;
    private int cartypeid;
    private int carsize;
    private int tonnage;
    private Date buytime;
    private Date leavetime;
    private int carstateid;
    private int lineid;
    private int empid;
    private String remark;

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public String getCarno() {
        return carno;
    }

    public void setCarno(String carno) {
        this.carno = carno;
    }

    public String getWorkno() {
        return workno;
    }

    public void setWorkno(String workno) {
        this.workno = workno;
    }

    public int getCartypeid() {
        return cartypeid;
    }

    public void setCartypeid(int cartypeid) {
        this.cartypeid = cartypeid;
    }

    public int getCarsize() {
        return carsize;
    }

    public void setCarsize(int carsize) {
        this.carsize = carsize;
    }

    public int getTonnage() {
        return tonnage;
    }

    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }

    public Date getBuytime() {
        return buytime;
    }

    public void setBuytime(Date buytime) {
        this.buytime = buytime;
    }

    public Date getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(Date leavetime) {
        this.leavetime = leavetime;
    }

    public int getCarstateid() {
        return carstateid;
    }

    public void setCarstateid(int carstateid) {
        this.carstateid = carstateid;
    }

    public int getLineid() {
        return lineid;
    }

    public void setLineid(int lineid) {
        this.lineid = lineid;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (carid != car.carid) return false;
        if (cartypeid != car.cartypeid) return false;
        if (carsize != car.carsize) return false;
        if (tonnage != car.tonnage) return false;
        if (carstateid != car.carstateid) return false;
        if (lineid != car.lineid) return false;
        if (empid != car.empid) return false;
        if (carno != null ? !carno.equals(car.carno) : car.carno != null) return false;
        if (workno != null ? !workno.equals(car.workno) : car.workno != null) return false;
        if (buytime != null ? !buytime.equals(car.buytime) : car.buytime != null) return false;
        if (leavetime != null ? !leavetime.equals(car.leavetime) : car.leavetime != null) return false;
        if (remark != null ? !remark.equals(car.remark) : car.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = carid;
        result = 31 * result + (carno != null ? carno.hashCode() : 0);
        result = 31 * result + (workno != null ? workno.hashCode() : 0);
        result = 31 * result + cartypeid;
        result = 31 * result + carsize;
        result = 31 * result + tonnage;
        result = 31 * result + (buytime != null ? buytime.hashCode() : 0);
        result = 31 * result + (leavetime != null ? leavetime.hashCode() : 0);
        result = 31 * result + carstateid;
        result = 31 * result + lineid;
        result = 31 * result + empid;
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
