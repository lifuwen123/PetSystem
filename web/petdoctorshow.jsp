<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>兽医查询页面</title>
<style type="text/css">

</style>
</head>
<body>
<%@include file="commontop2.jsp"%>
<%@include file="common.jsp"%>

<div style="margin: auto;width: 500px;background-color: beige">
    <table class="table table-hover"><thead>
        <tr>
            <th>兽医名称</th>
            <th>兽医专业</th>
        </tr>
        <c:forEach items="${list}" var="doc">
            <tr>
                <td>${doc.vname}</td>
                <td>${doc.sname}</td>
            </tr>
        </c:forEach>
    </table>

</div>
<button style="margin: auto;display: block;" onclick="javascript:history.go(-1)"> 重新查询</button>
<div>
<h2 style="text-align: center;"><font color="red">查询成功</font></h2>
</div>
<div style="position: absolute;bottom: 0px;width: 100%" >
    <%@include file="commonbottom.jsp"%>
</div>
</body>
</html>
