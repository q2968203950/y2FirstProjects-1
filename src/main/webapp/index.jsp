<%--
  Created by IntelliJ IDEA.
  User: q7240
  Date: 2019/8/21
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="s" uri="/struts-tags" %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>WBG物流管理系统</title>
    <link rel="stylesheet" href="./plugins/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="./plugins/font-awesome/css/font-awesome.min.css" media="all"/>
    <link rel="stylesheet" href="./src/css/app.css" media="all"/>
    <link rel="stylesheet" href="./src/css/themes/default.css" media="all" id="skin" kit-skin/>
</head>

<body class="kit-theme">
<div class="layui-layout layui-layout-admin kit-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">WBG物流管理系统</div>
        <div class="layui-logo kit-logo-mobile"></div>
        <ul class="layui-nav layui-layout-left kit-nav">
            <li class="layui-nav-item"><a href="javascript:;">控制台</a></li>

        </ul>
        <ul class="layui-nav layui-layout-right kit-nav">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <i class="layui-icon">&#xe63f;</i> 皮肤
                </a>
                <dl class="layui-nav-child skin">
                    <dd><a href="javascript:;" data-skin="default" style="color:#393D49;"><i
                            class="layui-icon">&#xe658;</i> 默认</a></dd>
                    <dd><a href="javascript:;" data-skin="orange" style="color:#ff6700;"><i
                            class="layui-icon">&#xe658;</i> 橘子橙</a></dd>
                    <dd><a href="javascript:;" data-skin="green" style="color:#00a65a;"><i
                            class="layui-icon">&#xe658;</i> 原谅绿</a></dd>
                    <dd><a href="javascript:;" data-skin="pink" style="color:#FA6086;"><i
                            class="layui-icon">&#xe658;</i> 少女粉</a></dd>
                    <dd><a href="javascript:;" data-skin="blue.1" style="color:#00c0ef;"><i
                            class="layui-icon">&#xe658;</i> 天空蓝</a></dd>
                    <dd><a href="javascript:;" data-skin="red" style="color:#dd4b39;"><i class="layui-icon">&#xe658;</i>
                        枫叶红</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="img/psb.jpg" class="layui-nav-img">${username}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;" kit-target
                           data-options="{url:'basic.html',icon:'&#xe658;',title:'基本资料',id:'966'}"><span>基本资料</span></a>
                    </dd>
                    <dd><a href="javascript:;">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="login.html" onclick='document.location="sessionInvalidate"'><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black kit-side">
        <div class="layui-side-scroll">
            <div class="kit-side-fold"><i class="fa fa-navicon" aria-hidden="true"></i></div>
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="kitNavbar" kit-navbar>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;"><i class="fa fa-plug" aria-hidden="true"></i><span> 用户管理</span></a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" kit-target
                               data-options="{url:'mains.jsp',icon:'&#xe6c6;',title:'公司结构',id:'1'}">
                                <i class="layui-icon">&#xe6c6;</i><span> 权限管理</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="employee.jsp" data-icon="fa-user" data-title="添加用户" kit-target
                               data-id='2'>
                                <i class="fa fa-user" aria-hidden="true"></i><span> 添加用户</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="/depart" data-icon="&#xe614;" data-title="修改用户信息"
                               kit-target data-id='3'><i class="layui-icon">&#xe614;</i><span> 修改用户信息</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="/depart" data-icon="&#xe614;" data-title="删除用户"
                               kit-target data-id='4'><i class="layui-icon">&#xe614;</i><span> 删除用户</span></a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="fa fa-user" aria-hidden="false"></i><span> 员工管理</span></a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" data-url="vehicle.jsp" data-icon="fa-user" data-title="添加员工信息" kit-target
                               data-id='5'>
                                <i class="fa fa-user" aria-hidden="true"></i><span> 添加员工信息</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="/vehicle" data-icon="&#xe614;" data-title="员工信息修改"
                               kit-target data-id='6'><i class="layui-icon">&#xe614;</i><span> 员工信息修改</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="/vehicle" data-icon="&#xe614;" data-title="员工信息查看"
                               kit-target data-id='7'><i class="layui-icon">&#xe614;</i><span> 员工信息查看</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="/vehicle" data-icon="&#xe614;" data-title="员工离职(加入历史记录)"
                               kit-target data-id='8'><i class="layui-icon">&#xe614;</i><span> 员工离职(加入历史记录)</span></a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="fa fa-plug" aria-hidden="true"></i><span> 车辆管理</span></a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" data-url="route.jsp" data-icon="fa-user" data-title="新购车辆登记" kit-target
                               data-id='9'>
                                <i class="fa fa-user" aria-hidden="true"></i><span> 新购车辆登记</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="/route" data-icon="&#xe614;" data-title="车辆编排"
                               kit-target data-id='10'><i class="layui-icon">&#xe614;</i><span> 车辆编排</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="/route" data-icon="&#xe614;" data-title="车辆状态记录"
                               kit-target data-id='11'><i class="layui-icon">&#xe614;</i><span> 车辆状态记录</span></a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="fa fa-plug" aria-hidden="true"></i><span> 配送点管理</span></a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" data-url="waybill.jsp" data-icon="fa-user" data-title="新增配送点" kit-target
                               data-id='12'>
                                <i class="fa fa-user" aria-hidden="true"></i><span> 新增配送点</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="/waybill" data-icon="&#xe628;" data-title="查看配送点" kit-target
                               data-id='13'><i class="layui-icon">&#xe628;</i><span> 查看配送点</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="/positions" data-icon="&#xe614;" data-title="修改配送点信息"
                               kit-target data-id='14'><i class="layui-icon">&#xe614;</i><span> 修改配送点信息</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="/positions" data-icon="&#xe614;" data-title="删除配送点"
                               kit-target data-id='15'><i class="layui-icon">&#xe614;</i><span> 删除配送点</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="/positions" data-icon="&#xe614;" data-title="配送价格管理"
                               kit-target data-id='16'><i class="layui-icon">&#xe614;</i><span> 配送价格管理</span></a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="fa fa-plug" aria-hidden="true"></i><span>线路管理</span></a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" data-url="form.html" data-icon="fa-user" data-title="配送点线路分配" kit-target
                               data-id='17'>
                                <i class="fa fa-user" aria-hidden="true"></i><span> 配送点线路分配</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="nav.html" data-icon="&#xe628;" data-title="线路查看" kit-target
                               data-id='18'><i class="layui-icon">&#xe628;</i><span> 线路查看</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="list4.html" data-icon="&#xe614;" data-title="线路删除"
                               kit-target data-id='19'><i class="layui-icon">&#xe614;</i><span> 线路删除</span></a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="fa fa-plug" aria-hidden="true"></i><span>订单管理</span></a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" data-url="form.html" data-icon="fa-user" data-title="接收订单" kit-target
                               data-id='20'>
                                <i class="fa fa-user" aria-hidden="true"></i><span> 接收订单</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="nav.html" data-icon="&#xe628;" data-title="更改订单状态" kit-target
                               data-id='21'><i class="layui-icon">&#xe628;</i><span> 更改订单状态</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="list4.html" data-icon="&#xe614;" data-title="按订单号查询订单"
                               kit-target data-id='22'><i class="layui-icon">&#xe614;</i><span> 按订单号查询订单</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="nav.html" data-icon="&#xe628;" data-title="删除订单" kit-target
                               data-id='23'><i class="layui-icon">&#xe628;</i><span> 删除订单</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="list4.html" data-icon="&#xe614;" data-title="交接单管理"
                               kit-target data-id='24'><i class="layui-icon">&#xe614;</i><span> 交接单管理</span></a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="fa fa-plug" aria-hidden="true"></i><span> 信息管理</span></a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" kit-target
                               data-options="{url:'navbar.html',icon:'&#xe658;',title:'Navbar',id:'6'}"><i
                                class="layui-icon">&#xe658;</i><span> Navbar</span></a></dd>
                        <dd><a href="javascript:;" kit-target
                               data-options="{url:'tab.html',icon:'&#xe658;',title:'TAB',id:'7'}"><i class="layui-icon">&#xe658;</i><span> Tab</span></a>
                        </dd>
                        <dd><a href="javascript:;" kit-target
                               data-options="{url:'onelevel.html',icon:'&#xe658;',title:'OneLevel',id:'50'}"><i
                                class="layui-icon">&#xe658;</i><span> OneLevel</span></a></dd>
                        <dd><a href="javascript:;" kit-target
                               data-options="{url:'app.html',icon:'&#xe658;',title:'App',id:'8'}"><i class="layui-icon">&#x<li class="layui-nav-item">-->
                <!--<a href="javascript:;"><i class="fa fa-plug" aria-hidden="true"></i><span> 权限分配</span></a>-->
                <!--<dl class="layui-nav-child">-->
                <!--<dd><a href="javascript:;" kit-target-->
                <!--data-options="{url:'navbar.html',icon:'&#xe658;',title:'Navbar',id:'6'}"><i-->
                <!--class="layui-icon">&#xe658;</i><span> Navbar</span></a></dd>-->
                <!--<dd><a href="javascript:;" kit-target-->
                <!--data-options="{url:'tab.html',icon:'&#xe658;',title:'TAB',id:'7'}"><i class="layui-icon">&#xe658;</i><span> Tab</span></a>-->
                <!--</dd>-->
                <!--<dd><a href="javascript:;" kit-target-->
                <!--data-options="{url:'onelevel.html',icon:'&#xe658;',title:'OneLevel',id:'50'}"><i-->
                <!--class="layui-icon">&#xe658;</i><span> OneLevel</span></a></dd>-->
                <!--<dd><a href="javascript:;" kit-target-->
                <!--data-options="{url:'app.html',icon:'&#xe658;',title:'App',id:'8'}"><i class="layui-icon">&#xe658;</i><span> app.js主入口</span></a>-->
                <!--</dd>-->
                <!--</dl>-->
                <!--</li>e658;</i><span> app.js主入口</span></a>
                        </dd>
                    </dl>
                </li>
                <!---->
            </ul>
        </div>
    </div>
    <div class="layui-body" id="container">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;"><i class="layui-icon layui-anim layui-anim-rotate layui-anim-loop">&#xe63e;</i>
            请稍等...
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        2018 &copy;
        <a href="http://kit.zhengjinfan.cn/">WBG物流管理系统</a>
        <!-- <marquee>WBG物流管理系统</marquee>-->
    </div>
