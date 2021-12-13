<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>所有入信息修改页面</title>
    <script type="text/javascript">
        function reselect (){
            location.href="${pageContext.request.contextPath}/pet.jsp"
        }
        function upPet() {
            location.href="${pageContext.request.contextPath}/updatePetServlet2?name=${pets.name}"
        }
    </script>
</head>
<body>
<%@include file="commontop2.jsp"%>
<%@include file="common.jsp"%>

<div style="margin: auto;width: 500px;border: gainsboro;position: relative">

    <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/UpdateOwnerServlet2">
        <div class="form-group">
            <label  class="col-sm-2 control-label">宠物名字</label>
            <div class="col-sm-10">
                <input type="hidden" name="id" value="${pets.id}">
                <input type="text" class="form-control"   readonly="readonly" name="name" value="${pets.name}">
            </div>
        </div>

        <div class="form-group">
            <label  class="col-sm-2 control-label">宠物类型</label>
            <div class="col-sm-10">
                <input type="text" class="form-control"  readonly="readonly" value="${pets.type}">
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-2 control-label">拥有人名字</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" readonly="readonly" value="${pets.oname}">
            </div>
        </div>
    </form>
    <hr>
    <table class="table">
        <tr class="active">
            <th>诊断时间</th>
            <th>备注</th>
            <th>状态</th>
        </tr>
        <c:forEach var="v" items="${lists}">
        <tr class="active">
            <td><fmt:formatDate value="${v.visit_date}" pattern="yyyy-MM-dd"/></td>
            <td>${v.description}</td>
            <td>${v.state}</td>
        </tr>
        </c:forEach>

    </table>
    <button onclick="javascript:history.go(-1)" type="button" style="position: absolute;left: 240px;font-size: 20px">返回</button>
</div>
<div style="position: absolute;bottom: 0px;width: 100%" >
    <%@include file="commonbottom.jsp"%>
</div>
</body>
</html>
