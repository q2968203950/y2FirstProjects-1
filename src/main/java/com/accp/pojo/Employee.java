package com.accp.pojo;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: Employee
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
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

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getGenoer() {
        return genoer;
    }

    public void setGenoer(int genoer) {
        this.genoer = genoer;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getStartwordtime() {
        return startwordtime;
    }

    public void setStartwordtime(Date startwordtime) {
        this.startwordtime = startwordtime;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public int getPsoitionid() {
        return psoitionid;
    }

    public void setPsoitionid(int psoitionid) {
        this.psoitionid = psoitionid;
    }

    public int getDeliveryspotid() {
        return deliveryspotid;
    }

    public void setDeliveryspotid(int deliveryspotid) {
        this.deliveryspotid = deliveryspotid;
    }

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
