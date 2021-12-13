<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>所有入信息修改页面</title>
    <script type="text/javascript">
        function reselect (){
            location.href="${pageContext.request.contextPath}/pet.jsp"
        }
    </script>
</head>
<body>
<%@include file="commontop2.jsp"%>
<%@include file="common.jsp"%>
<div style="margin: auto;width: 500px;height: 300px;border: gainsboro">
    <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/UpdateOwnerServlet2">
        <div class="form-group">
            <label for="firstname" class="col-sm-2 control-label">名字</label>
            <div class="col-sm-10">
                <input type="hidden" name="id" value="${owners.id}">
                <input type="text" class="form-control" id="firstname"  name="name" value="${owners.name}">
            </div>
        </div>
        <div class="form-group">
            <label for="lastname" class="col-sm-2 control-label">地址</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="lastname" name="address" value="${owners.address}">
            </div>
        </div>
        <div class="form-group">
            <label for="lastname" class="col-sm-2 control-label">城市</label>
            <div class="col-sm-10">
                <input type="text" class="form-control"  value="${owners.city}" name="city">
            </div>
        </div>
        <div class="form-group">
            <label for="lastname" class="col-sm-2 control-label">电话号码</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" value="${owners.telephone}" name="telephone">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">修改</button>
                <button type="button" onclick="reselect()" class="btn btn-default">放弃</button>
            </div>
        </div>
    </form>
</div>
<div style="position: absolute;bottom: 0px;width: 100%" >
    <%@include file="commonbottom.jsp"%>
</div>
</body>
</html>
