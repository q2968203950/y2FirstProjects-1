package com.accp.pojo;

import java.math.BigDecimal;

public class Deliveryspot {
    private int deliveryspotid;
    private String deliveryspotno;
    private String dname;
    private int provinceid;
    private int cityid;
    private int empid;
    private String tel;
    private BigDecimal startscope;
    private BigDecimal startprice;
    private BigDecimal secondprice;
    private int flag;
    private BigDecimal startvolumescope;
    private BigDecimal startvolumeprice;
    private BigDecimal secondvdlumeprice;

    public int getDeliveryspotid() {
        return deliveryspotid;
    }

    public void setDeliveryspotid(int deliveryspotid) {
        this.deliveryspotid = deliveryspotid;
    }

    public String getDeliveryspotno() {
        return deliveryspotno;
    }

    public void setDeliveryspotno(String deliveryspotno) {
        this.deliveryspotno = deliveryspotno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public int getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(int provinceid) {
        this.provinceid = provinceid;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public BigDecimal getStartscope() {
        return startscope;
    }

    public void setStartscope(BigDecimal startscope) {
        this.startscope = startscope;
    }

    public BigDecimal getStartprice() {
        return startprice;
    }

    public void setStartprice(BigDecimal startprice) {
        this.startprice = startprice;
    }

    public BigDecimal getSecondprice() {
        return secondprice;
    }

    public void setSecondprice(BigDecimal secondprice) {
        this.secondprice = secondprice;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public BigDecimal getStartvolumescope() {
        return startvolumescope;
    }

    public void setStartvolumescope(BigDecimal startvolumescope) {
        this.startvolumescope = startvolumescope;
    }

    public BigDecimal getStartvolumeprice() {
        return startvolumeprice;
    }

    public void setStartvolumeprice(BigDecimal startvolumeprice) {
        this.startvolumeprice = startvolumeprice;
    }

    public BigDecimal getSecondvdlumeprice() {
        return secondvdlumeprice;
    }

    public void setSecondvdlumeprice(BigDecimal secondvdlumeprice) {
        this.secondvdlumeprice = secondvdlumeprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deliveryspot that = (Deliveryspot) o;

        if (deliveryspotid != that.deliveryspotid) return false;
        if (provinceid != that.provinceid) return false;
        if (cityid != that.cityid) return false;
        if (empid != that.empid) return false;
        if (flag != that.flag) return false;
        if (deliveryspotno != null ? !deliveryspotno.equals(that.deliveryspotno) : that.deliveryspotno != null)
            return false;
        if (dname != null ? !dname.equals(that.dname) : that.dname != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (startscope != null ? !startscope.equals(that.startscope) : that.startscope != null) return false;
        if (startprice != null ? !startprice.equals(that.startprice) : that.startprice != null) return false;
        if (secondprice != null ? !secondprice.equals(that.secondprice) : that.secondprice != null) return false;
        if (startvolumescope != null ? !startvolumescope.equals(that.startvolumescope) : that.startvolumescope != null)
            return false;
        if (startvolumeprice != null ? !startvolumeprice.equals(that.startvolumeprice) : that.startvolumeprice != null)
            return false;
        if (secondvdlumeprice != null ? !secondvdlumeprice.equals(that.secondvdlumeprice) : that.secondvdlumeprice != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deliveryspotid;
        result = 31 * result + (deliveryspotno != null ? deliveryspotno.hashCode() : 0);
        result = 31 * result + (dname != null ? dname.hashCode() : 0);
        result = 31 * result + provinceid;
        result = 31 * result + cityid;
        result = 31 * result + empid;
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (startscope != null ? startscope.hashCode() : 0);
        result = 31 * result + (startprice != null ? startprice.hashCode() : 0);
        result = 31 * result + (secondprice != null ? secondprice.hashCode() : 0);
        result = 31 * result + flag;
        result = 31 * result + (startvolumescope != null ? startvolumescope.hashCode() : 0);
        result = 31 * result + (startvolumeprice != null ? startvolumeprice.hashCode() : 0);
        result = 31 * result + (secondvdlumeprice != null ? secondvdlumeprice.hashCode() : 0);
        return result;
    }
}
