<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/9/27
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书借阅系统</title>
</head>
<body>
<center>
    <form action="/login" method="post">
          <h1 style="margin-top: 100px">图书借阅系统</h1>
        <p>
            <a>登录账号：</a>
            <input type="text" name="username">
        </p>
        <p>
            <a>登录密码：</a>
            <input type="text" name="password">
        </p>
        <p>
            <input type="submit" value="登录">
            &nbsp;&nbsp;&nbsp;
            <button>注册用户</button>
        </p>
        <p><a style="color: red">${msg}</a></p>
    </form>
</center>
</body>
</html>
