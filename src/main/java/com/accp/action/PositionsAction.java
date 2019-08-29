package com.accp.action;

import com.accp.service.PositionsService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PositionsAction extends ActionSupport {
    private PositionsService positionsService;

    public void setPositionsService(PositionsService positionsService) {
        this.positionsService = positionsService;
    }

    public String findPos() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        List list = this.positionsService.findPos();
        response.getWriter().print(JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect));
        return null;
    }
}
