<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加宠物病例</title>
</head>
<script type="text/javascript">
    function reselect (){
        location.href="${pageContext.request.contextPath}/pet.jsp"
    }
</script>
<body>
<%@include file="commontop2.jsp"%>
<%@include file="common.jsp"%>
<div style="margin: auto;width: 500px;height: 300px;border: gainsboro">
    <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/addPetServlet2">
        <div class="form-group">
            <label  class="col-sm-2 control-label">所有人名字</label>
            <div class="col-sm-10">
                <select class="form-control" style="width: 410px" class="form-control" name="oname">
                    <c:forEach items="${lists}" var="n">
                        <option>${n}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="lastname" class="col-sm-2 control-label">宠物名字</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="lastname" placeholder="请输入宠物名字" name="name">
            </div>
        </div>
        <div class="form-group">
            <label for="lastname" class="col-sm-2 control-label">类型</label>
            <div class="col-sm-10">
                <select class="form-control" style="width: 410px" class="form-control" name="type">
                        <option>狗</option>
                        <option>猫</option>
                        <option>羊</option>
                        <option>猪</option>
                        <option>其他种类</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="lastname" class="col-sm-2 control-label">出生日期</label>
            <div class="col-sm-10">
                <input type="date" class="form-control"  placeholder="请选择日期" name="birth_date">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">添加</button>
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
