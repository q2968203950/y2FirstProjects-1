<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>Title</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="./plugins/layui/css/layui.css" media="all">
    <style>
        .rigtop {
            width: 1140px;
            height: 40px;
            border: 1px solid #b7d5df;
            line-height: 40px;
            margin: auto;
            margin-top: 5px;
        }

        .rigbody {
            width: 1140px;
            height: 463px;
            border: 1px solid #b7d5df;
            line-height: 40px;
            margin: auto;
            margin-top: 5px;
        }

        .layui-form-select {
            width: 190px;
            display: inline-block;
            margin-bottom: 14px;
            margin-left: 1px;
        }

        .rigtop1 {
            width: 900px;
            height: 40px;
            border: 1px solid #b7d5df;
            line-height: 40px;
            margin: auto;
            margin-top: 5px;
        }

        .layui-laydate, .layui-laydate-main, .layui-laydate-header, .layui-laydate-content {
            width: 250px;
        }

        .layui-laydate-content table {
            width: 100%;
        }
    </style>
</head>
<body>

<div class="rigbody">
    <table id="demo" lay-filter="demo"></table>
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script src="js/jquery.js"></script>
<script src="./plugins/layui/layui.js"></script>
<script>
    layui.config({
        base: '<%=path%>/js/'
    }).extend({
        select: 'select'
    });
    var table = null;
    var laydate = null;
    var layer = null;
    var $ = null;
    var form = null;
    var element = null;
    layui.use(["table", "jquery", "layer", 'form', "laydate", "select", "element"], function () {
        layer = layui.layer;
        laydate = layui.laydate;
        table = layui.table;
        $ = layui.jquery;
        form = layui.form;
        element = layui.element;
        layui.select.initSelect({
            elem: $("#addDeli select[name=deliveryspotid]"),
            url: "<%=path%>/del_findDelPName.action",
            value: "DELIVERYSPOTID",
            text: "cname"
        });
        layui.select.initSelect({
            elem: $("#addDeli select[name=powerid]"),
            url: "<%=path%>/pow_findAllP.action",
            value: "POWERID",
            text: "PNAME"
        });
        //监听工具条
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                $("#updateDeli input[name=username]").val(data.USERNAME);
                $("#updateDeli input[name=userid]").val(data.USERID);
                update(data.USERID);
            } else if (obj.event === 'del') {
                delet(data.USERID);
            }
        });
        table.on("toolbar(demo)", function (object) {
            if (object.event == 'add') {
                add();
            }
        });
        //进行渲染
        xrsj("use_findEmp.action");

    });
