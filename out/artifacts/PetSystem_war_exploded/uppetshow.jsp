<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>所有入信息修改页面</title>
    <script type="text/javascript">
        <%--   重新查询     --%>
        function reselect (){
            location.href="${pageContext.request.contextPath}/pet.jsp"
        }
        <%--   宠物信息更新   --%>
        function upPet() {
            location.href="${pageContext.request.contextPath}/updatePetServlet2?name=${pets.name}"
        }
        <%--   阅览宠物病例    --%>
        function LookPetIll() {
            location.href="${pageContext.request.contextPath}/lookPetIllServlet?id=${pets.id}"
        }
        <%--   添加宠物病例    --%>
        function addPetIll() {
            location.href="${pageContext.request.contextPath}/addPetIllServlet1?id=${pets.id}"
        }
    </script>
</head>
<body>
<%@include file="commontop2.jsp"%>
<%@include file="common.jsp"%>

<div style="margin: auto;width: 500px;height: 400px;border: gainsboro;position: relative">
    <div style="position: absolute;bottom: 50px;left: 150px">
        <span style="color: red">${msg}</span>
    </div>
    <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/UpdateOwnerServlet2">
        <div class="form-group">
            <label  class="col-sm-2 control-label">宠物名字</label>
            <div class="col-sm-10">
                <input type="hidden" name="id" value="${pets.id}">
                <input type="text" class="form-control"   readonly="readonly" name="name" value="${pets.name}">
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-2 control-label">出生日期</label>
            <div class="col-sm-10">
                <input type="date" class="form-control"  readonly="readonly" name="address" value="${pets.birth_date}">
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
                <input type="text" class="form-control" readonly="readonly" value="${owners.name}">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" onclick="javascript:upPet()" class="btn btn-default" style="left: 160px;position: absolute" >修改信息</button>
                <button type="button" onclick="javascript:addPetIll()" class="btn btn-default" style="left: 70px;top:30px;position: absolute">增加病例</button>
                <button type="button" onclick="javascript:LookPetIll()" class="btn btn-default" style="right: 110px;top:30px;position: absolute" >阅览病例</button>
            </div>
        </div>
    </form>

</div>
<div style="position: absolute;bottom: 0px;width: 100%" >
    <%@include file="commonbottom.jsp"%>
</div>
</body>
</html>
