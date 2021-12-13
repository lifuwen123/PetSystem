<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<div style="margin: auto;width: 500px;height: 100px;border: gainsboro">
    <form class="form-horizontal" method="get" action="${pageContext.request.contextPath}/petDocServlet">
        <div class="form-group">
            <span style="color: red;text-align: center;display: block;margin: auto">${msg1}</span>
            <label  class="col-sm-2 control-label">兽医名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control"  placeholder="请输入兽医名称" name="vname">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">专业</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputPassword3" placeholder="请输入兽医专业" name="sname">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">查询</button>
            </div>
        </div>
    </form>
</div>
<div style="position: absolute;bottom: 0px;width: 100%" >
    <%@include file="commonbottom.jsp"%>
</div>
</body>
</html>
