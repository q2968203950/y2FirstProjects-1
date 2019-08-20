package com.accp.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: Orders
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
@Entity
public class Orders {
    private int orderid;
    private String orderno;
    private String sendname;
    private String sendaddress;
    private String sendtel;
    private String sendmobtle;
    private String sendpostcode;
    private String receivename;
    private String receiveaddress;
    private String receivetel;
    private String receivemodile;
    private String receivepostcode;
    private int orderstateid;

    @Id
    @Column(name = "ORDERID")
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    @Basic
    @Column(name = "ORDERNO")
    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    @Basic
    @Column(name = "SENDNAME")
    public String getSendname() {
        return sendname;
    }

    public void setSendname(String sendname) {
        this.sendname = sendname;
    }

    @Basic
    @Column(name = "SENDADDRESS")
    public String getSendaddress() {
        return sendaddress;
    }

    public void setSendaddress(String sendaddress) {
        this.sendaddress = sendaddress;
    }

    @Basic
    @Column(name = "SENDTEL")
    public String getSendtel() {
        return sendtel;
    }

    public void setSendtel(String sendtel) {
        this.sendtel = sendtel;
    }

    @Basic
    @Column(name = "SENDMOBTLE")
    public String getSendmobtle() {
        return sendmobtle;
    }

    public void setSendmobtle(String sendmobtle) {
        this.sendmobtle = sendmobtle;
    }

    @Basic
    @Column(name = "SENDPOSTCODE")
    public String getSendpostcode() {
        return sendpostcode;
    }

    public void setSendpostcode(String sendpostcode) {
        this.sendpostcode = sendpostcode;
    }

    @Basic
    @Column(name = "RECEIVENAME")
    public String getReceivename() {
        return receivename;
    }

    public void setReceivename(String receivename) {
        this.receivename = receivename;
    }

    @Basic
    @Column(name = "RECEIVEADDRESS")
    public String getReceiveaddress() {
        return receiveaddress;
    }

    public void setReceiveaddress(String receiveaddress) {
        this.receiveaddress = receiveaddress;
    }

    @Basic
    @Column(name = "RECEIVETEL")
    public String getReceivetel() {
        return receivetel;
    }

    public void setReceivetel(String receivetel) {
        this.receivetel = receivetel;
    }

    @Basic
    @Column(name = "RECEIVEMODILE")
    public String getReceivemodile() {
        return receivemodile;
    }

    public void setReceivemodile(String receivemodile) {
        this.receivemodile = receivemodile;
    }

    @Basic
    @Column(name = "RECEIVEPOSTCODE")
    public String getReceivepostcode() {
        return receivepostcode;
    }

    public void setReceivepostcode(String receivepostcode) {
        this.receivepostcode = receivepostcode;
    }

    @Basic
    @Column(name = "ORDERSTATEID")
    public int getOrderstateid() {
        return orderstateid;
    }

    public void setOrderstateid(int orderstateid) {
        this.orderstateid = orderstateid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return orderid == orders.orderid &&
                orderstateid == orders.orderstateid &&
                Objects.equals(orderno, orders.orderno) &&
                Objects.equals(sendname, orders.sendname) &&
                Objects.equals(sendaddress, orders.sendaddress) &&
                Objects.equals(sendtel, orders.sendtel) &&
                Objects.equals(sendmobtle, orders.sendmobtle) &&
                Objects.equals(sendpostcode, orders.sendpostcode) &&
                Objects.equals(receivename, orders.receivename) &&
                Objects.equals(receiveaddress, orders.receiveaddress) &&
                Objects.equals(receivetel, orders.receivetel) &&
                Objects.equals(receivemodile, orders.receivemodile) &&
                Objects.equals(receivepostcode, orders.receivepostcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderid, orderno, sendname, sendaddress, sendtel, sendmobtle, sendpostcode, receivename, receiveaddress, receivetel, receivemodile, receivepostcode, orderstateid);
    }
}
