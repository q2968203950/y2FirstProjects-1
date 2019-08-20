package com.accp.pojo;

import java.sql.Date;
import java.util.Objects;

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
        return carid == car.carid &&
                cartypeid == car.cartypeid &&
                carsize == car.carsize &&
                tonnage == car.tonnage &&
                carstateid == car.carstateid &&
                lineid == car.lineid &&
                empid == car.empid &&
                Objects.equals(carno, car.carno) &&
                Objects.equals(workno, car.workno) &&
                Objects.equals(buytime, car.buytime) &&
                Objects.equals(leavetime, car.leavetime) &&
                Objects.equals(remark, car.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carid, carno, workno, cartypeid, carsize, tonnage, buytime, leavetime, carstateid, lineid, empid, remark);
    }
}
