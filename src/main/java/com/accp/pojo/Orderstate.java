package com.accp.pojo;


public class Orderstate {
    private int orderstateid;
    private String oname;

    public int getOrderstateid() {
        return orderstateid;
    }

    public void setOrderstateid(int orderstateid) {
        this.orderstateid = orderstateid;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orderstate that = (Orderstate) o;

        if (orderstateid != that.orderstateid) return false;
        if (oname != null ? !oname.equals(that.oname) : that.oname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderstateid;
        result = 31 * result + (oname != null ? oname.hashCode() : 0);
        return result;
    }
}
