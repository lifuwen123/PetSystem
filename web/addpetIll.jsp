<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>所有入信息修改页面</title>
</head>
<body>
<%@include file="commontop2.jsp"%>
<%@include file="common.jsp"%>

<div style="margin: auto;width: 500px;height: 400px;border: gainsboro;position: relative">
    <div style="position: absolute;bottom: 50px;left: 150px">
        <span style="color: red">${msg}</span>
    </div>
    <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/addPetIllServlet2" method="post">
        <div class="form-group">
            <label  class="col-sm-2 control-label">宠物名字</label>
            <div class="col-sm-10">
                <input type="hidden" name="pet_id" value="${pets.id}">
                <input type="text" class="form-control"   readonly="readonly" name="name" value="${pets.name}">
            </div>
        </div>

        <div class="form-group">
            <label  class="col-sm-2 control-label">宠物主人</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" readonly="readonly" value="${owners.name}">
            </div>
        </div>

        <div class="form-group">
            <label  class="col-sm-2 control-label">类型</label>
            <div class="col-sm-10">
                <input type="text" class="form-control"  readonly="readonly" value="${pets.type}">
            </div>
        </div>

        <div class="form-group">
            <label  class="col-sm-2 control-label">日期</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" name="visit_date">
            </div>
        </div>

        <div class="form-group">
            <label  class="col-sm-2 control-label">状态</label>
            <div class="col-sm-10">
                <select class="form-control" style="width: 412px" class="form-control" name="state">
                    <option>良好</option>
                    <option>虚弱</option>
                    <option>病危</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-2 control-label">描述</label>
            <div class="col-sm-10">
             <textarea rows="3" cols="56" name="description"></textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit"  class="btn btn-default">添加</button>
                <button type="button" onclick="javascript:history.go(-1)" class="btn btn-default">放弃</button>
                <button type="reset" class="btn btn-default">清空</button>
            </div>
        </div>
    </form>

</div>
<div style="position: absolute;bottom: 0px;width: 100%" >
    <%@include file="commonbottom.jsp"%>
</div>
</body>
</html>
