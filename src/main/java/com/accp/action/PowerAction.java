package com.accp.action;

import com.accp.service.PowerService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PowerAction extends ActionSupport {
    private PowerService powerService;

    public void setPowerService(PowerService powerService) {
        this.powerService = powerService;
    }

    public String findAllP() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        List list = this.powerService.findAllP();
        response.getWriter().print(JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect));
        return null;
    }
}
