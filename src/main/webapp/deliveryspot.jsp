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
            width: 91px;
            display: inline-block;
            margin-bottom: 14px;
            margin-left: 1px;
        }

        .rigbody1 {
            width: 900px;
            height: 450px;
            border: 1px solid #b7d5df;
            line-height: 40px;
            margin: auto;
            margin-top: 5px;
        }

        .rigtop1 {
            width: 900px;
            height: 40px;
            border: 1px solid #b7d5df;
            line-height: 40px;
            margin: auto;
            margin-top: 5px;
        }
    </style>
</head>
<body>

<div class="rigtop">
    <div class="layui-form-item layui-form layui-col-md-offset2">
        <div class="layui-inline">
            省:
            <div class="layui-inline" style="width:190px">
                <input class="layui-input" name="pname" id="pname" autocomplete="off">
            </div>
            市:
            <div class="layui-inline" style="width:190px">
                <input class="layui-input" name="cname" id="cname" autocomplete="off">
            </div>
            <div class="layui-inline">
                <button class="layui-btn layui-btns layui-btn-normal" id="nosele" data-type="getCheckData">模糊查询
                </button>
            </div>
        </div>
    </div>
</div>
<div class="rigbody">
    <table id="demo" lay-filter="demo"></table>
</div>
<div class="rigbody1" hidden="hidden" id="empInfo">
    <div class="rigtop1">
        <div class="layui-form-item layui-form layui-col-md-offset2">
            <div class="layui-inline">
                编号:
                <div class="layui-inline" style="width:190px">
                    <input class="layui-input" name="empno" id="empno" autocomplete="off">
                </div>
                姓名:
                <div class="layui-inline" style="width:190px">
                    <input class="layui-input" name="ename" id="ename" autocomplete="off">
                </div>
                <div class="layui-inline">
                    <button class="layui-btn layui-btns layui-btn-normal" id="empNosele" data-type="getCheckData">模糊查询
                    </button>
                </div>
            </div>
        </div>
    </div>
    <table id="demo1" lay-filter="demo1"></table>
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
        <%--layui.select.initSelect({--%>
            <%--elem: $("#addDeli select[name=provinceid]"),--%>
            <%--url: "<%=path%>/city_getProvince.action",--%>
            <%--value: "provinced",--%>
            <%--text: "pname"--%>
        <%--});--%>
        <%--layui.select.initSelect({--%>
            <%--elem: $("#addDeli select[name=cityid]"),--%>
            <%--url: "<%=path%>/city_getCity.action?provinced=" + 110000,--%>
            <%--value: "cityid",--%>
            <%--text: "cname"--%>
        <%--});--%>
        layui.select.initSelect({
            elem: $("#updateDeli select[name=provinceid]"),
            url: "<%=path%>/city_getProvince.action",
            value: "provinced",
            text: "pname"
        });
        //监听工具条
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                var valP = null;
                $("#updateDeli select[name=provinceid]").next().find('.layui-anim').children('dd').each(function () {
                    if ($(this).text() == data.pname) {
                        valP = $(this).attr('lay-value');
                        $("#updateDeli select[name=provinceid]").next().find('.layui-anim').children('dd[lay-value="' + valP + '"]').click();
                    }
                });
                layui.select.initSelect({
                    elem: $("#updateDeli select[name=cityid]"),
                    url: "<%=path%>/city_getCity.action?provinced=" + valP,
                    value: "cityid",
                    text: "cname"
                });
                setTimeout(function () {
                    $("#updateDeli select[name=cityid]").next().find('.layui-anim').children('dd').each(function () {
                        if ($(this).text() == data.cname) {
                            var valC = $(this).attr('lay-value');
                            $("#updateDeli select[name=cityid]").next().find('.layui-anim').children('dd[lay-value="' + valC + '"]').click();
                        }
                    });
                }, 300)
                $("#updateDeli input[name=deliveryspotid]").val(data.DELIVERYSPOTID);
                $("#updateDeli input[name=dname]").val(data.DNAME);
                $("#updateDeli input[name=tel]").val(data.TEL);
                $("#updateDeli input[name=startscope]").val(data.STARTSCOPE);
                $("#updateDeli input[name=startprice]").val(data.STARTPRICE);
                $("#updateDeli input[name=secondprice]").val(data.SECONDPRICE);
                $("#updateDeli input[name=startvolumescope]").val(data.STARTVOLUMESCOPE);
                $("#updateDeli input[name=startvolumeprice]").val(data.STARTVOLUMEPRICE);
                $("#updateDeli input[name=secondvdlumeprice]").val(data.SECONDVDLUMEPRICE);
                $('#updateDeli input[name=flag]').each(function (i, item) {
                    if ($(item).val() == data.FLAG) {
                        $("#updateDeli input[name=flag][value=" + data.FLAG + "]").prop('checked', true);
                        form.render();
                    }
                });
                $("#updateDeli input[name=deliveryspotno]").val(data.DELIVERYSPOTNO);
                $("#updateDeli input[name=empid]").val(data.EMPID);
                update(data.DELIVERYSPOTID);
            } else if (obj.event === 'del') {
                delet(data.DELIVERYSPOTID);
            }
        });
        table.on("toolbar(demo)", function (object) {
            if (object.event == 'add') {
                add();
            }
        });
        //进行渲染
        xrsj("del_page.action");
        //监听单击行事件
        table.on('rowDouble(demo)', function (obj) {
            var data = obj.data;
            layer.open({
                type: 1
                , title: "查看配送点管理员信息"
                , content: $("#empInfo")
                , area: ['900px', '450px']
                , success: function (layero, index) {
                    table.render({
                        elem: '#demo1'
                        , height: 430
                        , page: true
                        , url: "/emp_findEmpId.action?deliveryspotid=" + data.DELIVERYSPOTID + "&pname=" + '配送员' //数据接口
                        , cellMinWidth: 120
                        , cols: [[ //表头
                            {type: 'numbers', title: '序号'}
                            , {field: 'EMPID', title: 'ID', align: 'center', hide: true}
                            , {field: 'EMPNO', title: '编号', align: 'center'}
                            , {field: 'ENAME', title: '姓名', align: 'center'}
                            , {field: 'pname', title: '职位', align: 'center'}
                        ]]
                        , id: "idsws"
                    });
                    $("#empNosele").bind("click", function () {
                        table.reload("idsws", {
                            where: {
                                empno: $.trim($(".rigtop1 input[name=empno]").val()),
                                ename: $.trim($(".rigtop1 input[name=ename]").val())
                            },
                            page: {
                                curr: 1
                            }
                        });
                    });
                    table.on('row(demo1)', function (obj) {
                        var data = obj.data;
                        $.ajax({
                            type: "post"
                            , url: "/del_updateDelEmpId.action"
                            , dataType: 'json'
                            //, contentType: 'application/json;charset=utf-8'
                            , data: {
                                deliveryspotid: data.DELIVERYSPOTID,
                                empid: data.EMPID
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
                    layer.closeAll();
                }, cancel: function (index, layero) {
                    layer.closeAll();
                    return false;
                }
            });
        });
    });
</script>
<script>

    // $("#nosele").click(function () {
    //     xrsj("del_page.action?pname=" + $("#pname").val() + "&cname=" + $("#cname").val());
    // })

    function add() {
        layer.open({
            type: 1
            , title: "添加配送点信息"
            , content: $("#addDeli")
            , area: ['400px', '450px']
            , btn: ['添加', '取消'] //只是为了演示
            , success: function (layero, index) {
                layui.select.initSelect({
                    elem: $("#addDeli select[name=provinceid]"),
                    url: "<%=path%>/city_getProvince.action",
                    value: "provinced",
                    text: "pname"
                });
                layui.select.initSelect({
                    elem: $("#addDeli select[name=cityid]"),
                    url: "<%=path%>/city_getCity.action?provinced=" + 110000,
                    value: "cityid",
                    text: "cname"
                });
                $('#addDeli input').each(function (i, item) {
                    $(item).val("");
                });
                layero.addClass("layui-form");
                layero.find(".layui-layer-btn0").attr("lay-filter", "add").attr("lay-submit", "");
                form.render();
                form.on('select(prov)', function (data) {
                    layui.select.initSelect({
                        elem: $("#addDeli select[name=cityid]"),
                        url: "<%=path%>/city_getCity.action?provinced=" + data.value,
                        value: "cityid",
                        text: "cname"
                    });
                });
            }
            , yes: function (layero, index) {
                form.on('submit(add)', function (data) {
                    $.ajax({
                        type: "post"
                        , url: "/del_addDel.action"
                        , dataType: 'json'
                        //, contentType: 'application/json;charset=utf-8'
                        , data: {
                            dname: $("#addDeli input[name=dname]").val(),
                            provinceid: $("#addDeli select[name=provinceid]").val(),
                            cityid: $("#addDeli select[name=cityid]").val(),
                            tel: $("#addDeli input[name=tel]").val(),
                            startscope: $("#addDeli input[name=startscope]").val(),
                            startprice: $("#addDeli input[name=startprice]").val(),
                            secondprice: $("#addDeli input[name=secondprice]").val(),
                            startvolumescope: $("#addDeli input[name=startvolumescope]").val(),
                            startvolumeprice: $("#addDeli input[name=startvolumeprice]").val(),
                            secondvdlumeprice: $("#addDeli input[name=secondvdlumeprice]").val()
                        }
                        , success: function (data) {
                            layer.msg(data.msg, {time: 1000});
                            if (data.code == 0) {
                                setTimeout(function () {
                                    esc();
                                    $('#addDeli input').each(function (i, item) {
                                        $(item).val("");
                                    });
                                    layui.select.initSelect({
                                        elem: $("#addDeli select[name=provinceid]"),
                                        url: "<%=path%>/city_getProvince.action",
                                        value: "provinced",
                                        text: "pname"
                                    });
                                    layui.select.initSelect({
                                        elem: $("#addDeli select[name=cityid]"),
                                        url: "<%=path%>/city_getCity.action?provinced=" + 110000,
                                        value: "cityid",
                                        text: "cname"
                                    });
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
            , title: "编辑员工信息"
            , content: $("#updateDeli")
            , area: ['400px', '450px']
            , btn: ['修改', '取消'] //只是为了演示
            , success: function (layero, index) {
                layero.addClass("layui-form");
                layero.find(".layui-layer-btn0").attr("lay-filter", "add").attr("lay-submit", "");
                form.render();
                form.on('select(updateprov)', function (data) {
                    layui.select.initSelect({
                        elem: $("#updateDeli select[name=cityid]"),
                        url: "<%=path%>/city_getCity.action?provinced=" + data.value,
                        value: "cityid",
                        text: "cname"
                    });
                });
            }
            , yes: function () {
                $.ajax({
                    type: "post"
                    , url: "/del_updateDel.action"
                    , dataType: 'json'
                    , data: {
                        deliveryspotid: $("#updateDeli input[name=deliveryspotid]").val(),
                        dname: $("#updateDeli input[name=dname]").val(),
                        tel: $("#updateDeli input[name=tel]").val(),
                        startscope: $("#updateDeli input[name=startscope]").val(),
                        startprice: $("#updateDeli input[name=startprice]").val(),
                        secondprice: $("#updateDeli input[name=secondprice]").val(),
                        startvolumescope: $("#updateDeli input[name=startvolumescope]").val(),
                        startvolumeprice: $("#updateDeli input[name=startvolumeprice]").val(),
                        secondvdlumeprice: $("#updateDeli input[name=secondvdlumeprice]").val(),
                        flag: $("#updateDeli input[name=flag]:checked").val(),
                        provinceid: $("#updateDeli select[name=provinceid]").val(),
                        cityid: $("#updateDeli select[name=cityid]").val(),
                        deliveryspotno: $("#updateDeli input[name=deliveryspotno]").val(),
                        empid: $("#updateDeli input[name=empid]").val()
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
            }
            , btn2: function () {
                esc();
            }, cancel: function (index, layero) {
                esc()
                return false;
            }
        });
    }

    function delet(DELIVERYSPOTID) {
        layer.confirm('您是否要删除？', {
            btn: ['删除', '取消'] //按钮
        }, function () {
            $.ajax({
                type: "post"
                , url: "/del_deleteDel.action"
                , dataType: 'json'
                , data: {
                    deliveryspotid: DELIVERYSPOTID
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
            , cellMinWidth: 130
            , toolbar: "default"
            , cols: [[ //表头
                {type: 'numbers', title: '序号'}
                , {field: 'DELIVERYSPOTID', title: 'ID', align: 'center', hide: true}
                , {field: 'DELIVERYSPOTNO', title: '编号', align: 'center'}
                , {field: 'DNAME', title: '名称', align: 'center'}
                , {field: 'pname', title: '省', align: 'center'}
                , {field: 'cname', title: '市', align: 'center'}
                , {field: 'EMPID', title: '管理员ID', align: 'center', hide: true}
                , {field: 'empno', title: '管理员编号', align: 'center'}
                , {field: 'TEL', title: '联系电话', align: 'center'}
                , {field: 'STARTSCOPE', title: '首重量范围', align: 'center'}
                , {field: 'STARTPRICE', title: '首重量价格', align: 'center'}
                , {field: 'SECONDPRICE', title: '次重量价格系数', align: 'center'}
                , {field: 'STARTVOLUMESCOPE', title: '首体积范围', align: 'center'}
                , {field: 'STARTVOLUMEPRICE', title: '首体积价格', align: 'center'}
                , {field: 'SECONDVDLUMEPRICE', title: '次体积价格系数', align: 'center'}
                , {
                    field: 'FLAG', title: '是否有效', align: 'center', templet: function (d) {
                        if (d.FLAG == 0) {
                            return '<a class="layui-btn layui-btn-xs" >有效</a>';
                        }
                        return '<a class="layui-btn layui-btn-danger layui-btn-xs">无效</a>';
                    }
                }
                , {fixed: 'right', title: '操作', width: '178', align: 'center', toolbar: '#barDemo'}
            ]]
            , id: "idsw"
            , initSort: {
                field: 'DELIVERYSPOTID' //排序字段，对应 cols 设定的各字段名
                , type: 'desc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
            }
        });
        $("#nosele").bind("click", function () {
            table.reload("idsw", {
                where: {
                    pname: $.trim($(".rigtop input[name=pname]").val()),
                    cname: $.trim($(".rigtop input[name=cname]").val()),
                },
                page: {
                    curr: 1
                }
            });
        });
    }
</script>
<form class="layui-form" hidden="hidden" id="addDeli" style="padding-top: 20px;">
    <div class="layui-form-item">
        <label class="layui-form-label">站点名称</label>
        <div class="layui-input-inline">
            <input type="text" name="dname" maxlength="11" required lay-verify="required"
                   placeholder="请输入站点名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">站点地址</label>
        <div class="layui-input-block">
            <select name="provinceid" lay-verify="required" lay-filter="prov"> </select>
            <select name="cityid" lay-verify="required"> </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">联系电话</label>
        <div class="layui-input-inline">
            <input type="text" name="tel" maxlength="11" required lay-verify="required" placeholder="请输入联系电话"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">首公斤范围</label>
        <div class="layui-input-inline">
            <input type="text" name="startscope" maxlength="11" required lay-verify="required"
                   placeholder="请输入首公斤范围（Kg）"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">首公斤价格</label>
        <div class="layui-input-inline">
            <input type="text" name="startprice" maxlength="11" required lay-verify="required"
                   placeholder="请输入首公斤价格（￥）"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">次公斤价格</label>
        <div class="layui-input-inline">
            <input type="text" name="secondprice" maxlength="11" required lay-verify="required"
                   placeholder="请输入次公斤价格系数（￥）"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">首体积范围</label>
        <div class="layui-input-inline">
            <input type="text" name="startvolumescope" maxlength="11" required lay-verify="required"
                   placeholder="请输入首体积范围（立方米）"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">首体积价格</label>
        <div class="layui-input-inline">
            <input type="text" name="startvolumeprice" maxlength="11" required lay-verify="required"
                   placeholder="请输入首体积价格（￥）"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">次体积价格</label>
        <div class="layui-input-inline">
            <input type="text" name="secondvdlumeprice" maxlength="11" required lay-verify="required"
                   placeholder="请输入次体积价格系数（￥）"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
</form>
<form class="layui-form" hidden="hidden" id="updateDeli" style="padding-top: 20px;">
    <input type="text" name="deliveryspotid" hidden="hidden">
    <input type="text" name="deliveryspotno" hidden="hidden">
    <input type="text" name="empid" hidden="hidden">
    <div class="layui-form-item">
        <label class="layui-form-label">站点名称</label>
        <div class="layui-input-inline">
            <input type="text" name="dname" maxlength="11" required lay-verify="required"
                   placeholder="请输入站点名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">站点地址</label>
        <div class="layui-input-block">
            <select name="provinceid" lay-verify="required" lay-filter="updateprov"> </select>
            <select name="cityid" lay-verify="required"> </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">联系电话</label>
        <div class="layui-input-inline">
            <input type="text" name="tel" maxlength="11" required lay-verify="required" placeholder="请输入联系电话"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">首公斤范围</label>
        <div class="layui-input-inline">
            <input type="text" name="startscope" maxlength="11" required lay-verify="required"
                   placeholder="请输入首公斤范围（Kg）"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">首公斤价格</label>
        <div class="layui-input-inline">
            <input type="text" name="startprice" maxlength="11" required lay-verify="required"
                   placeholder="请输入首公斤价格（￥）"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">次公斤价格</label>
        <div class="layui-input-inline">
            <input type="text" name="secondprice" maxlength="11" required lay-verify="required"
                   placeholder="请输入次公斤价格系数（￥）"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">首体积范围</label>
        <div class="layui-input-inline">
            <input type="text" name="startvolumescope" maxlength="11" required lay-verify="required"
                   placeholder="请输入首体积范围（立方米）"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">首体积价格</label>
        <div class="layui-input-inline">
            <input type="text" name="startvolumeprice" maxlength="11" required lay-verify="required"
                   placeholder="请输入首体积价格（￥）"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">次体积价格</label>
        <div class="layui-input-inline">
            <input type="text" name="secondvdlumeprice" maxlength="11" required lay-verify="required"
                   placeholder="请输入次体积价格系数（￥）"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" hidden="hidden">
        <label class="layui-form-label">是否是有效</label>
        <div class="layui-input-block">
            <input type="radio" name="flag" value="0" title="有效">
            <input type="radio" name="flag" value="1" title="无效"> <!--lay-filter="uismany"-->
        </div>
    </div>
</form>
</body>
</html>
