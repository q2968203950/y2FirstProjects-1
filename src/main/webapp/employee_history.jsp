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
<div class="rigbody">
    <table id="demo" lay-filter="demo"></table>
</div>
<script src="js/jquery.js"></script>
<script src="./plugins/layui/layui.js"></script>
<script>
    var table = null;
    layui.use(["table"], function () {
        table = layui.table;
        //进行渲染
        xrsj("emp_findEmpHis.action");
    });
</script>
<script>

    function xrsj(url) {
        table.render({
            elem: '#demo'
            , height: 451
            , page: true
            , url: "/" + url //数据接口
            , cellMinWidth: 130
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
            ]]
            , id: "idsw"
            , initSort: {
                field: 'EMPID' //排序字段，对应 cols 设定的各字段名
                , type: 'desc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
            }
        });
    }
</script>
</body>
</html>
