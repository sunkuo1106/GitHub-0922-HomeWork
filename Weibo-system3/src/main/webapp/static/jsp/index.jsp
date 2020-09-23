<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/9/22
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>微博信息管理系统</title>
    <script type="text/javascript" src="/static/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<center>
    <p>
        用 户:<input type="text" id="username" name="username">
    </p>
    <p>
        密 码:<input type="password" id="password" name="password">
    </p>
    <p>
        <input type="button" value="登录" id="login">
    </p>
    <p>
        <span style="color: red" class="msg"></span>
    </p>
</center>
<script type="text/javascript">
    $(document).ready(function () {
        $("#username").blur(function () {
            var username=$("[name='username']").val();
            if(username==""){
                $(".msg").text("用户名不能为空!");
                return;
            }else{
                $(".msg").text("");
            }
        })
        $("#password").blur(function () {
            var password=$("[name='password']").val();
            if(password==""){
                $(".msg").text("密码不能为空!");
                return;
            }else{
                $(".msg").text("");
            }
        })
        $("#login").click(function () {
            var username=$("[name='username']").val();
            var password=$("[name='password']").val();
            var json={
                username:username,
                password:password
            }
            $.post("/doLogin",json,function (result) {
                if(result.status==true){
                    location.href="/toblog";
                }else{
                    $(".msg").text(result.error);
                }
            },"json")
        })
    })
</script>
</body>
</html>
