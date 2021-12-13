<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/29
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background-color: #6e7080">
<%@include file="common.jsp"%>
<%@include file="commontop.jsp"%>
<div  style="width: 400px;height: 400px;margin:  auto;text-align:center;">
    <form class="form-horizontal">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Sign in</button>
                <button type="submit" class="btn btn-default">Sign in</button>
            </div>
        </div>
    </form>
</div>
<%@include file="commonbottom.jsp"%>
</body>
</html>
