<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加所有入</title>
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
    <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/addOwnersServlet">
        <div class="form-group">
            <span style="color: red;text-align: center;display: block;margin: auto">${msg}</span>
            <label for="firstname" class="col-sm-2 control-label">名字</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="firstname" required placeholder="请输入名字" name="name">
            </div>
        </div>
        <div class="form-group">
            <label for="lastname" class="col-sm-2 control-label">地址</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="lastname" placeholder="请输入地址" name="address">
            </div>
        </div>
        <div class="form-group">
            <label for="lastname" class="col-sm-2 control-label">城市</label>
            <div class="col-sm-10">
                <input type="text" class="form-control"  placeholder="请输入城市" name="city">
            </div>
        </div>
        <div class="form-group">
            <label for="lastname" class="col-sm-2 control-label">电话号码</label>
            <div class="col-sm-10">
                <input type="text" class="form-control"  placeholder="请输入号码" name="telephone">
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
