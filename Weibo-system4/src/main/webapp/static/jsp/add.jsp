<%--
  Created by IntelliJ IDEA.
  User: LHX
  Date: 2020/9/23
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>微博信息管理系统</title>
    <script type="text/javascript" src="/static/js/jquery-1.12.4.js"></script>
</head>
<body>
<p>
    <span style="margin-left: 60px;">${user.username}&nbsp;你好！欢迎访问微博信息管理系统</span><a style="margin-left: 1000px;" href="">注销</a>
</p>
<div>
    <p>
        <a href="/toblog">微博管理</a>
    </p>
    <p>
        <a href="/toUser">账户管理</a>
    </p>
</div>
<form action="/doBlogAdd" method="post">
    <p>
        微博内容：
        <textarea rows="10" cols="40" name="content"></textarea>
    </p>
    <p><input type="submit" value="保存数据">
        <input type="button" value="返回" onclick="back()">
    </p>
</form>
<script type="text/javascript">
    function back() {
        location.href="javascript:history.back()";
    }
</script>
</body>
</html>

