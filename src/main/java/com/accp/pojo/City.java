package com.accp.pojo;


public class City {
    private int cityid;
    private String cname;
    private int provinceid;

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(int provinceid) {
        this.provinceid = provinceid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (cityid != city.cityid) return false;
        if (provinceid != city.provinceid) return false;
        if (cname != null ? !cname.equals(city.cname) : city.cname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cityid;
        result = 31 * result + (cname != null ? cname.hashCode() : 0);
        result = 31 * result + provinceid;
        return result;
    }
}
