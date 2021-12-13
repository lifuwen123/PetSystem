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
        function upPet() {
            location.href="${pageContext.request.contextPath}/updatePetServlet1?name=${pets.name}"
        }
    </script>
</head>
<body>
<%@include file="commontop2.jsp"%>
<%@include file="common.jsp"%>
<div style="margin: auto;width: 500px;height: 300px;border: gainsboro;position: relative">
    <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/updatePetServlet3" method="post">
        <div class="form-group">
            <label  class="col-sm-2 control-label">宠物名字</label>
            <div class="col-sm-10">
                <input type="hidden" name="id" value="${pets.id}">
                <input type="text" class="form-control"  name="name" value="${pets.name}">
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-2 control-label">出生日期</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" name="birth_date" value="${pets.birth_date}">
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-2 control-label">宠物类型</label>
            <div class="col-sm-10">
                <select class="form-control" style="width: 410px" class="form-control" name="type">
                    <option selected>${pets.type}</option>
                    <option>狗</option>
                    <option>羊</option>
                    <option>猪</option>
                    <option>其他种类</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-2 control-label">拥有人名字</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" readonly value="${owners.name}">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">修改</button>
                <button type="button" onclick="javascript:history.go(-1)" class="btn btn-default">放弃</button>
            </div>
        </div>
    </form>
</div>
<div style="position: absolute;bottom: 0px;width: 100%" >
    <%@include file="commonbottom.jsp"%>
</div>
</body>
</html>
