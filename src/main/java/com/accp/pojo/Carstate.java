package com.accp.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: Carstate
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
@Entity
public class Carstate {
    private int carstateid;
    private String cname;

    @Id
    @Column(name = "CARSTATEID")
    public int getCarstateid() {
        return carstateid;
    }

    public void setCarstateid(int carstateid) {
        this.carstateid = carstateid;
    }

    @Basic
    @Column(name = "CNAME")
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carstate carstate = (Carstate) o;
        return carstateid == carstate.carstateid &&
                Objects.equals(cname, carstate.cname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carstateid, cname);
    }
}
