package com.accp.pojo;


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

        if (orderid != orders.orderid) return false;
        if (orderstateid != orders.orderstateid) return false;
        if (orderno != null ? !orderno.equals(orders.orderno) : orders.orderno != null) return false;
        if (sendname != null ? !sendname.equals(orders.sendname) : orders.sendname != null) return false;
        if (sendaddress != null ? !sendaddress.equals(orders.sendaddress) : orders.sendaddress != null) return false;
        if (sendtel != null ? !sendtel.equals(orders.sendtel) : orders.sendtel != null) return false;
        if (sendmobtle != null ? !sendmobtle.equals(orders.sendmobtle) : orders.sendmobtle != null) return false;
        if (sendpostcode != null ? !sendpostcode.equals(orders.sendpostcode) : orders.sendpostcode != null)
            return false;
        if (receivename != null ? !receivename.equals(orders.receivename) : orders.receivename != null) return false;
        if (receiveaddress != null ? !receiveaddress.equals(orders.receiveaddress) : orders.receiveaddress != null)
            return false;
        if (receivetel != null ? !receivetel.equals(orders.receivetel) : orders.receivetel != null) return false;
        if (receivemodile != null ? !receivemodile.equals(orders.receivemodile) : orders.receivemodile != null)
            return false;
        if (receivepostcode != null ? !receivepostcode.equals(orders.receivepostcode) : orders.receivepostcode != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderid;
        result = 31 * result + (orderno != null ? orderno.hashCode() : 0);
        result = 31 * result + (sendname != null ? sendname.hashCode() : 0);
        result = 31 * result + (sendaddress != null ? sendaddress.hashCode() : 0);
        result = 31 * result + (sendtel != null ? sendtel.hashCode() : 0);
        result = 31 * result + (sendmobtle != null ? sendmobtle.hashCode() : 0);
        result = 31 * result + (sendpostcode != null ? sendpostcode.hashCode() : 0);
        result = 31 * result + (receivename != null ? receivename.hashCode() : 0);
        result = 31 * result + (receiveaddress != null ? receiveaddress.hashCode() : 0);
        result = 31 * result + (receivetel != null ? receivetel.hashCode() : 0);
        result = 31 * result + (receivemodile != null ? receivemodile.hashCode() : 0);
        result = 31 * result + (receivepostcode != null ? receivepostcode.hashCode() : 0);
        result = 31 * result + orderstateid;
        return result;
    }

    public Orders() {
    }

    public Orders(String orderno, String sendname, String sendaddress, String sendtel, String sendmobtle, String sendpostcode, String receivename, String receiveaddress, String receivetel, String receivemodile, String receivepostcode, int orderstateid) {
        this.orderno = orderno;
        this.sendname = sendname;
        this.sendaddress = sendaddress;
        this.sendtel = sendtel;
        this.sendmobtle = sendmobtle;
        this.sendpostcode = sendpostcode;
        this.receivename = receivename;
        this.receiveaddress = receiveaddress;
        this.receivetel = receivetel;
        this.receivemodile = receivemodile;
        this.receivepostcode = receivepostcode;
        this.orderstateid = orderstateid;
    }
}