</div>
<!-- <script type="text/javascript">
      var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
      document.write(unescape("%3Cspan id='cnzz_stat_icon_1264021086'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s22.cnzz.com/z_stat.php%3Fid%3D1264021086%26show%3Dpic1' type='text/javascript'%3E%3C/script%3E"));
  </script> -->
<script src="./plugins/layui/layui.js"></script>
<script>
    var message;
    layui.config({
        base: 'src/js/',
        version: '1.0.1'
    }).use(['app', 'message'], function () {
        var app = layui.app,
            $ = layui.jquery,
            layer = layui.layer;
        //将message设置为全局以便子页面调用
        message = layui.message;
        //主入口
        app.set({
            type: 'iframe'
        }).init();
        $('#pay').on('click', function () {
            layer.open({
                title: false,
                type: 1,
                content: '<img src="/src/images/pay.png" />',
                area: ['500px', '250px'],
                shadeClose: true
            });
        });
        $('dl.skin > dd').on('click', function () {
            var $that = $(this);
            var skin = $that.children('a').data('skin');
            switchSkin(skin);
        });
        var setSkin = function (value) {
                layui.data('kit_skin', {
                    key: 'skin',
                    value: value
                });
            },
            getSkinName = function () {
                return layui.data('kit_skin').skin;
            },
            switchSkin = function (value) {
                var _target = $('link[kit-skin]')[0];
                _target.href = _target.href.substring(0, _target.href.lastIndexOf('/') + 1) + value + _target.href.substring(_target.href.lastIndexOf('.'));
                setSkin(value);

            },
            initSkin = function () {
                var skin = getSkinName();
                switchSkin(skin === undefined ? 'default' : skin);
            }();
    });
</script>
</body>
</html>
