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
            姓名:
            <div class="layui-inline" style="width:190px">
                <input class="layui-input" name="ename" id="ename" autocomplete="off">
            </div>
            配送点:
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
            elem: $("#addDeli select[name=psoitionid]"),
            url: "<%=path%>/pos_findPos.action",
            value: "positidnid",
            text: "pname"
        });
        layui.select.initSelect({
            elem: $("#addDeli select[name=deliveryspotid]"),
            url: "<%=path%>/del_findDelPName.action",
            value: "DELIVERYSPOTID",
            text: "cname"
        });
        //监听工具条
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                layui.select.initSelect({
                    elem: $("#updateDeli select[name=psoitionid]"),
                    url: "<%=path%>/pos_findPos.action",
                    value: "positidnid",
                    text: "pname",
                    selected: data.PSOITIONID
                });
                layui.select.initSelect({
                    elem: $("#updateDeli select[name=deliveryspotid]"),
                    url: "<%=path%>/del_findDelPName.action",
                    value: "DELIVERYSPOTID",
                    text: "cname",
                    selected: data.DELIVERYSPOTID
                });
                $("#updateDeli select[name=psoitionid]").next().find('.layui-anim').children('dd[lay-value="' + data.PSOITIONID + '"]').click();
                $("#updateDeli select[name=deliveryspotid]").next().find('.layui-anim').children('dd[lay-value="' + data.DELIVERYSPOTID + '"]').click();
                $("#updateDeli input[name=empno]").val(data.EMPNO);
                $("#updateDeli input[name=empid]").val(data.EMPID);
                $("#updateDeli input[name=tel]").val(data.TEL);
                $("#updateDeli input[name=ename]").val(data.ENAME);
                var BIRTHDAY = getMyDate(data.BIRTHDAY);
                $("#updateDeli input[name=birthday]").val(BIRTHDAY);
                var STARTWORDTIME = getMyDate(data.STARTWORDTIME);
                $("#updateDeli input[name=startwordtime]").val(STARTWORDTIME);
                $("#updateDeli input[name=cardid]").val(data.CARDID);
                $("#updateDeli input[name=salary]").val(data.SALARY);
                $("#updateDeli input[name=address]").val(data.ADDRESS);
                $("#updateDeli input[name=email]").val(data.EMAIL);
                $('#updateDeli input[name=genoer]').each(function (i, item) {
                    if ($(item).val() == data.GENOER) {
                        $("#updateDeli input[name=genoer][value=" + data.GENOER + "]").prop('checked', true);
                        form.render();
                    }
                });
                update(data.DELIVERYSPOTID);
            } else if (obj.event === 'del') {
                delet(data.EMPID);
            }
        });
        table.on("toolbar(demo)", function (object) {
            if (object.event == 'add') {
                add();
            }
        });
        //进行渲染
        xrsj("emp_findEmp.action");
        //日期渲染
        laydate.render({
            elem: "#birthday_Date"
        });
        laydate.render({
            elem: "#startwordtime_Date"
        });
        laydate.render({
            elem: "#update_birthday_Date"
        });
        laydate.render({
            elem: "#update_startwordtime_Date"
        });

        //模糊查询
        $("#nosele").click(function () {
            xrsj("emp_findEmp.action?ename=" + $(".rigtop input[name=ename]").val() + "&cname=" + $.trim($(".rigtop input[name=cname]").val()));
        })
    });
