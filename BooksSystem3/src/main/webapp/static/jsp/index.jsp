<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/9/27
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>图书借阅系统</title>
    <%--<script type="text/javascript" src="/static/js/jquery-3.4.1.min.js"></script>--%>
</head>
<body>
<center>
    <h2>图书借阅系统</h2>
    <form action="/cha" method="post">
        <a>图书分类:</a>
        <select name="lei">
            <option value="0">请选择</option>
            <option value="1">小说</option>
            <option value="2">文学</option>
            <option value="3">传记</option>
            <option value="4">艺术</option>
            <option value="5">少儿</option>
            <option value="6">经济</option>
            <option value="7">管理</option>
            <option value="8">科技</option>
        </select>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a>图书名称:</a>
        <input type="text" name="title">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a>是否借阅</a>
        <select name="jie">
            <option value="10">请选择</option>
            <option value="1">已借阅</option>
            <option value="0">未借阅</option>
        </select>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="hidden" name="pageIndex" value="1" />
        <input type="submit" value="查询">
    </form>
    <p>
        <a style="margin-left: 400px">当前用户:&nbsp;${username}</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        <a href="javascript:void(0)" onclick="tui()">退出</a>
    </p>
    <table border="1px" width="800px">

        <tr style="text-align: center" id="shou">
            <td>图书编号</td>
            <td>图书分类</td>
            <td>图书名称</td>
            <td>作者</td>
            <td>出版社</td>
            <td>操作</td>
        </tr>
        <c:if test="${page.list.size()!=0}">
            <c:forEach items="${page.list}" var="p">
                <tr style="text-align: center" class="bian">
                    <td>${p.bookCode}</td>
                    <td>
                        <c:if test="${p.bookType==1}">
                            <a>小说</a>
                        </c:if>
                        <c:if test="${p.bookType==2}">
                            <a>文学</a>
                        </c:if>
                        <c:if test="${p.bookType==3}">
                            <a>传记</a>
                        </c:if>
                        <c:if test="${p.bookType==4}">
                            <a>艺术</a>
                        </c:if>
                        <c:if test="${p.bookType==5}">
                            <a>少儿</a>
                        </c:if>
                        <c:if test="${p.bookType==6}">
                            <a>经济</a>
                        </c:if>
                        <c:if test="${p.bookType==7}">
                            <a>管理</a>
                        </c:if>
                        <c:if test="${p.bookType==8}">
                            <a>科技</a>
                        </c:if>
                    </td>
                    <td>${p.bookName}</td>
                    <td>${p.bookAtuthor}</td>
                    <td>
                        ${p.publishPress}
                    </td>
                    <td>
                        <c:if test="${p.isBorrow==0}">
                            <a>未借阅</a>
                        </c:if>
                        <c:if test="${p.isBorrow==1}">
                            <a>已借阅</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${page.list.size()==0}">
            <tr>
                <td colspan="6"><a>对不起，没有符合条件查询的结果!</a></td>
            </tr>
        </c:if>

    </table>
<div>
    <a href="/cha?pageNum=${page.firstPage}">首页</a>
<c:if test="${pageInfo.hasPreviousPage}">
    <a href="/cha?pageNum=${page.prePage}">上一页</a>
</c:if>
<c:forEach items="${page.navigatepageNums}" var="i">
    <a href="/cha?pageNum=${i}">${i}</a>
</c:forEach>
<c:if test="${page.hasNextPage}">
    <a href="/cha?pageNum=${pageInfo.nextPage}">下一页</a>
</c:if>
</div>
</center>
</body>
</html>
<%--<script type="text/javascript">--%>
        <%--$("#shou").css("background-color","#5B5C60");--%>
        <%--$(".bian:odd").css("background-color","#7F8084");--%>

        <%--function tui() {--%>
               <%--var flag=confirm("确定要退出吗?");--%>
               <%--if(flag){--%>
                   <%--location.href="/tuichu";--%>
               <%--}--%>
               <%--return;--%>
        <%--}--%>
<%--</script>--%>
