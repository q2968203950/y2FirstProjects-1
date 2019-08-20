package com.accp.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: City
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
@Entity
public class City {
    private int cityid;
    private String cname;
    private int provinceid;

    @Id
    @Column(name = "CITYID")
    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    @Basic
    @Column(name = "CNAME")
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Basic
    @Column(name = "PROVINCEID")
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
        return cityid == city.cityid &&
                provinceid == city.provinceid &&
                Objects.equals(cname, city.cname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityid, cname, provinceid);
    }
}
