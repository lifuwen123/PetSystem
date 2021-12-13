<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>$Title$</title>
</head>
<body style="background-color: #757d80">
<%@include file="common.jsp"%>
<%@include file="commontop.jsp"%>
  <div  style="width: 400px;height: 400px;margin:  0px auto; padding-top: 20px">
  <form class="form-horizontal">
      <div class="form-group">
          <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
          <div class="col-sm-10">
              <input type="email" class="form-control" id="inputEmail3" placeholder="请输入账号" name="name">
          </div>
      </div>
      <div class="form-group">
          <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
          <div class="col-sm-10">
              <input type="password" class="form-control" id="inputPassword3" placeholder="请输入密码" name="password">
          </div>
      </div>

      <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
              <button type="submit" class="btn btn-default">登录</button>
              <button type="submit" class="btn btn-default">重置</button>
          </div>
      </div>
  </form>
  </div>
<%@include file="commonbottom.jsp"%>
  </body>
</html>
