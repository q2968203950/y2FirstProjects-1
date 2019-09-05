package com.accp.action;

import com.accp.pojo.Deliveryspot;
import com.accp.pojo.Employee;
import com.accp.service.EmployeeService;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeAction extends ActionSupport {
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private int page = 1;
    private int limit = 10;

    public void setPage(int page) {
        this.page = page;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

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

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setGenoer(int genoer) {
        this.genoer = genoer;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setStartwordtime(Date startwordtime) {
        this.startwordtime = startwordtime;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public void setPsoitionid(int psoitionid) {
        this.psoitionid = psoitionid;
    }

    public void setDeliveryspotid(int deliveryspotid) {
        this.deliveryspotid = deliveryspotid;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    private String pname;

    public void setPname(String pname) {
        this.pname = pname;
    }

    private String cname;

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int deliveryspotids;

    public void setDeliveryspotids(int deliveryspotids) {
        this.deliveryspotids = deliveryspotids;
    }

    public String findEmpId() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("page", page);
        map.put("limit", limit);
        if (!"".equals(deliveryspotid) && deliveryspotid != 0) {
            map.put("deliveryspotid", deliveryspotid);
        }
        if (empno != null && !empno.equals("")) {
            map.put("empno", "%" + empno + "%");
        }
        if (pname != null && !pname.equals("")) {
            map.put("pname", pname);
        }
        if (ename != null && !ename.equals("")) {
            map.put("ename", "%" + ename + "%");
        }
        Map<String, Object> map1 = this.employeeService.findMap(map);
        String json = JSON.toJSONString(map1);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        response.getWriter().print(json);
        return null;
    }

    public String findEmp() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("page", page);
        map.put("limit", limit);
        if (ename != null && !ename.equals("")) {
            map.put("ename", "%" + ename + "%");
        }
        if (cname != null && !cname.equals("")) {
            map.put("cname", "%" + cname + "%");
        }
        Map<String, Object> map1 = this.employeeService.findMap(map);
        String json = JSON.toJSONString(map1);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        response.getWriter().print(json);
        return null;
    }

    public String addPos() throws Exception {
        Map map = new HashMap();
        Employee employee = new Employee();
        employee.setEname(ename);
        employee.setGenoer(genoer);
        employee.setBirthday(birthday);
        employee.setAddress(address);
        employee.setTel(tel);
        employee.setStartwordtime(startwordtime);
        employee.setSalary(salary);
        employee.setEmail(email);
        employee.setCardid(cardid);
        employee.setPsoitionid(psoitionid);
        employee.setDeliveryspotid(deliveryspotid);
        employee.setFlag(0);
        try {
            int count = this.employeeService.addPos(employee);
            map.put("code", 0);
            map.put("msg", "添加成功");
        } catch (Exception e) {
            map.put("code", -1);
            map.put("msg", "添加失败");
        }
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        response.getWriter().print(JSON.toJSONString(map));
        return null;
    }

    private String enames;

    public void setEnames(String enames) {
        this.enames = enames;
    }

    public String updatePos() throws Exception {
        Map map = new HashMap();
        Employee employee = new Employee(empid, empno, enames, genoer, birthday, address, tel, startwordtime, salary, email, cardid, psoitionid, deliveryspotid, 0);
        try {
            int count = this.employeeService.updatePos(employee);
            map.put("code", 0);
            map.put("msg", "修改成功");
        } catch (Exception e) {
            map.put("code", -1);
            map.put("msg", "修改失败");
        }
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        response.getWriter().print(JSON.toJSONString(map));
        return null;
    }

    public String deletePos() throws Exception {
        Map map = new HashMap();
        try {
            int count = this.employeeService.deletePos(empid);
            map.put("code", 0);
            map.put("msg", "删除成功");
        } catch (Exception e) {
            map.put("code", -1);
            map.put("msg", "删除失败");
        }
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        response.getWriter().print(JSON.toJSONString(map));
        return null;
    }

    public String findEmpHis() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("page", page);
        map.put("limit", limit);
        Map<String, Object> map1 = this.employeeService.findMapHis(map);
        String json = JSON.toJSONString(map1);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        response.getWriter().print(json);
        return null;
    }

    private int deliveryspotidss;

    public void setDeliveryspotidss(int deliveryspotidss) {
        this.deliveryspotidss = deliveryspotidss;
    }

    public String findAll() throws Exception {
        List list = this.employeeService.findAll(deliveryspotidss);
        String json = JSON.toJSONString(list);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        response.getWriter().print(json);
        return null;
    }

    private int deliveryspotidsss;

    public void setDeliveryspotidsss(int deliveryspotidsss) {
        this.deliveryspotidsss = deliveryspotidsss;
    }

    public String findPname() throws Exception {
        List list = this.employeeService.findPname(deliveryspotidsss);
        String json = JSON.toJSONString(list);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        response.getWriter().print(json);
        return null;
    }
}
