package com.accp.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: Car
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
@Entity
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

    @Id
    @Column(name = "CARID")
    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    @Basic
    @Column(name = "CARNO")
    public String getCarno() {
        return carno;
    }

    public void setCarno(String carno) {
        this.carno = carno;
    }

    @Basic
    @Column(name = "WORKNO")
    public String getWorkno() {
        return workno;
    }

    public void setWorkno(String workno) {
        this.workno = workno;
    }

    @Basic
    @Column(name = "CARTYPEID")
    public int getCartypeid() {
        return cartypeid;
    }

    public void setCartypeid(int cartypeid) {
        this.cartypeid = cartypeid;
    }

    @Basic
    @Column(name = "CARSIZE")
    public int getCarsize() {
        return carsize;
    }

    public void setCarsize(int carsize) {
        this.carsize = carsize;
    }

    @Basic
    @Column(name = "TONNAGE")
    public int getTonnage() {
        return tonnage;
    }

    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }

    @Basic
    @Column(name = "BUYTIME")
    public Date getBuytime() {
        return buytime;
    }

    public void setBuytime(Date buytime) {
        this.buytime = buytime;
    }

    @Basic
    @Column(name = "LEAVETIME")
    public Date getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(Date leavetime) {
        this.leavetime = leavetime;
    }

    @Basic
    @Column(name = "CARSTATEID")
    public int getCarstateid() {
        return carstateid;
    }

    public void setCarstateid(int carstateid) {
        this.carstateid = carstateid;
    }

    @Basic
    @Column(name = "LINEID")
    public int getLineid() {
        return lineid;
    }

    public void setLineid(int lineid) {
        this.lineid = lineid;
    }

    @Basic
    @Column(name = "EMPID")
    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    @Basic
    @Column(name = "REMARK")
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
