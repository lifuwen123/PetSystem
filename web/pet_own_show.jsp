<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>兽医查询页面</title>
   <script type="text/javascript">
       function reselect (){
           location.href="${pageContext.request.contextPath}/pet.jsp"
       }
   </script>
</head>
<body>
<%@include file="commontop2.jsp"%>
<%@include file="common.jsp"%>

<div style="margin: auto;width: 500px;background-color: beige">
    <table class="table table-hover"><thead>
    <tr>
        <th>宠物名称</th>
        <th>拥有人名称</th>
    </tr>
    <c:forEach items="${list}" var="po">
    <tr>
        <td><a href="${pageContext.request.contextPath}/updatePetServlet1?name=${po.pname}" style="text-decoration: none">${po.pname}</a></td>
        <td><a href="${pageContext.request.contextPath}/updateOwnerServlet1?name=${po.oname}" style="text-decoration: none;">${po.oname}</a></td>
    </tr>
    </c:forEach>
    </table>

</div>
<button style="margin: auto;display: block" onclick="javascript:reselect()"> 重新查询</button>
<div>
    <h2 style="text-align: center;"><font color="red">查询成功</font></h2>
</div>
<div style="position: absolute;bottom: 0px;width: 100%" >
    <%@include file="commonbottom.jsp"%>
</div>
</body>
</html>
