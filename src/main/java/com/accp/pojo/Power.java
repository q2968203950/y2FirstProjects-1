package com.accp.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: Power
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
@Entity
public class Power {
    private int powerid;
    private String pname;

    @Id
    @Column(name = "POWERID")
    public int getPowerid() {
        return powerid;
    }

    public void setPowerid(int powerid) {
        this.powerid = powerid;
    }

    @Basic
    @Column(name = "PNAME")
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Power power = (Power) o;
        return powerid == power.powerid &&
                Objects.equals(pname, power.pname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerid, pname);
    }
}