</script>
<script>

    function add() {
        layer.open({
            type: 1
            , title: "添加用户信息"
            , content: $("#addDeli")
            , area: ['360px', '550px']
            , btn: ['添加', '取消'] //只是为了演示
            , success: function (layero, index) {
                $('#addDeli input').each(function (i, item) {
                    $(item).val("");
                });
                layero.addClass("layui-form");
                layero.find(".layui-layer-btn0").attr("lay-filter", "add").attr("lay-submit", "");
                form.render();
                layui.select.initSelect({
                    elem: $("#addDeli select[name=deliveryspotid]"),
                    url: "<%=path%>/del_findDelPName.action",
                    value: "DELIVERYSPOTID",
                    text: "cname"
                });
                $("#addDeli select[name=deliveryspotid]").next().find('.layui-anim').children('dd').each(function (i, item) {
                    if (i == 0) {
                        var valP = $(this).attr('lay-value');
                        layui.select.initSelect({
                            elem: $("#addDeli select[name=empid]"),
                            url: "<%=path%>/emp_findAll.action?deliveryspotidss=" + valP,
                            value: "EMPID",
                            text: "EMPNO"
                        });
                    }
                });
                form.on('select(addprov)', function (data) {
                    layui.select.initSelect({
                        elem: $("#addDeli select[name=empid]"),
                        url: "<%=path%>/emp_findAll.action?deliveryspotidss=" + data.value,
                        value: "EMPID",
                        text: "EMPNO"
                    });
                });
            }
            , yes: function (layero, index) {
                form.on('submit(add)', function (data) {
                    $.ajax({
                        type: "post"
                        , url: "/use_addUser.action"
                        , dataType: 'json'
                        //, contentType: 'application/json;charset=utf-8'
                        , data: {
                            username: $("#addDeli input[name=username]").val(),
                            passowrd: $("#addDeli input[name=passowrd]").val(),
                            powerid: $("#addDeli select[name=powerid]").val(),
                            deliveryspotid: $("#addDeli select[name=deliveryspotid]").val(),
                            empid: $("#addDeli select[name=empid]").val()
                        }
                        , success: function (data) {
                            layer.msg(data.msg, {time: 1000});
                            if (data.code == 0) {
                                setTimeout(function () {
                                    esc();
                                    table.reload('idsw');
                                }, 500)
                            }
                        }
                    });
                });
            }, btn2: function () {
                esc();
            }, cancel: function (index, layero) {
                esc()
                return false;
            }
        });
    }

    function update(DELIVERYSPOTID) {
        layer.open({
            type: 1
            , title: "修改用户密码"
            , content: $("#updateDeli")
            , area: ['400px', '230px']
            , btn: ['修改', '取消'] //只是为了演示
            , success: function (layero, index) {
                layero.addClass("layui-form");
                layero.find(".layui-layer-btn0").attr("lay-filter", "add").attr("lay-submit", "");
                form.render();
                $("#updateDeli input[name=passowrd]").val("");
            }
            , yes: function () {
                form.on('submit(add)', function (data) {
                    $.ajax({
                        type: "post"
                        , url: "/use_updateUser.action"
                        , dataType: 'json'
                        , data: {
                            passowrd: $("#updateDeli input[name=passowrd]").val(),
                            userid: $("#updateDeli input[name=userid]").val()
                        }
                        ,
                        success: function (data) {
                            layer.msg(data.msg, {time: 1000});
                            if (data.code == 0) {
                                setTimeout(function () {
                                    esc();
                                    table.reload('idsw');
                                }, 500)
                            }
                        }
                    });
                });
            }
            , btn2: function () {
                esc();
            }, cancel: function (index, layero) {
                esc()
                return false;
            }
        });
    }

    function delet(USERID) {
        layer.confirm('您是否要删除？', {
            btn: ['删除', '取消'] //按钮
        }, function () {
            $.ajax({
                type: "post"
                , url: "/use_deleteUser.action"
                , dataType: 'json'
                , data: {
                    userid: USERID
                },
                success: function (data) {
                    layer.msg(data.msg, {time: 1000});
                    if (data.code == 0) {
                        setTimeout(function () {
                            esc();
                            table.reload('idsw');
                        }, 500)
                    }
                }
            });
        }, function (index) {
            layer.close(index);
        });
    }

    //关闭回调事件
    function esc() {
        layer.closeAll();
        $("#addDeli").attr("hidden", "hidden").css("display", "none");
        $("#updateDeli").attr("hidden", "hidden").css("display", "none");
        $("#rigbody1").attr("hidden", "hidden").css("display", "none");
    }

    function xrsj(url) {
        table.render({
            elem: '#demo'
            , height: 451
            , page: true
            , url: "/" + url //数据接口
            , cellMinWidth: 184
            , toolbar: "default"
            , cols: [[ //表头
                {type: 'numbers', title: '序号'}
                , {field: 'USERID', title: 'ID', align: 'center', hide: true}
                , {field: 'EMPID', title: '员工编号ID', align: 'center', hide: true}
                , {field: 'EMPNO', title: '员工编号', align: 'center'}
                , {field: 'ENAME', title: '员工姓名', align: 'center'}
                , {field: 'USERNAME', title: '用户名', align: 'center'}
                , {field: 'POWERID', title: '权限ID', align: 'center', hide: true}
                , {field: 'PNAME', title: '权限', align: 'center'}
                , {field: 'DELIVERYSPOTID', title: '所属配送点ID', align: 'center', hide: true}
                , {field: 'cname', title: '所属配送点', align: 'center'}
                , {fixed: 'right', title: '操作', width: '178', align: 'center', toolbar: '#barDemo'}
            ]]
            , id: "idsw"
        });
    }
</script>
<form class="layui-form" hidden="hidden" id="addDeli" style="padding-top: 20px;">
    <div class="layui-form-item">
        <label class="layui-form-label">用户登录名</label>
        <div class="layui-input-inline">
            <input type="text" name="username" maxlength="11" required lay-verify="required"
                   placeholder="请输入用户名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" name="passowrd" maxlength="18" required lay-verify="required"
                   placeholder="请输入密码"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">权限</label>
        <div class="layui-input-block">
            <select name="powerid" lay-verify="required"> </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">所在配送点</label>
        <div class="layui-input-block">
            <select name="deliveryspotid" lay-verify="required" lay-filter="addprov"> </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">员工编号</label>
        <div class="layui-input-block">
            <select name="empid" lay-verify="required"> </select>
        </div>
    </div>
</form>
<form class="layui-form" hidden="hidden" id="updateDeli" style="padding-top: 20px;">
    <input type="text" hidden="hidden" name="userid">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline">
            <input type="text" name="username" readonly="readonly" maxlength="11" required lay-verify="required"
                   placeholder="请输入姓名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" name="passowrd" maxlength="18" required lay-verify="required"
                   placeholder="请输入密码"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
</form>
</body>
</html>
