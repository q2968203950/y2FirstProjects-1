package com.accp.pojo;

import java.math.BigDecimal;
import java.sql.Date;

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

        if (empid != employee.empid) return false;
        if (genoer != employee.genoer) return false;
        if (psoitionid != employee.psoitionid) return false;
        if (deliveryspotid != employee.deliveryspotid) return false;
        if (flag != employee.flag) return false;
        if (empno != null ? !empno.equals(employee.empno) : employee.empno != null) return false;
        if (ename != null ? !ename.equals(employee.ename) : employee.ename != null) return false;
        if (birthday != null ? !birthday.equals(employee.birthday) : employee.birthday != null) return false;
        if (address != null ? !address.equals(employee.address) : employee.address != null) return false;
        if (tel != null ? !tel.equals(employee.tel) : employee.tel != null) return false;
        if (startwordtime != null ? !startwordtime.equals(employee.startwordtime) : employee.startwordtime != null)
            return false;
        if (salary != null ? !salary.equals(employee.salary) : employee.salary != null) return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        if (cardid != null ? !cardid.equals(employee.cardid) : employee.cardid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = empid;
        result = 31 * result + (empno != null ? empno.hashCode() : 0);
        result = 31 * result + (ename != null ? ename.hashCode() : 0);
        result = 31 * result + genoer;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (startwordtime != null ? startwordtime.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (cardid != null ? cardid.hashCode() : 0);
        result = 31 * result + psoitionid;
        result = 31 * result + deliveryspotid;
        result = 31 * result + flag;
        return result;
    }
}
