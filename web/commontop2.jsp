<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
    span{
        color: black;
        font-size: 25px;
    }
    a{
        text-decoration: none;
        margin-left: 8px;
    }
</style>
</head>
<body style="background-color: #7e807b">

<div style="width: 100%;height: 200px;background-color: #167480;position: relative">
    <a href="${pageContext.request.contextPath}/logOutServlet" style="float: right"><span>退出</span></a>
    <h1 align="center" style="margin: auto">宠物诊所应用</h1>
<div style="margin: 0px;position: absolute;bottom: 0px">
    <a href="pet.jsp" style="float: right"><span>宠物</span></a>
    <a href="petdoctor.jsp" style="float: right"><span>兽医</span></a>
</div>
</div>
</body>
</html>