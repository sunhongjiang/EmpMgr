
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>修改页面</title>
<style>
	.container
		{
			text-align: center;
			position: relative;
			top:100px;
		}		
</style>
</head>
<body>
<body>
	<div id = "container">
		<form action="servlet/updateEmp" method="post">
		员工编号 <input type="text" id= "empno" name="empno" placeholder=<%="请输入员工编号"%> /> <br /> 		
		员工姓名 <input type="text" id="ename" name="ename" placeholder="请输入员工姓名" /> <br />
		员工职务 <input type="text" id="job" name="job" placeholder="请输入员工职务" /><br /> 
		每月薪水 <input type="text" id="sal" name="sal" placeholder="请输入每月薪水" /><br />

		<input type="submit" value="确认修改">
	</form>
	</div>
</body>
</body>
</html>