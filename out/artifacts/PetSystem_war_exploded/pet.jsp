<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>兽医查询页面</title>
 <script type="text/javascript">
     /*添加宠物
     * */
     function addPet() {
         location.href="${pageContext.request.contextPath}/addPetServlet1"
     }
     /*添加宠物的拥有人
    * */
     function  addPet_Own(){
        location.href="${pageContext.request.contextPath}/addowner.jsp"
     }

 </script>
</head>
<body>
<%@include file="commontop2.jsp"%>
<%@include file="common.jsp"%>

<div style="margin: auto;width: 500px;height: 300px;border: gainsboro;position: relative;">

    <form class="form-horizontal" method="get" action="${pageContext.request.contextPath}/petServlet">
        <div class="form-group">
            <span style="color: red;text-align: center;display: block;margin: auto">${msg1}</span>
            <label  class="col-sm-2 control-label">宠物名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control"  placeholder="请输入宠物名称" name="pname">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">所有人</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputPassword3" placeholder="请输入所有人名称" name="oname">
            </div>
        </div>
        <div class="form-group" style="padding-left: 170px">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">查询</button>
            </div>
        </div>
    </form>
    <div class="form-group"style="margin: auto;padding-left: 70px">
        <div class="col-sm-offset-2 col-sm-10">
            <button  class="btn btn-default" type="button" onclick="addPet()">添加新宠物</button>
            <button  class="btn btn-default" onclick="javascript:addPet_Own()">增加新所有入</button>
        </div>
    </div>
    <div style="position : absolute;left: 160px;bottom: 10px">
        <span style="color: red">${msg}</span>
    </div>

</div>
<div style="position: absolute;bottom: 0px;width: 100%" >

    <%@include file="commonbottom.jsp"%>
</div>
</body>
</html>
