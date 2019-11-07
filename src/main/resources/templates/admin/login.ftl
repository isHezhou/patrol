<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>伽罗文化后台管理系统-登录</title>

    <#assign adminTemplate = "adminLogin" />
    <#include "../_common_css.ftl" />
</head>

<body class="gray-bg">
    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <h1 class="logo-name" style="font-size: 60px;">巡查</h1>
        </div>
        <h3>管理系统</h3>
        <form class="m-t">
            <div class="form-group">
                <input name="account" type="text" class="form-control" placeholder="用户名" tag="param">
            </div>
            <div class="form-group">
                <input name="password" type="password" class="form-control" placeholder="密码" tag="param">
            </div>
            <a class="btn btn-primary block full-width m-b vip-login-submit">登 录</a>
        </form>
    </div>
</body>

<#include "../_common_js.ftl" />

</html>
