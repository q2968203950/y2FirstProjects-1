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
            height: 60px;
            border: 1px solid #b7d5df;
            line-height: 60px;
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
            width: 100px;
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

        .layui-laydate, .layui-laydate-main, .layui-laydate-header, .layui-laydate-content {
            width: 250px;
        }

        .layui-laydate-content table {
            width: 100%;
        }
    </style>
</head>
<body>

<div class="rigtop">
    <div class="layui-form-item layui-form layui-col-md-offset2">
        <div class="layui-inline">
            订单号:
            <div class="layui-inline" style="width:190px">
                <input class="layui-input" name="orderno" id="orderno" autocomplete="off">
            </div>
            状态:
            <div class="layui-inline" style="width:190px;margin-top: 2%">
                <select name="orderstateid" lay-verify="required">
                </select>
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
            elem: $(".rigtop select[name=orderstateid]"),
            url: "<%=path%>/ord_findState.action",
            value: "ORDERSTATEID",
            text: "ONAME"
        });
        setTimeout(function () {
            $(".rigtop select[name=orderstateid]").prepend('<option value="0" selected="selected">所有</option>');
        }, 500)

        <%--layui.select.initSelect({--%>
        <%--elem: $("#addDeli select[name=deliveryspotid]"),--%>
        <%--url: "<%=path%>/del_findDelPName.action",--%>
        <%--value: "DELIVERYSPOTID",--%>
        <%--text: "cname"--%>
        <%--});--%>
        //监听工具条
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {

            } else if (obj.event === 'del') {
                delet(data.EMPID);
            } else if (obj.event === 'zc') {
                layui.select.initSelect({
                    elem: $("#updateDeli select[name=empid]"),
                    url: "<%=path%>/emp_findPname.action?deliveryspotidsss=" + data.DELIVERYSPOTID,
                    value: "EMPID",
                    text: "ENAME"
                });
                setTimeout(function () {
                    $("#updateDeli select[name=empid]").next().find('.layui-anim').children('dd').each(function (i, item) {
                        if (i == 0) {
                            var valC = $(this).attr('lay-value');
                            $.ajax({
                                type: "post"
                                , url: "/rec_findCarno.action"
                                , dataType: 'json'
                                //, contentType: 'application/json;charset=utf-8'
                                , data: {
                                    empid: valC
                                }
                                , success: function (data) {
                                    $("#updateDeli input[name=carno]").val(data[0].CARNO);
                                }
                            });
                        }
                    });
                }, 300)
                $("#updateDeli input[name=deliveryspotid]").val(data.DELIVERYSPOTID);
                $("#updateDeli input[name=orderid]").val(data.ORDERID);
                $("#updateDeli input[name=orderno]").val(data.ORDERNO);
                update(data.DELIVERYSPOTID);
            }
        });
        table.on("toolbar(demo)", function (object) {
            if (object.event == 'add') {
                add();
            }
        });
        var deliveryspotid = ${sessionScope.users.deliveryspotid};
        //进行渲染
        xrsj("ord_findOrd.action?deliveryspotid=" + deliveryspotid);

        //模糊查询
        $("#nosele").click(function () {
            xrsj("ord_findOrd.action?deliveryspotid=" + deliveryspotid + "&orderno=" + $.trim($(".rigtop input[name=orderno]").val()) + "&orderstateid=" + $.trim($(".rigtop select[name=orderstateid]").val()));
        })

        //双击行事件
        table.on('rowDouble(demo)', function (obj) {
            var data = obj.data;
            layer.open({
                type: 1
                , title: "订单信息"
                , content: $("#selectDeli")
                , area: ['650px', '450px']
                , success: function (layero, index) {
                    $.ajax({
                        type: "post"
                        , url: "/ord_findOrdOne.action"
                        , dataType: 'json'
                        //, contentType: 'application/json;charset=utf-8'
                        , data: {
                            orderid: data.ORDERID
                        }
                        , success: function (data) {
                            alert(data);
                        }
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

    function add() {
        layer.open({
            type: 1
            , title: "添加订单信息"
            , content: $("#addDeli")
            , area: ['650px', '450px']
            , btn: ['添加', '取消'] //只是为了演示
            , success: function (layero, index) {
                $('#addDeli input').each(function (i, item) {
                    $(item).val("");
                });
                $("#addDeli textarea[name=remark]").val("");
                layero.addClass("layui-form");
                layero.find(".layui-layer-btn0").attr("lay-filter", "add").attr("lay-submit", "");
                form.render();
            }
            , yes: function (layero, index) {
                form.on('submit(add)', function (data) {
                    $.ajax({
                        type: "post"
                        , url: "/ord_addOrd.action"
                        , dataType: 'json'
                        //, contentType: 'application/json;charset=utf-8'
                        , data: {
                            deliveryspotids: ${sessionScope.users.deliveryspotid},
                            sendname: $("#addDeli input[name=sendname]").val(),
                            receivename: $("#addDeli input[name=receivename]").val(),
                            sendaddress: $("#addDeli input[name=sendaddress]").val(),
                            receiveaddress: $("#addDeli input[name=receiveaddress]").val(),
                            sendtel: $("#addDeli input[name=sendtel]").val(),
                            receivetel: $("#addDeli input[name=receivetel]").val(),
                            sendmobtle: $("#addDeli input[name=sendmobtle]").val(),
                            receivemodile: $("#addDeli input[name=receivemodile]").val(),
                            sendpostcode: $("#addDeli input[name=sendpostcode]").val(),
                            receivepostcode: $("#addDeli input[name=receivepostcode]").val(),
                            weight: $("#addDeli input[name=weight]").val(),
                            volume: $("#addDeli input[name=volume]").val(),
                            goodsprice: $("#addDeli input[name=goodsprice]").val(),
                            remark: $("#addDeli textarea[name=remark]").val()
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
            , title: "编辑订单状态"
            , content: $("#updateDeli")
            , area: ['400px', '530px']
            , btn: ['修改', '取消'] //只是为了演示
            , success: function (layero, index) {
                $("#updateDeli input[name=carno]").val("");
                form.on('select(nameprov)', function (data) {
                    $.ajax({
                        type: "post"
                        , url: "/rec_findCarno.action"
                        , dataType: 'json'
                        //, contentType: 'application/json;charset=utf-8'
                        , data: {
                            empid: data.value
                        }
                        , success: function (data) {
                            if (data != null && data != "") {
                                $("#updateDeli input[name=carno]").val(data[0].CARNO);
                            } else {
                                $("#updateDeli input[name=carno]").val("");
                            }
                        }
                    });
                });
                layero.addClass("layui-form");
                layero.find(".layui-layer-btn0").attr("lay-filter", "add").attr("lay-submit", "");
                form.render();
            }
            , yes: function () {
                $.ajax({
                    type: "post"
                    , url: "/rec_addRec.action"
                    , dataType: 'json'
                    , data: {
                        carno: $("#updateDeli input[name=carno]").val(),
                        deliveryspotid: $("#updateDeli input[name=deliveryspotid]").val(),
                        empids: $("#updateDeli select[name=empid]").val(),
                        remark: $("#updateDeli textarea[name=remark]").val(),
                        flag: 0,
                        ptyoe: $("#updateDeli select[name=ptyoe]").val(),
                        orderid: $("#updateDeli input[name=orderid]").val()
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

    function delet(EMPID) {
        layer.confirm('您是否要删除？', {
            btn: ['删除', '取消'] //按钮
        }, function () {
            $.ajax({
                type: "post"
                , url: "/emp_deletePos.action"
                , dataType: 'json'
                , data: {
                    empid: EMPID
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

    /*function updateState(DELIVERYSPOTID) {
        layer.open({
            type: 1
            , title: "编辑订单状态"
            , content: $("#updateDeli")
            , area: ['400px', '530px']
            , btn: ['修改', '取消'] //只是为了演示
            , success: function (layero, index) {
                layero.addClass("layui-form");
                layero.find(".layui-layer-btn0").attr("lay-filter", "add").attr("lay-submit", "");
                form.render();
            }
            , yes: function () {
                $.ajax({
                    type: "post"
                    , url: "/emp_updatePos.action"
                    , dataType: 'json'
                    , data: {
                        empno: $("#updateDeli input[name=empno]").val(),
                        enames: $("#updateDeli input[name=ename]").val()
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
    }*/

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
            , url: "/" + url//数据接口
            , cellMinWidth: 155
            , toolbar: "default"
            , cols: [[ //表头
                {type: 'numbers', title: '序号'}
                , {field: 'ORDERID', title: 'ID', align: 'center', hide: true}
                , {field: 'ORDERNO', title: '编号', align: 'center'}
                , {field: 'SENDNAME', title: '寄件人姓名', align: 'center'}
                , {field: 'SENDADDRESS', title: '寄件人地址', align: 'center'}
                , {field: 'RECEIVENAME', title: '收件人姓名', align: 'center'}
                , {field: 'RECEIVEADDRESS', title: '收件人地址', align: 'center'}
                , {
                    field: 'ORDERSTATEID', title: '状态', align: 'center', templet: function (d) {
                        if (d.oname == '未处理') {
                            return '<a class="layui-btn layui-btn-xs" >未处理</a>';
                        } else if (d.oname == '运输中') {
                            return '<a class="layui-btn layui-btn-xs" >运输中</a>';
                        } else if (d.oname == '投递中') {
                            return '<a class="layui-btn layui-btn-xs" >投递中</a>';
                        } else if (d.oname == '已完成') {
                            return '<a class="layui-btn layui-btn-xs" >已完成</a>';
                        }
                        return '<a class="layui-btn layui-btn-danger layui-btn-xs">失效</a>';
                    }
                }, {field: 'DELIVERYSPOTID', title: '配送点ID', align: 'center', hide: true}
                , {
                    fixed: 'right',
                    title: '操作',
                    width: '178',
                    align: 'center',
                    templet: function (d) {
                        if (d.oname == '未处理') {
                            return '<a class="layui-btn layui-btn-xs" lay-event="zc" >装车</a>';
                        } else if (d.oname == '运输中') {
                            return '<a class="layui-btn layui-btn-xs" lay-event="xc">卸车</a>';
                        } else if (d.oname == '投递中') {
                            return '<a class="layui-btn layui-btn-xs" lay-event="qs">签收</a>';
                        } else if (d.oname == '已完成') {
                            return '<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="sc">删除</a>';
                        }
                    }
                }
            ]]
            , id: "idsw"
        });
    }
</script>
<form class="layui-form" hidden="hidden" id="addDeli" style="padding-top: 20px;">
    <div class="layui-form-item">
        <label class="layui-form-label">发件人</label>
        <div class="layui-input-inline">
            <input type="text" name="sendname" maxlength="11" required lay-verify="required" placeholder="请输入发件人姓名"
                   autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">收件人</label>
        <div class="layui-input-inline">
            <input type="text" name="receivename" maxlength="11" required lay-verify="required" placeholder="请输入收件人姓名"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">发件地址</label>
        <div class="layui-input-inline">
            <input type="text" name="sendaddress" maxlength="30" required lay-verify="required" placeholder="请输入发件地址"
                   autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">收件地址</label>
        <div class="layui-input-inline">
            <input type="text" name="receiveaddress" maxlength="30" required lay-verify="required" placeholder="请输入收件地址"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">固定电话</label>
        <div class="layui-input-inline">
            <input type="text" name="sendtel" maxlength="11" required lay-verify="" placeholder="请输入发件人固定电话"
                   autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">固定电话</label>
        <div class="layui-input-inline">
            <input type="text" name="receivetel" maxlength="11" required lay-verify="" placeholder="请输入收件人固定电话"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号码</label>
        <div class="layui-input-inline">
            <input type="text" name="sendmobtle" maxlength="11" required lay-verify="required" placeholder="请输入发件人手机号码"
                   autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">手机号码</label>
        <div class="layui-input-inline">
            <input type="text" name="receivemodile" maxlength="11" required lay-verify="required"
                   placeholder="请输入收件人手机号码"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮编</label>
        <div class="layui-input-inline">
            <input type="text" name="sendpostcode" maxlength="11" required lay-verify="required" placeholder="请输入发件人邮编"
                   autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">邮编</label>
        <div class="layui-input-inline">
            <input type="text" name="receivepostcode" maxlength="11" required lay-verify="required"
                   placeholder="请输入收件人邮编"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">重量</label>
        <div class="layui-input-inline">
            <input type="text" name="weight" maxlength="11" required lay-verify="required" placeholder="请输入重量"
                   autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">体积</label>
        <div class="layui-input-inline">
            <input type="text" name="volume" maxlength="11" required lay-verify="required" placeholder="请输入体积"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">物品估价</label>
        <div class="layui-input-inline">
            <input type="text" name="goodsprice" maxlength="11" required lay-verify="required" placeholder="请输入物品估价"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <label class="layui-form-label">备注明细</label>
    <div class="layui-input-inline">
        <textarea name="remark" cols="66" required lay-verify="required" placeholder="请输入货物明细"
                  class="layui-textarea"></textarea>
    </div>
</form>
<form class="layui-form" hidden="hidden" id="selectDeli" style="padding-top: 20px;">
    <div class="layui-form-item">
        <label class="layui-form-label">发件人</label>
        <div class="layui-input-inline">
            <input type="text" name="sendname" maxlength="11" required lay-verify="required" placeholder="请输入发件人姓名"
                   autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">收件人</label>
        <div class="layui-input-inline">
            <input type="text" name="receivename" maxlength="11" required lay-verify="required" placeholder="请输入收件人姓名"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">发件地址</label>
        <div class="layui-input-inline">
            <input type="text" name="sendaddress" maxlength="30" required lay-verify="required" placeholder="请输入发件地址"
                   autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">收件地址</label>
        <div class="layui-input-inline">
            <input type="text" name="receiveaddress" maxlength="30" required lay-verify="required" placeholder="请输入收件地址"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">固定电话</label>
        <div class="layui-input-inline">
            <input type="text" name="sendtel" maxlength="11" required lay-verify="" placeholder="请输入发件人固定电话"
                   autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">固定电话</label>
        <div class="layui-input-inline">
            <input type="text" name="receivetel" maxlength="11" required lay-verify="" placeholder="请输入收件人固定电话"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号码</label>
        <div class="layui-input-inline">
            <input type="text" name="sendmobtle" maxlength="11" required lay-verify="required" placeholder="请输入发件人手机号码"
                   autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">手机号码</label>
        <div class="layui-input-inline">
            <input type="text" name="receivemodile" maxlength="11" required lay-verify="required"
                   placeholder="请输入收件人手机号码"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮编</label>
        <div class="layui-input-inline">
            <input type="text" name="sendpostcode" maxlength="11" required lay-verify="required" placeholder="请输入发件人邮编"
                   autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">邮编</label>
        <div class="layui-input-inline">
            <input type="text" name="receivepostcode" maxlength="11" required lay-verify="required"
                   placeholder="请输入收件人邮编"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">重量</label>
        <div class="layui-input-inline">
            <input type="text" name="weight" maxlength="11" required lay-verify="required" placeholder="请输入重量"
                   autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">体积</label>
        <div class="layui-input-inline">
            <input type="text" name="volume" maxlength="11" required lay-verify="required" placeholder="请输入体积"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">物品估价</label>
        <div class="layui-input-inline">
            <input type="text" name="goodsprice" maxlength="11" required lay-verify="required" placeholder="请输入物品估价"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <label class="layui-form-label">备注明细</label>
    <div class="layui-input-inline">
        <textarea name="remark" cols="66" required lay-verify="required" placeholder="请输入货物明细"
                  class="layui-textarea"></textarea>
    </div>
</form>
<form class="layui-form" hidden="hidden" id="updateDeli" style="padding-top: 20px;">
    <input type="text" name="orderid" hidden="hidden"/>
    <input type="text" name="deliveryspotid" hidden="hidden"/>
    <div class="layui-form-item">
        <label class="layui-form-label">条形码</label>
        <div class="layui-input-inline">
            <input type="text" name="orderno" readonly="readonly" maxlength="18" required lay-verify="required"
                   placeholder="请输入条形码"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">接收人姓名</label>
        <div class="layui-input-inline">
            <select name="empid" lay-verify="required" lay-filter="nameprov"> </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">接收种类</label>
        <select name="ptyoe" lay-verify="required">
            <option value="装车">装车</option>
            <option value="卸车">卸车</option>
        </select>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">车号</label>
        <div class="layui-input-inline">
            <input type="text" name="carno" readonly="readonly" maxlength="18" required lay-verify="required"
                   placeholder="请输入车号"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <label class="layui-form-label">备注</label>
    <div class="layui-input-inline">
        <textarea name="remark" cols="22" required placeholder="请输入备注"
                  class="layui-textarea"></textarea>
    </div>
</form>
</body>
</html>
