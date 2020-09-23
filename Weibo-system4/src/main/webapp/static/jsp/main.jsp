<%--
  Created by IntelliJ IDEA.
  User: LHX
  Date: 2020/9/23
  Time: 16:44
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
    <span style="margin-left: 60px;">${user.username}&nbsp;你好！欢迎访问微博信息管理系统</span><a style="margin-left: 1000px;" href="/zhuxiao">注销</a>
</p>
<div>
    <p>
        <a href="/toblog">微博管理</a>
    </p>
    <p>
        <a href="/toUser">账户管理</a>
    </p>
</div>
<table border="1px">
    <tr>
        <td colspan="4">微博首页</td>
    </tr>
    <c:forEach items="${pageInfo.list}" var="item">
        <tr>
            <td><img src="/static/uploadfiles/${item.picpath}" style="width: 50px;height: 50px;"></td>
            <td>${item.content}</td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.publishtime}" type="both"/></td>
            <td><a href="/delBlog?id=${item.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
<div style="margin-left:110px;margin-top: 10px;">
    <a href="/toblog?pageNum=${pageInfo.firstPage}">首页</a>
    <c:if test="${pageInfo.hasPreviousPage}">
        <a href="/toblog?pageNum=${pageInfo.prePage}">上一页</a>
    </c:if>
    <c:if test="${pageInfo.hasNextPage}">
        <a href="/toblog?pageNum=${pageInfo.nextPage}">下一页</a>
    </c:if>
    <a href="/toblog?pageNum=${pageInfo.lastPage}">末页</a>
    <span>第${pageInfo.pageNum}页/共${pageInfo.pages}页</span>
</div>
<p>
    <input type="button" value="发表微博" id="publish">
</p>
</div>
<script type="text/javascript">
    $("#publish").click(function () {
        location.href="/zhuxiao";
    })
</script>
</body>
</html>
