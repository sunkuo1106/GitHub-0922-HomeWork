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
    <script type="text/javascript" src="/static/js/jquery-1.8.3.min.js"></script>
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
<div style="margin-left: 450px;margin-top:-200px;width: 800px;height:300px;border: 1px solid red">
<table border="1" style="width: 800px;height: 100px;">
    <tr>
        <td>账户管理列表</td>
    </tr>
    <tr>
        <td>用户名</td>
        <td>昵称</td>
        <td>手机</td>
        <td>地址</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${pageInfo.list}" var="item">
        <tr align="center" style="background-color: silver;">
            <td><img src="/static/uploadfiles/${item.picpath}" style="width: 50px;height: 50px;">
            <span>${item.username}</span>
            </td>
            <td>${item.nickname}</td>
            <td>${item.mobile}</td>
            <td>${item.address}</td>
            <td><a href="javascript:void(0)" onclick="del(${item.id})">删除</a></td>
        </tr>
    </c:forEach>
</table>
    <div style="margin-left:250px;margin-top: 10px;">
        <a href="/toUser?pageNum=${pageInfo.firstPage}">首页</a>
        <c:if test="${pageInfo.hasPreviousPage}">
            <a href="/toUser?pageNum=${pageInfo.prePage}">上一页</a>
        </c:if>
        <c:if test="${pageInfo.hasNextPage}">
            <a href="/toUser?pageNum=${pageInfo.nextPage}">下一页</a>
        </c:if>
        <a href="/toUser?pageNum=${pageInfo.lastPage}">末页</a>
        <span>第${pageInfo.pageNum}页/共${pageInfo.pages}页</span>
    </div>
    <p>
        <input type="button" value="添加数据" class="publish">
    </p>
</div>
<script type="text/javascript">
    $(".publish").click(function () {
        location.href="/toAddUsers";
    })
    function del(id) {
        location.href="/delUsers?id="+id;
    }
</script>
</body>
</html>
