package com.accp.pojo;

import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: Orders
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
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

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getSendname() {
        return sendname;
    }

    public void setSendname(String sendname) {
        this.sendname = sendname;
    }

    public String getSendaddress() {
        return sendaddress;
    }

    public void setSendaddress(String sendaddress) {
        this.sendaddress = sendaddress;
    }

    public String getSendtel() {
        return sendtel;
    }

    public void setSendtel(String sendtel) {
        this.sendtel = sendtel;
    }

    public String getSendmobtle() {
        return sendmobtle;
    }

    public void setSendmobtle(String sendmobtle) {
        this.sendmobtle = sendmobtle;
    }

    public String getSendpostcode() {
        return sendpostcode;
    }

    public void setSendpostcode(String sendpostcode) {
        this.sendpostcode = sendpostcode;
    }

    public String getReceivename() {
        return receivename;
    }

    public void setReceivename(String receivename) {
        this.receivename = receivename;
    }

    public String getReceiveaddress() {
        return receiveaddress;
    }

    public void setReceiveaddress(String receiveaddress) {
        this.receiveaddress = receiveaddress;
    }

    public String getReceivetel() {
        return receivetel;
    }

    public void setReceivetel(String receivetel) {
        this.receivetel = receivetel;
    }

    public String getReceivemodile() {
        return receivemodile;
    }

    public void setReceivemodile(String receivemodile) {
        this.receivemodile = receivemodile;
    }

    public String getReceivepostcode() {
        return receivepostcode;
    }

    public void setReceivepostcode(String receivepostcode) {
        this.receivepostcode = receivepostcode;
    }

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
