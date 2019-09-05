package com.accp.action;

import com.accp.service.CityService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CityAction extends ActionSupport {
    private CityService cityService;

    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    public String getProvince() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        List list = this.cityService.getProvince();
        response.getWriter().print(JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect));
        return null;
    }

    private int provinced;

    public int getProvinced() {
        return provinced;
    }

    public void setProvinced(int provinced) {
        this.provinced = provinced;
    }

    public String getCity() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        List list = this.cityService.getCity(provinced);
        response.getWriter().print(JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect));
        return null;
    }
}
