package com.accp.pojo;

import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: Power
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
public class Power {
    private int powerid;
    private String pname;

    public int getPowerid() {
        return powerid;
    }

    public void setPowerid(int powerid) {
        this.powerid = powerid;
    }

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
