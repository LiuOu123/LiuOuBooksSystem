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
<script type="text/javascript" src="/static/js/jquery-3.4.1.min.js"></script>
<script>
    $(function () {
        $("form").submit(function () {
            var username=$("input[name=username]").val();
            var password=$("input[name=password]").val();
            if (username==""){
                alert("输入用户名")
                return false;
            }
            if(username.length<7)
            {
                alert("账号长度不够")
                return false;
            }
            if (password==""){
                alert("输入密码")
                return false;
            }
            if(password.length<6)
            {
                alert("密码长度不够")
                return false;
            }
        })
    })
</script>
</html>
