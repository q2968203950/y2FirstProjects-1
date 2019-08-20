package com.accp.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: Orderstate
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
@Entity
public class Orderstate {
    private int orderstateid;
    private String oname;

    @Id
    @Column(name = "ORDERSTATEID")
    public int getOrderstateid() {
        return orderstateid;
    }

    public void setOrderstateid(int orderstateid) {
        this.orderstateid = orderstateid;
    }

    @Basic
    @Column(name = "ONAME")
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
        return orderstateid == that.orderstateid &&
                Objects.equals(oname, that.oname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderstateid, oname);
    }
}
