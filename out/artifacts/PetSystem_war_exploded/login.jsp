<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>$Title$</title>
    <style type="text/css">
        body{
            background:url(img/y.jpg) no-repeat;
            background-size: 100%;
        }
    </style>
</head>

<body>
<%@include file="common.jsp"%>
<%@include file="commontop.jsp"%>

  <div  style="width: 400px;height: 400px;margin:auto;position: relative">
  <form class="form-horizontal" action="${pageContext.request.contextPath}/loginServlet" method="post">
      <div class="form-group">
          <span style="color: red;text-align: center;display: block;margin: auto">${msg}</span>
          <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
          <div class="col-sm-10">
              <input type="text" class="form-control" id="inputEmail3" required placeholder="请输入账号" name="name" value="${cookie.name.value}">
          </div>
      </div>
      <div class="form-group">
          <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
          <div class="col-sm-10">
              <input type="password" class="form-control" id="inputPassword3"  required placeholder="请输入密码" name="password">
          </div>

      </div>

      <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
              <div class="checkbox">
                  <label>
                      <input type="checkbox" name="checkbox" value="1">记住用户名
                  </label>
              </div>
          </div>
      </div>
      <div class="form-group">

          <div class="col-sm-offset-2 col-sm-10">
              <button type="submit" class="btn btn-default">登录</button>
              <button type="reset" class="btn btn-default">重置</button>
          </div>
      </div>
  </form>
  </div>
<div style="position: absolute;bottom: 0px;width: 100%" >
    <%@include file="commonbottom.jsp"%>
</div>
  </body>
</html>
