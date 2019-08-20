package com.accp.pojo;

import java.util.Objects;

public class Carstate {
    private int carstateid;
    private String cname;

    public int getCarstateid() {
        return carstateid;
    }

    public void setCarstateid(int carstateid) {
        this.carstateid = carstateid;
    }

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