</script>
<script>

    function getMyDate(str) {
        var oDate = new Date(str),
            oYear = oDate.getFullYear(),
            oMonth = oDate.getMonth() + 1,
            oDay = oDate.getDate(),
            oTime = oYear + '-' + getzf(oMonth) + '-' + getzf(oDay);//最后拼接时间
        return oTime;
    };

    //补0操作
    function getzf(num) {
        if (parseInt(num) < 10) {
            num = '0' + num;
        }
        return num;
    }

    function add() {
        layer.open({
            type: 1
            , title: "添加员工信息"
            , content: $("#addDeli")
            , area: ['400px', '530px']
            , btn: ['添加', '取消'] //只是为了演示
            , success: function (layero, index) {
                $('#addDeli input').each(function (i, item) {
                    if (i == '1' | i == '2') {
                        $("#addDeli input[name=genoer][value='0']").prop('checked', true);
                    } else {
                        $(item).val("");
                    }
                });
                layero.addClass("layui-form");
                layero.find(".layui-layer-btn0").attr("lay-filter", "add").attr("lay-submit", "");
                form.render();
                layui.select.initSelect({
                    elem: $("#addDeli select[name=psoitionid]"),
                    url: "<%=path%>/pos_findPos.action",
                    value: "positidnid",
                    text: "pname"
                });
                layui.select.initSelect({
                    elem: $("#addDeli select[name=deliveryspotid]"),
                    url: "<%=path%>/del_findDelPName.action",
                    value: "DELIVERYSPOTID",
                    text: "cname"
                });
            }
            , yes: function (layero, index) {
                form.on('submit(add)', function (data) {
                    $.ajax({
                        type: "post"
                        , url: "/emp_addPos.action"
                        , dataType: 'json'
                        //, contentType: 'application/json;charset=utf-8'
                        , data: {
                            ename: $("#addDeli input[name=ename]").val(),
                            genoer: $("#addDeli input[name=genoer]:checked").val(),
                            birthday: $("#addDeli input[name=birthday]").val(),
                            address: $("#addDeli input[name=address]").val(),
                            tel: $("#addDeli input[name=tel]").val(),
                            startwordtime: $("#addDeli input[name=startwordtime]").val(),
                            salary: $("#addDeli input[name=salary]").val(),
                            email: $("#addDeli input[name=email]").val(),
                            cardid: $("#addDeli input[name=cardid]").val(),
                            psoitionid: $("#addDeli select[name=psoitionid]").val(),
                            deliveryspotid: $("#addDeli select[name=deliveryspotid]").val(),
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
            , title: "编辑员工信息"
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
                        enames: $("#updateDeli input[name=ename]").val(),
                        tel: $("#updateDeli input[name=tel]").val(),
                        birthday: $("#updateDeli input[name=birthday]").val(),
                        startwordtime: $("#updateDeli input[name=startwordtime]").val(),
                        cardid: $("#updateDeli input[name=cardid]").val(),
                        salary: $("#updateDeli input[name=salary]").val(),
                        address: $("#updateDeli input[name=address]").val(),
                        email: $("#updateDeli input[name=email]").val(),
                        genoer: $("#updateDeli input[name=genoer]:checked").val(),
                        psoitionid: $("#updateDeli select[name=psoitionid]").val(),
                        deliveryspotid: $("#updateDeli select[name=deliveryspotid]").val(),
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
                , {field: 'EMPID', title: 'ID', align: 'center', hide: true}
                , {field: 'EMPNO', title: '编号', align: 'center'}
                , {field: 'ENAME', title: '名称', align: 'center'}
                , {
                    field: 'GENOER', title: '性别', align: 'center', templet: function (d) {
                        if (d.GENOER == 0) {
                            return '男';
                        }
                        return '女';
                    }
                }
                , {
                    field: 'BIRTHDAY',
                    title: '生日',
                    align: 'center',
                    templet: "<div>{{layui.util.toDateString(d.BIRTHDAY,'yyyy-MM-dd')}}</div>"
                }
                , {field: 'ADDRESS', title: '地址', align: 'center'}
                , {field: 'TEL', title: '电话号码', align: 'center'}
                , {
                    field: 'STARTWORDTIME',
                    title: '入职时间',
                    align: 'center',
                    templet: "<div>{{layui.util.toDateString(d.STARTWORDTIME,'yyyy-MM-dd')}}</div>"
                }
                , {field: 'EMAIL', title: '邮箱', align: 'center'}
                , {field: 'CARDID', title: '身份证号码', align: 'center'}
                , {field: 'SALARY', title: '工资', align: 'center'}
                , {field: 'PSOITIONID', title: '职位ID', align: 'center', hide: true}
                , {field: 'pname', title: '职位', align: 'center'}
                , {field: 'DELIVERYSPOTID', title: '配送点ID', align: 'center', hide: true}
                , {field: 'cname', title: '所属配送点', align: 'center'}
                , {
                    field: 'FLAG', title: '是否在职', align: 'center', templet: function (d) {
                        if (d.FLAG == 0) {
                            return '<a class="layui-btn layui-btn-xs" >在职</a>';
                        }
                        return '<a class="layui-btn layui-btn-danger layui-btn-xs">离职</a>';
                    }
                }
                , {fixed: 'right', title: '操作', width: '178', align: 'center', toolbar: '#barDemo'}
            ]]
            , id: "idsw"
            , initSort: {
                field: 'EMPID' //排序字段，对应 cols 设定的各字段名
                , type: 'desc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
            }
        });
    }
</script>
<form class="layui-form" hidden="hidden" id="addDeli" style="padding-top: 20px;">
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="ename" maxlength="11" required lay-verify="required"
                   placeholder="请输入姓名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="radio" name="genoer" value="0" title="男">
            <input type="radio" name="genoer" value="1" title="女">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">生日</label>
            <div class="layui-input-inline">
                <input type="text" name="birthday" id="birthday_Date" lay-verify="date" placeholder="yyyy-MM-dd"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">入职日期</label>
            <div class="layui-input-inline">
                <input type="text" name="startwordtime" id="startwordtime_Date" lay-verify="date"
                       placeholder="yyyy-MM-dd"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">身份证号码</label>
        <div class="layui-input-inline">
            <input type="text" name="cardid" maxlength="18" required lay-verify="required"
                   placeholder="请输入身份证号码"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">电话号码</label>
        <div class="layui-input-inline">
            <input type="text" name="tel" maxlength="11" required lay-verify="required"
                   placeholder="请输入电话号码"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">职位</label>
        <div class="layui-input-block">
            <select name="psoitionid" lay-verify="required" lay-filter="addprov"> </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">工资</label>
        <div class="layui-input-inline">
            <input type="text" name="salary" maxlength="11" required lay-verify="required"
                   placeholder="请输入工资"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">地址</label>
        <div class="layui-input-inline">
            <input type="text" name="address" required lay-verify="required"
                   placeholder="请输入地址"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-inline">
            <input type="text" name="email" required lay-verify="required"
                   placeholder="请输入邮箱"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">所属配送点</label>
        <div class="layui-input-block">
            <select name="deliveryspotid" lay-verify="required" lay-filter="addprov1"> </select>
        </div>
    </div>
</form>
<form class="layui-form" hidden="hidden" id="updateDeli" style="padding-top: 20px;">
    <input type="text" name="empno" hidden="hidden">
    <input type="text" name="empid" hidden="hidden">
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="ename" maxlength="11" required lay-verify="required"
                   placeholder="请输入姓名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="radio" name="genoer" value="0" title="男">
            <input type="radio" name="genoer" value="1" title="女">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">生日</label>
            <div class="layui-input-inline">
                <input type="text" name="birthday" id="update_birthday_Date" lay-verify="date" placeholder="yyyy-MM-dd"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">入职日期</label>
            <div class="layui-input-inline">
                <input type="text" name="startwordtime" id="update_startwordtime_Date" lay-verify="date"
                       placeholder="yyyy-MM-dd"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">身份证号码</label>
        <div class="layui-input-inline">
            <input type="text" name="cardid" maxlength="18" required lay-verify="required"
                   placeholder="请输入身份证号码"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">电话号码</label>
        <div class="layui-input-inline">
            <input type="text" name="tel" maxlength="11" required lay-verify="required"
                   placeholder="请输入电话号码"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">职位</label>
        <div class="layui-input-block">
            <select name="psoitionid" lay-verify="required" lay-filter="addprov"> </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">工资</label>
        <div class="layui-input-inline">
            <input type="text" name="salary" maxlength="11" required lay-verify="required"
                   placeholder="请输入工资"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">地址</label>
        <div class="layui-input-inline">
            <input type="text" name="address" required lay-verify="required"
                   placeholder="请输入地址"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-inline">
            <input type="text" name="email" required lay-verify="required"
                   placeholder="请输入邮箱"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">所属配送点</label>
        <div class="layui-input-block">
            <select name="deliveryspotid" lay-verify="required" lay-filter="addprov1"> </select>
        </div>
    </div>
</form>
</body>
</html>
