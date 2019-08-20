package com.accp.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: Employee
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
@Entity
public class Employee {
    private int empid;
    private String empno;
    private String ename;
    private int genoer;
    private Date birthday;
    private String address;
    private String tel;
    private Date startwordtime;
    private BigDecimal salary;
    private String email;
    private String cardid;
    private int psoitionid;
    private int deliveryspotid;
    private int flag;

    @Id
    @Column(name = "EMPID")
    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    @Basic
    @Column(name = "EMPNO")
    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    @Basic
    @Column(name = "ENAME")
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Basic
    @Column(name = "GENOER")
    public int getGenoer() {
        return genoer;
    }

    public void setGenoer(int genoer) {
        this.genoer = genoer;
    }

    @Basic
    @Column(name = "BIRTHDAY")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "TEL")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "STARTWORDTIME")
    public Date getStartwordtime() {
        return startwordtime;
    }

    public void setStartwordtime(Date startwordtime) {
        this.startwordtime = startwordtime;
    }

    @Basic
    @Column(name = "SALARY")
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "CARDID")
    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    @Basic
    @Column(name = "PSOITIONID")
    public int getPsoitionid() {
        return psoitionid;
    }

    public void setPsoitionid(int psoitionid) {
        this.psoitionid = psoitionid;
    }

    @Basic
    @Column(name = "DELIVERYSPOTID")
    public int getDeliveryspotid() {
        return deliveryspotid;
    }

    public void setDeliveryspotid(int deliveryspotid) {
        this.deliveryspotid = deliveryspotid;
    }

    @Basic
    @Column(name = "FLAG")
    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empid == employee.empid &&
                genoer == employee.genoer &&
                psoitionid == employee.psoitionid &&
                deliveryspotid == employee.deliveryspotid &&
                flag == employee.flag &&
                Objects.equals(empno, employee.empno) &&
                Objects.equals(ename, employee.ename) &&
                Objects.equals(birthday, employee.birthday) &&
                Objects.equals(address, employee.address) &&
                Objects.equals(tel, employee.tel) &&
                Objects.equals(startwordtime, employee.startwordtime) &&
                Objects.equals(salary, employee.salary) &&
                Objects.equals(email, employee.email) &&
                Objects.equals(cardid, employee.cardid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empid, empno, ename, genoer, birthday, address, tel, startwordtime, salary, email, cardid, psoitionid, deliveryspotid, flag);
    }
}
