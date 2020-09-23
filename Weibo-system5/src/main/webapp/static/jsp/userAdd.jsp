<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/9/22
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>微博信息管理系统</title>
    <script type="text/javascript" src="/static/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<p>
    <span style="margin-left: 60px;">${users.username}&nbsp;你好！欢迎访问微博信息管理系统</span><a style="margin-left: 1000px;" href="/zhuxiao">注销</a>
</p>
<div style="margin-left: 60px;margin-top:60px;width: 300px;height:200px;border: 1px solid red">
<p align="center" style="margin-top: 50px;">
    <a href="/toblog">微博管理</a>
</p>
    <p align="center" style="margin-top: 30px;">
        <a href="/toUser">账户管理</a>
    </p>
</div>
<form method="post" action="/doAddUsers" enctype="multipart/form-data">
<div style="margin-left: 450px;margin-top:-200px;width: 800px;height:400px;border: 1px solid red">
    <table border="1" style="width: 800px;height: 30px;">
        <tr>
            <td>添加账号</td>
        </tr>
    </table>
    <p align="center">用户名:<input type="text" name="username"></p>
    <p align="center">密码:<input type="password" name="password"></p>
    <p align="center">昵称:<input type="text" name="nickname"></p>
    <p align="center">年龄:<input type="text" name="age"></p>
    <p align="center">性别:<select name="sex"><option value="0">请选择</option><option value="1">女</option><option value="2">男</option></select></p>
    <p align="center">手机:<input type="text" name="mobile"></p>
    <p align="center">地址:<input type="text" name="address"></p>
    <p align="center">头像:<input type="file" name="picpathZJH"></p>
    <p align="center">
        <input type="submit" value="保存数据">
        <input type="button" value="返回" onclick="back()">
    </p>
</div>
</form>
<script type="text/javascript">
    function back() {
        location.href="javascript:history.back()";
    }
</script>
</body>
</html>
