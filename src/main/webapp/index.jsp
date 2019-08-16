<%--
  Created by IntelliJ IDEA.
  User: yan
  Date: 2019/8/9
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>登录</title>
    <link rel="stylesheet" href="<%=path%>/layui/css/layui.css">
    <style type="text/css">
        #loginDialog {
            position: absolute;
            top: 230px;
            color: white;
        }

        h1 {
            position: absolute;
            top: -40px;
            left: 150px;
        }
    </style>
</head>
<body>
<div class="layui-row">
    <div class="layui-col-md3 layui-col-md-offset4" id="loginDialog"
         style="width: 320px; padding-top: 20px;">
        <form class="layui-form" action="<%=path%>/user_login.action"
              method="post">
            <div class="layui-form-item">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-block">
                    <input type="text" name="userName" required lay-verify="required"
                           placeholder="请输入用户名" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-block">
                    <input type="password" name="passWord" required lay-verify="required"
                           placeholder="请输入密码" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item" style="margin-left: 30px;position:relative; top: 10px;">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">登录</button>
                    <button id="userbtn" type="button"
                            class="layui-btn layui-btn-primary">注册
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
<div id="addDialog"
     style="display: none; width: 340px; padding-top: 24px;">
    <form class="layui-form" action="<%=path%>/user_register.action"
          method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="username" required lay-verify="required"
                       placeholder="请输入用户名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input type="password" name="pwd" required lay-verify="required"
                       placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="<%=path%>/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(["jquery", "layer", 'form'], function () {
        var layer = layui.layer;
        var $ = layui.jquery;
        var form = layui.form;
        $("#userbtn").click(function () {
            layer.open({
                type: 1,
                title: "添加管理员信息",
                content: $("#addDialog"),
                btn: ["注册", "取消"],
                area: ["360px", "230px"],
                success: function (layero, index) {
                    layero.addClass("layui-form");
                    layero.find(".layui-layer-btn0").attr("lay-filter", "add").attr("lay-submit", "");
                    form.render();
                },
                yes: function (layero, index) {
                    form.on('submit(add)', function (data) {
                        var username = $("#addDialog input[name=username]").val();
                        var pwd = $("#addDialog input[name=pwd]").val();
                        $.ajax({
                            url: "<%=path%>/user_register.action",
                            type: "post",
                            data: {
                                userName: username,
                                passWord: pwd
                            },
                            success: function (data) {
                                layer.closeAll('page');
                            }
                        });
                    });
                },
                btn2: function (index) {
                    layer.close(index);
                }
            });
        });
    });
</script>
</body>
</html>
