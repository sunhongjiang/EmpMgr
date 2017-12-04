<!-- pageEncoding是jsp文件本身的编码格式，因为容器把jsp文件转化成java文件前，必须要知道jsp文件的编码格式 -->
<!-- contentType是服务端相应客户端的编码格式 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!-- jsp指令 -->
<%@ page
	import="java.util.*, java.text.*, com.cheer.empmgrsystem.domain.*, com.cheer.empmgrsystem.service.*"%>
<!DOCTYPE html>
<html>
<head>
<title>首页</title>
<style type="text/css">
</style>
</head>
<body>
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

		<%
		    EmpService empService = (EmpService)application.getAttribute("empService");

		    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    for (Emp emp : empService.getAll())
		    {
		%>
		<tr>
			<td><%=emp.getEmpno()%></td>
			<td><%=emp.getEname()%></td>
			<td><%=emp.getJob()%></td>
			<td><%=df.format(emp.getHiredate())%></td>
			<td><%=emp.getSal()%></td>
			<td><a href="servlet/delEmp?empno=<%=emp.getEmpno()%>">删除</a></td>
			<td><a href="servlet/updateEmp?empno=<%=emp.getEmpno()%>">修改</a></td>
			
		</tr>
		<%
		    }
		%>
	</table>
	<a href="servlet/addEmp">新增</a>

</body>
</html>