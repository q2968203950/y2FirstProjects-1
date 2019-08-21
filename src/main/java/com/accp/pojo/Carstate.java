package com.accp.pojo;


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

        if (carstateid != carstate.carstateid) return false;
        if (cname != null ? !cname.equals(carstate.cname) : carstate.cname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = carstateid;
        result = 31 * result + (cname != null ? cname.hashCode() : 0);
        return result;
    }
}
