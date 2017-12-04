<!-- pageEncoding是jsp文件本身的编码格式，因为容器把jsp文件转化成java文件前，必须要知道jsp文件的编码格式 -->
<!-- contentType是服务端相应客户端的编码格式 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!-- jsp指令 -->
<%@ page
	import="java.util.*, java.text.*, com.cheer.empmgrsystem.domain.*, com.cheer.empmgrsystem.service.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>首页</title>
<style type="text/css">
</style>
</head>
<body>
	<%
	    EmpService empService = (EmpService)application.getAttribute("empService");
	    pageContext.setAttribute("empList", empService.getAll());
	%>
	<div class="head">
		<hr />
		<span> <a href="login.jsp">重新登陆 </a></span> <span><a
			href="servlet/logout"> 注销</a></span> <span style="text-align: right">
			<a href="add.jsp"> 新增</a>
		</span> <br />
		<hr />
		<br /> <br />
	</div>

	<table border="1" cellspacing="0" align="center">
		<tr>
			<td>员工编号</td>
			<td>员工姓名</td>
			<td>工作</td>
			<td>雇佣日期</td>
			<td>薪水</td>
			<td>操作</td>
			<td>操作</td>
		</tr>

		<c:forEach var="emp" items="${empList}">
			<tr>
				<td>${emp.empno}</td>
				<td>${emp.ename}</td>
				<td>${emp.job}</td>
				<td>${emp.hiredate}</td>
				<td>${emp.sal}</td>
				<td><a href="servlet/delEmp?empno=${emp.empno}">删除</a></td>
				<td><a href="update.jsp">修改</a></td>
			</tr>
		</c:forEach>


	</table>


</body>
</html>