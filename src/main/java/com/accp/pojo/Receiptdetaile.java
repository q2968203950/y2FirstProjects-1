package com.accp.pojo;


public class Receiptdetaile {
    private int rdid;
    private Integer receiptid;
    private Integer orderid;

    public int getRdid() {
        return rdid;
    }

    public void setRdid(int rdid) {
        this.rdid = rdid;
    }

    public Integer getReceiptid() {
        return receiptid;
    }

    public void setReceiptid(Integer receiptid) {
        this.receiptid = receiptid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receiptdetaile that = (Receiptdetaile) o;

        if (rdid != that.rdid) return false;
        if (receiptid != null ? !receiptid.equals(that.receiptid) : that.receiptid != null) return false;
        if (orderid != null ? !orderid.equals(that.orderid) : that.orderid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rdid;
        result = 31 * result + (receiptid != null ? receiptid.hashCode() : 0);
        result = 31 * result + (orderid != null ? orderid.hashCode() : 0);
        return result;
    }
}
