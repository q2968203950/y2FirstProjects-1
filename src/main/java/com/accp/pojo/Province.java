package com.accp.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: Province
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
@Entity
public class Province {
    private int provinced;
    private String pname;

    @Id
    @Column(name = "PROVINCED")
    public int getProvinced() {
        return provinced;
    }

    public void setProvinced(int provinced) {
        this.provinced = provinced;
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
        Province province = (Province) o;
        return provinced == province.provinced &&
                Objects.equals(pname, province.pname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(provinced, pname);
    }
}
