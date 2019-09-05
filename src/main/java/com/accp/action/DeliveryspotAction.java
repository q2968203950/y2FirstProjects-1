package com.accp.action;

import com.accp.pojo.Deliveryspot;
import com.accp.service.DeliveryspotService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliveryspotAction extends ActionSupport {
    private DeliveryspotService deliveryspotService;

    public void setDeliveryspotService(DeliveryspotService deliveryspotService) {
        this.deliveryspotService = deliveryspotService;
    }

    private int page = 1;
    private int limit = 10;

    public void setPage(int page) {
        this.page = page;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    private String pname;
    private String cname;

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String page() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("page", page);
        map.put("limit", limit);
        if (pname != null && !pname.equals("")) {
            map.put("pname", "%" + pname + "%");
        }
        if (cname != null && !cname.equals("")) {
            map.put("cname", "%" + cname + "%");
        }
        Map<String, Object> map1 = this.deliveryspotService.findMap(map);
        String json = JSON.toJSONString(map1);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        response.getWriter().print(json);
        return null;
    }

    private String dname;
    private int provinceid;
    private int cityid;
    private String tel;
    private BigDecimal startscope;
    private BigDecimal startprice;
    private BigDecimal secondprice;
    private BigDecimal startvolumescope;
    private BigDecimal startvolumeprice;
    private BigDecimal secondvdlumeprice;
    private int empid;

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void setProvinceid(int provinceid) {
        this.provinceid = provinceid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setStartscope(BigDecimal startscope) {
        this.startscope = startscope;
    }

    public void setStartprice(BigDecimal startprice) {
        this.startprice = startprice;
    }

    public void setSecondprice(BigDecimal secondprice) {
        this.secondprice = secondprice;
    }

    public void setStartvolumescope(BigDecimal startvolumescope) {
        this.startvolumescope = startvolumescope;
    }

    public void setStartvolumeprice(BigDecimal startvolumeprice) {
        this.startvolumeprice = startvolumeprice;
    }

    public void setSecondvdlumeprice(BigDecimal secondvdlumeprice) {
        this.secondvdlumeprice = secondvdlumeprice;
    }

    public String addDel() throws Exception {
        Map map = new HashMap();
        Deliveryspot deliveryspot = new Deliveryspot();
        deliveryspot.setDname(dname);
        deliveryspot.setProvinceid(provinceid);
        deliveryspot.setCityid(cityid);
        deliveryspot.setTel(tel);
        deliveryspot.setStartscope(startscope);
        deliveryspot.setStartprice(startprice);
        deliveryspot.setSecondprice(secondprice);
        deliveryspot.setStartvolumescope(startvolumescope);
        deliveryspot.setStartvolumeprice(startvolumeprice);
        deliveryspot.setSecondvdlumeprice(secondvdlumeprice);
        deliveryspot.setFlag(0);
        deliveryspot.setEmpid(0);
        try {
            int count = this.deliveryspotService.addDel(deliveryspot);
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

    private int deliveryspotid;
    private int flag;
    private String deliveryspotno;

    public void setDeliveryspotid(int deliveryspotid) {
        this.deliveryspotid = deliveryspotid;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setDeliveryspotno(String deliveryspotno) {
        this.deliveryspotno = deliveryspotno;
    }

    public String updateDel() throws Exception {
        Map map = new HashMap();
        Deliveryspot deliveryspot = new Deliveryspot(deliveryspotid, deliveryspotno, dname, provinceid, cityid, empid, tel, startscope, startprice, secondprice, flag, startvolumescope, startvolumeprice, secondvdlumeprice);
        try {
            int count = this.deliveryspotService.updateDel(deliveryspot);
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

    public String deleteDel() throws Exception {
        Map map = new HashMap();
        try {
            int count = this.deliveryspotService.deleteDel(deliveryspotid);
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

    public String updateDelEmpId() throws Exception {
        Map map = new HashMap();
        try {
            int count = this.deliveryspotService.updateDelEmpId(deliveryspotid, empid);
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

    public String findDelPName() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        List list = this.deliveryspotService.findDelPName();
        response.getWriter().print(JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect));
        return null;
    }
}
