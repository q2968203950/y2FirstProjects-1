package com.accp.action;

import com.accp.pojo.Deliveryspot;
import com.accp.pojo.Orders;
import com.accp.pojo.Users;
import com.accp.pojo.Waybill;
import com.accp.service.OrdersService;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdersAction extends ActionSupport {
    private OrdersService ordersService;

    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    private int page = 1;
    private int limit = 10;

    public void setPage(int page) {
        this.page = page;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    private String orderno;
    private int orderstateid;
    private int deliveryspotid;

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public void setDeliveryspotid(int deliveryspotid) {
        this.deliveryspotid = deliveryspotid;
    }

    public void setOrderstateid(int orderstateid) {
        this.orderstateid = orderstateid;
    }

    public String findOrd() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("page", page);
        map.put("limit", limit);
        if (orderno != null && !orderno.equals("")) {
            map.put("orderno", "%" + orderno + "%");
        }
        if (!"".equals(orderstateid) && orderstateid != 1 && orderstateid != 0) {
            map.put("orderstateid", orderstateid);
        }
        if (!"".equals(deliveryspotid) && deliveryspotid != 0) {
            map.put("deliveryspotid", deliveryspotid);
        }
        Map<String, Object> map1 = this.ordersService.findMap(map);
        String json = JSON.toJSONString(map1);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        response.getWriter().print(json);
        return null;
    }

    public String findState() throws Exception {
        List list = this.ordersService.findState();
        String json = JSON.toJSONString(list);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        response.getWriter().print(json);
        return null;
    }

    private int orderid;
    //private String ordernos;
    private String sendname;
    private String sendaddress;
    private String sendtel;
    private String sendmobtle;
    private String sendpostcode;
    private String receivename;
    private String receiveaddress;
    private String receivetel;
    private String receivemodile;
    private String receivepostcode;
    //private int orderstateids;
    //private BigDecimal totalprice;
    private BigDecimal insureprice;
    private BigDecimal goodsprice;
    private BigDecimal volume;
    private BigDecimal weight;
    private String remark;
    //private Date createtime;
    private int deliveryspotids;

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public void setSendname(String sendname) {
        this.sendname = sendname;
    }

    public void setSendaddress(String sendaddress) {
        this.sendaddress = sendaddress;
    }

    public void setSendtel(String sendtel) {
        this.sendtel = sendtel;
    }

    public void setSendmobtle(String sendmobtle) {
        this.sendmobtle = sendmobtle;
    }

    public void setSendpostcode(String sendpostcode) {
        this.sendpostcode = sendpostcode;
    }

    public void setReceivename(String receivename) {
        this.receivename = receivename;
    }

    public void setReceiveaddress(String receiveaddress) {
        this.receiveaddress = receiveaddress;
    }

    public void setReceivetel(String receivetel) {
        this.receivetel = receivetel;
    }

    public void setReceivemodile(String receivemodile) {
        this.receivemodile = receivemodile;
    }

    public void setReceivepostcode(String receivepostcode) {
        this.receivepostcode = receivepostcode;
    }

    public void setInsureprice(BigDecimal insureprice) {
        this.insureprice = insureprice;
    }

    public void setGoodsprice(BigDecimal goodsprice) {
        this.goodsprice = goodsprice;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setDeliveryspotids(int deliveryspotids) {
        this.deliveryspotids = deliveryspotids;
    }

    public String addOrd() throws Exception {
        Orders orders = new Orders();
        orders.setSendname(sendname);
        orders.setReceivename(receivename);
        orders.setSendaddress(sendaddress);
        orders.setReceiveaddress(receiveaddress);
        if ("".equals(sendtel) && sendtel == null) {
            orders.setSendtel("0");
        } else {
            orders.setSendtel(sendtel);
        }
        if ("".equals(receivetel) && receivetel == null) {
            orders.setReceivetel("0");
        } else {
            orders.setReceivetel(receivetel);
        }
        orders.setSendmobtle(sendmobtle);
        orders.setReceivemodile(receivemodile);
        orders.setSendpostcode(sendpostcode);
        orders.setReceivepostcode(receivepostcode);
        Waybill waybill = new Waybill();
        waybill.setWeight(weight);
        waybill.setVolume(volume);
        waybill.setGoodsprice(goodsprice);
        waybill.setRemark(remark);
        waybill.setDeliveryspotid(deliveryspotids);
        Map map = new HashMap();
        try {
            this.ordersService.addOrd(orders);
            this.ordersService.addWay(waybill);
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

    public String findOrdOne() throws Exception {
        List list = this.ordersService.findOrdOne(orderid);
        String json = JSON.toJSONString(list);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        response.getWriter().print(json);
        return null;
    }

    public String login() {
        Users users = new Users();
        users.setDeliveryspotid(7);
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.setAttribute("users", users);
        return null;
    }

}
